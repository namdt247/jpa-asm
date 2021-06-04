package com.example.jpastreet.controller;

import com.example.jpastreet.dto.DistrictDTO;
import com.example.jpastreet.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/districts")
public class DistrictController {
    @Autowired
    DistrictService districtService;
    @RequestMapping(method = RequestMethod.GET)
    public List<DistrictDTO> list() {
        return districtService.list().stream().map(x -> x.toDistrictDTO()).collect(Collectors.toList());
    }
}
