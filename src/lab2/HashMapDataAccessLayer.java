package lab2;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by jjensen on 4/25/14.
 */
public class HashMapDataAccessLayer implements DataAccessLayer {

    private HashMap<String, Item> items = new HashMap<String, Item>();

    public HashMapDataAccessLayer() {
        //Setup the Hashmap item inventory
        items.put("1234", new Item("1234", "09/27/2014"));
        items.put("1235", new Item("1235", "07/27/2014"));
        items.put("1236", new Item("1236", "06/05/2014"));
        items.put("1237", new Item("1237", "09/02/2014"));
        items.put("1238", new Item("1238", "05/29/2014"));
        items.put("1239", new Item("1239", "08/17/2014"));
        items.put("1240", new Item("1240", "09/27/2014"));

    }
    @Override
    public Item getItem(String id) {
        return items.get(id);
    }

    @Override
    public boolean update(Item item) {
        Item oldItem = items.get(item.getId());

        if(item.getExperation() == null) {
            item.setExperationDate(oldItem.getExperation());
            items.put(item.getId(), item);
        } else {
            items.put(item.getId(), item);
        }
        return true;
    }
}
