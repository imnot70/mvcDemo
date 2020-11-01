package demo.io.io;

import org.junit.Test;

import java.io.*;

public class IODemo001 {

	@Test
    public void test001() throws Exception {
        String hello="hello,world!";
        File file = new File("hello.txt");
        OutputStream os = new FileOutputStream(file);
        os.write(hello.getBytes());
        os.close();
    }

    @Test
    public void test002() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("hello.txt"),true));
        bw.newLine();
        bw.newLine();
        bw.append("this words will be appended to file's end after a new line");
        bw.close();
    }

    @Test
    public void test003() throws Exception {
        BufferedInputStream  bis = new BufferedInputStream(new FileInputStream(new File("简历5.docx")));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("简历6.docx")));
        byte[] bytes = new byte[8192];
        int flag = 0;
        while((flag =bis.read(bytes)) != -1){
            bos.write(bytes,0,bytes.length);
        }

        bis.close();
        bos.close();
    }

    @Test
    public void test004() throws Exception {
    	InputStream is = new FileInputStream(new File("test.txt"));
    	byte[] bytes = new byte[1024];
    	OutputStream os = new FileOutputStream(new File("test_buffer.txt"));
    	while(is.read(bytes) != -1) {
    		os.write(bytes);
    	}
    	is.close();
    	os.close();
    }

}
