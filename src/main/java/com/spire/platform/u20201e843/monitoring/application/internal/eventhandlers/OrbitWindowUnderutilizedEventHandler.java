package com.spire.platform.u20201e843.monitoring.application.internal.eventhandlers;

import com.spire.platform.u20201e843.missions.domain.model.events.OrbitWindowUnderutilizedEvent;
import com.spire.platform.u20201e843.monitoring.domain.model.commands.CreateAlertCommand;
import com.spire.platform.u20201e843.monitoring.domain.model.valueobjects.AlertType;
import com.spire.platform.u20201e843.monitoring.domain.services.AlertCommandService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class OrbitWindowUnderutilizedEventHandler {

    private final AlertCommandService alertCommandService;

    public OrbitWindowUnderutilizedEventHandler(AlertCommandService alertCommandService) {
        this.alertCommandService = alertCommandService;
    }

    @EventListener
    public void on(OrbitWindowUnderutilizedEvent event) {
        var createAlertCommand = new CreateAlertCommand(
                event.getSatelliteCode(),
                AlertType.SYSTEM_ERROR.getLabel()
        );

        alertCommandService.handle(createAlertCommand);
    }
}
