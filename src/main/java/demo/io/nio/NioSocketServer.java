package demo.io.nio;

import demo.constants.Constants;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author imnot
 */
public class NioSocketServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Server start");
        // 1,创建服务通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 2,切换异步
        ssc.configureBlocking(false);
        // 3,绑定连接
        ssc.bind(new InetSocketAddress(Constants.NIO_PORT));
        // 4,获取选择器
        Selector selector = Selector.open();
        // 5,将通道注册到选择器中，并监听已接收到的事件
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        // 6,轮询获取已经准备就绪的事件
        while(selector.select() > 0){
            // 7,获取当前选择器已监听到的事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while(it.hasNext()){
                // 8,获取准备就绪事件
                SelectionKey sk = it.next();
                // 9,判断事件准备就绪
                if(sk.isAcceptable()){
                    // 10,若就绪，获取客户端连接
                    SocketChannel sc = ssc.accept();
                    // 11,设置为异步非阻塞
                    sc.configureBlocking(false);
                    // 12,将该通道注册到服务器上
                    sc.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    // 13,获取当前选择器就绪状态的通道
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
                    // 14,读取数据
                    int len=0;
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while((len = socketChannel.read(buffer)) > 0){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                it.remove();
            }
        }
    }
}
