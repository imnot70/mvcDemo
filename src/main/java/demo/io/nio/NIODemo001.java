package demo.io.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo001 {

    @Test
    public void demo001() throws Exception {
        InputStream is = new FileInputStream(new File("hello.txt"));
        FileChannel inChannel = ((FileInputStream) is).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(8192);

        OutputStream os = new FileOutputStream(new File("hello_nio.txt"));
        FileChannel outChannel = ((FileOutputStream) os).getChannel();

        while(true){
            if(inChannel.read(buffer)== -1){
                break;
            }
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
        is.close();
        os.close();
    }
}
