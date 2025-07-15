package com.spire.platform.u20201e843.regulations.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class OrbitThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String orbitClass;

    @NotNull
    @Min(1)
    private Integer maxSafeDuration;

    public OrbitThreshold(String orbitClass,Integer maxSafeDuration) {
        this.orbitClass = orbitClass;
        this.maxSafeDuration = maxSafeDuration;
    }

    public boolean calculateSuboptimalUse(Integer estimatedDuration) {
        var permittedDuration = this.maxSafeDuration * 0.2;
        return estimatedDuration < permittedDuration;
    }
}
