/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.repositories;

import com.mycompany.SCLab1.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Matt
 */
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    
}
