package cn.id0755.im.server.service.wrapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TopicSet {
    private Map<String, TopicItem> mTopicMap = new ConcurrentHashMap<String, TopicItem>();

    public TopicSet() {

    }

    public void addTopicItem(String topicID, TopicItem item) {
        mTopicMap.put(topicID, item);
    }

    public TopicItem getTopicItem(String topicId) {
        if (!mTopicMap.containsKey(topicId)) {
            return null;
        }
        return mTopicMap.get(topicId);
    }
}
