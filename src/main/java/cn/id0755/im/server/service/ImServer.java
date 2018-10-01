package cn.id0755.im.server.service;

import cn.id0755.im.chat.proto.Message;
import cn.id0755.im.server.config.Config;
import cn.id0755.im.server.handler.CommandReqHandler;
import cn.id0755.im.server.handler.biz.LoginHandler;
import cn.id0755.im.server.handler.biz.PingHandler;
import cn.id0755.im.server.handler.biz.SendMsgHandler;
import cn.id0755.im.server.handler.biz.SubjectTopicHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class ImServer {
    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //添加登录处理--实际上应由短连处理获取token
                            CommandReqHandler commandReqHandler = new CommandReqHandler();
                            commandReqHandler.addBizHandler(new LoginHandler());
                            commandReqHandler.addBizHandler(new PingHandler());
                            commandReqHandler.addBizHandler(new SubjectTopicHandler());
                            commandReqHandler.addBizHandler(new SendMsgHandler());
                            socketChannel.pipeline()
                                    .addLast(new ProtobufVarint32FrameDecoder())
                                    .addLast(new ProtobufDecoder(Message.MessageData.getDefaultInstance()))
                                    .addLast(new ProtobufVarint32LengthFieldPrepender())
                                    .addLast(new ProtobufEncoder())
                                    .addLast(commandReqHandler);
                        }
                    });
            ChannelFuture channelFuture = bootstrap.bind(Config.PORT).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
