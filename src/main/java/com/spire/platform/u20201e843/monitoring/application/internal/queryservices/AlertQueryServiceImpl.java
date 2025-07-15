package com.spire.platform.u20201e843.monitoring.application.internal.queryservices;

import com.spire.platform.u20201e843.monitoring.domain.model.aggregates.Alert;
import com.spire.platform.u20201e843.monitoring.domain.model.queries.GetAllAlertsQuery;
import com.spire.platform.u20201e843.monitoring.domain.services.AlertQueryService;
import com.spire.platform.u20201e843.monitoring.infrastructure.persistence.jpa.repositories.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertQueryServiceImpl implements AlertQueryService {

    private final AlertRepository alertRepository;

    public AlertQueryServiceImpl(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public List<Alert> handle(GetAllAlertsQuery query) {
        return alertRepository.findAll();
    }
}
