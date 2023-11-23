package com.audittrail.app.repository;

import com.audittrail.app.model.db.TrailRecord;
import org.springframework.data.repository.CrudRepository;

public interface TrailRepository extends CrudRepository<TrailRecord, Long> {
}
