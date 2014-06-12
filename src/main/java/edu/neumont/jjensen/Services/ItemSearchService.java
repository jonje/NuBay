package edu.neumont.jjensen.Services;

import edu.neumont.jjensen.model.Item;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by jjensen on 6/12/14.
 */
public interface ItemSearchService {
    public List<Item> search(List<String> query) throws ExecutionException;
}
