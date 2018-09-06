package cn.id0755.im.server.handler;

import cn.id0755.im.chat.proto.Chat;
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
        L.d("", "");
        switch (msg.getCmdId()) {
            case CMD_AUTH:
                break;
            case CMD_HELLO:
                ByteString content = msg.getContent();
                Chat.SendMessageRequest sendMessageRequest = Chat.SendMessageRequest.getDefaultInstance().getParserForType()
                        .parseFrom(content);
                L.d("CMD_ID_HELLO", "" + sendMessageRequest.toString());
                break;
            case CMD_LOGIN_REQ: {
                Login.LoginRequest loginRequest = Login.LoginRequest.getDefaultInstance()
                        .getParserForType()
                        .parseFrom(msg.getContent());
                L.d(TAG, loginRequest.toString());
                ctx.writeAndFlush(MessageUtil.wrap(response()));
            }
            break;
            case CMD_LOGIN_RESP: {
                Login.LoginResponse loginResponse = Login.LoginResponse.getDefaultInstance()
                        .getParserForType()
                        .parseFrom(msg.getContent());
                L.d(TAG, loginResponse.toString());
            }
            break;
            default:
                break;
        }
    }

    private Login.LoginResponse response(){
        Login.LoginResponse.Builder builder = Login.LoginResponse.newBuilder();
        builder.setAccessToken("13510773022");
        return builder.build();
    }
}
