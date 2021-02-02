package demo.temp;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author imnot
 */
public class UnsafeTest {

    private static Unsafe unsafe;

    static{
        Class<Unsafe> unsafeClass = Unsafe.class;
        try {
            Field f = unsafeClass.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(unsafeClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(unsafe);
    }

}
