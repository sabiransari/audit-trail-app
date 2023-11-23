package com.audittrail.app.model.db;

import com.audittrail.app.model.TrailType;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Setter
@Getter
@Table(name = "trail")
public class ApiTrailRecord extends TrailRecord {

    public ApiTrailRecord() {
        this.trailType = TrailType.Api;
    }

    @Id
    private Long id;
    private String requestSource;
    private RequestMethod requestMethod;
    private String requestPath;
    private String requestBody;
    private String responseBody;
    private boolean successful;
    private LocalDateTime requestTime;
}
