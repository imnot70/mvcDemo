package demo.collections;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CollectionDemo {

    @Test
    public void testSet(){
        List<String> strs = new ArrayList<String>(Arrays.asList("1","2","3","3"));
        Set<String> set = new HashSet<String>();
        set.addAll(strs);
        System.out.println(set);
    }

    @Test
    public void test1(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("4");

        List<String> result1 = new ArrayList<>();
        for (String s:list2){
            if(!list1.contains(s)){
                System.out.println(s);
                result1.add(s);
            }
        }

        List<String> result2 = list2.stream().filter(s -> !list1.contains(s)).collect(toList());
        for(String s:result2){
            System.out.println(s);
        }

        list1.removeAll(list2);
        for(String s:list1){
            System.out.println(s);
        }

    }

    public static void main(String[] args) {
        Set<InnerClass> set = new HashSet<>();
        InnerClass i1 = new InnerClass().setId(1).setName("A");
        InnerClass i2 = new InnerClass().setId(1).setName("B");
        System.out.println(i1.equals(i2));

        set.add(i1);
        set.add(i2);

        System.out.println(set);

        List<InnerClass> l1 = new ArrayList<>();
        l1.add(i1);
        l1.add(i2);

        Set<InnerClass> s1 = new HashSet<>();
        s1.addAll(l1);
        System.out.println(s1);
    }

    static class InnerClass{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public InnerClass setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public InnerClass setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof InnerClass){
                return this.id == ((InnerClass) obj).getId();
            }
            return super.equals(obj);
        }
    }

}
