/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.jee.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;

/**
 *
 * @author tss
 */

/*
$ curl -v -X POST http://localhost:8080/jee01-1.0-SNAPSHOT/resources/people -H 'Content-Type:application/json' -d '{"id":3,"first_name":"bianchi","last_name":"alex", "age":40}'

*/

// LA CONVERSIONE DA JAVA A JSON VIENE FATTA DA JSON BINDING 
@JsonbPropertyOrder({"id", "nome", "cognome", "eta", "dataCreazione"}) // ORDINA COME VENGONO MESSI NEL FILE JSON
public class Person implements Serializable{
    //@JsonbTransient // SERVE A ESCLUDERE UNA PROPRIETÀ NEL FILE JSON
    private long id;
    @JsonbProperty(value = "first_name") // CASTOMIZZZI IL NOME DELLA PROPRIETÀ NEL FILE JSON
    private String nome;
    @JsonbProperty(value = "last_name")
    private String cognome;
    @JsonbProperty(value = "age")
    private int eta;
    @JsonbProperty(value = "creation_date")
    private LocalDate dataCrezione = LocalDate.now();

    
    public Person() {
    }

    public Person(long id, String nome, String cognome, int eta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }
    
    
    public JsonObject toJsonMin(){
        return Json.createObjectBuilder()
                .add("last_name", this.cognome)
                .build();
    }
    
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public LocalDate getDataCrezione() {
        return dataCrezione;
    }

    public void setDataCrezione(LocalDate dataCrezione) {
        this.dataCrezione = dataCrezione;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + '}';
    }
    
    
}
