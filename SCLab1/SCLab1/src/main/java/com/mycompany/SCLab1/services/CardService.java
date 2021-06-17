/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.services;

import com.mycompany.SCLab1.models.Card;
import com.mycompany.SCLab1.repositories.CardRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matt
 */
@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public void deleteById(Integer id){
        cardRepository.deleteById(id);
    }
}
