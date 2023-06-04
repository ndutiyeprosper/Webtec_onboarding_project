package com.example.Onboarding.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Onboarding.services.ChecklistInterface;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class Checklist {
    @Autowired
    ChecklistInterface  employeeService;

    @GetMapping("/home")
    public String homePage(Model model){

        return findPaginated(1,model);
    }

    @GetMapping("/")
    public String ind(){
        return "homes";
    }
    @GetMapping("/newhires")
    public String homme()
    { return "newhires";}
    @GetMapping("/come")
    public String homes()
    { return "aboutus";}
    @GetMapping("/tasks")
    public String candidate(){
        return "tasks";
    }
   
    }
    @GetMapping("/registration")
    public String registeremployeePage(Model model){
        Checklist stud = new Checklist();
        model.addAttribute("employee", stud);
        return "registrar";
    }
    @GetMapping("/employees")
    public String employeepage(Model model){
        Checklist stud = new Checklist();
        model.addAttribute("employee", emp);
        return "employee";
    }

    @PostMapping("/register")
    public String registerLawyer(@ModelAttribute("employee") Checklist theemployee){
        Checklist savedemployee = employeeService.registeremployee(theemployee);
        if(savedemployee != null){
            return "redirect:/tasks";
        }else {
            return "redirect:/register";
        }
    }

    @PostMapping("/reg")
    public String registeremployeeInDb(@ModelAttribute("employee") Checklist theemployee){
        Checklist savedemployee = employeeService.registeremployee(theemployee);
        if(savedemployee != null){
            return "redirect:/register?success";
        }else {
            return "redirect:/register?error";
        }
    }

    @GetMapping("/home/update/{id}")
    public String editemployee(@PathVariable String id, Model model){

        Long  lawyerId=Long.parseLong(id);
        model.addAttribute("employee", employeeService.findemployeeByemployeeId(lawyerId));
        return "update";
    }
    @PostMapping("/home/{id}")
    public String updateemployee(@PathVariable String id,
                                @ModelAttribute("employee") Checklist employee, Model model)
    {

        Long  empId=Long.parseLong(id);
        Checklist existingemployee=employeeService.findemployeeByemployeeId(empId);
        existingemployee.setTel(employee.getTel());
        existingemployee.setId(employee.getId());
        existingemployee.setNames(employee.getNames());
        existingemployee.setCases(employee.getTitle());
        existingemployee.setDate(employee.getDate());
        existingemployee.setEmails(employee.getEmails());
        existingemployee.setLawyer(employee.getDepartment());
        employeeService.updateemployee(existingemployee);
        return "redirect:/home";
    }
    @GetMapping("/home/{id}")
    public String deleteemployee(@PathVariable String id)
    {
    Long  lawyerId=Long.parseLong(id);
        employeeService.deleteemployee(lawyerId);
        return "redirect:/home";
    }



}
