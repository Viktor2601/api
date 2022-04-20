/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.boundary;

import it.viktor.control.SegnalibroStore;
import it.viktor.control.UtenteStore;
import it.viktor.entity.Segnalibro;
import it.viktor.entity.Utente;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/utenti")
public class UtenteResources {

    @Inject
    UtenteStore utenteStore;
    
    @Inject
    SegnalibroStore segnalibroStore;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@Valid Utente entity) {
        utenteStore.create(entity);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utente> all() {
       return utenteStore.all();
    }
    
    
    // SEGNALIBRI
    
    @POST
    @Path("{id}/segnalibro")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createSegnalibro(@PathParam("id") Long id, @Valid Segnalibro entity){
        Utente found = utenteStore.find(id).orElseThrow(() -> new NotFoundException("Utente non trovato... id =" + id));
        entity.setUtente(found);
        segnalibroStore.create(entity);
    }
}
