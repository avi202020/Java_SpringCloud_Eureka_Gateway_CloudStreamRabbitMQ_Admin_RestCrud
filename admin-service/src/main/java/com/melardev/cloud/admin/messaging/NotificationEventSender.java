package com.melardev.cloud.admin.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class NotificationEventSender {
    @Autowired
    Source source;

    public boolean send(String notification) {
        return this.source.output().send(MessageBuilder.withPayload(notification).build());
    }
}
