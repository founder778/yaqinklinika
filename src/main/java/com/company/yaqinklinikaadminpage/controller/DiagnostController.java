package com.company.yaqinklinikaadminpage.controller;

import com.company.yaqinklinikaadminpage.bot.repository.UserRepository;
import com.company.yaqinklinikaadminpage.dto.DiagnostDto;
import com.company.yaqinklinikaadminpage.entity.ClinicEntity;
import com.company.yaqinklinikaadminpage.entity.DiagnostEntity;
import com.company.yaqinklinikaadminpage.service.ClinicService;
import com.company.yaqinklinikaadminpage.service.DiagnostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/diagnost")
public class DiagnostController {
    @Autowired
    ClinicService clinicService;
    @Autowired
    DiagnostService diagnostService;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/dcreate")
    public String create(Model model,Model model2,Model model3,Model model4){
        int all1 = userRepository.getAll();
        model4.addAttribute("users",all1);
        model.addAttribute("diag",new DiagnostDto());
        List<ClinicEntity> clinics = clinicService.getAll();
        model2.addAttribute("clincs",clinics);
        List<String> types = diagnostService.getType("diagnostika");
        model3.addAttribute("types",types);
        return "diagnos";
    }
    @PostMapping("/diagnost/save")
    public String createDiagnost(DiagnostDto diagnost, RedirectAttributes mas){
        diagnostService.create(diagnost);
        mas.addFlashAttribute("message","succesully");
        return "redirect:/diagnost/dcreate";
    }

}
