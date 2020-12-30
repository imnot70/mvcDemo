package demo.unsafe;

import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

/**
 * @author zhangpeng
 * @description
 * @date 2020-11-21 下午2:56
 **/
public class UnsafeDemo {
    public static void main(String[] args) {
        Unsafe unsafe = UnsafeUtils.getUnsafe();

    }
}
