/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.services;

import com.mycompany.SCLab1.models.BusinessCredit;
import com.mycompany.SCLab1.models.Deposit;
import com.mycompany.SCLab1.repositories.BusinessCreditRepository;
import com.mycompany.SCLab1.repositories.DepositRepository;
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
public class DepositService {
    @Autowired
    DepositRepository depositRepository;
    public Deposit findById(Integer id) {
        Optional<Deposit> result = depositRepository.findById(id);
        Deposit n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Deposit> findAll() {
        return depositRepository.findAll();
    }

    public Iterable<Deposit> findAll(Pageable pageable) {
        return depositRepository.findAll(pageable);
    }

    public Iterable<Deposit> findAll(Sort sort) {
        return depositRepository.findAll(sort);

    }

    public void save(Deposit card) {
        depositRepository.save(card);
    }

    public void deleteById(Integer id){
        depositRepository.deleteById(id);
    }
}
