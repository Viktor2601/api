/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.control;

import it.viktor.blogapp.boundary.Credential;
import it.viktor.blogapp.entity.User;
import it.viktor.blogapp.security.control.SecurityEncoding;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional(Transactional.TxType.REQUIRED) // GESTISCE LE TRANSAZIONI TRA L'APPLICAZIONE E IL DATABASE
@RequestScoped // GESTISCE LA CREAZIONE DI UN NUOVO OGGETTO SENZA USARE LA NEW
public class UserStore {

    @PersistenceContext
    EntityManager em;

    /**
     * ritorna una lista con tutti gli utenti ordinati per cognome
     *
     * @return
     */
    public List<User> all() {
        return em.createQuery("select e from User e order by e.surname").getResultList();
    }

    /**
     * cerca un determinato utente passnado come parametro l'ID del utente da
     * cercare. ritorna l'utente se l'ha trovato se no ritorna null
     *
     * @param id
     * @return
     */
    public Optional<User> find(Long id) {
        User found = em.find(User.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

  
    public User create(User entity){
        entity.setPassword(SecurityEncoding.shaHash(entity.getPassword()));
        return save(entity);
    }
    
    public User save(User entity) {
        User saved = em.merge(entity);
        return saved;
    }
    /**
     * cancella un user con l'ID passato come parametro
     *
     * @param id
     */
    public void delete(Long id) {
        em.remove(em.getReference(User.class, id));
    }

    public Optional<User> login(Credential credential) {
        try {
             return Optional.of( em.createQuery("select e from User e where e.email = :user and e.password = :password ", User.class)
                    .setParameter("user", credential.user)
                    .setParameter("password", SecurityEncoding.shaHash(credential.password))
                    .getSingleResult());
        } catch (NoResultException error){
            return Optional.empty();
        }
    }
}
