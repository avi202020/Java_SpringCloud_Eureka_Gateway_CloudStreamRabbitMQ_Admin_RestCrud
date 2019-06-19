package com.melardev.cloud.admin.messaging;

import com.melardev.cloud.admin.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Component;

@Component
public class TodoEventReceiver {

    @Autowired
    NotificationEventSender notificationEventSender;

    @StreamListener(Processor.INPUT)
    public void onTodoCreated(Todo todo) {
        notificationEventSender.send("Todo Created event processed");
    }
}
