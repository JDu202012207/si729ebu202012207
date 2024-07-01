package org.hign.platform.u202012207.personnel.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u202012207.personnel.application.services.ExaminerService;
import org.hign.platform.u202012207.personnel.domain.model.Examiner;
import org.hign.platform.u202012207.personnel.interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.u202012207.personnel.interfaces.rest.resources.ExaminerResource;
import org.hign.platform.u202012207.personnel.interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ExaminerController.
 * <p>
 * This class provides RESTful endpoints for managing examiners.
 * </p>
 * <ul>
 *     <li>POST /api/v1/examiners - Create a new examiner</li>
 * </ul>
 *
 * @author Juan Cueto u202012207
 */
@RestController
@RequestMapping("/api/v1/examiners")
@Tag(name = "Examiners", description = "Endpoints for managing examiners")
public class ExaminerController {

    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    /**
     * Create a new examiner.
     *
     * @param resource the resource containing the examiner information
     * @return the created examiner resource
     */
    @PostMapping
    @Operation(summary = "Create a new examiner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Examiner created successfully",
                    content = @Content(schema = @Schema(implementation = ExaminerResource.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource resource) {
        Examiner examiner = examinerService.addExaminer(resource.firstName(), resource.lastName(), resource.nationalProviderIdentifier());
        ExaminerResource examinerResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(examiner);
        return new ResponseEntity<>(examinerResource, HttpStatus.CREATED);
    }
}


