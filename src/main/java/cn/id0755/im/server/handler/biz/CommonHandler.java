package cn.id0755.im.server.handler.biz;

import cn.id0755.im.chat.proto.Common;
import cn.id0755.im.chat.proto.Message;
import cn.id0755.im.chat.proto.Push;
import cn.id0755.im.chat.proto.Topic;
import cn.id0755.im.server.biz.*;
import cn.id0755.im.server.biz.entity.TopicEntity;
import cn.id0755.im.server.handler.BaseBizHandler;
import cn.id0755.im.server.service.TopicService;
import cn.id0755.im.server.service.wrapper.TopicSet;
import cn.id0755.im.server.utils.GsonHelper;
import io.netty.channel.ChannelHandlerContext;

import java.util.*;

public class CommonHandler extends BaseBizHandler<Common.CommonReq, Common.CommonResp> {
    protected void channelRead(ChannelHandlerContext ctx, Common.CommonReq commonReq, String seqId) {
        Common.CommonResp.Builder builder = Common.CommonResp.newBuilder();
        switch (commonReq.getType()) {
            case RequestType.TEXT_MSG: {
                TextMsgReq msgReq = GsonHelper.INSTANCE.fromJson(commonReq.getContent(), TextMsgReq.class);
                Push.Message message = Push.Message
                        .newBuilder()
                        .setContent(msgReq.getContent())
                        .setFrom(msgReq.getFrom())
                        .setTopicType(msgReq.getTopicType())
                        .setTo(msgReq.getTo())
                        .build();
                //发送消息
                TopicService.INSTANCE.sendMsg(message);

                TextMsgResp msgResp = new TextMsgResp();
                msgResp.setErrorCode(0)
                        .setErrorMsg(msgReq.getContent());
                builder.setContent(GsonHelper.INSTANCE.toJson(msgResp));
            }
            break;
            case RequestType.IMAGE_MSG:
                break;

            case RequestType.GET_PUBLISH: {
                Map<Topic.TopicType, TopicSet> publisherMap = TopicService.INSTANCE.getPublisherMap();
                List<TopicEntity> topicEntities = new LinkedList<TopicEntity>();
                for (Topic.TopicType topicType : publisherMap.keySet()) {
                    TopicSet topicSet = publisherMap.get(topicType);
                    for (String topicId : topicSet.getAllTopicId()) {
                        TopicEntity entity = new TopicEntity();
                        entity.setTopicType(topicType)
                                .setTopicId(topicId);
                        topicEntities.add(entity);
                    }
                }
                GetPublishResp resp = new GetPublishResp();
                resp.setTopicEntities(topicEntities);
                builder.setContent(GsonHelper.INSTANCE.toJson(resp));
            }
            break;
            case RequestType.SUBJECT: {
                SubjectReq req = GsonHelper.INSTANCE.fromJson(commonReq.getContent(), SubjectReq.class);
                List<TopicEntity> topicEntities = req.getTopicEntities();
                for (TopicEntity entity : topicEntities) {
                    Topic.TopicInfo topicItem = Topic.TopicInfo
                            .newBuilder()
                            .setTopicType(entity.getTopicType())
                            .setTopic(entity.getTopicId())
                            .setContent("")
                            .build();
                    //订阅个人在线主题
                    TopicService.INSTANCE.subject(topicItem, ctx);
                }
                SubjectResp resp = new SubjectResp();
                builder.setContent(GsonHelper.INSTANCE.toJson(resp));
            }
            break;
            default:
                break;
        }
        response(ctx, Message.CMD_ID.COMMON_RESP, builder.build());
    }

    protected Message.CMD_ID getType() {
        return Message.CMD_ID.COMMON_REQ;
    }

    protected Common.CommonReq getMessageLite() {
        return Common.CommonReq.getDefaultInstance();
    }
}
