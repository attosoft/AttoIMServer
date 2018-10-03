package cn.id0755.im.server.biz;

import cn.id0755.im.server.biz.entity.TopicEntity;

import java.util.List;

import static cn.id0755.im.server.biz.RequestType.SUBJECT;


public class SubjectReq extends BaseReq {
    private List<TopicEntity> topicEntities;

    public List<TopicEntity> getTopicEntities() {
        return topicEntities;
    }

    public SubjectReq setTopicEntities(List<TopicEntity> topicEntities) {
        this.topicEntities = topicEntities;
        return this;
    }

    @Override
    public int getReqType() {
        return SUBJECT;
    }
}
