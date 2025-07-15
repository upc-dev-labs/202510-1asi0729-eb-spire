package com.spire.platform.u20201e843.monitoring.domain.services;

import com.spire.platform.u20201e843.monitoring.domain.model.commands.CreateAlertCommand;

public interface AlertCommandService {

    Long handle(CreateAlertCommand command);
}
