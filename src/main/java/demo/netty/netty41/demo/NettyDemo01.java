package demo.netty.netty41.demo;

import demo.constants.Constants;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * @author zhangpeng
 * @description
 * @date 2021-02-09 1:37 下午
 **/
public class NettyDemo01 {
    public static void main(String[] args) {

    }

    public static void test01() throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap server = new ServerBootstrap();
        server.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new CustomHandler());
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);

        ChannelFuture future = server.bind(Constants.NETTY_PORT).sync();
        future.channel().closeFuture().sync();
    }

    static class CustomHandler extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("channelRead");
            ChannelFuture future = ctx.newSucceededFuture();
//            future.addListener(new CustomListener());

//            future.awaitUninterruptibly();
            //            super.channelRead(ctx, msg);
        }
    }

    static class CustomListener implements GenericFutureListener<Future<Void>> {

//        @Override
//        public void operationComplete(Future<String> future) throws Exception {
//            String result = future.get();
//            System.out.println(result);
//        }

        @Override
        public void operationComplete(Future<Void> future) throws Exception {
            Void result = future.get();
            System.out.println(result);
        }
    }
}
