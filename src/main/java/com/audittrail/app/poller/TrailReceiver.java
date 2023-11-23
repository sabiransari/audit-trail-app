package com.audittrail.app.poller;

import com.audittrail.app.model.ApiTrail;
import com.audittrail.app.model.Trail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;

@Slf4j
public class TrailReceiver {
    @SqsListener(value = "apiTrailQueue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(final ApiTrail apiTrail, @Header("SenderId") String senderId) {
        log.info("trail received {}, {}", senderId, apiTrail);
    }
}
