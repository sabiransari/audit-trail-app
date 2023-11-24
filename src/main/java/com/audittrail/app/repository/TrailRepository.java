package com.audittrail.app.repository;

import com.audittrail.app.model.db.TrailRecord;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailRepository extends PagingAndSortingRepository<TrailRecord, Long>, CrudRepository<TrailRecord, Long>, JpaSpecificationExecutor<TrailRecord> {
}
