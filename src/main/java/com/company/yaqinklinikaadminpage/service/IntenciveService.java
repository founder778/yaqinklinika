package com.company.yaqinklinikaadminpage.service;

import com.company.yaqinklinikaadminpage.dto.IntenciveDto;
import com.company.yaqinklinikaadminpage.entity.AdviceEntity;
import com.company.yaqinklinikaadminpage.entity.DiagnostEntity;
import com.company.yaqinklinikaadminpage.entity.IntenciveEntity;
import com.company.yaqinklinikaadminpage.repository.AdviceRepository;
import com.company.yaqinklinikaadminpage.repository.IntenciveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntenciveService {
    @Autowired
    IntenciveRepository intenciveRepository;
    public void create(IntenciveDto intencive){
        if(intencive.getA_c_id().contains("/")){
            String[] split = intencive.getA_c_id().split("/");
            for (String s : split) {
                IntenciveEntity analizUz = new IntenciveEntity();
                analizUz.setA_c_id(Integer.parseInt(s));
                analizUz.setA_name(intencive.getA_name());
                analizUz.setA_type(intencive.getA_type());
                analizUz.setLan("UZ");
                intenciveRepository.save(analizUz);
                IntenciveEntity analizRu = new IntenciveEntity();
                analizRu.setA_c_id(Integer.parseInt(s));
                analizRu.setA_name(intencive.getA_nameru());
                analizRu.setA_type(intencive.getA_typeru());
                analizRu.setLan("RU");
                intenciveRepository.save(analizRu);
            }
        }
        else {
            IntenciveEntity analizUz = new IntenciveEntity();
            analizUz.setA_c_id(Integer.parseInt(intencive.getA_c_id()));
            analizUz.setA_name(intencive.getA_name());
            analizUz.setA_type(intencive.getA_type());
            analizUz.setLan("UZ");
            intenciveRepository.save(analizUz);
            IntenciveEntity analizRu = new IntenciveEntity();
            analizRu.setA_c_id(Integer.parseInt(intencive.getA_c_id()));
            analizRu.setA_name(intencive.getA_nameru());
            analizRu.setA_type(intencive.getA_typeru());
            analizRu.setLan("RU");
            intenciveRepository.save(analizRu);
        }
    }
    public List<String> getType(String table){
        return  intenciveRepository.findBytabel(table);
    }
}
