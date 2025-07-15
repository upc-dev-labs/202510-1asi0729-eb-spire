package com.spire.platform.u20201e843.missions.interfaces.rest.transform;

import com.spire.platform.u20201e843.missions.domain.model.aggregates.MissionAssignment;
import com.spire.platform.u20201e843.missions.interfaces.rest.resources.MissionAssignmentResource;

public class MissionAssignmentResourceFromEntityAssembler {
    public static MissionAssignmentResource toResourceFroEntity(MissionAssignment entity) {
        return new MissionAssignmentResource(
                entity.getId(),
                entity.getSatelliteCode().satelliteCode().toString(),
                entity.getOrbitClass(),
                entity.getEstimatedDuration(),
                entity.getStatus().getLabel(),
                entity.getRequestedAt()
        );
    }
}
