/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.control;

import it.viktor.entity.Utente;
import it.viktor.sicurezza.SecurityEncoding;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class UtenteStore {
    
    @PersistenceContext
    EntityManager em;
    
    public Utente create(@Valid Utente entity) {
        entity.setPassword(SecurityEncoding.shaHash(entity.getPassword()));
        return em.merge(entity);
    }
    
    public List<Utente> all() {
        return em.createQuery("select e from Utente e order by e.cognome", Utente.class).getResultList();
    }
    
    public Optional<Utente> find (Long id){
        Utente found = em.find(Utente.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }
}
