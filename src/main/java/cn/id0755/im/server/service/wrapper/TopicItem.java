package cn.id0755.im.server.service.wrapper;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ConcurrentSet;

import java.util.Set;

public class TopicItem {

    private Set<ChannelHandlerContext> contextSet = new ConcurrentSet<ChannelHandlerContext>();

    public TopicItem() {

    }

    public void addObserver(ChannelHandlerContext observer) {
        contextSet.add(observer);
    }

    public Set<ChannelHandlerContext> getObserver() {
        return contextSet;
    }
}
