package cn.id0755.im.server.handler;

import cn.id0755.im.chat.proto.Common;
import cn.id0755.im.server.utils.MessageUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;

import io.netty.channel.ChannelHandlerContext;

public abstract class BaseBizHandler<Request extends MessageLite,Response extends MessageLite> {
    protected abstract void channelRead(ChannelHandlerContext ctx, Request request, String seqId);

    protected abstract cn.id0755.im.chat.proto.Message.CMD_ID getType();

    protected abstract Request getMessageLite();

    private String seqId;

    public boolean channelRead0(ChannelHandlerContext ctx, cn.id0755.im.chat.proto.Message.MessageData msg) throws InvalidProtocolBufferException {
        if (getType() != msg.getCmdId()) {
            return false;
        }
        Request request = (Request) getMessageLite().getParserForType().parseFrom(msg.getContent());
        seqId = msg.getSeqId();
        channelRead(ctx, request,msg.getSeqId());
        return true;
    }

    protected void response(ChannelHandlerContext ctx, cn.id0755.im.chat.proto.Message.CMD_ID cmd_id, Response resp){
        ctx.writeAndFlush(MessageUtil.wrap(cmd_id,seqId,resp));
    }
}
