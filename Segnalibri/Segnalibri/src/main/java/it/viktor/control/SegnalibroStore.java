/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.control;

import it.viktor.entity.Etichetta;
import it.viktor.entity.Segnalibro;
import it.viktor.entity.Utente;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class SegnalibroStore {

    @PersistenceContext
    EntityManager em;

    @Inject
    EtichettaStore etichettaStore;

    public Segnalibro create(@Valid Segnalibro entity) {
        return em.merge(entity);
    }

    public List<Segnalibro> all() {
        return em.createQuery("select e from Segnalibro e order by e.utente").getResultList();
    }

    public Optional<Segnalibro> find(Long id) {
        Segnalibro found = em.find(Segnalibro.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public void addEtichetta(Segnalibro found, String etichetta) {
        Segnalibro toUpdate = find(found.getId()).get();
        Etichetta saved = etichettaStore.salvaSeNonEsiste(etichetta);
        toUpdate.getEtichette().add(saved);
        create(toUpdate);
    }

}
