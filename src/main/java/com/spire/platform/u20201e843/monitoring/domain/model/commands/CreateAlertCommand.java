package com.spire.platform.u20201e843.monitoring.domain.model.commands;

public record CreateAlertCommand(
        String satelliteCode,
        String alertType
) {
    public CreateAlertCommand {
        if (alertType == null || alertType.isBlank())
            throw new IllegalArgumentException("Alert type cannot be null or empty");
    }
}
