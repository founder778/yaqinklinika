package com.company.yaqinklinikaadminpage.controller;

import com.company.yaqinklinikaadminpage.bot.repository.UserRepository;
import com.company.yaqinklinikaadminpage.dto.IntenciveDto;
import com.company.yaqinklinikaadminpage.entity.CircleEntity;
import com.company.yaqinklinikaadminpage.entity.ClinicEntity;
import com.company.yaqinklinikaadminpage.entity.IntenciveEntity;
import com.company.yaqinklinikaadminpage.service.CircleService;
import com.company.yaqinklinikaadminpage.service.ClinicService;
import com.company.yaqinklinikaadminpage.service.IntenciveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/intensive")
public class IntenciveController {
    @Autowired
    ClinicService clinicService;
    @Autowired
    IntenciveService intenciveService;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/icreate")
    public String create(Model model, Model model2,Model model3,Model model4){
        int all1 = userRepository.getAll();
        model4.addAttribute("users",all1);
        model.addAttribute("inten",new IntenciveDto());
        List<ClinicEntity> clinics = clinicService.getAll();
        model2.addAttribute("clincs",clinics);
        List<String> types = intenciveService.getType("intencive");
        model3.addAttribute("types",types);
        return "intencive";
    }
    @PostMapping("/int/save")
    public String createDiagnost(IntenciveDto intencive, RedirectAttributes mas){
        intenciveService.create(intencive);
        mas.addFlashAttribute("message","succesully");
        return "redirect:/intensive/icreate";
    }
}
