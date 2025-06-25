package com.uniinfobd.uniinfo.bd.service;

import com.uniinfobd.uniinfo.bd.dto.UniversityRequestDTO;
import com.uniinfobd.uniinfo.bd.dto.UniversityResponseDTO;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityServiceImplement implements UniversityService{

    private final UniversityRepository universityRepository;

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
                new ResourceNotFoundException("University", "id", id));
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
                .orElseThrow(() -> new ResourceNotFoundException("University", "id", id));
        UniversityMapper.updateEntityFromDto(universityRequestDTO, university);
        University updatedUniversity = universityRepository.save(university);
        return UniversityMapper.toResponseDTO(updatedUniversity);
    }

    @Override
    @Transactional
    public void deleteUniversity(Long id) {
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University", "id", id));
        universityRepository.delete(university);
    }

    @Override
    public List<UniversityResponseDTO> findByName(String name) {
        return universityRepository.findNameIgnoreCaseContaining(name)
                .stream().map(UniversityMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UniversityResponseDTO> findByLocation(String location) {
        return universityRepository.findByLocationIgnoreCaseContaining(location)
                .stream().map(UniversityMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UniversityResponseDTO> findByType(UniversityType type) {
        return universityRepository.findByType(type).stream().map(UniversityMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
