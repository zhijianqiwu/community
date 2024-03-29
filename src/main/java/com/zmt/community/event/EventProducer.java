package com.zmt.community.event;

import com.alibaba.fastjson.JSONObject;
import com.zmt.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 事件的生产者
 *@author zmt
 */

@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    // 触发事件->处理事件
    public void fireEvent(Event event) {
        // 将事件发布到指定的主题
        //事件转化为JSON
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }

}
