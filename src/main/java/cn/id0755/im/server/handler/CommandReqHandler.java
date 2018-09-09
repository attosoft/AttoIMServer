package cn.id0755.im.server.handler;

import cn.id0755.im.chat.proto.Chat;
import cn.id0755.im.chat.proto.HeartBeat;
import cn.id0755.im.chat.proto.Login;
import cn.id0755.im.chat.proto.Message;
import cn.id0755.im.server.utils.L;
import cn.id0755.im.server.utils.MessageUtil;
import com.google.protobuf.ByteString;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class CommandReqHandler extends SimpleChannelInboundHandler<Message.MessageData> {
    private final static String TAG = "CommandReqHandler";

    protected void channelRead0(ChannelHandlerContext ctx, Message.MessageData msg) throws Exception {
        L.d(TAG, "CommandReqHandler | channelRead0 | " + msg.getCmdId());
        switch (msg.getCmdId()) {
            case CMD_AUTH:
                break;
            case CMD_HELLO:
                ByteString content = msg.getContent();
                Chat.SendMessageRequest sendMessageRequest = Chat.SendMessageRequest.getDefaultInstance().getParserForType()
                        .parseFrom(content);
                L.d(TAG, "CMD_HELLO" + sendMessageRequest.toString());
                break;
            case CMD_LOGIN_REQ: {
                Login.LoginRequest loginRequest = Login.LoginRequest.getDefaultInstance()
                        .getParserForType()
                        .parseFrom(msg.getContent());
                L.d(TAG, loginRequest.toString());
                Login.LoginResponse.Builder builder = Login.LoginResponse.newBuilder();
                builder.setAccessToken(loginRequest.getAccount());
                ctx.writeAndFlush(MessageUtil.wrap(builder.build()));
            }
            break;
            case CMD_LOGIN_RESP: {
                Login.LoginResponse loginResponse = Login.LoginResponse.getDefaultInstance()
                        .getParserForType()
                        .parseFrom(msg.getContent());
                L.d(TAG, loginResponse.toString());
            }
            break;
            case CMD_PING:{
                HeartBeat.Pong pong = HeartBeat.Pong
                        .newBuilder()
                        .setCmdId(Message.CMD_ID.CMD_PONG)
                        .build();
                ctx.writeAndFlush(MessageUtil.wrap(pong));
            }

                break;
            case CMD_PONG:
                break;
            default:
                break;
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        L.d(TAG,"CommandReqHandler | exceptionCaught | cause:"+cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }
}
