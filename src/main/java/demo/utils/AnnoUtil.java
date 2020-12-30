package demo.utils;

import demo.annotations.TestAnno;

public class AnnoUtil {

    public static <T> void procAnno(T t){
        Class clazz = t.getClass();
        if(clazz.isAnnotationPresent(TestAnno.class)){

        }
    }

}
