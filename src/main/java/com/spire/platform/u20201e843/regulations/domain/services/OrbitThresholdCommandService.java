package com.spire.platform.u20201e843.regulations.domain.services;

import com.spire.platform.u20201e843.regulations.domain.model.commands.SeedOrbitThresholdsCommand;

public interface OrbitThresholdCommandService {

    void handle(SeedOrbitThresholdsCommand command);
}
