package com.audittrail.app.service;

import com.audittrail.app.model.db.TrailRecord;
import com.audittrail.app.repository.TrailRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ApiTrailService {
    @Autowired
    private TrailRepository trailRepository;

    public void getTrail(String requestSource, RequestMethod requestMethod, String requestPath, Boolean successful, PageRequest pageRequest) {
        trailRepository.findAll(specs(requestSource, requestMethod, requestPath, successful), pageRequest);
    }

    private Specification<TrailRecord> specs(String requestSource, RequestMethod requestMethod, String requestPath, Boolean successful) {
        return (r, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (requestSource != null) {
                predicates.add(cb.equal(r.get("requestSource"), requestSource));
            }
            if (requestMethod != null) {
                predicates.add(cb.equal(r.get("requestMethod"), requestMethod));
            }
            if (requestPath != null) {
                predicates.add(cb.equal(r.get("requestPath"), requestPath));
            }
            if (successful != null) {
                predicates.add(cb.equal(r.get("successful"), successful));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
