package com.spire.platform.u20201e843.monitoring.domain.model.aggregates;

import com.spire.platform.u20201e843.monitoring.domain.model.commands.CreateAlertCommand;
import com.spire.platform.u20201e843.monitoring.domain.model.valueobjects.AlertType;
import com.spire.platform.u20201e843.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.spire.platform.u20201e843.shared.domain.model.valueobjects.SatelliteCode;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Alert extends AuditableAbstractAggregateRoot<Alert> {

    @Embedded
    @AttributeOverride(
            name = "satelliteCode",
            column = @Column(name = "satellite_code", nullable = false)
    )
    private SatelliteCode satelliteCode;

    @NotNull
    @Column(nullable = false)
    private AlertType alertType;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime registeredAt;

    protected Alert() {}

    public Alert(CreateAlertCommand command) {
        this.satelliteCode = new SatelliteCode(command.satelliteCode());
        this.alertType = AlertType.fromLabel(command.alertType());
        this.registeredAt = LocalDateTime.now();
    }
}
