package com.melardev.cloud.rest.messaging;

import com.melardev.cloud.rest.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class TodoSource {
    @Autowired
    private Source source;

    public boolean send(Todo todo) {
        // original code is using integration.support.MessageBuilder
        return this.source.output().send(MessageBuilder.withPayload(todo).build());
    }
}
