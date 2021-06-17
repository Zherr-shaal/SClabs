/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.services;


import com.mycompany.SCLab1.models.TimeType;
import com.mycompany.SCLab1.repositories.TimeTypeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matt
 */
@Service
public class TimeTypeService {
        @Autowired
        TimeTypeRepository timeTypeRepository;
        public TimeType findById(Integer id) {
        Optional<TimeType> result = timeTypeRepository.findById(id);
        TimeType n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }
        public Iterable<TimeType> findAll(){
            return timeTypeRepository.findAll();
        }
        public void save(TimeType timetype){
            timeTypeRepository.save(timetype);
        }
}
