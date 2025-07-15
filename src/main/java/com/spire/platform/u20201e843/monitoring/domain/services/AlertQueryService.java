package com.spire.platform.u20201e843.monitoring.domain.services;

import com.spire.platform.u20201e843.monitoring.domain.model.aggregates.Alert;
import com.spire.platform.u20201e843.monitoring.domain.model.queries.GetAllAlertsQuery;

import java.util.List;

public interface AlertQueryService {

    List<Alert> handle(GetAllAlertsQuery query);
}
