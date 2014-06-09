package edu.neumont.jjensen.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jjensen on 4/25/14.
 */
public class HashMapDataAccessLayer implements DataAccessLayer {

    private Map<Long, Item> items = new HashMap<Long, Item>();

    public HashMapDataAccessLayer() {
        //Setup the Hashmap item inventory
        items.put(1234L, new Item(1234L, "Something", "http://cdn.visualnews.com/wp-content/uploads/2013/07/5-art-of-%CF%80.png", "09/27/2014"));
        items.put(1235L, new Item(1235L, "Something", "http://cdn.visualnews.com/wp-content/uploads/2013/07/5-art-of-%CF%80.png", "07/27/2014"));
        items.put(1236L, new Item(1236L, "Something", "http://cdn.visualnews.com/wp-content/uploads/2013/07/5-art-of-%CF%80.png", "06/05/2014"));
        items.put(1237L, new Item(1237L, "Something", "http://cdn.visualnews.com/wp-content/uploads/2013/07/5-art-of-%CF%80.png", "09/02/2014"));
        items.put(1238L, new Item(1238L, "Something", "http://cdn.visualnews.com/wp-content/uploads/2013/07/5-art-of-%CF%80.png", "05/29/2014"));
        items.put(1239L, new Item(1239L, "Something", "http://cdn.visualnews.com/wp-content/uploads/2013/07/5-art-of-%CF%80.png", "08/17/2014"));
        items.put(1240L, new Item(1240L, "Something", "http://cdn.visualnews.com/wp-content/uploads/2013/07/5-art-of-%CF%80.png", "09/27/2014"));

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
            if(item.getExpiration() == null) {
                item.setExpirationDate(oldItem.getExpiration());
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

    @Override
    public boolean delete(long id) {
        items.remove(id);
        return true;
    }

    /**
     * Returns the last Item id from the hashmap
     * @return long
     */
    private long getLastId() {

        long lastKey = 0;

        for(Map.Entry<Long, Item> entry : items.entrySet()){
            Item item = entry.getValue();
            if(item.getId() > lastKey) {
                lastKey = item.getId();
            }
        }


        return lastKey;
    }
}