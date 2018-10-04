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
            TopicSet broadcast = new TopicSet();
            broadcast.addTopicItem("online",new TopicItem(null));
            mTopicMap.put(Topic.TopicType.BROADCAST, broadcast);
        }

        public void subject(Topic.TopicInfo topicInfo, ChannelHandlerContext observer) {
            TopicSet topicSet = mTopicMap.get(topicInfo.getTopicType());
            TopicItem topicItem = topicSet.getTopicItem(topicInfo.getTopic());
            topicItem.addObserver(observer);
        }

        public void publisher(Topic.TopicType topicType, String topicId, ChannelHandlerContext context) {
            TopicSet topicSet = mTopicMap.get(topicType);
            TopicItem topicItem = topicSet.getTopicItem(topicId);
            if (topicItem == null) {
                topicSet.addTopicItem(topicId, new TopicItem(context));
            } else {
                if (topicItem.getContext() != context) {
                    if (topicItem.getContext().channel().isActive()) {
                        //todo
                    }
                    topicItem.setContext(context);
                } else if (!topicItem.getContext().channel().isActive()) {
                    topicItem.setContext(context);
                } else {
                    //todo
                }
            }
        }

        public Map<Topic.TopicType, TopicSet> getPublisherMap() {
            return mTopicMap;
        }

        public void sendMsg(Push.Message message) {
            TopicSet topicSet = mTopicMap.get(message.getTopicType());
            TopicItem topicItem = topicSet.getTopicItem(message.getTo());
            if (topicItem != null) {
                    topicItem.getContext().writeAndFlush(MessageUtil.wrap(Message.CMD_ID.PUSH, message));
            }
        }

        public void publishMsg(Push.Message message) {
            TopicSet topicSet = mTopicMap.get(message.getTopicType());
            TopicItem topicItem = topicSet.getTopicItem(message.getTo());
            if (topicItem != null) {
                if (message.getTopicType() == Topic.TopicType.BROADCAST) {
                    Iterator<ChannelHandlerContext> iterable = topicItem.getObserver().iterator();
                    while (iterable.hasNext()) {
                        ChannelHandlerContext context = iterable.next();
                        if (context.channel().isActive()) {
                            context.writeAndFlush(MessageUtil.wrap(Message.CMD_ID.PUSH, message));
                        }else {
                            iterable.remove();
                        }
                    }
                }
            }
        }
    }
}
