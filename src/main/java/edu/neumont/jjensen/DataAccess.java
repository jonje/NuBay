package edu.neumont.jjensen;

import edu.neumont.jjensen.model.DataAccessLayer;

/**
 * Created by jjensen on 5/13/14.
 */
public class DataAccess {
    private final static ThreadLocal<DataAccessLayer> dataAccess = new ThreadLocal<DataAccessLayer>();

    public static DataAccessLayer getDataAccess() {
        return dataAccess.get();
    }

    public static void setDataAccess(DataAccessLayer dal) {
        dataAccess.set(dal);
    }
}
