package demo.collections.custom;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author imnot
 */
public class LruContainer<K, V> extends LinkedHashMap<K, V> {

    private static int size;

    public LruContainer() {
        this(4, 0.75f, true);
    }

    public LruContainer(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
        size = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > size;
    }

}
