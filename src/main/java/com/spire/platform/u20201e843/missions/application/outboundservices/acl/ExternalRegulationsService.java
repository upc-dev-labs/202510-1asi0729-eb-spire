package com.spire.platform.u20201e843.missions.application.outboundservices.acl;

import com.spire.platform.u20201e843.regulations.interfaces.acl.RegulationsContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalRegulationsService {

    private final RegulationsContextFacade regulationsContextFacade;

    public ExternalRegulationsService(RegulationsContextFacade regulationsContextFacade) {
        this.regulationsContextFacade = regulationsContextFacade;
    }

    public boolean existsOrbitThresholdByOrbitClass(String orbitClass) {
        return regulationsContextFacade.existsOrbitThresholdByOrbitClass(orbitClass);
    }

    public boolean isSuboptimalUse(String orbitClass, Integer estimatedDuration) {
        return regulationsContextFacade.isSuboptimalUse(orbitClass, estimatedDuration);
    }
}
