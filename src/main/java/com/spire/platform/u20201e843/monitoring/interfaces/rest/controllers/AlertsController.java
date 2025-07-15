package com.spire.platform.u20201e843.monitoring.interfaces.rest.controllers;

import com.spire.platform.u20201e843.monitoring.domain.model.queries.GetAllAlertsQuery;
import com.spire.platform.u20201e843.monitoring.domain.services.AlertCommandService;
import com.spire.platform.u20201e843.monitoring.domain.services.AlertQueryService;
import com.spire.platform.u20201e843.monitoring.interfaces.rest.resources.AlertResource;
import com.spire.platform.u20201e843.monitoring.interfaces.rest.transform.AlertResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/alerts", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Alerts", description = "Endpoints for managing alerts")
public class AlertsController {

    private final AlertCommandService alertCommandService;
    private final AlertQueryService alertQueryService;

    public AlertsController(AlertCommandService alertCommandService, AlertQueryService alertQueryService) {
        this.alertCommandService = alertCommandService;
        this.alertQueryService = alertQueryService;
    }

    @GetMapping
    @Operation(summary = "Get all alerts", description = "Get all alerts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alerts found"),
            @ApiResponse(responseCode = "404", description = "Alerts not found")})
    public ResponseEntity<List<AlertResource>> getAllAlerts() {
        var alerts = alertQueryService.handle(new GetAllAlertsQuery());
        if (alerts.isEmpty()) return ResponseEntity.notFound().build();
        var alertResources = alerts.stream()
                .map(AlertResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(alertResources);
    }
}
