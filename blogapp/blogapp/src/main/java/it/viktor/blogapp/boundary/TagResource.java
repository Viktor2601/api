/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.boundary;

import it.viktor.blogapp.control.TagStore;
import it.viktor.blogapp.entity.Tag;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */

@Path("/tags")
public class TagResource {
    
    @Inject
    private TagStore store;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tag> all(){
        return store.all();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@Valid Tag entity){
        store.save(entity);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tag findById(@PathParam("id") Long id){
        return store.findById(id).orElseThrow( () -> new NotFoundException("Tag non trovato. id=" + id ));
    }
    
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tag findByName(@PathParam("name") String name){
        return store.findByName(name).orElseThrow( () -> new NotFoundException("Tag non trovato. name=" + name ));
    }
    
    @DELETE
    @Path("{id}")
    public void deleteById (@PathParam("id") Long id){
        Tag found = store.findById(id).orElseThrow(() -> new NotFoundException("Tag non trovato. id=" + id));
        store.delete(found.getId());
    }
    
    @DELETE
    @Path("{name}")
    public void deleteByName (@PathParam("name") String name){
        Tag found = store.findByName(name).orElseThrow(() -> new NotFoundException("Tag non trovato. name=" + name ));
        store.delete(found.getId());
    }
    
    
}
