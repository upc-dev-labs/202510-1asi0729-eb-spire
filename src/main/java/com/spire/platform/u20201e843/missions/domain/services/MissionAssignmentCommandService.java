package com.spire.platform.u20201e843.missions.domain.services;

import com.spire.platform.u20201e843.missions.domain.model.aggregates.MissionAssignment;
import com.spire.platform.u20201e843.missions.domain.model.commands.CreateMissionAssignmentCommand;

import java.util.Optional;

public interface MissionAssignmentCommandService {

    Optional<MissionAssignment> handle(CreateMissionAssignmentCommand command);
}
