package demo.collections;

import java.util.ArrayList;

/**
 * @author imnot
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(10);
        list.add("A");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
