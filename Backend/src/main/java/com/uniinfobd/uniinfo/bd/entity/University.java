package com.uniinfobd.uniinfo.bd.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "universities")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true, nullable = false)
    @NotBlank(message = "University name is required")
    @Size(max = 300, message = "University name cannot exceed 300 characters")
    private String name;



    @Column(nullable = false)
    @NotBlank(message = "Location is required")
    private String location;



    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UniversityType type;


    @Column(name = "established_year")
    @Min(value = 1800, message = "Established year must be after 1800")
    @Max(value = 2025, message = "Established year cannot be in the future")
    private Integer establishedYear;


    @Column(columnDefinition = "TEXT")
    private String description;



    @Column(name = "website_url")
    @Pattern(regexp = "^(https?://).*", message = "Website URL must start with http:// or https://")
    private String websiteUrl;

    @Column(name = "phone_number")
    @Pattern(regexp = "^(\\+8801|01)[0-9]{9}$", message = "Invalid Bangladeshi phone number")
    private String phoneNumber;

    @Column(unique = true, nullable = false)
    @Email(message = "Please provide a valid email address")
    private String email;

    @Column(name = "tuition_fee_range_min")
    @DecimalMin(value = "0.0", message = "Minimum tuition fee cannot be negative")
    private BigDecimal tuitionFeeRangeMin;


    @Column(name = "tuition_fee_range_max")
    @DecimalMin(value = "0.0", message = "Maximum tuition fee cannot be negative")
    private BigDecimal tuitionFeeRangeMax;


    @ElementCollection
    @CollectionTable(name = "university_subjects", joinColumns = @JoinColumn(name = "university_id"))
    private List<String> availableSubjects;


    @Column(name = "total_students")
    @Min(value = 0, message = "Total students cannot be negative")
    private Integer totalStudents;

    @Column(name = "total_faculty")
    @Min(value = 0, message = "Total faculty cannot be negative")
    private Integer totalFaculty;

    @Column(name = "campus_size_acres")
    @DecimalMin(value = "0.0", message = "Campus size cannot be negative")
    private BigDecimal campusSizeAcres;


    @URL(message = "Please provide a valid URL")
    @Column(name = "logo_url")
    private String logoUrl;


    @Column(name = "local_ranking_position")
    private Integer localRankingPosition;

    @Column(name = "international_ranking_position")
    private Integer internationalRankingPosition;


    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
