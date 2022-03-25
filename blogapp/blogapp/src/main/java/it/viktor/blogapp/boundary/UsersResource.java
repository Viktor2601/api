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
public class UsersResource {
    
    @Inject // crea un istanza di UserStore
    private UserStore UserPost;
 
    @Inject
    private PostStore postStore;
    
    
    // USERS
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> all(){
        return UserPost.all();               
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create (@Valid User entity){ // @Valid -> valida il parametro e se non lo è lo converte in un errore conforme a rest 
        UserPost.save(entity);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User find(@PathParam("id") Long id){
        return UserPost.find(id).orElseThrow(() -> new NotFoundException("User non trovato. id=" + id));
    }
    
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        User found = UserPost.find(id).orElseThrow(() -> new NotFoundException("User non trovato. id=" + id));
        UserPost.delete(found.getId());
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
         User found = UserPost.find(id).orElseThrow(() -> new NotFoundException("User non trovato. id=" + id));
         entity.setAuthor(found);
         postStore.save(entity);
    }
}
