package demo.proxy;

import java.lang.reflect.Proxy;

/**
 * @author imnot
 */
public class Demo {
    public static void main(String[] args) {
        SqlFileLoader.read();
        Mapper mapper = (Mapper) Proxy.newProxyInstance(
                Demo.class.getClassLoader(),
                new Class<?>[]{Mapper.class},
                (proxy, method, args1) -> {
                    String sqlContent = SqlContainer.getSql(method.getName());
                    // TODO 在这里获取statement,上面的sqlContent（即sql的内容）
                    return null;
                });

        System.out.println(mapper.getOne());
    }
}
