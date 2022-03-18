package com.company.yaqinklinikaadminpage.service;

import com.company.yaqinklinikaadminpage.dto.AnalizDto;
import com.company.yaqinklinikaadminpage.entity.AnalizEntity;
import com.company.yaqinklinikaadminpage.repository.AnalizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalizService {
    @Autowired
    AnalizRepository analizRepository;
    public void create(AnalizDto analiz){
        if(analiz.getA_c_id().contains("/")){
            String[] split = analiz.getA_c_id().split("/");
            for (String s : split) {
                AnalizEntity analizUz = new AnalizEntity();
                analizUz.setA_c_id(Integer.parseInt(s));
                analizUz.setA_name(analiz.getA_name());
                analizUz.setA_type(analiz.getA_type());
                analizUz.setLan("UZ");
                analizRepository.save(analizUz);
                AnalizEntity analizRu = new AnalizEntity();
                analizRu.setA_c_id(Integer.parseInt(s));
                analizRu.setA_name(analiz.getA_nameru());
                analizRu.setA_type(analiz.getA_typeru());
                analizRu.setLan("RU");
                analizRepository.save(analizRu);
            }
        }else {
            AnalizEntity analizUz = new AnalizEntity();
            analizUz.setA_c_id(Integer.parseInt(analiz.getA_c_id()));
            analizUz.setA_name(analiz.getA_name());
            analizUz.setA_type(analiz.getA_type());
            analizUz.setLan("UZ");
            analizRepository.save(analizUz);
            AnalizEntity analizRu = new AnalizEntity();
            analizRu.setA_c_id(Integer.parseInt(analiz.getA_c_id()));
            analizRu.setA_name(analiz.getA_nameru());
            analizRu.setA_type(analiz.getA_typeru());
            analizRu.setLan("RU");
            analizRepository.save(analizRu);
        }
    }
    public List<String> getType(String table){
        return  analizRepository.findBytabel(table);
    }
}
