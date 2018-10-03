package cn.id0755.im.server.biz;

import cn.id0755.im.server.biz.entity.TopicEntity;

import java.util.List;

public class GetPublishResp {
    public List<TopicEntity> getTopicEntities() {
        return topicEntities;
    }

    public GetPublishResp setTopicEntities(List<TopicEntity> topicEntities) {
        this.topicEntities = topicEntities;
        return this;
    }

    private List<TopicEntity> topicEntities;
}
