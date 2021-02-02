package demo.collections;

import demo.collections.custom.LruContainer;

import java.util.Map;
import java.util.Set;

/**
 * @author imnot
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LruContainer<String,String> container = new LruContainer<>();
        container.put("A","A");
        container.put("B","B");
        container.put("C","C");
        container.put("D","D");
        container.put("E","E");
        container.get("E");
        container.get("C");
        container.get("B");

        Set<Map.Entry<String, String>> entrySet = container.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
