package com.spire.platform.u20201e843.monitoring.infrastructure.persistence.jpa.repositories;

import com.spire.platform.u20201e843.monitoring.domain.model.aggregates.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alert,Long> {

}
