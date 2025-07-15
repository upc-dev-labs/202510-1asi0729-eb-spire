package com.spire.platform.u20201e843.regulations.application.internal.eventhandlers;

import com.spire.platform.u20201e843.regulations.domain.model.commands.SeedOrbitThresholdsCommand;
import com.spire.platform.u20201e843.regulations.domain.services.OrbitThresholdCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ApplicationReadyEventHandler {

    private final OrbitThresholdCommandService orbitThresholdCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(OrbitThresholdCommandService orbitThresholdCommandService) {
        this.orbitThresholdCommandService = orbitThresholdCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if orbit thresholds seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedOrbitThresholds = new SeedOrbitThresholdsCommand();
        orbitThresholdCommandService.handle(seedOrbitThresholds);
        LOGGER.info("Orbit thresholds seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
