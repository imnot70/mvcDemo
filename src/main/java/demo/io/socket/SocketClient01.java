package demo.io.socket;

import demo.constants.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author zhangpeng
 * @description
 * @date 2021-01-31 下午3:07
 **/
public class SocketClient01 {
    public static void main(String[] args) throws IOException {
        test01();
    }

    public static void test01() throws IOException {
        // connect to server
        Socket socket = new Socket(Constants.LOCAL_ADDRESS,Constants.SOCKET_PORT);
        // get outputStream
        OutputStream outputStream = socket.getOutputStream();
        // send message
        outputStream.write("test request".getBytes(StandardCharsets.UTF_8));
        // very important,tell the server send data finished,client will receive data
        socket.shutdownOutput();

        //get inputStream
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while((len = inputStream.read(buffer)) != -1){
            sb.append(new String(buffer, 0, len, StandardCharsets.UTF_8));
            System.out.println(sb.toString());
        }

        // close resources
        outputStream.close();
        inputStream.close();
        socket.close();
    }


}
