package demo.utils;

import java.util.Random;

/**
 * @author imnot
 */
public class RandomStringUtil {

    private static int uppercaseStart = 65;
    private static int lowercaseStart = 97;
    private static final int ARRAY_LENGTH = 26;
    private static final String[] UPPERCASE_ARRAY = new String[ARRAY_LENGTH];
    private static final String[] LOWERCASE_ARRAY = new String[ARRAY_LENGTH];
    private static final String[] ALL_ARRAY = new String[ARRAY_LENGTH << 1];

    static {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            UPPERCASE_ARRAY[i] = String.valueOf((char) (uppercaseStart++));
            LOWERCASE_ARRAY[i] = String.valueOf((char) (lowercaseStart++));
            ALL_ARRAY[i] = UPPERCASE_ARRAY[i];
            ALL_ARRAY[i + ARRAY_LENGTH] = LOWERCASE_ARRAY[i];
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            String result = null;
            result = getRandomString(10, Type.ALL, result);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 获取随机字符串
     * @param length  长度
     * @param type    类型，枚举
     * @param lastStr 生成的字符串，会和lastStr比较，相同重新生成
     * @return String生成的结果
     */
    public static String getRandomString(int length, Type type, String lastStr) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        String result;
        if (Type.UPPERCASE.equals(type)) {
            for (int i = 0; i < length; i++) {
                stringBuilder.append(UPPERCASE_ARRAY[random.nextInt(ARRAY_LENGTH)]);
            }
        } else if (Type.LOWERCASE.equals(type)) {
            for (int i = 0; i < length; i++) {
                stringBuilder.append(LOWERCASE_ARRAY[random.nextInt(ARRAY_LENGTH)]);
            }
        } else if (Type.ALL.equals(type)) {
            int bound = ARRAY_LENGTH << 1;
            for (int i = 0; i < length; i++) {
                stringBuilder.append(ALL_ARRAY[random.nextInt(bound)]);
            }
        } else {
            throw new IllegalArgumentException("type is wrong");
        }
        result = stringBuilder.toString();
        if (result.equals(lastStr)) {
            System.out.println("regenerate,lastStr:" + lastStr);
            getRandomString(length, type, lastStr);
        }
        return result;
    }

    public enum Type {
        /**
         * 大写
         */
        UPPERCASE,
        /**
         * 小写
         */
        LOWERCASE,
        /**
         * 大小写
         */
        ALL;
    }

}
