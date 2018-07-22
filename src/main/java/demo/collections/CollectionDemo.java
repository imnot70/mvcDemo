package demo.collections;

import org.junit.Test;

import java.util.*;

public class CollectionDemo {

    @Test
    public void testSet(){
        List<String> strs = new ArrayList<String>(Arrays.asList("1","2","3","3"));
        Set<String> set = new HashSet<String>();
        set.addAll(strs);
        System.out.println(set);
    }

}
