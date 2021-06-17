/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.models;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Matt
 */
@Entity
public class TimeType {
    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    @Column(name = "type_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "timetype",
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
    private List<Credit> credits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

//    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "gender",
//            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
//            })
//    private List<Driver> drivers;

    public TimeType() {
    }
    
    @PreRemove
    private void preRemove() {
        for (Credit s : credits) {
            s.setTimetype(null);
        }
        
    }
}
