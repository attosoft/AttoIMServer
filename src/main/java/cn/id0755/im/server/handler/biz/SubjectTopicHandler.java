package cn.id0755.im.server.handler.biz;

import cn.id0755.im.chat.proto.Message;
import cn.id0755.im.chat.proto.Topic;
import cn.id0755.im.server.handler.BaseBizHandler;
import cn.id0755.im.server.service.TopicService;
import cn.id0755.im.server.utils.MessageUtil;
import io.netty.channel.ChannelHandlerContext;

public class SubjectTopicHandler extends BaseBizHandler<Topic.TopicRequest, Topic.TopicResponse> {

    protected void channelRead(ChannelHandlerContext ctx, Topic.TopicRequest topicRequest, String seqId) {
        Topic.TopicInfo topicItem = Topic.TopicInfo
                .newBuilder()
                .setTopicType(topicRequest.getTopicType())
                .setTopic(topicRequest.getTopic())
                .setContent("")
                .build();
        //订阅个人在线主题
        TopicService.INSTANCE.subject(topicItem, ctx);
        Topic.TopicResponse response = Topic.TopicResponse
                .newBuilder()
                .setErrCode(0)
                .setErrMsg("")
                .build();
        ctx.writeAndFlush(MessageUtil.wrap(Message.CMD_ID.SUBJECT_TOPIC_RESP, seqId, response));
        response(ctx, Message.CMD_ID.SUBJECT_TOPIC_RESP, response);
    }

    protected Message.CMD_ID getType() {
        return Message.CMD_ID.SUBJECT_TOPIC_REQ;
    }

    protected Topic.TopicRequest getMessageLite() {
        return Topic.TopicRequest.getDefaultInstance();
    }
}
