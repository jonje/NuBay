package lab2;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by jjensen on 5/7/14.
 */
public class ServerContext {
    private final static Map<String, Object> contextMap = new HashMap();

    public static Object getAttribute(String index) {
        return contextMap.get(index);
    }

    public static void setAttribute(String index, Object object) {
        contextMap.put(index, object);
    }
}
