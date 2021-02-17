package demo.netty.netty41.discard;

import demo.constants.Constants;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * @author imnot
 */
public class DiscardServer {

    public static void main(String[] args) throws Exception {
        discardServer();
    }

    public static void discardServer() throws InterruptedException {
        // boss group，接收进来的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // work group，用来处理已经被接收的连接
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            // 启动Nio服务
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            socketChannel.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // 绑定端口
            ChannelFuture channelFuture = server.bind(Constants.NETTY_PORT).sync();
            // 等待服务器socket关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    static class DiscardEchoServerHandler extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            ByteBuf byteBuf = (ByteBuf) msg;
            System.out.println("channelRead method,msg:");
            try{
                while(byteBuf.isReadable()){
                    String result = byteBuf.toString(CharsetUtil.US_ASCII);
                    System.out.println(result);
                    ChannelFuture future = ctx.writeAndFlush(result);
                    future.addListener((ChannelFutureListener) future1 -> ctx.close());
                }
            }finally {
                // 丢弃消息
                ReferenceCountUtil.release(msg);
            }
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            System.out.println("exceptionCaught method");
            cause.printStackTrace();
            // 出现异常关闭连接
            ctx.close();
        }
    }

    static class DiscardServerHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            // 丢弃消息
            ((ByteBuf) msg).release();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            System.out.println("exceptionCaught method");
            cause.printStackTrace();
            // 出现异常关闭连接
            ctx.close();
        }
    }
}
