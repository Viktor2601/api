/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.control;

import it.viktor.blogapp.entity.Comment;
import it.viktor.blogapp.entity.Post;
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


@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class CommentStore {
    
    @PersistenceContext
    EntityManager em;
    
    /**
     * ritorna tutti i commenti di un determinato post
     * @param postId
     * @return 
     */
    public List<Comment> allByPost(Long postId) {
        return em.createQuery("select e from Comment e where e.post.id = :postId", Comment.class)
          .setParameter("postId",postId)
          .getResultList();
    }
    
    /**
     * crea un commento
     * @param entity 
     */
    public Comment create (Comment entity){
         return em.merge(entity);
    }
    
    public Optional<Comment> find (Long id){
        Comment found = em.find(Comment.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }
    
}
