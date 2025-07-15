package com.spire.platform.u20201e843.regulations.interfaces.acl;

public interface RegulationsContextFacade {

    boolean existsOrbitThresholdByOrbitClass(String orbitClass);

    boolean isSuboptimalUse(String orbitClass, Integer estimatedDuration);
}
