package com.company.yaqinklinikaadminpage.controller;

import com.company.yaqinklinikaadminpage.bot.entity.BotUsersEntity;
import com.company.yaqinklinikaadminpage.bot.repository.UserRepository;
import com.company.yaqinklinikaadminpage.entity.ClinicEntity;
import com.company.yaqinklinikaadminpage.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/allclinic")
public class AllClinicController {
    @Autowired
    ClinicService clinicService;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/get")
    public String get(Model model,Model model2){
        int all1 = userRepository.getAll();
        model2.addAttribute("users",all1);
        List<ClinicEntity> all = clinicService.getAll();
        model.addAttribute("clinics", all );
        return "AllClinic";

    }

    @GetMapping("/clinic/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes mas){
      clinicService.delete(id);
        return "redirect:/allclinic/get";
    }
}
