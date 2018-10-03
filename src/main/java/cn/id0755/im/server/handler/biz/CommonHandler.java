package cn.id0755.im.server.handler.biz;

import cn.id0755.im.chat.proto.Common;
import cn.id0755.im.chat.proto.Message;
import cn.id0755.im.chat.proto.Push;
import cn.id0755.im.chat.proto.Topic;
import cn.id0755.im.server.biz.RequestType;
import cn.id0755.im.server.biz.TextMsgReq;
import cn.id0755.im.server.biz.TextMsgResp;
import cn.id0755.im.server.handler.BaseBizHandler;
import cn.id0755.im.server.service.TopicService;
import cn.id0755.im.server.utils.GsonHelper;
import io.netty.channel.ChannelHandlerContext;

public class CommonHandler extends BaseBizHandler<Common.CommonReq, Common.CommonResp> {
    protected void channelRead(ChannelHandlerContext ctx, Common.CommonReq commonReq, String seqId) {
        Common.CommonResp.Builder builder = Common.CommonResp.newBuilder();
        switch (commonReq.getType()) {
            case RequestType.TEXT_MSG:
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
                break;
            case RequestType.IMAGE_MSG:
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
