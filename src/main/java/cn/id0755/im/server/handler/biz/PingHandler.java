package cn.id0755.im.server.handler.biz;

import cn.id0755.im.chat.proto.HeartBeat;
import cn.id0755.im.chat.proto.Message;
import cn.id0755.im.server.handler.BaseBizHandler;
import cn.id0755.im.server.utils.MessageUtil;
import io.netty.channel.ChannelHandlerContext;

public class PingHandler extends BaseBizHandler<HeartBeat.Ping, HeartBeat.Pong> {
    protected void channelRead(ChannelHandlerContext ctx, HeartBeat.Ping ping,String seqId) {
        HeartBeat.Pong pong = HeartBeat.Pong
                .newBuilder()
                .setCmdId(Message.CMD_ID.PONG)
                .build();
        ctx.writeAndFlush(MessageUtil.wrap(Message.CMD_ID.PONG, pong));
    }

    protected Message.CMD_ID getType() {
        return Message.CMD_ID.PING;
    }

    protected HeartBeat.Ping getMessageLite() {
        return HeartBeat.Ping.getDefaultInstance();
    }
}
