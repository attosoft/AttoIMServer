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
     * 发布者
     */
    void publisher(Topic.TopicType topicType,String topicId,ChannelHandlerContext context);

    /**
     * 投递消息
     * @param message
     */
    void sendMsg(Push.Message message);

    /**
     * 发布消息
     * @param message
     */
    void publishMsg(Push.Message message);
}
