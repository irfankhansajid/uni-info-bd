
package com.uniinfobd.uniinfo.bd.service;

import com.uniinfobd.uniinfo.bd.dto.UniversityRequestDTO;
import com.uniinfobd.uniinfo.bd.dto.UniversityResponseDTO;
import com.uniinfobd.uniinfo.bd.entity.UniversityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UniversityService {

    UniversityResponseDTO createUniversity(UniversityRequestDTO universityRequestDTO);
    UniversityResponseDTO getUniversityById(Long id);
    Page<UniversityResponseDTO> getAllUniversities(Pageable pageable);
    UniversityResponseDTO updateUniversity(Long id, UniversityRequestDTO universityRequestDTO);
    void deleteUniversity(Long id);

    // search methods

    List<UniversityResponseDTO> findByName(String name);
    List<UniversityResponseDTO> findByLocation(String location);
    List<UniversityResponseDTO> findByType(UniversityType type);


}
