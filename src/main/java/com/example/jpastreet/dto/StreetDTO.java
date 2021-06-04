package com.example.jpastreet.dto;

import com.example.jpastreet.entity.District;
import com.example.jpastreet.entity.Street;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StreetDTO {
    private int id;
    private String name;
    private long founding;
    private String description;
    private int status;
    private int districtId;
    private String districtName;
    public Street toStreet(){
        Street street = new Street();
        street.setId(this.id);
        street.setName(this.name);
        street.setFounding(this.founding);
        street.setDescription(this.description);
        street.setStatus(this.status);
        street.setDistrictId(this.districtId);
        street.setDistrict(new District(this.districtId,this.districtName, Collections.singleton(street)));
        return street;
    }
}
