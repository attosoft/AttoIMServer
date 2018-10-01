package cn.id0755.im.server.service;


import cn.id0755.im.chat.proto.Push;
import cn.id0755.im.chat.proto.Topic;
import io.netty.channel.ChannelHandlerContext;

public interface ITopicService {
    /**
     * 订阅
     *
     * @param topicItem 订阅的主题
     * @param observer
     */
    void subject(Topic.TopicInfo topicItem, ChannelHandlerContext observer);

    /**
     * 发布
     */
    void publish(Topic.TopicInfo topicItem, Push.Message msg);
}
