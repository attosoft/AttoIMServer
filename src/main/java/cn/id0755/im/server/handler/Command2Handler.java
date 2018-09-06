package cn.id0755.im.server.handler;

import cn.id0755.im.server.utils.L;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class Command2Handler extends SimpleChannelInboundHandler<String>{
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        L.d("Command2Handler","channelRead0");
    }
}
