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

import java.util.LinkedList;
import java.util.List;

public class CommandReqHandler extends SimpleChannelInboundHandler<Message.MessageData> {
    private final static String TAG = "CommandReqHandler";

    private List<BaseBizHandler> mBizHandlerList = new LinkedList<BaseBizHandler>();
    public void addBizHandler(BaseBizHandler handler){
        mBizHandlerList.add(handler);
    }
    protected void channelRead0(ChannelHandlerContext ctx, Message.MessageData msg) throws Exception {
        L.d(TAG, "CommandReqHandler | channelRead0 | " + msg.getCmdId());
        for (BaseBizHandler bizHandler : mBizHandlerList) {
            if (bizHandler.channelRead0(ctx, msg)) {
                break;
            }
        }
//        switch (msg.getCmdId()) {
//            case CMD_AUTH:
//                break;
//            case CMD_HELLO:
//                ByteString content = msg.getContent();
//                Chat.SendMessageRequest sendMessageRequest = Chat.SendMessageRequest.getDefaultInstance().getParserForType()
//                        .parseFrom(content);
//                L.d(TAG, "CMD_HELLO" + sendMessageRequest.toString());
//                break;
//            case LOGIN_REQ: {
//                Login.LoginRequest loginRequest = Login.LoginRequest.getDefaultInstance()
//                        .getParserForType()
//                        .parseFrom(msg.getContent());
//                L.d(TAG, loginRequest.toString());
//                Login.LoginResponse.Builder builder = Login.LoginResponse.newBuilder();
//                builder.setAccessToken(loginRequest.getAccount());
//                ctx.writeAndFlush(MessageUtil.wrap(Message.CMD_ID.LOGIN_RESP, builder.build()));
//            }
//            break;
//            case LOGIN_RESP: {
//                Login.LoginResponse loginResponse = Login.LoginResponse.getDefaultInstance()
//                        .getParserForType()
//                        .parseFrom(msg.getContent());
//                L.d(TAG, loginResponse.toString());
//            }
//            break;
//            case PING: {
//                HeartBeat.Pong pong = HeartBeat.Pong
//                        .newBuilder()
//                        .setCmdId(Message.CMD_ID.PONG)
//                        .build();
//                ctx.writeAndFlush(MessageUtil.wrap(Message.CMD_ID.PONG, pong));
//            }
//
//            break;
//            case PONG:
//                break;
//            default:
//                break;
//        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        L.d(TAG, "CommandReqHandler | exceptionCaught | cause:" + cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }
}
