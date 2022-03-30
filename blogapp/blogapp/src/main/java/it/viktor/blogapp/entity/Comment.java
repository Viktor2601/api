    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.entity;

import it.viktor.blogapp.adapters.PostTypeAdapter;
import it.viktor.blogapp.adapters.UserTypeAdapter;
import java.io.Serializable;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_comment")
public class Comment extends BaseEntity implements Serializable{
    // ATTRIBUTI
    
    @JsonbTypeAdapter(UserTypeAdapter.class)
    @ManyToOne(optional = false)
    private User author;
    
    @Column(nullable = false)
    private String message;
    
    @ManyToOne(optional = false)
    @JsonbTypeAdapter(PostTypeAdapter.class)
    private Post post;
    
    // GETTER AND SETTER
    
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
   
    // TO STRING

    @Override
    public String toString() {
        return "Comment{" + "author=" + author + ", message=" + message + ", post=" + post + '}';
    }
    

    
}
