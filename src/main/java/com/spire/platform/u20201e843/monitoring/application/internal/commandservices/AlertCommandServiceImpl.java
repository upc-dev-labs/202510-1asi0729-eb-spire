package com.spire.platform.u20201e843.monitoring.application.internal.commandservices;

import com.spire.platform.u20201e843.monitoring.domain.model.aggregates.Alert;
import com.spire.platform.u20201e843.monitoring.domain.model.commands.CreateAlertCommand;
import com.spire.platform.u20201e843.monitoring.domain.services.AlertCommandService;
import com.spire.platform.u20201e843.monitoring.infrastructure.persistence.jpa.repositories.AlertRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertCommandServiceImpl implements AlertCommandService {

    private final AlertRepository alertRepository;

    public AlertCommandServiceImpl(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public Long handle(CreateAlertCommand command) {
        var alert = new Alert(command);

        try {
            alertRepository.save(alert);
            return alert.getId();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving alert: %s".formatted(e.getMessage()));
        }
    }
}
