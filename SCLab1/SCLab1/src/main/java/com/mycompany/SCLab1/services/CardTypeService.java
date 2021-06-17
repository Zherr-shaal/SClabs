/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.services;

import com.mycompany.SCLab1.models.CardType;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mycompany.SCLab1.repositories.CardTypeRepository;

/**
 *
 * @author Matt
 */
@Service
public class CardTypeService {
    @Autowired
    CardTypeRepository cardRepository;
    public CardType findById(Integer id) {
        Optional<CardType> result = cardRepository.findById(id);
        CardType n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<CardType> findAll() {
        return cardRepository.findAll();
    }

    public Iterable<CardType> findAll(Pageable pageable) {
        return cardRepository.findAll(pageable);
    }

    public Iterable<CardType> findAll(Sort sort) {
        return cardRepository.findAll(sort);

    }

    public void save(CardType card) {
        cardRepository.save(card);
    }

    public void deleteById(Integer id){
        cardRepository.deleteById(id);
    }
}
