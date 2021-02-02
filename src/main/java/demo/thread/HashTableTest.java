package demo.thread;

import demo.utils.RandomStringUtil;
import org.springframework.util.StopWatch;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author imnot
 */
public class HashTableTest {

    /**
     * 线程数量，这里设置为对应CPU核心数
     */
    private static final int CORES = 6;
    private static final int COUNT_MILLION = 1000000;
    private static final int COUNT_100K = 100000;

    private static final String[] STR_ARRAY = new String[COUNT_MILLION];
    private static final String[][] STR_ARRAY_2 = new String[6][COUNT_100K];
    private static final Random RANDOM = new Random();
    private static final Hashtable<String, String> HASHTABLE = new Hashtable<>();
    private static final HashMap<String, String> HASHMAP = new HashMap<>();
    private static final ConcurrentHashMap<String, String> CHM = new ConcurrentHashMap<>();

    /*
     * 初始化STR_ARRAY，在其中存入1,000,000个随机字符串
     * 初始化STR_ARRAY_2，在其中存入6个字符串数组，每个数组有100,000个字符串
     */
    static {
        String result = null;
        for (int i = 0; i < COUNT_MILLION; i++) {
            result = RandomStringUtil.getRandomString(10, RandomStringUtil.Type.ALL, result);
            STR_ARRAY[i] = result;
        }

        String result2 = null;
        for (int i = 0; i < CORES; i++) {
            for (int j = 0; j < COUNT_100K; j++) {
                result2 = RandomStringUtil.getRandomString(10, RandomStringUtil.Type.ALL, result2);
                STR_ARRAY_2[i][j] = result2;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        test1();
    }

    private static void test1() throws Exception{
        StopWatch stopWatch = new StopWatch();
        // 单线程Put
        stopWatch.start("Single,Put,HashMap");
        testHashMapPut(false);
        stopWatch.stop();
        stopWatch.start("Single,Put,Hashtable");
        testHashtablePut(false);
        stopWatch.stop();
        stopWatch.start("Single,Put,ConcurrentHashMap");
        testConcurrentHashMapPut(false);
        stopWatch.stop();

        // 单线程Get
        stopWatch.start("Single,Get,HashMap");
        testHashMapGet(false);
        stopWatch.stop();
        stopWatch.start("Single,Get,Hashtable");
        testHashTableGet(false);
        stopWatch.stop();
        stopWatch.start("Single,Get,ConcurrentHashMap");
        testConcurrentHashMapGet(false);
        stopWatch.stop();

        // 多线程Put
        stopWatch.start("Multi,Put,Hashtable");
        testHashtableMultiThreadPut(false);
        stopWatch.stop();
        stopWatch.start("Multi,Put,ConcurrentHashMap");
        testConcurrentHashMapMultiThreadPut(false);
        stopWatch.stop();

        // 多线程Get
        stopWatch.start("Multi,Get,Hashtable");
        testHashtableMultiThreadGet(false);
        stopWatch.stop();
        stopWatch.start("Multi,Get,ConcurrentHashMap");
        testConcurrentHashMapMultiThreadGet(false);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * HashMap的put测试
     *
     * @param print 是否打印结果
     */
    private static void testHashMapPut(boolean print) {
        HASHMAP.clear();
        long start = System.currentTimeMillis();
        commonPut(HASHMAP);
        long current = System.currentTimeMillis();
        if (print) {
            System.out.println("HashMap put total time:" + (current - start));
            System.out.println("HashMap size:" + HASHTABLE.size());
        }
    }

    /**
     * Hashtable的put测试
     *
     * @param print 是否打印结果
     */
    private static void testHashtablePut(boolean print) {
        HASHTABLE.clear();
        long start = System.currentTimeMillis();
        commonPut(HASHTABLE);
        long current = System.currentTimeMillis();
        if (print) {
            System.out.println("Hashtable put total time:" + (current - start));
            System.out.println("Hashtable size:" + HASHTABLE.size());
        }
    }

    /**
     * ConcurrentHashMap的put测试
     *
     * @param print 是否打印结果
     */
    private static void testConcurrentHashMapPut(boolean print) {
        CHM.clear();
        long start = System.currentTimeMillis();
        commonPut(CHM);
        long current = System.currentTimeMillis();
        if (print) {
            System.out.println("ConcurrentHashMap put total time:" + (current - start));
            System.out.println("ConcurrentHashMap size:" + HASHTABLE.size());
        }
    }

    /**
     * 通用的put方法，从STR_ARRAY中取出字符，放入map（Hashtable,HashMap,ConcurrentMap）
     */
    private static void commonPut(Map<String, String> map) {
        for (int i = 0; i < COUNT_MILLION; i++) {
            String str = STR_ARRAY[i];
            map.put(str, str);
        }
    }

    /**
     * HashMap的get测试
     */
    private static void testHashMapGet(boolean print) {
        testHashMapPut(false);
        // 为了减少获取key的时间干扰，将keySet单独放入一个ArrayList中，
        // 然后使用随机访问的方式，从map中获取value
        ArrayList<String> keyList = new ArrayList<>(HASHMAP.keySet());
        // 计时
        long start = System.currentTimeMillis();
        commonGet(keyList, HASHMAP);
        long current = System.currentTimeMillis();
        if (print) {

            System.out.println("HashMap get total time:" + (current - start));
        }
    }

    /**
     * Hashtable的get测试
     */
    private static void testHashTableGet(boolean print) {
        testHashtablePut(false);
        ArrayList<String> keyList = new ArrayList<>(HASHTABLE.keySet());

        long start = System.currentTimeMillis();
        commonGet(keyList, HASHTABLE);
        long current = System.currentTimeMillis();

        if (print) {

            System.out.println("Hashtable get total time:" + (current - start));
        }
    }

    /**
     * ConcurrentHashMap的get测试
     */
    private static void testConcurrentHashMapGet(boolean print) {
        testConcurrentHashMapPut(false);
        ArrayList<String> keyList = new ArrayList<>(CHM.keySet());

        long start = System.currentTimeMillis();
        commonGet(keyList, CHM);
        long current = System.currentTimeMillis();
        if (print) {
            System.out.println("ConcurrentHashMap total time:" + (current - start));
        }
    }

    /**
     * 通用的get方法，此方法被计时，因此keyList会由外部传入，减少获取key的时间干扰
     *
     * @param keyList map的key的集合
     * @param map     map对象（Hashtable，HashMap，ConcurrentHashMap)
     */
    private static void commonGet(ArrayList<String> keyList, Map<String, String> map) {
        int bound = keyList.size();
        for (int i = 0; i < bound; i++) {
            map.get(keyList.get(RANDOM.nextInt(bound)));
        }
    }

    /**
     * Hashtable多线程put测试，不使用executors
     */
    private static void testHashtableMultiThreadPut(boolean print) throws InterruptedException {
        HASHTABLE.clear();
        // 构造线程数组
        Thread[] threads = generatePutThreadArray(HASHTABLE);
        // 启动线程
        long result = calculateTime(threads);

        if (print) {
            System.out.println("Hashtable multi put,time:" + result);
            System.out.println("Hashtable size:" + HASHTABLE.size());
        }
    }

    /**
     * ConcurrentHashMap多线程put测试，不使用executors
     */
    private static void testConcurrentHashMapMultiThreadPut(boolean print) throws InterruptedException {
        CHM.clear();
        // 构造线程数组
        Thread[] threads = generatePutThreadArray(CHM);
        // 启动线程
        long result = calculateTime(threads);
        if (print) {
            System.out.println("ConcurrentHashMap multi put,time:" + result);
            System.out.println("ConcurrentHashMap size:" + CHM.size());
        }
    }

    /**
     * 生成线程数组
     *
     * @param map 要操作的Map对象（Hashtable,ConcurrentHashMap)
     */
    private static Thread[] generatePutThreadArray(Map<String, String> map) {
        Thread[] threads = new Thread[CORES];
        // 构造线程数组
        for (int i = 0; i < CORES; i++) {
            Thread temp = new InnerPutThread(STR_ARRAY_2[i], map);
            threads[i] = temp;
        }
        return threads;
    }

    /**
     * 计算Thread数组的执行时间
     *
     * @param threads 线程数组
     */
    private static long calculateTime(Thread[] threads) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 启动线程
        for (int i = 0; i < CORES; i++) {
            threads[i].start();
        }
        // 线程join至main
        for (int i = 0; i < CORES; i++) {
            threads[i].join();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static void testHashtableMultiThreadGet(boolean print) throws InterruptedException {
        testHashtableMultiThreadPut(false);
        Thread[] threads = generateGetThreadArray(HASHTABLE);
        long result = calculateTime(threads);
        if (print) {

            System.out.println("Hashtable multi get,time:" + result);
        }
    }

    private static void testConcurrentHashMapMultiThreadGet(boolean print) throws InterruptedException {
        testConcurrentHashMapMultiThreadPut(false);
        Thread[] threads = generateGetThreadArray(CHM);
        long result = calculateTime(threads);
        if (print) {

            System.out.println("ConcurrentHashMap multi get,time:" + result);
        }
    }

    /**
     * 构造get方法的线程数组
     *
     * @param map 要操作的Map对象
     */
    private static Thread[] generateGetThreadArray(Map<String, String> map) {
        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        Thread[] threads = new Thread[CORES];
        // 构造线程数组
        for (int i = 0; i < CORES; i++) {
            Thread temp = new InnerGetThread(COUNT_100K, keyList, map);
            threads[i] = temp;
        }
        return threads;
    }

    /**
     * get方法的内部类，在这个方法里面会对Map对象进行loopCount次的get
     */
    static class InnerGetThread extends Thread {
        private final int loopCount;
        private final ArrayList<String> keyList;
        private final Map<String, String> map;

        public InnerGetThread(int loopCount, ArrayList<String> keyList, Map<String, String> map) {
            this.loopCount = loopCount;
            this.keyList = keyList;
            this.map = map;
        }

        @Override
        public void run() {
            int bound = keyList.size();
            for (int i = 0; i < loopCount; i++) {
                map.get(keyList.get(RANDOM.nextInt(bound)));
            }
        }
    }

    static class InnerPutThread extends Thread {

        private final String[] strings;
        private final Map<String, String> map;

        public InnerPutThread(String[] strings, Map<String, String> map) {
            this.strings = strings;
            this.map = map;
        }

        @Override
        public void run() {
            for (String str : strings) {
                map.put(str, str);
            }
        }
    }

}
