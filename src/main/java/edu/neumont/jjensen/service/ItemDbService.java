package edu.neumont.jjensen.service;

import edu.neumont.jjensen.model.Item;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Created by jjensen on 6/12/14.
 */
@Stateless
@LocalBean
@Local(ItemService.class)
public class ItemDbService implements ItemService {
    @PersistenceContext(name="nubay")
    EntityManager em;

    @Override
    public List<Item> findAll() {

        return em.createQuery("SELECT i FROM Item i", Item.class).getResultList();
    }

    @Override
    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    @Override
    public void updateItem(Item item) {
        em.persist(item);
    }
}
