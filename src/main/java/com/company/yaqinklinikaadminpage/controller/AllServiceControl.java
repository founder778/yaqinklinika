package com.company.yaqinklinikaadminpage.controller;

import com.company.yaqinklinikaadminpage.bot.controller.Start;
import com.company.yaqinklinikaadminpage.bot.repository.UserRepository;
import com.company.yaqinklinikaadminpage.bot.service.AnalizService;
import com.company.yaqinklinikaadminpage.dto.AllServiceDto;
import com.company.yaqinklinikaadminpage.service.AllService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/allservice")
public class AllServiceControl {
    @Autowired
    AllService allService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/get")
    public String get(Model model,Model model2){
        int all1 = userRepository.getAll();
        model2.addAttribute("users",all1);
        List<AllServiceDto> all = allService.getAll();
        model.addAttribute("services", all );
        return "AllService";

    }


    @GetMapping("/service/delete/{id}")
    public String delete(@PathVariable("id") String id, RedirectAttributes mas){
        allService.delete(id);
        return "redirect:/allservice/get";
    }

}
