package edu.neumont.jjensen.service;

import edu.neumont.jjensen.model.Item;

import java.util.List;

/**
 * Created by jjensen on 6/12/14.
 */
public interface ItemService {
    public List<Item> findAll();

    public Item findById(Long id);

    public void updateItem(Item item);

}
