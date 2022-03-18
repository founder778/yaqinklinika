package com.company.yaqinklinikaadminpage.service;

import com.company.yaqinklinikaadminpage.dto.AdviceDto;
import com.company.yaqinklinikaadminpage.entity.AdviceEntity;
import com.company.yaqinklinikaadminpage.entity.AnalizEntity;
import com.company.yaqinklinikaadminpage.entity.DiagnostEntity;
import com.company.yaqinklinikaadminpage.repository.AdviceRepository;
import com.company.yaqinklinikaadminpage.repository.DiagnostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceService {
    @Autowired
    AdviceRepository adviceRepository;
    public void create(AdviceDto advice) {
        if (advice.getA_c_id().contains("/")) {
            String[] split = advice.getA_c_id().split("/");
            for (String s : split) {
                AdviceEntity adviceUz = new AdviceEntity();
                adviceUz.setA_c_id(Integer.parseInt(s));
                adviceUz.setA_name(advice.getA_name());
                adviceUz.setLan("UZ");
                adviceRepository.save(adviceUz);
                AdviceEntity adviceRu = new AdviceEntity();
                adviceRu.setA_c_id(Integer.parseInt(s));
                adviceRu.setA_name(advice.getA_nameru());
                adviceRu.setLan("RU");
                adviceRepository.save(adviceRu);
            }
        } else {
            AdviceEntity aUz = new AdviceEntity();
            AdviceEntity adviceUz = new AdviceEntity();
            adviceUz.setA_c_id(Integer.parseInt(advice.getA_c_id()));
            adviceUz.setA_name(advice.getA_name());
            adviceUz.setLan("UZ");
            adviceRepository.save(adviceUz);
            AdviceEntity adviceRu = new AdviceEntity();
            adviceRu.setA_c_id(Integer.parseInt(advice.getA_c_id()));
            adviceRu.setA_name(advice.getA_nameru());
            adviceRu.setLan("RU");
            adviceRepository.save(aUz);

        }


    }
}
