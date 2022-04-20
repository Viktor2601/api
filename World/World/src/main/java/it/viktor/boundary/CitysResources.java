/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.boundary;

import it.viktor.control.CityStore;
import it.viktor.entity.CityEntity;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/citys")
public class CitysResources {
    
    @Inject
    CityStore cityStore;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityEntity> all (){
        return cityStore.all();
    }
}
