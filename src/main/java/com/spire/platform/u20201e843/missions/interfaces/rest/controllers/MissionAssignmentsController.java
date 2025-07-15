package com.spire.platform.u20201e843.missions.interfaces.rest.controllers;

import com.spire.platform.u20201e843.missions.domain.services.MissionAssignmentCommandService;
import com.spire.platform.u20201e843.missions.interfaces.rest.resources.CreateMissionAssignmentResource;
import com.spire.platform.u20201e843.missions.interfaces.rest.resources.MissionAssignmentResource;
import com.spire.platform.u20201e843.missions.interfaces.rest.transform.CreateMissionAssignmentCommandFromResourceAssembler;
import com.spire.platform.u20201e843.missions.interfaces.rest.transform.MissionAssignmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/mission-assignments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Missions Assignments", description = "Endpoints for managing mission assignments")
public class MissionAssignmentsController {

    private final MissionAssignmentCommandService missionAssignmentCommandService;

    public MissionAssignmentsController(MissionAssignmentCommandService missionAssignmentCommandService) {
        this.missionAssignmentCommandService = missionAssignmentCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a mission assignment", description = "Registers a mission assignment in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mission assignment successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "409", description = "Mission assignment with given UUID already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<MissionAssignmentResource> createMissionAssignment(@RequestBody CreateMissionAssignmentResource resource) {
        var createMissionAssignmentCommand = CreateMissionAssignmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var missionAssignment = missionAssignmentCommandService.handle(createMissionAssignmentCommand);
        if (missionAssignment.isEmpty()) return ResponseEntity.badRequest().build();
        var missionAssignmentEntity = missionAssignment.get();
        var missionAssignmentResource = MissionAssignmentResourceFromEntityAssembler.toResourceFroEntity(missionAssignmentEntity);
        return new ResponseEntity<>(missionAssignmentResource, HttpStatus.CREATED);
    }
}
