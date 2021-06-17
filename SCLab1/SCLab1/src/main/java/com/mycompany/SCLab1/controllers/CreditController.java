/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.controllers;

import com.mycompany.SCLab1.models.CardType;
import com.mycompany.SCLab1.models.Credit;
import com.mycompany.SCLab1.models.TimeType;
import com.mycompany.SCLab1.services.CreditService;
import com.mycompany.SCLab1.services.TimeTypeService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
@RequestMapping("/credit")
public class CreditController {
     private CreditService creditService;
     private TimeTypeService timeTypeService;

    public CreditController(CreditService creditService,TimeTypeService timeTypeService) {
        this.creditService = creditService;
        this.timeTypeService = timeTypeService;
    }
    
    @GetMapping("/list")
    public String getCreditlist(Model model){
        model.addAttribute("credit", creditService.findAll());
        return "credit/show_all";
    }
    @GetMapping("/person")
    public String getCreditPerson(@RequestParam("id") int id, Model model){
        model.addAttribute("credit", creditService.findById(id));
        return "credit/all_person";
    }
    @GetMapping("/add")
    public String addCredit(Model model){
        Credit credit=new Credit();

        model.addAttribute("timetypeList", timeTypeService.findAll());
        model.addAttribute("credit", credit);
        return "credit/update_create";
    }
    @GetMapping("/delete")
    public String deleteCredit(@RequestParam("id") int id){
        creditService.deleteById(id);
        return "redirect:/credit/list";
    }
    @GetMapping("/update")
    public String updateCredit(@RequestParam("id") int id, Model model){
        model.addAttribute("credit",  creditService.findById(id));
        model.addAttribute("timetypeList", timeTypeService.findAll());
        return "credit/update_create";
    }
    @PostMapping("/save")
    public String saveCredit(@ModelAttribute("credit") Credit credit){

        creditService.save(credit);
        
        return "redirect:/credit/list";
    }
}
