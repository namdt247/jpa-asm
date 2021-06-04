package com.example.jpastreet.repository;

import com.example.jpastreet.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Integer> {
    public List<Street> findStreetByNameContainsAndDistrictId(String streetName, int districtId);

    public List<Street> findStreetByNameContains(String streetName);

    public List<Street> findStreetByDistrictId(int districtId);
}
