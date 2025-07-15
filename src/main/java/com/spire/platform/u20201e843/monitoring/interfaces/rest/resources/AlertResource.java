package com.spire.platform.u20201e843.monitoring.interfaces.rest.resources;

import java.time.LocalDateTime;
import java.util.Date;

public record AlertResource(
        Long id,
        String satelliteCode,
        String alertType,
        LocalDateTime registeredAt,
        Date createdAt,
        Date updatedAt
) {
}
