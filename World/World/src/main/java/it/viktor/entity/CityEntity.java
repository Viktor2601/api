/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.entity;

import it.viktor.adapter.CountryTypeAdapter;
import java.io.Serializable;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "city")
public class CityEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", length = 35, nullable = false)
    @NotNull
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CountryCode")
    @JsonbTypeAdapter(CountryTypeAdapter.class)
    private CountryEntity country;

    @Column(name = "District", length = 20, nullable = false)
    @NotNull
    private String district;

    @Column(name = "Population", nullable = false)
    @NotNull
    private int population;

    // GETTER AND SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryEntity getCountryCode() {
        return country;
    }

    public void setCountryCode(CountryEntity countryCode) {
        this.country = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // EQUALS AND HASHCODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final CityEntity other = (CityEntity) obj;
        return Objects.equals(this.id, other.id);
    }

}
