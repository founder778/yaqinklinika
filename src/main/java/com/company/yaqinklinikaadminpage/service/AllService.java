package com.company.yaqinklinikaadminpage.service;

import com.company.yaqinklinikaadminpage.dto.AllServiceDto;
import com.company.yaqinklinikaadminpage.entity.*;
import com.company.yaqinklinikaadminpage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AllService {
    @Autowired
    AdviceRepository adviceRepository;
    @Autowired
    AnalizRepository analizRepository;
    @Autowired
    CircleRepository circleRepository;
    @Autowired
    DiagnostRepository diagnostRepository;
    @Autowired
    IntenciveRepository intenciveRepository;
    @Autowired
    Clinicrepository clinicrepository;

    public List<AllServiceDto> getAll() {
        List<AllServiceDto> service = new LinkedList<>();
        Iterable<AdviceEntity> Advice = adviceRepository.findAll();
        Iterator<AdviceEntity> advice = Advice.iterator();
        while (advice.hasNext()) {
            AllServiceDto s = new AllServiceDto();
            s.setA_name(advice.next().getA_name());
            service.add(s);
        }

        Iterable<AnalizEntity> Analin = analizRepository.findAll();
        Iterator<AnalizEntity> analiz = Analin.iterator();
        while (analiz.hasNext()) {
            AllServiceDto s = new AllServiceDto();
            s.setA_name(analiz.next().getA_name());
            service.add(s);
        }

        Iterable<CircleEntity> Cricle = circleRepository.findAll();
        Iterator<CircleEntity> cricle = Cricle.iterator();
        while (cricle.hasNext()) {
            AllServiceDto s = new AllServiceDto();
            s.setA_name(cricle.next().getA_name());
            service.add(s);
        }

        Iterable<DiagnostEntity> D = diagnostRepository.findAll();
        Iterator<DiagnostEntity> d = D.iterator();
        while (d.hasNext()) {
            AllServiceDto s = new AllServiceDto();
            s.setA_name(d.next().getA_name());
            service.add(s);
        }

        Iterable<IntenciveEntity> I = intenciveRepository.findAll();
        Iterator<IntenciveEntity> i = I.iterator();
        while (i.hasNext()) {
            AllServiceDto s = new AllServiceDto();
            s.setA_name(i.next().getA_name());
            service.add(s);
        }

        return service;

    }

    public void delete(String id) {
        List<AdviceEntity> adName = adviceRepository.getName(id);
        List<AnalizEntity> anName = analizRepository.getName(id);
        List<CircleEntity> cName = circleRepository.getName(id);
        List<DiagnostEntity> dName = diagnostRepository.getName(id);
        List<IntenciveEntity> iName = intenciveRepository.getName(id);
        if (!adName.isEmpty()) {
            adviceRepository.ByNameDelete(adName.get(0).getA_name());
        } else if (!anName.isEmpty()) {
            analizRepository.ByNameDelete(adName.get(0).getA_name());
        } else if (!cName.isEmpty()) {
            circleRepository.ByNameDelete(adName.get(0).getA_name());
        } else if (!dName.isEmpty()) {
            diagnostRepository.ByNameDelete(adName.get(0).getA_name());
        } else if (!iName.isEmpty())
        {
            intenciveRepository.ByNameDelete(adName.get(0).getA_name());
        }
    }


}
