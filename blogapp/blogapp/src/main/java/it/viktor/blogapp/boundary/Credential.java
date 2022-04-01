/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.boundary;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author tss
 */
public class Credential {
    @NotBlank
    public String user;
    @NotBlank
    public String password;
    
    
}
