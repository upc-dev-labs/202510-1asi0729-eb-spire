package com.spire.platform.u20201e843.monitoring.infrastructure.persistence.jpa.converters;

import com.spire.platform.u20201e843.monitoring.domain.model.valueobjects.AlertType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AlertTypeConverter implements AttributeConverter<AlertType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AlertType attribute) {
        if (attribute == null) return null;
        return attribute.getId();
    }

    @Override
    public AlertType convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        return AlertType.fromId(dbData);
    }
}
