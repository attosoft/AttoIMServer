package cn.id0755.im.server.handler.biz;

import cn.id0755.im.chat.proto.*;
import cn.id0755.im.server.handler.BaseBizHandler;
import cn.id0755.im.server.service.TopicService;
import cn.id0755.im.server.utils.L;
import io.netty.channel.ChannelHandlerContext;

public class LoginHandler extends BaseBizHandler<Login.LoginRequest, Login.LoginResponse> {
    private final static String TAG = LoginHandler.class.getSimpleName();

    @Override
    protected void channelRead(ChannelHandlerContext ctx, Login.LoginRequest loginRequest, String seqId) {
        L.d(TAG, loginRequest.toString());
        Login.LoginResponse.Builder builder = Login.LoginResponse.newBuilder();
        builder.setAccessToken(loginRequest.getAccount());
        response(ctx, Message.CMD_ID.LOGIN_RESP, builder.build());

        //发布到个人主题
        TopicService.INSTANCE.publisher(Topic.TopicType.PERSON, loginRequest.getAccount(), ctx);
        //广播 个人在线消息
        Push.Message message = Push.Message.newBuilder()
                .setFrom(loginRequest.getAccount())
                .setTopicId(loginRequest.getAccount())
                .setTo("online")
                .setTopicType(Topic.TopicType.BROADCAST)
                .setContent("{'status':'online'}")
                .build();
        TopicService.INSTANCE.publishMsg(message);
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
