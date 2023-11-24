package com.audittrail.app.poller;

import com.audittrail.app.model.ApiTrail;
import com.audittrail.app.model.Trail;
import com.audittrail.app.service.TrailProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TrailReceiver {
    @Autowired
    private TrailProcessor trailProcessor;
    @SqsListener(value = "apiTrailQueue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(final ApiTrail apiTrail, @Header("SenderId") String senderId) {
        log.info("trail received {}, {}", senderId, apiTrail);
        trailProcessor.process(apiTrail);
        log.info("trail processed successfully");
    }
}
