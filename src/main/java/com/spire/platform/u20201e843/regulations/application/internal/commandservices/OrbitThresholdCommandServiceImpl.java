package com.spire.platform.u20201e843.regulations.application.internal.commandservices;

import com.spire.platform.u20201e843.regulations.domain.model.commands.SeedOrbitThresholdsCommand;
import com.spire.platform.u20201e843.regulations.domain.model.entities.OrbitThreshold;
import com.spire.platform.u20201e843.regulations.domain.services.OrbitThresholdCommandService;
import com.spire.platform.u20201e843.regulations.infrastructure.persistence.jpa.repositories.OrbitThresholdRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class OrbitThresholdCommandServiceImpl implements OrbitThresholdCommandService {

    private final OrbitThresholdRepository orbitThresholdRepository;

    public OrbitThresholdCommandServiceImpl(OrbitThresholdRepository orbitThresholdRepository) {
        this.orbitThresholdRepository = orbitThresholdRepository;
    }

    @Override
    public void handle(SeedOrbitThresholdsCommand command) {
        if (orbitThresholdRepository.count() > 0) {
            return;
        }

        var thresholds = Arrays.asList(
                new OrbitThreshold("LEO", 300),
                new OrbitThreshold("MEO", 450),
                new OrbitThreshold("GEO", 600)
        );

        orbitThresholdRepository.saveAll(thresholds);
    }
}
