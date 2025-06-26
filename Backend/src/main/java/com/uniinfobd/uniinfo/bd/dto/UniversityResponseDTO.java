
package com.uniinfobd.uniinfo.bd.dto;

import com.uniinfobd.uniinfo.bd.entity.UniversityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityResponseDTO {

    private Long id;
    private String name;
    private String location;
    private UniversityType type;
    private Integer establishedYear;
    private String description;
    private String websiteUrl;
    private String phoneNumber;
    private String email;
    private BigDecimal tuitionFeeRangeMin;
    private BigDecimal tuitionFeeRangeMax;
    private List<String> availableSubjects;
    private Integer totalStudents;
    private Integer totalFaculty;
    private BigDecimal campusSizeAcres;
    private String logoUrl;
    private Integer localRankingPosition;
    private Integer internationalRankingPosition;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
