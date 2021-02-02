package demo.io.netty3;

import demo.constants.Constants;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author imnot
 */
public class Netty3Client {
    public static void main(String[] args) {
        // 1,创建客户端
        ClientBootstrap client = new ClientBootstrap();
        // 2,创建线程池
        ExecutorService portPool = Executors.newCachedThreadPool();
        ExecutorService nioPool = Executors.newCachedThreadPool();
        // 3,线程池放入工程中
        client.setFactory(new NioClientSocketChannelFactory(portPool,nioPool));
        // 4,设置管道工厂
        // 设置管道
        client.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addFirst("decoder",new StringDecoder());
                pipeline.addFirst("encoder",new StringEncoder());
                pipeline.addFirst("clientHandler",new CustomChannelHandler());
                return pipeline;
            }
        });
        // 5,连接服务端
        ChannelFuture channelFuture = client.connect(new InetSocketAddress(Constants.LOCAL_ADDRESS, Constants.NETTY_PORT));
        Channel channel = channelFuture.getChannel();
        System.out.println("client start");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String message = scanner.next();
            channel.write(message);
        }
    }

    static class CustomChannelHandler extends SimpleChannelHandler{
        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            System.out.println("message:" + e.getMessage());
            super.messageReceived(ctx,e);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
            System.out.println("exceptionCaught");
            super.exceptionCaught(ctx, e);
        }

        @Override
        public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("channel closed");
            super.channelClosed(ctx,e);
        }
    }
}
