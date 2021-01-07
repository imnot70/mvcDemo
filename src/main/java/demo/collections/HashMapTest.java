package demo.collections;

import java.util.HashMap;

/**
 * @author imnot
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>(16);
        System.out.println(map.size());
        map.put("A","A");
    }
}
