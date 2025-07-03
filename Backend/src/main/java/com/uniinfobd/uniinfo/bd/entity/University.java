package com.uniinfobd.uniinfo.bd.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "universities")
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

    @NotNull(message = "University type is required")
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
    private String websiteUrl;

    @Column(name = "phone_number")
    @Size(max = 20, message = "Phone number cannot exceed 20 characters")
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

    public University() {
    }

    public University(Long id, String name, String location, UniversityType type, Integer establishedYear,
                      String description, String websiteUrl, String phoneNumber, String email,
                      BigDecimal tuitionFeeRangeMin, BigDecimal tuitionFeeRangeMax, List<String> availableSubjects,
                      Integer totalStudents, Integer totalFaculty, BigDecimal campusSizeAcres, String logoUrl,
                      Integer localRankingPosition, Integer internationalRankingPosition, Boolean isActive,
                      LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
        this.establishedYear = establishedYear;
        this.description = description;
        this.websiteUrl = websiteUrl;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.tuitionFeeRangeMin = tuitionFeeRangeMin;
        this.tuitionFeeRangeMax = tuitionFeeRangeMax;
        this.availableSubjects = availableSubjects;
        this.totalStudents = totalStudents;
        this.totalFaculty = totalFaculty;
        this.campusSizeAcres = campusSizeAcres;
        this.logoUrl = logoUrl;
        this.localRankingPosition = localRankingPosition;
        this.internationalRankingPosition = internationalRankingPosition;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UniversityType getType() {
        return type;
    }

    public void setType(UniversityType type) {
        this.type = type;
    }

    public Integer getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(Integer establishedYear) {
        this.establishedYear = establishedYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getTuitionFeeRangeMin() {
        return tuitionFeeRangeMin;
    }

    public void setTuitionFeeRangeMin(BigDecimal tuitionFeeRangeMin) {
        this.tuitionFeeRangeMin = tuitionFeeRangeMin;
    }

    public BigDecimal getTuitionFeeRangeMax() {
        return tuitionFeeRangeMax;
    }

    public void setTuitionFeeRangeMax(BigDecimal tuitionFeeRangeMax) {
        this.tuitionFeeRangeMax = tuitionFeeRangeMax;
    }

    public List<String> getAvailableSubjects() {
        return availableSubjects;
    }

    public void setAvailableSubjects(List<String> availableSubjects) {
        this.availableSubjects = availableSubjects;
    }

    public Integer getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(Integer totalStudents) {
        this.totalStudents = totalStudents;
    }

    public Integer getTotalFaculty() {
        return totalFaculty;
    }

    public void setTotalFaculty(Integer totalFaculty) {
        this.totalFaculty = totalFaculty;
    }

    public BigDecimal getCampusSizeAcres() {
        return campusSizeAcres;
    }

    public void setCampusSizeAcres(BigDecimal campusSizeAcres) {
        this.campusSizeAcres = campusSizeAcres;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getLocalRankingPosition() {
        return localRankingPosition;
    }

    public void setLocalRankingPosition(Integer localRankingPosition) {
        this.localRankingPosition = localRankingPosition;
    }

    public Integer getInternationalRankingPosition() {
        return internationalRankingPosition;
    }

    public void setInternationalRankingPosition(Integer internationalRankingPosition) {
        this.internationalRankingPosition = internationalRankingPosition;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
