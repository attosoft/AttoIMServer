package cn.id0755.im.server.service.wrapper;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ConcurrentSet;

import java.util.Set;

public class TopicItem {

    private Set<ChannelHandlerContext> contextSet = new ConcurrentSet<ChannelHandlerContext>();

    public ChannelHandlerContext getContext() {
        return context;
    }

    public void setContext(ChannelHandlerContext context) {
        this.context = context;
    }

    /**
     * 主题自身
     */
    private ChannelHandlerContext context;

    public TopicItem(ChannelHandlerContext context){
        this.context = context;
    }

    public void addObserver(ChannelHandlerContext observer) {
        contextSet.add(observer);
    }

    public Set<ChannelHandlerContext> getObserver() {
        return contextSet;
    }
}
