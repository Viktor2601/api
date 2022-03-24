/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.control;


import it.viktor.blogapp.entity.Tag;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class TagStore {
    
    @PersistenceContext
    EntityManager em;
    
    
    public List<Tag> all(){
        return em.createQuery("select e from Tag e ").getResultList();
    }
    
    
    public Tag save(Tag entity){
        return em.merge(entity);
    }
    
    public Optional<Tag> findById(Long id){
        Tag found = em.find(Tag.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }
    
    public Optional<Tag> findByName(String name){
        Tag found = em.find(Tag.class, name);
        return found == null ? Optional.empty() : Optional.of(found);
    }
    
    public void delete(Long id){
         em.remove(em.getReference(Tag.class, id));
    }
}
