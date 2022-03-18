package com.company.yaqinklinikaadminpage.service;

import com.company.yaqinklinikaadminpage.dto.DiagnostDto;
import com.company.yaqinklinikaadminpage.entity.AnalizEntity;
import com.company.yaqinklinikaadminpage.entity.CircleEntity;
import com.company.yaqinklinikaadminpage.entity.DiagnostEntity;
import com.company.yaqinklinikaadminpage.repository.AnalizRepository;
import com.company.yaqinklinikaadminpage.repository.DiagnostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnostService {
    @Autowired
    DiagnostRepository diagnostRepository;
    public void create(DiagnostDto diagnost){
        if(diagnost.getA_c_id().contains("/")){
            String[] split = diagnost.getA_c_id().split("/");
            for (String s : split) {
                DiagnostEntity analizUz = new DiagnostEntity();
                analizUz.setA_c_id(Integer.parseInt(s));
                analizUz.setA_name(diagnost.getA_name());
                analizUz.setA_type(diagnost.getA_type());
                analizUz.setLan("UZ");
                diagnostRepository.save(analizUz);
                DiagnostEntity analizRu = new DiagnostEntity();
                analizRu.setA_c_id(Integer.parseInt(s));
                analizRu.setA_name(diagnost.getA_nameru());
                analizRu.setA_type(diagnost.getA_typeru());
                analizRu.setLan("RU");
                diagnostRepository.save(analizRu);
            }
        }
        else {
            DiagnostEntity analizUz = new DiagnostEntity();
            analizUz.setA_c_id(Integer.parseInt(diagnost.getA_c_id()));
            analizUz.setA_name(diagnost.getA_name());
            analizUz.setA_type(diagnost.getA_type());
            analizUz.setLan("UZ");
            diagnostRepository.save(analizUz);
            DiagnostEntity analizRu = new DiagnostEntity();
            analizRu.setA_c_id(Integer.parseInt(diagnost.getA_c_id()));
            analizRu.setA_name(diagnost.getA_nameru());
            analizRu.setA_type(diagnost.getA_typeru());
            analizRu.setLan("RU");
            diagnostRepository.save(analizRu);

        }
    }
    public List<String> getType(String table){
        return  diagnostRepository.findBytabel(table);
    }
}
