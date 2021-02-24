package demo.classloader;

/**
 * @author imnot
 */
public class CustomClassLoader extends ClassLoader{
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("loadClass,name:"+name);
        return super.loadClass(name);
    }
}
