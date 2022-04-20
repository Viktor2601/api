/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.entity;

import it.viktor.adapters.UtenteTypeAdapter;
import java.util.Set;
import java.util.TreeSet;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "t_segnalibri")
public class Segnalibro extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    private String link;

    @Column(nullable = false, length = 500)
    @NotBlank
    private String descrizione;

    @JsonbTransient
    @ManyToMany
    @JoinTable(name = "segnalibro_etichetta",
            joinColumns = @JoinColumn(name = "segnalibro_id"),
            inverseJoinColumns = @JoinColumn(name = "etichetta_id"))
    private Set<Etichetta> etichette = new TreeSet<>();

    @Column(nullable = false)
    private boolean condiviso;

    @ManyToOne(optional = false)
    @JsonbTypeAdapter(UtenteTypeAdapter.class)
    private Utente utente;
    
    
    // GETTER AND SETTER

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Set<Etichetta> getEtichette() {
        return etichette;
    }

    public void setEtichette(Set<Etichetta> etichette) {
        this.etichette = etichette;
    }

    public boolean isCondiviso() {
        return condiviso;
    }

    public void setCondiviso(boolean condiviso) {
        this.condiviso = condiviso;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    
    
    // TO STRING

    @Override
    public String toString() {
        return "Segnalibro{" + "link=" + link + ", descrizione=" + descrizione + ", etichette=" + etichette + ", condiviso=" + condiviso + ", utente=" + utente + '}';
    }
    
}
