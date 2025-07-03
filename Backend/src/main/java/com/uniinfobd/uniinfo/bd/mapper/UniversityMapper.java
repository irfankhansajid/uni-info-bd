
package com.uniinfobd.uniinfo.bd.mapper;

import com.uniinfobd.uniinfo.bd.dto.UniversityRequestDTO;
import com.uniinfobd.uniinfo.bd.dto.UniversityResponseDTO;
import com.uniinfobd.uniinfo.bd.entity.University;

public class UniversityMapper {

    private UniversityMapper() {
        // Private constructor to prevent instantiation
    }

    public static UniversityResponseDTO toResponseDTO(University university) {
        if (university == null) return null;

        UniversityResponseDTO dto = new UniversityResponseDTO();
        dto.setId(university.getId());
        dto.setName(university.getName());
        dto.setLocation(university.getLocation());
        dto.setType(university.getType());
        dto.setEstablishedYear(university.getEstablishedYear());
        dto.setDescription(university.getDescription());
        dto.setWebsiteUrl(university.getWebsiteUrl());
        dto.setPhoneNumber(university.getPhoneNumber());
        dto.setEmail(university.getEmail());
        dto.setTuitionFeeRangeMin(university.getTuitionFeeRangeMin());
        dto.setTuitionFeeRangeMax(university.getTuitionFeeRangeMax());
        dto.setAvailableSubjects(university.getAvailableSubjects());
        dto.setTotalStudents(university.getTotalStudents());
        dto.setTotalFaculty(university.getTotalFaculty());
        dto.setCampusSizeAcres(university.getCampusSizeAcres());
        dto.setLogoUrl(university.getLogoUrl());
        dto.setLocalRankingPosition(university.getLocalRankingPosition());
        dto.setInternationalRankingPosition(university.getInternationalRankingPosition());
        dto.setCreatedAt(university.getCreatedAt());
        dto.setUpdatedAt(university.getUpdatedAt());

        return dto;
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
        university.setActive(requestDTO.getIsActive());

        return university;


    }

    public static void updateEntityFromDto(UniversityRequestDTO requestDTO, University university) {
        if (requestDTO == null || university == null) return;

        updateBasicInfo(requestDTO, university);
        updateContactInfo(requestDTO, university);
        updateAcademicInfo(requestDTO, university);
        updateRankingInfo(requestDTO, university);
}

    private static void updateBasicInfo(UniversityRequestDTO dto, University university) {
        if (dto.getName() != null) university.setName(dto.getName());
        if (dto.getLocation() != null) university.setLocation(dto.getLocation());
        if (dto.getType() != null) university.setType(dto.getType());
        if (dto.getEstablishedYear() != null) university.setEstablishedYear(dto.getEstablishedYear());
        if (dto.getDescription() != null) university.setDescription(dto.getDescription());
        if (dto.getWebsiteUrl() != null) university.setWebsiteUrl(dto.getWebsiteUrl());
        if (dto.getLogoUrl() != null) university.setLogoUrl(dto.getLogoUrl());
        if (dto.getIsActive() != null) university.setActive(dto.getIsActive());
    }

    private static void updateContactInfo(UniversityRequestDTO dto, University university) {
        if (dto.getPhoneNumber() != null) university.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getEmail() != null) university.setEmail(dto.getEmail());
    }

    private static void updateAcademicInfo(UniversityRequestDTO dto, University university) {
        if (dto.getAvailableSubjects() != null) university.setAvailableSubjects(dto.getAvailableSubjects());
        if (dto.getTotalStudents() != null) university.setTotalStudents(dto.getTotalStudents());
        if (dto.getTotalFaculty() != null) university.setTotalFaculty(dto.getTotalFaculty());
        if (dto.getCampusSizeAcres() != null) university.setCampusSizeAcres(dto.getCampusSizeAcres());
        if (dto.getTuitionFeeRangeMin() != null) university.setTuitionFeeRangeMin(dto.getTuitionFeeRangeMin());
        if (dto.getTuitionFeeRangeMax() != null) university.setTuitionFeeRangeMax(dto.getTuitionFeeRangeMax());
    }

    private static void updateRankingInfo(UniversityRequestDTO dto, University university) {
        if (dto.getLocalRankingPosition() != null) university.setLocalRankingPosition(dto.getLocalRankingPosition());
        if (dto.getInternationalRankingPosition() != null) university.setInternationalRankingPosition(dto.getInternationalRankingPosition());
    }


}
