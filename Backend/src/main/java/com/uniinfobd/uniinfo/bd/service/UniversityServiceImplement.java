
package com.uniinfobd.uniinfo.bd.service;

import com.uniinfobd.uniinfo.bd.dto.UniversityRequestDTO;
import com.uniinfobd.uniinfo.bd.dto.UniversityResponseDTO;
import com.uniinfobd.uniinfo.bd.dto.UniversityUpdateDTO;
import com.uniinfobd.uniinfo.bd.entity.University;
import com.uniinfobd.uniinfo.bd.entity.UniversityType;
import com.uniinfobd.uniinfo.bd.exception.ResourceNotFoundException;
import com.uniinfobd.uniinfo.bd.mapper.UniversityMapper;
import com.uniinfobd.uniinfo.bd.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UniversityServiceImplement implements UniversityService{

    private final UniversityRepository universityRepository;

    private static final String ENTITY_NAME = "University";

    @Override
    @Transactional
    public UniversityResponseDTO createUniversity(UniversityRequestDTO universityRequestDTO) {

        University university = UniversityMapper.toEntity(universityRequestDTO);
        University savedUniversity = universityRepository.save(university);
        return UniversityMapper.toResponseDTO(savedUniversity);

    }

    @Override
    public UniversityResponseDTO getUniversityById(Long id) {
        University university = universityRepository.findById(id).orElseThrow( () ->
                new ResourceNotFoundException(ENTITY_NAME, "id", id));
        return UniversityMapper.toResponseDTO(university);
    }

    @Override
    public Page<UniversityResponseDTO> getAllUniversities(Pageable pageable) {
        return universityRepository.findAll(pageable)
                .map(UniversityMapper::toResponseDTO);
    }

    @Override
    @Transactional
    public UniversityResponseDTO updateUniversity(Long id, UniversityRequestDTO universityRequestDTO) {
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
        UniversityMapper.updateEntityFromDto(universityRequestDTO, university);
        University updatedUniversity = universityRepository.save(university);
        return UniversityMapper.toResponseDTO(updatedUniversity);
    }

    @Override
    @Transactional
    public void deleteUniversity(Long id) {
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
        universityRepository.delete(university);
    }

    @Override
    public UniversityResponseDTO patchUniversity(Long id, UniversityUpdateDTO updateDTO) {
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));

        if (updateDTO.getName() != null) {
            university.setName(updateDTO.getName());
        }
        if (updateDTO.getLocation() != null) {
            university.setLocation(updateDTO.getLocation());
        }
        if (updateDTO.getType() != null) {
            university.setType(updateDTO.getType());
        }
        if (updateDTO.getEstablishedYear() != null) {
            university.setEstablishedYear(updateDTO.getEstablishedYear());
        }
        if (updateDTO.getDescription() != null) {
            university.setDescription(updateDTO.getDescription());
        }
        if (updateDTO.getWebsiteUrl() != null) {
            university.setWebsiteUrl(updateDTO.getWebsiteUrl());
        }
        if (updateDTO.getPhoneNumber() != null) {
            university.setPhoneNumber(updateDTO.getPhoneNumber());
        }
        if (updateDTO.getEmail() != null) {
            university.setEmail(updateDTO.getEmail());
        }
        if (updateDTO.getTuitionFeeRangeMin() != null) {
            university.setTuitionFeeRangeMin(updateDTO.getTuitionFeeRangeMin());
        }
        if (updateDTO.getTuitionFeeRangeMax() != null) {
            university.setTuitionFeeRangeMax(updateDTO.getTuitionFeeRangeMax());
        }
        if (updateDTO.getAvailableSubjects() != null) {
            university.setAvailableSubjects(updateDTO.getAvailableSubjects());
        }
        if (updateDTO.getTotalStudents() != null) {
            university.setTotalStudents(updateDTO.getTotalStudents());
        }
        if (updateDTO.getTotalFaculty() != null) {
            university.setTotalFaculty(updateDTO.getTotalFaculty());
        }
        if (updateDTO.getCampusSizeAcres() != null) {
            university.setCampusSizeAcres(updateDTO.getCampusSizeAcres());
        }
        if (updateDTO.getLogoUrl() != null) {
            university.setLogoUrl(updateDTO.getLogoUrl());
        }
        if (updateDTO.getLocalRankingPosition() != null) {
            university.setLocalRankingPosition(updateDTO.getLocalRankingPosition());
        }
        if (updateDTO.getInternationalRankingPosition() != null) {
            university.setInternationalRankingPosition(updateDTO.getInternationalRankingPosition());
        }
        if (updateDTO.getIsActive() != null) {
            university.setActive(updateDTO.getIsActive());
        }

        University updatedUniversity = universityRepository.save(university);
        return UniversityMapper.toResponseDTO(updatedUniversity);
    }




    @Override
    public List<UniversityResponseDTO> findByName(String name) {
        return universityRepository.findByNameIgnoreCaseContaining(name)
                .stream().map(UniversityMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<UniversityResponseDTO> findByLocation(String location) {
        return universityRepository.findByLocationIgnoreCaseContaining(location)
                .stream().map(UniversityMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<UniversityResponseDTO> findByType(UniversityType type) {
        return universityRepository.findByType(type).stream().map(UniversityMapper::toResponseDTO)
                .toList();
    }

}
