package lab2.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by jjensen on 4/25/14.
 */
public class HashMapDataAccessLayer implements DataAccessLayer {

    private HashMap<Long, Item> items = new HashMap<Long, Item>();

    public HashMapDataAccessLayer() {
        //Setup the Hashmap item inventory
        items.put(1234L, new Item(1234L, "09/27/2014"));
        items.put(1235L, new Item(1235L, "07/27/2014"));
        items.put(1236L, new Item(1236L, "06/05/2014"));
        items.put(1237L, new Item(1237L, "09/02/2014"));
        items.put(1238L, new Item(1238L, "05/29/2014"));
        items.put(1239L, new Item(1239L, "08/17/2014"));
        items.put(1240L, new Item(1240L, "09/27/2014"));

    }

    @Override
    public Item getItem(long id) {
        return items.get(id);
    }

    @Override
    public boolean update(Item item) {
        Item oldItem = items.get(item.getId());
        BigDecimal currentBid = oldItem.getCurrentBid();
        boolean isSuccesful;

        if(item.getCurrentBid().compareTo(currentBid) > 0) {
            if(item.getExperation() == null) {
                item.setExperationDate(oldItem.getExperation());
                items.put(item.getId(), item);
            } else {
                items.put(item.getId(), item);
            }
            isSuccesful = true;
        } else {
            isSuccesful = false;

        }

        return isSuccesful;
    }

    @Override
    public long create(Item item) {
        long key = getLastId();
        key++;
        item.setId(key);
        items.put(key, item);

        return key;
    }

    /**
     * Returns the last Item id from the hashmap
     * @return long
     */
    private long getLastId() {
        Iterator iterator = items.entrySet().iterator();
        long lastKey = 0;

        while(iterator.hasNext()) {
            Item item = (Item) iterator.next();

            if(item.getId() > lastKey) {
                lastKey = item.getId();
            }

        }

        return lastKey;
    }
}