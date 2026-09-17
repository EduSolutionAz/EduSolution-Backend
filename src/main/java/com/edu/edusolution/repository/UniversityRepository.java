package com.edu.edusolution.repository;

import com.edu.edusolution.entity.country.CountryEntity;
import com.edu.edusolution.entity.university.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityEntity, UUID> {
    List<UniversityEntity> findAllByCountry(CountryEntity country);

    List<UniversityEntity> findAllByTopList(boolean topList);
}
