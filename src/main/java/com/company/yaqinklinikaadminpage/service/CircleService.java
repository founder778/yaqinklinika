package com.company.yaqinklinikaadminpage.service;

import com.company.yaqinklinikaadminpage.dto.CircleDto;
import com.company.yaqinklinikaadminpage.entity.AnalizEntity;
import com.company.yaqinklinikaadminpage.entity.CircleEntity;
import com.company.yaqinklinikaadminpage.entity.DiagnostEntity;
import com.company.yaqinklinikaadminpage.repository.CircleRepository;
import com.company.yaqinklinikaadminpage.repository.DiagnostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleService {
    @Autowired
    CircleRepository circleRepository;
    public void create(CircleDto circle){
        if(circle.getA_c_id().contains("/")){
            String[] split = circle.getA_c_id().split("/");
            for (String s : split) {
                CircleEntity analizUz = new CircleEntity();
                analizUz.setA_c_id(Integer.parseInt(s));
                analizUz.setA_name(circle.getA_name());
                analizUz.setA_type(circle.getA_type());
                analizUz.setLan("UZ");
                circleRepository.save(analizUz);
                CircleEntity analizRu = new CircleEntity();
                analizRu.setA_c_id(Integer.parseInt(s));
                analizRu.setA_name(circle.getA_nameru());
                analizRu.setA_type(circle.getA_typeru());
                analizRu.setLan("RU");
                circleRepository.save(analizRu);
            }
        }
        else {
            CircleEntity analizUz = new CircleEntity();
            analizUz.setA_c_id(Integer.parseInt(circle.getA_c_id()));
            analizUz.setA_name(circle.getA_name());
            analizUz.setA_type(circle.getA_type());
            analizUz.setLan("UZ");
            circleRepository.save(analizUz);
            CircleEntity analizRu = new CircleEntity();
            analizRu.setA_c_id(Integer.parseInt(circle.getA_c_id()));
            analizRu.setA_name(circle.getA_nameru());
            analizRu.setA_type(circle.getA_typeru());
            analizRu.setLan("RU");
            circleRepository.save(analizRu);
        }
    }
    public List<String> getType(String table){
        return  circleRepository.findBytabel(table);
    }
}
