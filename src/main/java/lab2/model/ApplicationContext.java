package lab2.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jjensen on 5/16/14.
 */
public class ApplicationContext {
    private static ApplicationContext applicationContext = new ApplicationContext();
    private Map<String, Object> contextMap = new HashMap<>();

    public static ApplicationContext getInstance() {
        return applicationContext;
    }

    public void setAttribute(String index, Object obj) {
        contextMap.put(index, obj);
    }

    public Object getAttribute(String index) {
        return contextMap.get(index);
    }
}
