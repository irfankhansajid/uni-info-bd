package com.uniinfobd.uniinfo.bd.repository;

import com.uniinfobd.uniinfo.bd.entity.University;
import com.uniinfobd.uniinfo.bd.entity.UniversityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {


    List<University> findNameIgnoreCaseContaining(String name);

    List<University> findByLocationIgnoreCaseContaining(String location);

    List<University> findByType(UniversityType type);
}
