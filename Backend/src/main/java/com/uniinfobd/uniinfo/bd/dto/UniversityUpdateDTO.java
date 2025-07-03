<<<<<<< HEAD
package com.uniinfobd.uniinfo.bd.dto;public class UniversityUpdateDTO {
}
=======
package com.uniinfobd.uniinfo.bd.dto;

import com.uniinfobd.uniinfo.bd.entity.UniversityType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UniversityUpdateDTO {

    @Size(max = 300, message = "University name cannot exceed 300 characters")
    private String name;

    private String location;

    private UniversityType type;

    @Min(value = 1800, message = "Established year must be after 1800")
    @Max(value = 2025, message = "Established year cannot be in the future")
    private Integer establishedYear;

    private String description;

    @Pattern(regexp = "^(https?://).*", message = "Website URL must start with http:// or https://")
    private String websiteUrl;

    @Size(max = 20, message = "Phone number cannot exceed 20 characters")
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

    @Min(value = 1, message = "Local ranking position must be positive")
    private Integer localRankingPosition;

    @Min(value = 1, message = "International ranking position must be positive")
    private Integer internationalRankingPosition;

    private Boolean isActive;
}
>>>>>>> d0403b5 (Add initial User and Role entity classes)
