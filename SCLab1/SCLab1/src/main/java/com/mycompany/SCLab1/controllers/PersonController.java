/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.controllers;

import com.mycompany.SCLab1.models.Card;
import com.mycompany.SCLab1.models.CardType;
import com.mycompany.SCLab1.models.Credit;
import com.mycompany.SCLab1.models.Person;
import com.mycompany.SCLab1.services.CardService;
import com.mycompany.SCLab1.services.CardTypeService;
import com.mycompany.SCLab1.services.CreditService;
import com.mycompany.SCLab1.services.PersonService;
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
@RequestMapping("/person")
public class PersonController {
    private CardTypeService cardTypeService;
    private PersonService personService;
    private CardService cardService;
    private CreditService creditService;
    
    public PersonController(PersonService personService, CardTypeService cardTypeService,CardService cardService,CreditService creditService) {
        this.personService = personService;
        this.cardTypeService = cardTypeService;
        this.cardService = cardService;
        this.creditService = creditService;
    }
    
    @GetMapping("/list")
    public String getPersonlist(Model model){
        model.addAttribute("person", personService.findAll());
        return "person/show_all";
    }
    @GetMapping("/add")
    public String addPerson(Model model){
        Person person=new Person();
        model.addAttribute("person", person);
        return "person/update_create";
    }
    @GetMapping("/delete")
    public String deletePerson(@RequestParam("id") int id){
        personService.deleteById(id);
        return "redirect:/person/list";
    }
    @GetMapping("/deletecard")
    public String deletePersonCard(@RequestParam("id") int id,@RequestParam("id_person") int id_person){
        cardService.deleteById(id);
        return "redirect:/person/cards?id="+id_person;
    }
    @GetMapping("/deleteCredit")
    public String deletePersonCredit(@RequestParam("id") int id,@RequestParam("id_person") int id_person){
        Person person= personService.findById(id_person);
        Credit credit = creditService.findById(id);
        person.getCredit().remove(credit);
        credit.getPerson().remove(person);
        personService.save(person);
        creditService.save(credit);
        return "redirect:/person/credit?id="+id_person;
    }
    @GetMapping("/cards")
    public String cardsPerson(@RequestParam("id") int id, Model model){
        Person person =personService.findById(id);
        model.addAttribute("person",  personService.findById(id));
        return "person/all_cards";
    }
    @GetMapping("/addCard")
    public String addCard(@RequestParam("id") int id, Model model){
        Person person =personService.findById(id);
        Card card=new Card();
        model.addAttribute("card", card);
        model.addAttribute("types", cardTypeService.findAll());
        model.addAttribute("person",  personService.findById(id));
        return "person/add_card_to_person";
    }
    @GetMapping("/credit")
    public String creditPerson(@RequestParam("id") int id, Model model){
        model.addAttribute("person",  personService.findById(id));
        return "person/all_credits";
    }
    @GetMapping("/selectCredit")
    public String selectCreditPerson(@RequestParam("id") int id, Model model){
        Person person = personService.findById(id);
        model.addAttribute("credit", creditService.findAll());
        model.addAttribute("person",  personService.findById(id));
        return "person/add_credit_to_person";
    }
    @GetMapping("/addCredit")
    public String addCreditPerson (@RequestParam("id_person") int id_person, @RequestParam("id_credit") int id_credit){
        Person person = personService.findById(id_person);
        Credit credit = creditService.findById(id_credit);
        person.getCredit().add(credit);
        credit.getPerson().add(person);
        personService.save(person);
        creditService.save(credit);
        return "redirect:/person/credit?id="+id_person;
    }
    @GetMapping("/update")
    public String updatePerson(@RequestParam("id") int id, Model model){
        model.addAttribute("person",  personService.findById(id));
        return "person/update_create";
    }
    
    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") Person person){
        personService.save(person);
        return "redirect:/person/list";
    }
    @PostMapping("/savecard")
    public String savePersonCard(@ModelAttribute("card") Card card, @RequestParam("id_card") int id){
        Person person = personService.findById(id);
        CardType cardType= cardTypeService.findById(card.getType().getId());
        card.setPerson(person);
        person.getCard().add(card);
        cardType.getCard().add(card);
        personService.save(person);
        cardTypeService.save(cardType);
        return "redirect:/person/cards?id="+id;
    }
}
