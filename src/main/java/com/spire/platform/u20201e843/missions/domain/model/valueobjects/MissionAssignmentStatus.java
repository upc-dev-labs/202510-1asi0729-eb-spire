package com.spire.platform.u20201e843.missions.domain.model.valueobjects;

import lombok.Getter;

/**
 * Mission assignment status with numeric ID mapping.
 *
 * @author Author
 * @since 1.0
 */
@Getter
public enum MissionAssignmentStatus {
    SCHEDULED(0, "SCHEDULED"),
    REJECTED(1, "REJECTED");

    private final int id;

    private final String label;

    MissionAssignmentStatus(int id, String label) {
        this.id = id;
        this.label = label;
    }

    /**
     * Returns the MissionAssignmentStatus corresponding to the given ID.
     *
     * @param id the status ID
     * @return the matching MissionAssignmentStatus
     * @throws IllegalArgumentException if no matching status is found
     */
    public static MissionAssignmentStatus fromId(int id) {
        for (MissionAssignmentStatus status : values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid MissionAssignmentStatus id: " + id);
    }

    /**
     * Returns the MissionAssignmentStatus corresponding to the given label.
     *
     * @param label the status label (case-insensitive)
     * @return the matching MissionAssignmentStatus
     * @throws IllegalArgumentException if no matching status is found
     */
    public static MissionAssignmentStatus fromLabel(String label) {
        label = label.toUpperCase();
        for (MissionAssignmentStatus status : values()) {
            if (status.label.equals(label)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid MissionAssignmentStatus label: " + label);
    }
}
