/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.controllers;

import com.mycompany.SCLab1.models.CardType;
import com.mycompany.SCLab1.models.Manager;
import com.mycompany.SCLab1.services.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Matt
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }
    
    @GetMapping("/list")
    public String getManagerlist(Model model){
        model.addAttribute("manager", managerService.findAll());
        return "manager/show_all";
    }
    @GetMapping("/add")
    public String addManager(Model model){
        Manager card=new Manager();
        model.addAttribute("manager", card);
        return "manager/update_create";
    }
    @GetMapping("/delete")
    public String deleteManager(@RequestParam("id") int id){
        managerService.deleteById(id);
        return "redirect:/manager/list";
    }
    @GetMapping("/update")
    public String updateManager(@RequestParam("id") int id, Model model){
        model.addAttribute("manager",  managerService.findById(id));
        return "manager/update_create";
    }
    @PostMapping("/save")
    public String saveManager(@ModelAttribute("card") Manager manager){
        managerService.save(manager);
        return "redirect:/manager/list";
    }
}
