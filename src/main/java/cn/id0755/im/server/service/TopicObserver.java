package cn.id0755.im.server.service;

import io.netty.channel.ChannelHandlerContext;

public class TopicObserver {
    private ChannelHandlerContext mCtx;
    public TopicObserver(ChannelHandlerContext ctx){
        this.mCtx = ctx;
    }

    public ChannelHandlerContext getCtx(){
        return mCtx;
    }
}
