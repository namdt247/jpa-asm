package com.example.jpastreet.controller;

import com.example.jpastreet.entity.District;
import com.example.jpastreet.entity.Street;
import com.example.jpastreet.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/seed/generate")
public class SeedController {
    @Autowired
    DistrictService districtService;
    @RequestMapping(method = RequestMethod.GET)
    public String seed(){
        District district1 = new District("Ba Đình");
        district1.addStreet(new Street("Phan Đình Phùng", Calendar.getInstance().getTimeInMillis(),"Đường 2 chiều",1,district1));
        district1.addStreet(new Street("Cửa Bắc", Calendar.getInstance().getTimeInMillis(),"Đường 2 chiều",1,district1));
        District district2 = new District("Hoàn Kiếm");
        district2.addStreet(new Street("Hàng Ngang", Calendar.getInstance().getTimeInMillis(),"Đường 2 chiều",1,district2));
        district2.addStreet(new Street("Hàng Trống", Calendar.getInstance().getTimeInMillis(),"Đường 2 chiều",1,district2));
        District district3 = new District("Tây Hồ");
        district3.addStreet(new Street("Nhật Triêu", Calendar.getInstance().getTimeInMillis(),"Đường 2 chiều",1,district3));
        district3.addStreet(new Street("Nguyễn Đình Thi", Calendar.getInstance().getTimeInMillis(),"Đường 2 chiều",1,district3));
        District district4 = new District("Cầu Giấy");
        district4.addStreet(new Street("Cầu Giấy", Calendar.getInstance().getTimeInMillis(),"Đường 2 chiều",1,district4));
        district4.addStreet(new Street("Nguyễn Văn Huyên", Calendar.getInstance().getTimeInMillis(),"Đường 2 chiều",1,district4));
        District district5 = new District("Hoàng Mai");
        district5.addStreet(new Street("Xã Đàn", Calendar.getInstance().getTimeInMillis(),"Đường 2 chiều",1,district5));
        district5.addStreet(new Street("Đại Cồ Việt", Calendar.getInstance().getTimeInMillis(),"Đường 2 chiều",1,district5));
        List<District> districts = Arrays.asList(district1, district2, district3, district4,district5);
        districtService.saveAll(districts);
        return "success!";
    }

}
