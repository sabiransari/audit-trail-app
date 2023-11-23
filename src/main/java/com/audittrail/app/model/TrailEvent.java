package com.audittrail.app.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;

@Data
public class TrailEvent {
    private RequestMethod requestMethod;
    private String requestPath;
    private String requestSource;
    private String requestBody;
    private String responseBody;
    private boolean successful;
    private Instant requestedAt;
}
