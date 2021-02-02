package demo.io.nio;

import demo.constants.Constants;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author imnot
 */
public class NioSocketClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Client start");
        // 1,创建socket通道
        SocketChannel sc = SocketChannel.open(new InetSocketAddress(Constants.LOCAL_ADDRESS, Constants.NIO_PORT));
        // 2,切换异步非阻塞
        sc.configureBlocking(false);
        // 3,指定缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(new Date().toString().getBytes(StandardCharsets.UTF_8));
        // 4,切换到读取模式
        buffer.flip();
        sc.write(buffer);
        buffer.clear();
        // 5,关闭通道
        sc.close();
    }
}
