package demo.reflect;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;

public class LoadClass {
    public static void main(String[] args) throws Exception {
        LoadClass loadClass = new LoadClass();
        loadClass.loadClass("mvc.controller");
    }

    public void loadClass(String basePath) throws IOException, URISyntaxException, ClassNotFoundException {
        String baseFilePath = basePath.replace(".","/");
        System.out.println("baseFilePath:"+baseFilePath);
        ClassLoader loader = this.getClass().getClassLoader();
        Enumeration<URL> classes = loader.getResources(baseFilePath);
        System.out.println("classes:"+classes);
        if(classes != null){
            while(classes.hasMoreElements()){
                URL classUrl = classes.nextElement();
                System.out.println(classUrl.toString());
                File classFile = new File(classUrl.toURI());
                String[] fileList = classFile.list((dir, name) -> name.endsWith("class"));
                if(fileList != null){
                    for(String fileName:fileList){
                        String classFullName = basePath+"."+fileName;
                        System.out.println(classFullName);
                        Class c = Class.forName(classFullName);
                        System.out.println(c);
                    }
                }
            }
        }
    }
}
