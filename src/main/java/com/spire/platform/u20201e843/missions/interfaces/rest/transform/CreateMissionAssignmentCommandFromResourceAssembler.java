package com.spire.platform.u20201e843.missions.interfaces.rest.transform;

import com.spire.platform.u20201e843.missions.domain.model.commands.CreateMissionAssignmentCommand;
import com.spire.platform.u20201e843.missions.interfaces.rest.resources.CreateMissionAssignmentResource;

public class CreateMissionAssignmentCommandFromResourceAssembler {
    public static CreateMissionAssignmentCommand toCommandFromResource(CreateMissionAssignmentResource resource) {
        return new CreateMissionAssignmentCommand(
                resource.satelliteCode(),
                resource.orbitClass(),
                resource.estimatedDuration(),
                resource.status(),
                resource.requestedAt()
        );
    }
}
