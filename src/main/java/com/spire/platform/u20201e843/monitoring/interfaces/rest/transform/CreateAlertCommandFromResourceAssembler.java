package com.spire.platform.u20201e843.monitoring.interfaces.rest.transform;

import com.spire.platform.u20201e843.monitoring.domain.model.commands.CreateAlertCommand;
import com.spire.platform.u20201e843.monitoring.interfaces.rest.resources.CreateAlertResource;

public class CreateAlertCommandFromResourceAssembler {
    public static CreateAlertCommand toCommandFromResource(CreateAlertResource resource){
        return new  CreateAlertCommand(
                resource.satelliteCode(),
                resource.alertType()
        );
    }
}
