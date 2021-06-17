/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.services;

import com.mycompany.SCLab1.models.BusinessCredit;
import com.mycompany.SCLab1.models.CardType;
import com.mycompany.SCLab1.repositories.BusinessCreditRepository;
import com.mycompany.SCLab1.repositories.CardTypeRepository;
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
public class BusinessCreditService {
    @Autowired
    BusinessCreditRepository businessCreditRepository;
    public BusinessCredit findById(Integer id) {
        Optional<BusinessCredit> result = businessCreditRepository.findById(id);
        BusinessCredit n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<BusinessCredit> findAll() {
        return businessCreditRepository.findAll();
    }

    public Iterable<BusinessCredit> findAll(Pageable pageable) {
        return businessCreditRepository.findAll(pageable);
    }

    public Iterable<BusinessCredit> findAll(Sort sort) {
        return businessCreditRepository.findAll(sort);

    }

    public void save(BusinessCredit card) {
        businessCreditRepository.save(card);
    }

    public void deleteById(Integer id){
        businessCreditRepository.deleteById(id);
    }
}
