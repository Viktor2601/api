/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.adapters;

import it.viktor.control.UtenteStore;
import it.viktor.entity.Utente;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.ws.rs.NotFoundException;
import net.minidev.json.JSONObject;

/**
 *
 * @author tss
 */
public class UtenteTypeAdapter implements JsonbAdapter<Utente, JsonObject>{

    @Inject
    UtenteStore utenteStore;
    
    @Override
    public JsonObject adaptToJson(Utente entity) throws Exception {
        return entity.toJsonByCreatedSegnalibro();
    }

    @Override
    public Utente adaptFromJson(JsonObject json) throws Exception {
          if (!json.containsKey("id")) {
            return null;
        }
        return utenteStore.find(json.getJsonNumber("id").longValue()).orElseThrow(() -> new NotFoundException("..."));
    }
    
}
