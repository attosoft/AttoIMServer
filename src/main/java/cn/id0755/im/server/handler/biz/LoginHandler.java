package cn.id0755.im.server.handler.biz;

import cn.id0755.im.chat.proto.Login;
import cn.id0755.im.chat.proto.Message;
import cn.id0755.im.chat.proto.Push;
import cn.id0755.im.chat.proto.Topic;
import cn.id0755.im.server.handler.BaseBizHandler;
import cn.id0755.im.server.service.TopicService;
import cn.id0755.im.server.utils.L;
import cn.id0755.im.server.utils.MessageUtil;
import io.netty.channel.ChannelHandlerContext;

public class LoginHandler extends BaseBizHandler<Login.LoginRequest> {
    private final static String TAG = LoginHandler.class.getSimpleName();

    @Override
    protected void channelRead(ChannelHandlerContext ctx, Login.LoginRequest loginRequest, String seqId) {
        L.d(TAG, loginRequest.toString());
        Login.LoginResponse.Builder builder = Login.LoginResponse.newBuilder();
        builder.setAccessToken(loginRequest.getAccount());
        ctx.writeAndFlush(MessageUtil.wrap(Message.CMD_ID.LOGIN_RESP, seqId, builder.build()));

        //发布到个人主题 -- 在线消息
        Topic.TopicInfo topicInfo = Topic.TopicInfo.newBuilder()
                .setTopicType(Topic.TopicType.PERSON)
                .setTopic(loginRequest.getAccount())
                .setContent("个人")
                .build();
        Push.Message message = Push.Message.newBuilder()
                .setFrom(loginRequest.getAccount())
                .setTopic(loginRequest.getAccount())
                .setContent("{'type':'online'}")
                .build();
        TopicService.INSTANCE.publish(topicInfo, message);
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
