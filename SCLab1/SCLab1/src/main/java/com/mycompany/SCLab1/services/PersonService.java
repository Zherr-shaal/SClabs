/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.services;

import com.mycompany.SCLab1.models.Person;
import com.mycompany.SCLab1.repositories.PersonRepository;
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
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public Person findById(Integer id) {
        Optional<Person> result = personRepository.findById(id);
        Person n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Iterable<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public Iterable<Person> findAll(Sort sort) {
        return personRepository.findAll(sort);

    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void deleteById(Integer id){
        personRepository.deleteById(id);
    }
}
