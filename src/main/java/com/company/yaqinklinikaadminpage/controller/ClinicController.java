package com.company.yaqinklinikaadminpage.controller;

import com.company.yaqinklinikaadminpage.bot.repository.UserRepository;
import com.company.yaqinklinikaadminpage.entity.ClinicEntity;
import com.company.yaqinklinikaadminpage.entity.RegionEntity;
import com.company.yaqinklinikaadminpage.repository.RegionRepository;
import com.company.yaqinklinikaadminpage.service.ClinicService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/hospital")
public class ClinicController {
    @Autowired
    ClinicService clinicService;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    UserRepository userRepository;

    public String showAllClinic(Model model,Model model2) {
        List<ClinicEntity> clinics = clinicService.getAll();
        List<RegionEntity> regions = (List<RegionEntity>) regionRepository.findAll();
        model.addAttribute("clinic",clinics);
        model2.addAttribute("regions",regions);
        return "Clinic";
    }
    @GetMapping("/clinic")
    public String showNewclinc(Model model,Model model2,Model model3) {
        int all1 = userRepository.getAll();
        model3.addAttribute("users",all1);
        model.addAttribute("clinc", new ClinicEntity());
        List<RegionEntity> regions = (List<RegionEntity>) regionRepository.findAll();
        model2.addAttribute("regions",regions);
        return "Clinic";
    }

    @PostMapping("/clinic/save")
    public String create(ClinicEntity clinic, RedirectAttributes mas) {
        boolean b = clinicService.isexist(clinic);
        if(!b){
            mas.addFlashAttribute("message", "Bu klinika ro`yhatdan o`tgan");
            return "redirect:/clinic";
        }
        mas.addFlashAttribute("message", "Ro`yhatga olindi");
        clinicService.createClinic(clinic);
        return "redirect:/clinic";
    }

}
