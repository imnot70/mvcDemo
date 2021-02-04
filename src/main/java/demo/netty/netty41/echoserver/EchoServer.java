package demo.netty.netty41.echoserver;

import demo.constants.Constants;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.channels.Pipe;

/**
 * @author imnot
 */
public class EchoServer {

    public static void main(String[] args) throws Exception{
        echoServer();
    }

    public static void echoServer() throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup= new NioEventLoopGroup();
        try{
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture channelFuture = server.bind(Constants.NETTY_PORT).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    static class EchoServerHandler extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            // 输出消息，write方法可以逐字的把接收到的消息写入
            ctx.write(msg);
            // write方法不会使消息写入到通道上，而是缓冲到了内部。可以使用flush强制把缓冲区的数据输出
            ctx.flush();
            // 上面的两步还可以使用下面的方法代替
            // ctx.writeAndFlush(msg);
        }
    }
}
