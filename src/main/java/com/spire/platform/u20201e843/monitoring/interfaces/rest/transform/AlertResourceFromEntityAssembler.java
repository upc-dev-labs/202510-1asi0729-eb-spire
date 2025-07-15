package com.spire.platform.u20201e843.monitoring.interfaces.rest.transform;

import com.spire.platform.u20201e843.monitoring.domain.model.aggregates.Alert;
import com.spire.platform.u20201e843.monitoring.interfaces.rest.resources.AlertResource;

public class AlertResourceFromEntityAssembler {
    public static AlertResource toResourceFromEntity(Alert entity) {
        return new AlertResource(
                entity.getId(),
                entity.getSatelliteCode().satelliteCode().toString(),
                entity.getAlertType().getLabel(),
                entity.getRegisteredAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
