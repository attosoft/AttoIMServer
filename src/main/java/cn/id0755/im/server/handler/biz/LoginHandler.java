package cn.id0755.im.server.handler.biz;

import cn.id0755.im.chat.proto.Login;
import cn.id0755.im.chat.proto.Message;
import cn.id0755.im.server.handler.BaseBizHandler;
import cn.id0755.im.server.utils.L;
import cn.id0755.im.server.utils.MessageUtil;
import io.netty.channel.ChannelHandlerContext;

public class LoginHandler extends BaseBizHandler<Login.LoginRequest> {
    private final static String TAG = LoginHandler.class.getSimpleName();

    @Override
    protected void channelRead(ChannelHandlerContext ctx, Login.LoginRequest loginRequest) {
        L.d(TAG, loginRequest.toString());
        Login.LoginResponse.Builder builder = Login.LoginResponse.newBuilder();
        builder.setAccessToken(loginRequest.getAccount());
        ctx.writeAndFlush(MessageUtil.wrap(Message.CMD_ID.LOGIN_RESP, builder.build()));
    }

    @Override
    protected Message.CMD_ID getType() {
        return Message.CMD_ID.LOGIN_REQ;
    }

    @Override
    protected Login.LoginRequest getMessageLite() {
        return Login.LoginRequest.getDefaultInstance();
    }

}
