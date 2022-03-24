/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.boundary;

import it.viktor.blogapp.control.CommentStore;
import it.viktor.blogapp.entity.Comment;
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

@Path("/comments")
public class CommentResource {
    
    @Inject
    private CommentStore store;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> all(){
        return store.all();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@Valid Comment entity){
        store.save(entity);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment find(@PathParam("id") Long id){
        return store.find(id).orElseThrow( () -> new NotFoundException("Commento non trovato. id=" + id ));
    }
    
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") Long id){
        Comment found = store.find(id).orElseThrow(() -> new NotFoundException("Commento non trovato. id=" + id));
        store.delete(found.getId());
    }
}
