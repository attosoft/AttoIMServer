package cn.id0755.im.server.handler.biz;

import cn.id0755.im.chat.proto.*;
import cn.id0755.im.server.handler.BaseBizHandler;
import cn.id0755.im.server.service.TopicService;
import cn.id0755.im.server.utils.MessageUtil;
import io.netty.channel.ChannelHandlerContext;

public class SendMsgHandler extends BaseBizHandler<Chat.SendMessageRequest, Chat.SendMessageResponse> {
    protected void channelRead(ChannelHandlerContext ctx, Chat.SendMessageRequest sendMessageRequest, String seqId) {
        Chat.SendMessageResponse response = Chat.SendMessageResponse
                .newBuilder()
                .setText("")
                .setFrom("")
                .build();
        ctx.writeAndFlush(MessageUtil.wrap(Message.CMD_ID.SEND_MESSAGE_RESP,seqId,response));
        response(ctx,Message.CMD_ID.SEND_MESSAGE_RESP,response);

        //发布
        Topic.TopicInfo topicInfo = Topic.TopicInfo.newBuilder()
                .setTopic(sendMessageRequest.getTopic())
                .setContent(sendMessageRequest.getText())
                .setTopicType(Topic.TopicType.PERSON)
                .build();
        Push.Message message = Push.Message.newBuilder()
//                .setTopic(sendMessageRequest.getTopic())
                .setFrom(sendMessageRequest.getFrom())
                .setContent(sendMessageRequest.getText())
                .build();
//        TopicService.INSTANCE.publish(topicInfo, message);
    }

    protected Message.CMD_ID getType() {
        return Message.CMD_ID.SEND_MESSAGE_REQ;
    }

    protected Chat.SendMessageRequest getMessageLite() {
        return Chat.SendMessageRequest.getDefaultInstance();
    }
}
