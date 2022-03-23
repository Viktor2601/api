/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @ManyToOne(optional = false)
    private User author;
    
    @Column(nullable = false)
    private String message;
    
    @ManyToOne(optional = false)
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
