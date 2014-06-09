package edu.neumont.jjensen.model;

/**
 * Created by jjensen on 4/25/14.
 */
public class DataAccessFactory {
    public static DataAccessLayer create(String type) {
        DataAccessLayer dal = null;
        if(type.equalsIgnoreCase("hashmap")) {
            dal = new HashMapDataAccessLayer();

        } else if(type.equalsIgnoreCase("database")) {

        }

        return dal;
    }
}
