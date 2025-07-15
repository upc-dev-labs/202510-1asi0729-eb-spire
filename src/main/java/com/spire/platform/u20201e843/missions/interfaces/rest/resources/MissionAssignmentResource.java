package com.spire.platform.u20201e843.missions.interfaces.rest.resources;

import java.time.LocalDateTime;

public record MissionAssignmentResource(
        Long id,
        String satelliteCode,
        String orbitClass,
        Integer estimatedDuration,
        String status,
        LocalDateTime requestedAt
) {
}
