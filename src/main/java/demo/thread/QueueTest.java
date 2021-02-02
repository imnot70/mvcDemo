package demo.thread;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author imnot
 */
public class QueueTest {
    static ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) {
        test04();
    }

    /**
     * 有界队列测试
     * 会拋出IllegalStateException，提示队列满
     */
    private static void test01(){
        addElement(5,6);
    }

    private static void test02(){
        addElement(10,10);
    }

    private static void addElement(int size,int loop){
        Queue<Integer> queue = new LinkedBlockingQueue<>(size);
        for(int i=0;i<loop;i++){
            queue.add(i);
        }
        try {
            System.out.println(mapper.writeValueAsString(queue));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * offer
     */
    private static void test03(){
        int size = 10;
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for(int i=0;i<size;i++){
            queue.offer(i);
        }
        try {
            System.out.println(mapper.writeValueAsString(queue));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * put
     */
    private static void test04(){
        int size = 10;
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for(int i=0;i<size;i++){
            try {
                queue.put(i);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println(mapper.writeValueAsString(queue));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历
     */
    private static void test05(){
        int size = 10;
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for(int i=0;i<size;i++){
            queue.add(i);
        }
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }
}
