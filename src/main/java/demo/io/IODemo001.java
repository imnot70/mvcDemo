package demo.io;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class IODemo001 {

    @Test
    public void test001() throws Exception {
        String hello="hello,world!";
        File file = new File("hello.txt");
        OutputStream os = new FileOutputStream(file);
        os.write(hello.getBytes());
        os.close();
    }

}
