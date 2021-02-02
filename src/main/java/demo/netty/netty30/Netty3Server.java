package demo.netty.netty30;

import demo.constants.Constants;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author imnot
 */
public class Netty3Server {

    public static void main(String[] args) {
        // 1,创建Netty的服务对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 2,创建2个线程池，其中第一个用于监听端口号，第二个用于NIO监听
        ExecutorService portPool = Executors.newCachedThreadPool();
        ExecutorService nioPool = Executors.newCachedThreadPool();
        // 3,将线程池放入工程中
        serverBootstrap.setFactory(new NioServerSocketChannelFactory(portPool, nioPool));
        // 4,设置管道工厂
        // 设置管道
        serverBootstrap.setPipelineFactory(() -> {
            ChannelPipeline pipeline = Channels.pipeline();
            // 传输数据时解码器为String类型
            pipeline.addLast("decoder", new StringDecoder());
            // 编码器为String类型
            pipeline.addLast("encoder", new StringEncoder());
            // 设置Handler
            pipeline.addLast("serverHandler", new CustomChannelHandler());
            return pipeline;
        });
        // 5,绑定端口号
        serverBootstrap.bind(new InetSocketAddress(Constants.NETTY_PORT));
        System.out.println("Server started");
    }

    static class CustomChannelHandler extends SimpleChannelHandler {
        // 处理接收到的数据
        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            System.out.println("messageReceived,content:" + e.getMessage());
            super.messageReceived(ctx, e);
        }

        // 异常处理
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
            System.out.println("exceptionCaught");
            super.exceptionCaught(ctx, e);
        }

        // 关闭通道时触发
        @Override
        public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("channelDisconnected");
            super.channelDisconnected(ctx, e);
        }
    }

}
