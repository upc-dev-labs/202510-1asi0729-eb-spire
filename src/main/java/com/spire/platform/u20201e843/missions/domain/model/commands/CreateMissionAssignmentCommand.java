package com.spire.platform.u20201e843.missions.domain.model.commands;

import java.time.LocalDateTime;

public record CreateMissionAssignmentCommand(
    String satelliteCode,
    String orbitClass,
    Integer estimatedDuration,
    String status,
    LocalDateTime requestedAt
) {
    public CreateMissionAssignmentCommand {
        if (orbitClass == null || orbitClass.isBlank())
            throw new IllegalArgumentException("Orbit class cannot be null or empty");
        if (estimatedDuration == null || estimatedDuration <= 0)
            throw new IllegalArgumentException("Estimated duration cannot be null or non-positive");
        if (status == null || status.isBlank())
            throw new IllegalArgumentException("Status cannot be null or empty");
        if (requestedAt == null || requestedAt.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("Requested date cannot be in the future");
    }
}
