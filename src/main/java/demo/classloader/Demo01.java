package demo.classloader;

import demo.beans.Person;

import java.lang.reflect.Field;
import java.util.concurrent.Executors;

/**
 * @author imnot
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        String className = "demo.beans.Person";
        CustomClassLoader loader = new CustomClassLoader();
        Class<?> loadClass = loader.loadClass(className);

        Field[] fields = loadClass.getDeclaredFields();
        for(Field f:fields){
            System.out.println(f.getName());
        }
        // 加载java开头的包，会直接报错Prohibited package name
        /*
        Class<String> str = (Class<String>) loader.loadClass("java.lang1.String");
        System.out.println(loader.getParent());
        String instance = str.newInstance();
        System.out.println(instance);
        */
        
        InnerLoader1 loader1 = new InnerLoader1();
        InnerLoader2 loader2 = new InnerLoader2();
        Class<?> loadClass1 = loader1.loadClass(className);
        Class<?> loadClass2 = loader2.loadClass(className);

        Person p3 = (Person) loadClass1.newInstance();
        Person p4 = p3;
    }

    static class InnerLoader1 extends ClassLoader{

    }

    static class InnerLoader2 extends ClassLoader{

    }
}
