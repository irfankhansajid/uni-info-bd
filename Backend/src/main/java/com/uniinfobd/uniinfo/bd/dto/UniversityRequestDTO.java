package com.uniinfobd.uniinfo.bd.dto;

import com.uniinfobd.uniinfo.bd.entity.UniversityType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UniversityRequestDTO {

    @NotBlank(message = "University name is required")
    @Size(max = 200, message = "University name cannot exceed 200 characters")
    private String name;


    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "University type is required")
    private UniversityType type;

    @Min(value = 1800, message = "Established year must be after 1800")
    @Max(value = 2025, message = "Established year cannot be in the future")
    private Integer establishedYear;

    private String description;

    @Pattern(regexp = "^(https?://).*", message = "Website URL must start with http:// or https://")
    private String websiteUrl;

    @Pattern(regexp = "^(\\+8801|01)[0-9]{9}$", message = "Invalid Bangladeshi phone number")
    private String phoneNumber;


    @Email(message = "Please provide a valid email address")
    private String email;

    @DecimalMin(value = "0.0", message = "Minimum tuition fee cannot be negative")
    private BigDecimal tuitionFeeRangeMin;

    @DecimalMin(value = "0.0", message = "Maximum tuition fee cannot be negative")
    private BigDecimal tuitionFeeRangeMax;

    private List<String> availableSubjects;


    @Min(value = 0, message = "Total students cannot be negative")
    private Integer totalStudents;

    @Min(value = 0, message = "Total faculty cannot be negative")
    private Integer totalFaculty;

    @DecimalMin(value = "0.0", message = "Campus size cannot be negative")
    private BigDecimal campusSizeAcres;

    private String logoUrl;

    private Integer localRankingPosition;

    private Integer internationalRankingPosition;

    private Boolean isActive = true;

}
