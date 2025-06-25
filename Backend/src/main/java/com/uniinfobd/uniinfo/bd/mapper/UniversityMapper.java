package com.uniinfobd.uniinfo.bd.mapper;

import com.uniinfobd.uniinfo.bd.dto.UniversityRequestDTO;
import com.uniinfobd.uniinfo.bd.dto.UniversityResponseDTO;
import com.uniinfobd.uniinfo.bd.entity.University;

public class UniversityMapper {

    public static UniversityResponseDTO toResponseDTO(University university) {
        if (university == null) return null;

        return UniversityResponseDTO.builder()
                .id(university.getId())
                .name(university.getName())
                .location(university.getLocation())
                .type(university.getType())
                .establishedYear(university.getEstablishedYear())
                .description(university.getDescription())
                .websiteUrl(university.getWebsiteUrl())
                .phoneNumber(university.getPhoneNumber())
                .email(university.getEmail())
                .tuitionFeeRangeMin(university.getTuitionFeeRangeMin())
                .tuitionFeeRangeMax(university.getTuitionFeeRangeMax())
                .availableSubjects(university.getAvailableSubjects())
                .totalStudents(university.getTotalStudents())
                .totalFaculty(university.getTotalFaculty())
                .campusSizeAcres(university.getCampusSizeAcres())
                .logoUrl(university.getLogoUrl())
                .localRankingPosition(university.getLocalRankingPosition())
                .internationalRankingPosition(university.getInternationalRankingPosition())
                .createdAt(university.getCreatedAt())
                .updatedAt(university.getUpdatedAt())
                .build();

    }

    public static University toEntity(UniversityRequestDTO requestDTO) {
        if (requestDTO == null) return null;
        University university = new University();
        university.setName(requestDTO.getName());
        university.setLocation(requestDTO.getLocation());
        university.setType(requestDTO.getType());
        university.setEstablishedYear(requestDTO.getEstablishedYear());
        university.setDescription(requestDTO.getDescription());
        university.setWebsiteUrl(requestDTO.getWebsiteUrl());
        university.setPhoneNumber(requestDTO.getPhoneNumber());
        university.setEmail(requestDTO.getEmail());
        university.setTuitionFeeRangeMin(requestDTO.getTuitionFeeRangeMin());
        university.setTuitionFeeRangeMax(requestDTO.getTuitionFeeRangeMax());
        university.setAvailableSubjects(requestDTO.getAvailableSubjects());
        university.setTotalStudents(requestDTO.getTotalStudents());
        university.setTotalFaculty(requestDTO.getTotalFaculty());
        university.setCampusSizeAcres(requestDTO.getCampusSizeAcres());
        university.setLogoUrl(requestDTO.getLogoUrl());
        university.setLocalRankingPosition(requestDTO.getLocalRankingPosition());
        university.setInternationalRankingPosition(requestDTO.getInternationalRankingPosition());
        university.setIsActive(requestDTO.getIsActive());

        return university;


    }

    public static void updateEntityFromDto(UniversityRequestDTO requestDTO, University university) {
        if (requestDTO == null || university == null) return;

        if (requestDTO.getName() != null) university.setName(requestDTO.getName());
        if (requestDTO.getLocation() != null) university.setLocation(requestDTO.getLocation());
        if (requestDTO.getType() != null) university.setType(requestDTO.getType());
        if (requestDTO.getEstablishedYear() != null) university.setEstablishedYear(requestDTO.getEstablishedYear());
        if (requestDTO.getDescription() != null) university.setDescription(requestDTO.getDescription());
        if (requestDTO.getWebsiteUrl() != null) university.setWebsiteUrl(requestDTO.getWebsiteUrl());
        if (requestDTO.getPhoneNumber() != null) university.setPhoneNumber(requestDTO.getPhoneNumber());
        if (requestDTO.getEmail() != null) university.setEmail(requestDTO.getEmail());
        if (requestDTO.getTuitionFeeRangeMin() != null) university.setTuitionFeeRangeMin(requestDTO.getTuitionFeeRangeMin());
        if (requestDTO.getTuitionFeeRangeMax() != null) university.setTuitionFeeRangeMax(requestDTO.getTuitionFeeRangeMax());
        if (requestDTO.getAvailableSubjects() != null) university.setAvailableSubjects(requestDTO.getAvailableSubjects());
        if (requestDTO.getTotalStudents() != null) university.setTotalStudents(requestDTO.getTotalStudents());
        if (requestDTO.getTotalFaculty() != null) university.setTotalFaculty(requestDTO.getTotalFaculty());
        if (requestDTO.getCampusSizeAcres() != null) university.setCampusSizeAcres(requestDTO.getCampusSizeAcres());
        if (requestDTO.getLogoUrl() != null) university.setLogoUrl(requestDTO.getLogoUrl());
        if (requestDTO.getLocalRankingPosition() != null) university.setLocalRankingPosition(requestDTO.getLocalRankingPosition());
        if (requestDTO.getInternationalRankingPosition() != null) university.setInternationalRankingPosition(requestDTO.getInternationalRankingPosition());
        if (requestDTO.getIsActive() != null) university.setIsActive(requestDTO.getIsActive());

    }

}
