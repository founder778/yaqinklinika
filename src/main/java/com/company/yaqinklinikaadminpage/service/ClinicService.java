package com.company.yaqinklinikaadminpage.service;

import com.company.yaqinklinikaadminpage.entity.ClinicEntity;
import com.company.yaqinklinikaadminpage.repository.Clinicrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {
    @Autowired
    Clinicrepository clinicrepository;
    public void createClinic(ClinicEntity clinic){
        clinic.setC_name(clinic.getC_name().toLowerCase());
        clinicrepository.save(clinic);
    }
    public List<ClinicEntity> getAll(){
        return (List<ClinicEntity>) clinicrepository.findAll();
    }
    public boolean isexist(ClinicEntity clinic){
        Optional<ClinicEntity> result = clinicrepository.findByName(clinic.getC_name());
        if(result.isPresent() && result.get().getC_name().equalsIgnoreCase(clinic.getC_name())){
            return false;
        }
        return true;
    }

    public void delete(Integer id){
        clinicrepository.deleteById(id);
    }



}
