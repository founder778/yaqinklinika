package com.company.yaqinklinikaadminpage.controller;

import com.company.yaqinklinikaadminpage.entity.AdminEntity;
import com.company.yaqinklinikaadminpage.entity.AnalizEntity;
import com.company.yaqinklinikaadminpage.entity.ClinicEntity;
import com.company.yaqinklinikaadminpage.entity.RegionEntity;
import com.company.yaqinklinikaadminpage.repository.RegionRepository;
import com.company.yaqinklinikaadminpage.service.AdminService;
import com.company.yaqinklinikaadminpage.service.ClinicService;
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
public class HomeController {
    @Autowired
    ClinicService clinicService;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    AdminService adminService;

    @GetMapping("")
    public String showNewForm(Model model) {
        model.addAttribute("admin", new AdminEntity());
        return "HomePage";
    }
    @GetMapping("/create")
    public String showHomeForm(Model model) {
        model.addAttribute("admin", new AdminEntity());
        return "HomePage";
    }
    @PostMapping("/admin")
    public String checkAdmin(AdminEntity admin, Model model, Model model2, RedirectAttributes mas){
        boolean b = adminService.checkAdmin(admin);
        if(b){
            model.addAttribute("clinc", new ClinicEntity());
            List<RegionEntity> regions = (List<RegionEntity>) regionRepository.findAll();
            model2.addAttribute("regions",regions);
            return "Clinic";
        }
        mas.addFlashAttribute("message", "User topilmadi");
      return "redirect:/create";

    }


    @GetMapping("/clinic")
    public String showNewclinc(Model model,Model model2) {
        model.addAttribute("clinc", new ClinicEntity());
        List<RegionEntity> regions = (List<RegionEntity>) regionRepository.findAll();
        model2.addAttribute("regions",regions);
        return "Clinic";
    }



}
