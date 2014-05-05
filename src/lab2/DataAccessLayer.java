package lab2;

/**
 * Created by jjensen on 4/24/14.
 */
public interface DataAccessLayer {
    public Item getItem(String id);
    public boolean update(Item item);
    

}
