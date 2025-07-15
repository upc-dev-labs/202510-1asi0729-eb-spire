package com.spire.platform.u20201e843.missions.domain.model.aggregates;

import com.spire.platform.u20201e843.missions.domain.model.commands.CreateMissionAssignmentCommand;
import com.spire.platform.u20201e843.missions.domain.model.events.OrbitWindowUnderutilizedEvent;
import com.spire.platform.u20201e843.missions.domain.model.valueobjects.MissionAssignmentStatus;
import com.spire.platform.u20201e843.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.spire.platform.u20201e843.shared.domain.model.valueobjects.SatelliteCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class MissionAssignment extends AuditableAbstractAggregateRoot<MissionAssignment> {

    @Embedded
    @AttributeOverride(
            name = "satelliteCode",
            column = @Column(name = "satellite_code", nullable = false)
    )
    private SatelliteCode satelliteCode;

    @NotBlank
    @Column(nullable = false)
    private String orbitClass;

    @Min(1)
    @NotNull
    @Column(nullable = false)
    private Integer estimatedDuration;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private MissionAssignmentStatus status;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime requestedAt;

    /**
     * Default constructor for JPA.
     */
    protected MissionAssignment() {}

    public MissionAssignment(CreateMissionAssignmentCommand command) {
        this.satelliteCode = new SatelliteCode(command.satelliteCode());
        this.orbitClass = command.orbitClass();
        this.estimatedDuration = command.estimatedDuration();
        this.status = MissionAssignmentStatus.fromLabel(command.status());
        this.requestedAt = command.requestedAt();
    }

    public void markAsUnderutilized() {
        addDomainEvent(new OrbitWindowUnderutilizedEvent(
                this,
                this.satelliteCode.satelliteCode().toString()
        ));
    }
}
