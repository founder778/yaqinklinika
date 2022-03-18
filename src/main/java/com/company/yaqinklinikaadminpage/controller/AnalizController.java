package com.company.yaqinklinikaadminpage.controller;
import com.company.yaqinklinikaadminpage.bot.repository.UserRepository;
import com.company.yaqinklinikaadminpage.dto.AnalizDto;
import com.company.yaqinklinikaadminpage.entity.AnalizEntity;
import com.company.yaqinklinikaadminpage.entity.ClinicEntity;
import com.company.yaqinklinikaadminpage.service.AnalizService;
import com.company.yaqinklinikaadminpage.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/analiz")
public class AnalizController {
    @Autowired
    AnalizService analizService;
    @Autowired
    ClinicService clinicService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/acreate")
    public String showAnalizForm(Model model, Model model2,Model model3,Model model4){
        int all1 = userRepository.getAll();
        model4.addAttribute("users",all1);
        model.addAttribute("analiz",new AnalizDto());
        List<String> types = analizService.getType("analiz");
        model3.addAttribute("types",types);
        List<ClinicEntity> clinics = clinicService.getAll();
        model2.addAttribute("clincs",clinics);
        return "Analiz";
    }

    @PostMapping("/analiz/save")
    public String create(AnalizDto dto, RedirectAttributes mas){
        analizService.create(dto);

        mas.addFlashAttribute("message","succesully");
        return "redirect:/analiz/acreate";
    }
}
