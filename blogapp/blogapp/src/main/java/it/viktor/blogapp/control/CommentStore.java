/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.control;

import it.viktor.blogapp.entity.Comment;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author tss
 */




public class CommentStore {
    
    @PersistenceContext
    EntityManager em;
    
    
    public List<Comment> all(){
        return em.createQuery("select e from Comment e ").getResultList();
    }
    
    
    public Comment save(Comment entity){
        return em.merge(entity);
    }
    
    public Optional<Comment> find(Long id){
        Comment found = em.find(Comment.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }
    
    public void delete(Long id){
         em.remove(em.getReference(Comment.class, id));
    }
}
