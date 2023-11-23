package com.audittrail.app.service;

import com.audittrail.app.model.ApiTrail;
import com.audittrail.app.model.Trail;
import com.audittrail.app.model.db.ApiTrailRecord;
import com.audittrail.app.repository.TrailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class ApiTrailProcessor implements TrailProcessor {
    @Autowired
    private TrailRepository trailRepository;

    @Override
    public void process(Trail trail) {
        ApiTrail apiTrail = (ApiTrail) trail;
        ApiTrailRecord trailRecord = toTrailRecord(apiTrail);
        trailRepository.save(trailRecord);
        log.debug("saved trail to db");
    }

    private static ApiTrailRecord toTrailRecord(ApiTrail apiTrail) {
        ApiTrailRecord trailRecord = new ApiTrailRecord();
        trailRecord.setRequestSource(apiTrail.getRequestSource());
        trailRecord.setRequestMethod(apiTrail.getRequestMethod());
        trailRecord.setRequestPath(apiTrail.getRequestPath());
        trailRecord.setRequestBody(apiTrail.getRequestBody());
        trailRecord.setResponseBody(apiTrail.getResponseBody());
        trailRecord.setSuccessful(apiTrail.isSuccessful());
        trailRecord.setRequestTime(LocalDateTime.now());
        return trailRecord;
    }
}
