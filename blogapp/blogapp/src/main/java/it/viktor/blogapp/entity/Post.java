/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.entity;

import it.viktor.blogapp.adapters.UserTypeAdapter;
import it.viktor.blogapp.boundary.PostResource;
import it.viktor.blogapp.boundary.UserResource;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_post")
public class Post extends BaseEntity implements Serializable {
    // ATTRIBUTI
    
    private LocalDateTime created = LocalDateTime.now();
    
    @ManyToOne(optional = false)
    @JsonbTypeAdapter(UserTypeAdapter.class)
    private User author;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String body;
    
    @JsonbTransient
    @ManyToMany
    @JoinTable(name = "post_tag", 
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new TreeSet<>();
    
   
    
    // GETTER AND SETTER

    public LocalDateTime getCreated() {
        return created;
    }

    @JsonbTransient // NON FA VEDERE 
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
    
    
    // TO STRING
    @Override
    public String toString() {
        return "Post{" + "created=" + created + ", author=" + author + ", title=" + title + ", body=" + body + ", tags=" + tags + '}';
    }
    
    
    // METODI PER TRASFORMARE LA CLASSE POST IN JSON
    
    public JsonObject toJson (){
          return Json.createObjectBuilder()
                .add("id", this.id)
                .add("link", UriBuilder.fromResource(PostResource.class)
                        .path(PostResource.class, "comments")
                        .build(this.id).toString())
                .build();
    }
    
}
