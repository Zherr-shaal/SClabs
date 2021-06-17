/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.services;

import com.mycompany.SCLab1.models.Deposit;
import com.mycompany.SCLab1.models.Manager;
import com.mycompany.SCLab1.repositories.DepositRepository;
import com.mycompany.SCLab1.repositories.ManagerRepository;
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
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;
    public Manager findById(Integer id) {
        Optional<Manager> result = managerRepository.findById(id);
        Manager n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Manager> findAll() {
        return managerRepository.findAll();
    }

    public Iterable<Manager> findAll(Pageable pageable) {
        return managerRepository.findAll(pageable);
    }

    public Iterable<Manager> findAll(Sort sort) {
        return managerRepository.findAll(sort);

    }

    public void save(Manager card) {
        managerRepository.save(card);
    }

    public void deleteById(Integer id){
        managerRepository.deleteById(id);
    }
}
