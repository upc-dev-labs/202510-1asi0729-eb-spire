package com.spire.platform.u20201e843.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record SatelliteCode(UUID satelliteCode) {
    public SatelliteCode {
        if (satelliteCode == null)
            throw new IllegalArgumentException("Satellite Code UUID cannot be null");
    }

    public SatelliteCode(String satelliteCode) {
        this(parseString(satelliteCode));
    }

    private static UUID parseString(String str) {
        if (str == null || str.isBlank())
            throw new IllegalArgumentException("Satellite Code cannot be null or empty");
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format for SatelliteCode: " + str, e);
        }
    }
}
