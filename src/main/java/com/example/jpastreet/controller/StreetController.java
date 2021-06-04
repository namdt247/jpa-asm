package com.example.jpastreet.controller;

import com.example.jpastreet.dto.StreetDTO;
import com.example.jpastreet.service.DistrictService;
import com.example.jpastreet.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/streets")
public class StreetController {
    @Autowired
    StreetService streetService;
    @Autowired
    DistrictService districtService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public StreetDTO create(@RequestBody StreetDTO streetDTO) {
        return streetService.create(streetDTO.toStreet()).toStreetDTO();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<StreetDTO> list() {
        return streetService.list().stream().map(x -> x.toStreetDTO()).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<StreetDTO> findAllByDistrictIdAndName(@RequestParam(defaultValue = "") String streetName, @RequestParam(defaultValue = "-1") int districtId) {
        List<StreetDTO> list = null;
        if (districtId != -1 && !streetName.equals("")) {
            list = streetService.findStreetByNameContainsAndDistrictId(streetName, districtId).stream().map(x -> x.toStreetDTO()).collect(Collectors.toList());
        } else if (districtId == -1 && !streetName.equals("")) {
            list = streetService.findStreetByNameContains(streetName).stream().map(x -> x.toStreetDTO()).collect(Collectors.toList());
        } else if (districtId != -1 && streetName.equals("")) {
            list = streetService.findStreetByDistrictId(districtId).stream().map(x -> x.toStreetDTO()).collect(Collectors.toList());
        } else {
            list = streetService.list().stream().map(x -> x.toStreetDTO()).collect(Collectors.toList());
        }
        return list;
    }

}
