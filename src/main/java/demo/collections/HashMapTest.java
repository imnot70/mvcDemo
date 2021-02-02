package demo.collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangpeng
 * @description
 * @date 2021-01-07 下午3:34
 **/
public class HashMapTest {

    static final int HASH_BITS = 0x7fffffff;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {
//        spreadTest();
//        linkedHashMapTest();
        treeMapTest();
        linkedHashMapTest();
        linkedHashMapAccessTest();
    }

    private static void linkedHashMapAccessTest() throws JsonProcessingException {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(4, 0.75f, true);
        setMapValue("linkedHashMapAccess", map, true);
    }

    private static void linkedHashMapTest() throws JsonProcessingException {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(4);
        setMapValue("linkedHashMap", map, false);
    }

    private static void treeMapTest() throws JsonProcessingException {
        TreeMap<String, String> map = new TreeMap<>();
        setMapValue("treeMap", map, false);
    }

    private static void setMapValue(String prefix, Map<String, String> map, boolean print) throws JsonProcessingException {
        map.put("A", "A");
        map.put("C", "C");
        map.put("B", "B");
        System.out.println(prefix + ":" + MAPPER.writeValueAsString(map));
        map.get("C");
        System.out.println(prefix + ":" + MAPPER.writeValueAsString(map));

        if (print) {
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                System.out.println(prefix + ":" + entry.getKey() + ":" + entry.getValue());
            }
        }

    }

    private static int spreadTest() {
        String str = "test";
        return spread(str.hashCode());
    }

    private static int spread(int h) {
        String hResult = Integer.toBinaryString(h);
        System.out.println("h:" + h + ",hResult:" + hResult);
        int rh = h >>> 16;
        System.out.println(rh);
        String rhResult = Integer.toBinaryString(rh);
        System.out.println("rh:" + rh + ",rhResult:" + rhResult);
        System.out.println(h ^ (h >>> 16));
        System.out.println(h ^ rh);
        String result = Integer.toBinaryString(h ^ (h >>> 16));
        System.out.println("h ^ rh:" + (h ^ rh) + ",result:" + result);

        System.out.println((h ^ (h >>> 16)) & HASH_BITS);
        return (h ^ (h >>> 16)) & HASH_BITS;
    }

    private static void HashMapTest() {
        HashMap<String, String> map = new HashMap<>(4);
        map.put("A", "A");
        map.put("E", "E");
        map.put("B", "B");
        map.put("C", "C");
    }

    private static void ConcurrentHashMapTest() {
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>(4);
        chm.put("A", "A");
        chm.put("E", "E");
        chm.put("B", "B");
        chm.put("C", "C");
        System.out.println(tableSizeFor(0));
    }

    private static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1024) ? 1024 : n + 1;
    }
}
