/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_etichette")
public class Etichetta extends BaseEntity{
    
    @Column(nullable = false)
    @NotBlank
    private String name;
    
    
    // COSTRUTTORI

    public Etichetta() {
    }

    public Etichetta(String name) {
        this.name = name;
    }
    
    
    
    
    // GETTER AND SETTER

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    // TO STRING 

    @Override
    public String toString() {
        return "Etichetta{" + "name=" + name + '}';
    }
    
    
}
