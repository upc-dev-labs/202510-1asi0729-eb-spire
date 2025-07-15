package com.spire.platform.u20201e843.monitoring.domain.model.valueobjects;

import lombok.Getter;

/**
 * Alert type with numeric ID mapping.
 *
 * @author Author
 * @since 1.0
 */
@Getter
public enum AlertType {
    UNSAFE_ORBIT_TASK(0, "UNSAFE_ORBIT_TASK"),
    NODE_COMMUNICATION_LOST(1, "NODE_COMMUNICATION_LOST"),
    SYSTEM_ERROR(2, "SYSTEM_ERROR"),
    OTHER(3, "OTHER");

    private final int id;

    private final String label;

    AlertType(int id, String label) {
        this.id = id;
        this.label = label;
    }

    /**
     * Returns the AlertType corresponding to the given ID.
     *
     * @param id the type ID
     * @return the matching AlertType
     * @throws IllegalArgumentException if no matching type is found
     */
    public static AlertType fromId(int id) {
        for (AlertType alertType : AlertType.values()) {
            if (alertType.id == id) {
                return alertType;
            }
        }
        throw new IllegalArgumentException("Invalid AlertType id: " + id);
    }

    /**
     * Returns the AlertType corresponding to the given label.
     *
     * @param label the type label (case-insensitive)
     * @return the matching AlertType
     * @throws IllegalArgumentException if no matching type is found
     */
    public static AlertType fromLabel(String label) {
        label = label.toUpperCase();
        for (AlertType alertType : AlertType.values()) {
            if (alertType.label.equals(label)) {
                return alertType;
            }
        }
        throw new IllegalArgumentException("Invalid AlertType label: " + label);
    }
}
