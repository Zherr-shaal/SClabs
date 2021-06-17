/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SCLab1.models;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;

/**
 *
 * @author Matt
 */
@Entity
public class Credit {
    @Id
    @Column(name = "id_credit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY,targetEntity=Person.class,
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
    @JoinTable(name = "credit_person",
            joinColumns = { @JoinColumn(name = "credit_fk", referencedColumnName="id_credit")},
            inverseJoinColumns = { @JoinColumn(name = "person_fk",referencedColumnName="id_person")})
    private List<Person> person;
    
    @Column(name = "credit_sum")
    private Integer sum;
    
    @Column(name = "credit_term")
    private Integer term;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "type_id")
    private TimeType timetype;
    
   
    

    @Column(name = "credit_type")
    private String type;
    
    @Column(name = "percent")
    private Integer percent;

    public Credit() {
    }

    public TimeType getTimetype() {
        return timetype;
    }

    public void setTimetype(TimeType timetype) {
        this.timetype = timetype;
    }

    public Integer getId() {
        return id;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }
    @PreRemove
    public void PreRemove(){
       for(Person p: person){
           p.getCredit().remove(this);
       }
    }
}
