/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.boundary;

import it.viktor.control.SegnalibroStore;
import it.viktor.entity.Segnalibro;
import java.util.List;
import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/segnalibri")
public class SegnalibroResources {
    
    @Inject
    SegnalibroStore segnalibroStore;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Segnalibro> all(){
        return segnalibroStore.all();
    }
    
    
    // ETICHETTA
    @PATCH
    @Path("{id}/etichetta")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addEtichetta(@PathParam("id") Long id, @NotBlank String etichetta){
        Segnalibro found = segnalibroStore.find(id).orElseThrow( () -> new NotFoundException("Segnalibro non trovato... id = " + id ));
        segnalibroStore.addEtichetta(found, etichetta);
    }
    
}
