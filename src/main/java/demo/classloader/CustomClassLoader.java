package demo.classloader;

/**
 * @author imnot
 */
public class CustomClassLoader<T> extends ClassLoader{
    @Override
    public Class<T> loadClass(String name) throws ClassNotFoundException {
        System.out.println("loadClass,name:"+name);
        return (Class<T>) super.loadClass(name);
    }
}
