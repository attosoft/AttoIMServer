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
