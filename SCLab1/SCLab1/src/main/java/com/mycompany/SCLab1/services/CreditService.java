/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.services;

import com.mycompany.SCLab1.models.Credit;
import com.mycompany.SCLab1.repositories.CreditRepository;
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
public class CreditService {
    @Autowired
    CreditRepository creditRepository;
    public Credit findById(Integer id) {
        Optional<Credit> result = creditRepository.findById(id);
        Credit n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Credit> findAll() {
        return creditRepository.findAll();
    }

    public Iterable<Credit> findAll(Pageable pageable) {
        return creditRepository.findAll(pageable);
    }

    public Iterable<Credit> findAll(Sort sort) {
        return creditRepository.findAll(sort);

    }

    public void save(Credit credit) {
        creditRepository.save(credit);
    }

    public void deleteById(Integer id){
        creditRepository.deleteById(id);
    }
}
