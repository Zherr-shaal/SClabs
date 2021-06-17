/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.controllers;

import com.mycompany.SCLab1.models.CardType;
import com.mycompany.SCLab1.services.CardTypeService;
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
@RequestMapping("/card")
public class CardTypeController {
    private CardTypeService cardService;

    public CardTypeController(CardTypeService personService) {
        this.cardService = personService;
    }
    
    @GetMapping("/list")
    public String getCardlist(Model model){
        model.addAttribute("card", cardService.findAll());
        return "card/show_all";
    }
    @GetMapping("/add")
    public String addCard(Model model){
        CardType card=new CardType();
        model.addAttribute("card", card);
        return "card/update_create";
    }
    @GetMapping("/delete")
    public String deleteCard(@RequestParam("id") int id){
        cardService.deleteById(id);
        return "redirect:/card/list";
    }
    @GetMapping("/update")
    public String updateCard(@RequestParam("id") int id, Model model){
        model.addAttribute("card",  cardService.findById(id));
        return "card/update_create";
    }
    @PostMapping("/save")
    public String saveCard(@ModelAttribute("card") CardType card){
        cardService.save(card);
        return "redirect:/card/list";
    }
}
