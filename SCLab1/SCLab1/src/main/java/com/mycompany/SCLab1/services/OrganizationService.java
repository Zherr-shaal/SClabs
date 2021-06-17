/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.services;

import com.mycompany.SCLab1.models.Manager;
import com.mycompany.SCLab1.models.Organization;
import com.mycompany.SCLab1.repositories.ManagerRepository;
import com.mycompany.SCLab1.repositories.OrganizationRepository;
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
public class OrganizationService {
    @Autowired
    OrganizationRepository organizationRepository;
    public Organization findById(Integer id) {
        Optional<Organization> result = organizationRepository.findById(id);
        Organization n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Organization> findAll() {
        return organizationRepository.findAll();
    }

    public Iterable<Organization> findAll(Pageable pageable) {
        return organizationRepository.findAll(pageable);
    }

    public Iterable<Organization> findAll(Sort sort) {
        return organizationRepository.findAll(sort);

    }

    public void save(Organization card) {
        organizationRepository.save(card);
    }

    public void deleteById(Integer id){
        organizationRepository.deleteById(id);
    }
}
