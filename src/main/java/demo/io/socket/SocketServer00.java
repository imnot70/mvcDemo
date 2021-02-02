package demo.io.socket;

import demo.constants.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author zhangpeng
 * @description
 * @date 2021-01-31 下午4:09
 **/
public class SocketServer00 {

    public static void main(String[] args) throws IOException {
        test01();
    }

    public static void test01() throws IOException {
        ServerSocket serverSocket = new ServerSocket(Constants.SOCKET_PORT);

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = inputStream.read(buffer);
        System.out.println(new String(buffer,0,len, StandardCharsets.UTF_8));

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("response message".getBytes());
        outputStream.flush();

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();

    }
}
