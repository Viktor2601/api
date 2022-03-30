/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.boundary;

import it.viktor.blogapp.control.CommentStore;
import it.viktor.blogapp.control.PostStore;
import it.viktor.blogapp.control.TagStore;
import it.viktor.blogapp.entity.Comment;
import it.viktor.blogapp.entity.Post;
import it.viktor.blogapp.entity.Tag;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */

@Path("/posts")
public class PostResource {
    
    @Inject
    CommentStore commentStore;
    
    @Inject
    PostStore postStore;
    
    @Inject
    TagStore tagStore;
   
    // POST
    
    /**
     * ritorna tutti i post
     * @return 
     */
   @GET
   @Produces(MediaType.APPLICATION_JSON)
    public List<Post> all() {
        return postStore.all();
    }

    /**
     * cerca un post con un determinato id
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post find(@PathParam("id") Long id) {
        throw new UnsupportedOperationException();
    }

    /**
     * aggiorna un post
     * @param id
     * @param entity
     * @return 
     */
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Post update(@PathParam("id") Long id, @Valid Post entity) {
        throw new UnsupportedOperationException();
    }

    /**
     * cancella un post 
     * @param id 
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        throw new UnsupportedOperationException();
    }

    // COMMENT
    
    /**
     * torna tutti i commenti del post
     * @return 
     */
    @GET
    @Path("{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> comments(@PathParam("id") Long id)  {
        return commentStore.allByPost(id);
    }

    /**
     * crea un commento su un determinato post
     * @param id
     * @param entity 
     */
    @POST
    @Path("{id}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createComment(@PathParam("id") Long id, @Valid Comment entity) {
        Post found = postStore.find(id).orElseThrow(() -> new NotFoundException("Post non trovato. id=" + id));
        entity.setPost(found);
        commentStore.create(entity);
    }

    // TAG 
    
    /**
     * visualizza tutti i tag di un post
     * @param id
     * @return 
     */
    @GET
    @Path("{id}/tags")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Tag> tags(@PathParam("id") Long id) {
        return tagStore.byPost(id);
    }


    @PATCH
    @Path("{id}/tags")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addTag(@PathParam("id") Long id, @NotBlank String tag) {
        Post found = postStore.find(id).orElseThrow(() -> new NotFoundException());
        postStore.addTag(found,tag);
    }

    @DELETE
    @Path("{id}/tags")
    @Consumes(MediaType.TEXT_PLAIN)
    public void removeTag(@PathParam("id") Long id, String tag) {
        postStore.removeTag(id,tag);
    }
    
}
