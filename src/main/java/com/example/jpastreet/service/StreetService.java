package com.example.jpastreet.service;

import com.example.jpastreet.entity.Street;
import com.example.jpastreet.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class StreetService {
    @Autowired
    StreetRepository streetRepository;
    public Street create(Street street){
        return streetRepository.save(street);
    }

    public List<Street> list() {
        return streetRepository.findAll();
    }
    public Street findById(int id){
        return streetRepository.findById(id).get();
    }
    public List<Street> findStreetByNameContainsAndDistrictId( String nameStreet,int districtId){
        return streetRepository.findStreetByNameContainsAndDistrictId(nameStreet,districtId);
    }
    public List<Street> findStreetByNameContains( String nameStreet){
        return streetRepository.findStreetByNameContains(nameStreet);
    }
    public List<Street> findStreetByDistrictId(int districtId){
        return streetRepository.findStreetByDistrictId(districtId);
    }
}
