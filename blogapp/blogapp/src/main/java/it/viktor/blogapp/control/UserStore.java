/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.control;

import it.viktor.blogapp.entity.User;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional(Transactional.TxType.REQUIRED) // GESTISCE LE TRANSAZIONI TRA L'APPLICAZIONE E IL DATABASE
@RequestScoped // GESTISCE LA CREAZIONE DI UN NUOVO OGGETTO SENZA USARE LA NEW
public class UserStore {
    
    @PersistenceContext
    EntityManager em;
    
    public List<User> all(){
        return em.createQuery("select e from User e order by e.surname").getResultList();
    }
    
    public Optional<User> find(Long id){
        User found = em.find(User.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }
    
    public User save(User entity){
       return em.merge(entity);
    }
    
    public void delete(Long id) {
        em.remove(em.getReference(User.class, id));
    }
}
