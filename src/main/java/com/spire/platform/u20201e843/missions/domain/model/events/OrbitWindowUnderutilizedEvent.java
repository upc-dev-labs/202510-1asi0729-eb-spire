package com.spire.platform.u20201e843.missions.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OrbitWindowUnderutilizedEvent extends ApplicationEvent {

    private final String satelliteCode;

    public OrbitWindowUnderutilizedEvent(Object source, String satelliteCode) {
        super(source);
        this.satelliteCode = satelliteCode;
    }
}
