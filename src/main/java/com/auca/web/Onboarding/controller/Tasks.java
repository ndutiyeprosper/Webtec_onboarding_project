package com.auca.web.Onboarding.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.auca.web.Onboarding.model.Tasks;
import com.example.Onboarding.services.newhireService;

@Controller
public class Tasks {
    private final checklist newhireService;

    public Tasks(checklist newhireService) {
        this.newhireService = newhireService;
    }
    @GetMapping("/newhire")
    public String viewnewhire(Model model){
        model.addAttribute("newhire", new Tasks());
        return "newhireus";
    }
    @GetMapping("/display")
    public String displaynewhire(Model model){
        model.addAttribute("display",newhireService.GetAllnewhire());
        return "displaynewhireus";
    }
    @PostMapping("/regnewhireus")
    public String savenewhire(@ModelAttribute("newhire") Tasks newhire) {
        Tasks newhire1 = newhireService.saveVontact(newhire);
        if (newhire1 != null) {
            return "redirect:/newhire?success";
        } else {
            return "redirect:/newhire?error";
        }
    }
    @GetMapping("/display/{emaill}")
public String deletenewhire(@PathVariable String emaill){
        newhireService.deletenewhire(emaill);
        return "redirect:/display";
    }
}
