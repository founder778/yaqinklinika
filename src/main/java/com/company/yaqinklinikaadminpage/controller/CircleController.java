package com.company.yaqinklinikaadminpage.controller;

import com.company.yaqinklinikaadminpage.bot.repository.UserRepository;
import com.company.yaqinklinikaadminpage.dto.CircleDto;
import com.company.yaqinklinikaadminpage.entity.CircleEntity;
import com.company.yaqinklinikaadminpage.entity.ClinicEntity;
import com.company.yaqinklinikaadminpage.entity.DiagnostEntity;
import com.company.yaqinklinikaadminpage.service.CircleService;
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
@RequestMapping("/circle")
public class CircleController {

    @Autowired
    ClinicService clinicService;
    @Autowired
    CircleService circleService;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/ccreate")
    public String create(Model model, Model model2,Model model3,Model model4){
        int all1 = userRepository.getAll();
        model4.addAttribute("users",all1);
        model.addAttribute("circle",new CircleDto());
        List<ClinicEntity> clinics = clinicService.getAll();
        List<String> types = circleService.getType("circle");
        model3.addAttribute("types",types);
        model2.addAttribute("clincs",clinics);
        return "circle";
    }
    @PostMapping("/circ/save")
    public String createDiagnost(CircleDto circle, RedirectAttributes mas){
        circleService.create(circle);
        mas.addFlashAttribute("message","succesully");
        return "redirect:/circle/ccreate";
    }

}
