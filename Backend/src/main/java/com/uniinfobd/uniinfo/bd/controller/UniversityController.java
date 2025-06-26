package com.uniinfobd.uniinfo.bd.controller;


import com.uniinfobd.uniinfo.bd.dto.UniversityRequestDTO;
import com.uniinfobd.uniinfo.bd.dto.UniversityResponseDTO;
import com.uniinfobd.uniinfo.bd.service.UniversityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/universities")
@Tag(name = "University", description = "University management APIs")
public class UniversityController {

    private final UniversityService universityService;

    @Operation(summary = "Create a new university", description ="Creates a new university and returns the created university details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "University created Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UniversityResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<UniversityResponseDTO> createUniversity(@Valid @RequestBody UniversityRequestDTO universityRequestDTO) {
        return new ResponseEntity<>(universityService.createUniversity(universityRequestDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Get university by ID", description = "Returns university details by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieved university", content = @Content(schema = @Schema(implementation = UniversityResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "University not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping("/{id}")
    public ResponseEntity<UniversityResponseDTO> getUniversityById(@Parameter(description = "University ID", required = true) @PathVariable Long id) {
        return ResponseEntity.ok(universityService.getUniversityById(id));
    }


    @Operation(summary = "Get all universities with pagination", description = "Returns a paginated list of all universities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieved universities", content = @Content(schema = @Schema(implementation = UniversityResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping
    public ResponseEntity<Page<UniversityResponseDTO>> getAllUniversities(
            @Parameter(description = "Page number (0-based") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size") @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Sort field") @RequestParam(defaultValue = "name") String sortBy,
            @Parameter(description = "Sort direction (asc/desc)") @RequestParam(defaultValue = "asc") String direction
    )
    {
        Sort.Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Sort sort = Sort.by(sortDirection, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        return ResponseEntity.ok(universityService.getAllUniversities(pageable));
    }

    @Operation(summary = "Update university by ID", description = "Updates an existing university and returns the updated details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "University updated successfully", content = @Content(schema = @Schema(implementation = UniversityResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "University not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UniversityResponseDTO> updateUniversity(
            @Parameter(description = "University ID", required = true) @PathVariable Long id,
            @Valid @RequestBody UniversityRequestDTO universityRequestDTO) {
        return ResponseEntity.ok(universityService.updateUniversity(id, universityRequestDTO));
    }

    // Delete a university by ID

    @Operation(summary = "Delete University by ID", description = "Deletes a university by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "University deleted successfully"),
        @ApiResponse(responseCode = "404", description = "University not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@Parameter(description = "University ID", required = true) @PathVariable Long id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }

    // Seacrh universities by name
    @Operation(summary = "Search universities by name", description = "Return universities that match the name search")
    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<UniversityResponseDTO>> searchByName(@Parameter(description = "Name to search for", required = true) @PathVariable String name) {
        return ResponseEntity.ok(universityService.findByName(name));
    }

    // Search universities by location
    @Operation(summary = "Search universities by location", description = "Return universities that match the location search")
    @GetMapping("/search/location/{location}")
    public ResponseEntity<List<UniversityResponseDTO>> searchByLocation(@Parameter(description = "Location to search for", required = true) @PathVariable String location) {
        return ResponseEntity.ok(universityService.findByLocation(location));
    }
    
}
