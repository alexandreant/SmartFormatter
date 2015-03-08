package br.com.smart.formatter.environment;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by alexandre on 08/03/15.
 */
public class VolatileRepository {

    private static VolatileRepository instance;

    private Map<String, Object> tags = new LinkedHashMap<String, Object>();

    public static VolatileRepository getInstance(){
        if (instance == null) {
            instance = new VolatileRepository();
        }
        return instance;
    }

    public void save(String key, Object value){
        tags.put(key, value);
    }

    public Object getValue(String key){
        return tags.get(key);
    }
}
