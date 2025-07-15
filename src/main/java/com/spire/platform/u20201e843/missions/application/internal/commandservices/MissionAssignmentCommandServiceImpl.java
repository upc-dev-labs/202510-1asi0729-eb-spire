package com.spire.platform.u20201e843.missions.application.internal.commandservices;

import com.spire.platform.u20201e843.missions.domain.model.aggregates.MissionAssignment;
import com.spire.platform.u20201e843.missions.domain.model.commands.CreateMissionAssignmentCommand;
import com.spire.platform.u20201e843.missions.domain.services.MissionAssignmentCommandService;
import com.spire.platform.u20201e843.missions.infrastructure.persistence.jpa.repositories.MissionAssignmentRepository;
import com.spire.platform.u20201e843.shared.domain.model.valueobjects.SatelliteCode;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;

@Service
public class MissionAssignmentCommandServiceImpl implements MissionAssignmentCommandService {

    private final MissionAssignmentRepository missionAssignmentRepository;

    public MissionAssignmentCommandServiceImpl(MissionAssignmentRepository missionAssignmentRepository) {
        this.missionAssignmentRepository = missionAssignmentRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<MissionAssignment> handle(CreateMissionAssignmentCommand command) {

        var date = command.requestedAt().toLocalDate();

        if (missionAssignmentRepository.existsBySatelliteCodeAndRequestedAtBetween(
                new SatelliteCode(command.satelliteCode()),
                date.atStartOfDay(),
                date.atTime(LocalTime.MAX)))
            throw new IllegalArgumentException(
                    "Mission assignment with satellite code %s and date %s already exists".formatted(command.satelliteCode(), date));

        var missionAssignment = new MissionAssignment(command);

        try {
            missionAssignmentRepository.save(missionAssignment);
            return Optional.of(missionAssignment);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving mission assignment: %s".formatted(e.getMessage()));
        }
    }
}
