package edu.neumont.jjensen.model;

/**
 * Created by jjensen on 4/24/14.
 */
public interface DataAccessLayer {
    public Item getItem(long id);
    public boolean update(Item item);
    public long create(Item item);
    public boolean delete(long id);

}
