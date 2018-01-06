package spring.framework.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangjun on 2018/1/6.
 */
public class MapBuilder<K, V> {
    private Map<K, V> map = new HashMap<>();

    private MapBuilder() {
    }

    public static MapBuilder builder() {
        return new MapBuilder();
    }

    public MapBuilder<K, V> put(K key, V value) {
        this.map.put(key, value);
        return this;
    }

    public Map<K, V> build() {
        return this.map;
    }
}
