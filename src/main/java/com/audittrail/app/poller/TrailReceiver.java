package com.audittrail.app.poller;

import com.audittrail.app.model.TrailEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;

@Slf4j
public class TrailReceiver {
    @SqsListener(value = "trailQueue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(final TrailEvent trail, @Header("SenderId") String senderId) {
        log.info("trail received {}, {}", senderId, trail);
    }
}
