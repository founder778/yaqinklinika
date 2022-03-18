package com.company.yaqinklinikaadminpage.controller;

import com.company.yaqinklinikaadminpage.bot.repository.UserRepository;
import com.company.yaqinklinikaadminpage.dto.AdviceDto;
import com.company.yaqinklinikaadminpage.entity.AdviceEntity;
import com.company.yaqinklinikaadminpage.entity.ClinicEntity;
import com.company.yaqinklinikaadminpage.entity.DiagnostEntity;
import com.company.yaqinklinikaadminpage.service.AdviceService;
import com.company.yaqinklinikaadminpage.service.ClinicService;
import com.company.yaqinklinikaadminpage.service.DiagnostService;
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
@RequestMapping("/advice")
public class AdviceController {
    @Autowired
    ClinicService clinicService;
    @Autowired
    AdviceService adviceService;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/adviceCreate")
    public String create(Model model, Model model2,Model model3){
        int all1 = userRepository.getAll();
        model3.addAttribute("users",all1);
        model.addAttribute("advice",new AdviceDto());
        List<ClinicEntity> clinics = clinicService.getAll();
        model2.addAttribute("clincs",clinics);
        return "advice";
    }
    @PostMapping("/advice/save")
    public String createDiagnost(AdviceDto advice, RedirectAttributes mas){
        adviceService.create(advice);
        mas.addFlashAttribute("message","succesully");
        return "redirect:/advice/adviceCreate";
    }
}
