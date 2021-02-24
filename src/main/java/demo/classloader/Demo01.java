package demo.classloader;

/**
 * @author imnot
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        CustomClassLoader<java.lang.String> loader = new CustomClassLoader<java.lang.String>();
        loader.loadClass("demo.beans.Person");
        // 加载java开头的包，会直接报错Prohibited package name
        /*
        Class<String> str = (Class<String>) loader.loadClass("java.lang1.String");
        System.out.println(loader.getParent());
        String instance = str.newInstance();
        System.out.println(instance);
        */

    }
}
