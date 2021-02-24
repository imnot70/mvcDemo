package springdemo.convert;

import org.springframework.core.convert.converter.Converter;

/**
 * @author imnot
 */
public class ConvertDemo {

    public static void main(String[] args) {

    }

    public static void test1(){
    }

    static class CustomConverter implements Converter<String,Integer>{

        @Override
        public Integer convert(String source) {

            return null;
        }
    }
}
