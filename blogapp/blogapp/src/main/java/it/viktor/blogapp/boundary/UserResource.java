/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.boundary;

import it.viktor.blogapp.control.PostStore;
import it.viktor.blogapp.control.UserStore;
import it.viktor.blogapp.entity.Post;
import it.viktor.blogapp.entity.User;
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


@Path("/users")
public class UserResource {
    
    @Inject // crea un istanza di userStore
    private UserStore userStore;
 
    @Inject
    private PostStore postStore;
    
    
    // USERS
    
    /**
     * visualizza tutti gli utenti 
     * @return 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> all(){
        return userStore.all();               
    }
    
    /**
     * crea un utente
     * @param entity 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create (@Valid User entity){ // @Valid -> valida il parametro e se non lo è lo converte in un errore conforme a rest 
        userStore.save(entity);
    }
    
    /**
     * cerca un utente con un specifico id
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User find(@PathParam("id") Long id){
        return userStore.find(id).orElseThrow(() -> new NotFoundException("User non trovato. id=" + id));
    }
    
    /**
     * cancella un utente con un determinato id
     * @param id 
     */
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        User found = userStore.find(id).orElseThrow(() -> new NotFoundException("User non trovato. id=" + id));
        userStore.delete(found.getId());
    }
    
    
    // POSTS
    
    /**
     * visualizza tutti i post di un utente
     * @return 
     */
    @GET
    @Path("{id}/posts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> posts(@PathParam("id") Long id){
        return postStore.byUser(id);
    }
    
    /**
     * crea un post su un determinato user
     * @param id
     * @return 
     */
    @POST
    @Path("{id}/posts")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPost(@PathParam("id") Long id, @Valid Post entity){
         User found = userStore.find(id).orElseThrow(() -> new NotFoundException("User non trovato. id=" + id));
         entity.setAuthor(found);
         postStore.save(entity);
    }
}
