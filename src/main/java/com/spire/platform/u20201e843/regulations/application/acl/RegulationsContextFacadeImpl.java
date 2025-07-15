package com.spire.platform.u20201e843.regulations.application.acl;

import com.spire.platform.u20201e843.regulations.infrastructure.persistence.jpa.repositories.OrbitThresholdRepository;
import com.spire.platform.u20201e843.regulations.interfaces.acl.RegulationsContextFacade;
import org.springframework.stereotype.Service;

@Service
public class RegulationsContextFacadeImpl implements RegulationsContextFacade {

    private final OrbitThresholdRepository orbitThresholdRepository;

    public RegulationsContextFacadeImpl(OrbitThresholdRepository orbitThresholdRepository) {
        this.orbitThresholdRepository = orbitThresholdRepository;
    }

    @Override
    public boolean existsOrbitThresholdByOrbitClass(String orbitClass) {
        return orbitThresholdRepository.existsByOrbitClass(orbitClass);
    }

    @Override
    public boolean isSuboptimalUse(String orbitClass, Integer estimatedDuration) {
        var orbitThreshold = orbitThresholdRepository.findByOrbitClass(orbitClass)
                .orElseThrow(() -> new IllegalArgumentException("Orbit threshold not found"));

        return orbitThreshold.calculateSuboptimalUse(estimatedDuration);
    }
}
