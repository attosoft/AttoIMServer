package cn.id0755.im.server.service;

import cn.id0755.im.chat.proto.Message;
import cn.id0755.im.chat.proto.Push;
import cn.id0755.im.chat.proto.Topic;
import cn.id0755.im.server.service.wrapper.TopicItem;
import cn.id0755.im.server.service.wrapper.TopicSet;
import cn.id0755.im.server.utils.MessageUtil;
import io.netty.channel.ChannelHandlerContext;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum TopicService implements ITopicService {
    INSTANCE {
        Map<Topic.TopicType, TopicSet> mTopicMap = new ConcurrentHashMap<Topic.TopicType, TopicSet>();
        {
            mTopicMap.put(Topic.TopicType.SYS, new TopicSet());
            mTopicMap.put(Topic.TopicType.PERSON, new TopicSet());
            mTopicMap.put(Topic.TopicType.GROUP, new TopicSet());
            mTopicMap.put(Topic.TopicType.BROADCAST, new TopicSet());
        }

        public void subject(Topic.TopicInfo topicInfo, ChannelHandlerContext observer) {
            TopicSet topicSet = mTopicMap.get(topicInfo.getTopicType());
            TopicItem topicItem = topicSet.getTopicItem(topicInfo.getTopic());
            topicItem.addObserver(observer);
        }

        public void publish(Topic.TopicInfo topicInfo, Push.Message msg) {
            TopicSet topicSet = mTopicMap.get(topicInfo.getTopicType());
            TopicItem topicItem = topicSet.getTopicItem(topicInfo.getTopic());
            Iterator<ChannelHandlerContext> iterable = topicItem.getObserver().iterator();
            while (iterable.hasNext()) {
                ChannelHandlerContext context = iterable.next();
                context.writeAndFlush(MessageUtil.wrap(Message.CMD_ID.PUSH, msg));
            }
        }
    }
}
