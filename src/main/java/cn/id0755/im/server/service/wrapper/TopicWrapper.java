package cn.id0755.im.server.service.wrapper;

import cn.id0755.im.chat.proto.Topic;
import cn.id0755.im.server.service.TopicObserver;

public class TopicWrapper {
    private Topic.TopicInfo topicInfo;
    private TopicObserver observer;

    public TopicWrapper(Topic.TopicInfo topicInfo, TopicObserver observer) {
        this.topicInfo = topicInfo;
        this.observer = observer;
    }
}
