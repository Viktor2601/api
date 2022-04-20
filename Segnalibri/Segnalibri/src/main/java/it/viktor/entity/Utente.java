/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_utenti")
public class Utente extends BaseEntity {
    
    @Column(nullable = false)
    @NotBlank
    private String nome;
    
    @Column(nullable = false)
    @NotBlank
    private String cognome;
    
    @Column(nullable = false)
    @Email
    @NotBlank
    private String email;
    
    @Column(nullable = false)
    @NotBlank
    @Size(min = 8)
    private String password;
    
    
    // GETTER AND SETTER

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    // TO STRING

    @Override
    public String toString() {
        return "Utenti{" + "nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password=" + password + '}';
    }
    
    
    // METODI PER LA CONVERSIONE IN JSON
    
    public JsonObject toJsonByCreatedSegnalibro (){
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("email", this.email)
                .build();
    }
    
  
        
}
