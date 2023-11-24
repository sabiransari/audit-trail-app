package com.audittrail.app.model.db;

import com.audittrail.app.model.TrailType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name = "trail")
public class ApiTrailRecord extends TrailRecord {

    public ApiTrailRecord() {
        this.trailType = TrailType.Api;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String requestSource;
    @Enumerated(EnumType.STRING)
    private RequestMethod requestMethod;
    private String requestPath;
    private String requestBody;
    private String responseBody;
    private boolean successful;
    private LocalDateTime requestTime;
}
