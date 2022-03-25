/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table (name = "t_tag")
public class Tag extends BaseEntity implements Serializable{
    // ATTRIBUTI
    @Column(nullable = false)
    private String name;
    
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
        return "Tag{" + "name=" + name + '}';
    }

    
    
}
