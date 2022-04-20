/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.adapter;

import it.viktor.entity.CountryEntity;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CountryTypeAdapter implements JsonbAdapter<CountryEntity, JsonObject> {

    @PersistenceContext
    EntityManager em;

    @Override
    public JsonObject adaptToJson(CountryEntity entity) throws Exception {
        return entity.toJsonSlice();
    }

    @Override
    public CountryEntity adaptFromJson(JsonObject json) throws Exception {
        if (!json.containsKey("code")) {
            return null;
        }
        return em.find(CountryEntity.class, json.getString("code"));
    }

}
