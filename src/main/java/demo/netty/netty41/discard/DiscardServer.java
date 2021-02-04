package demo.netty.netty41.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author imnot
 */
public class DiscardServer {

    public static void main(String[] args) {

    }

    public static void discardServer(){
        // boss group，接收进来的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // work group，用来处理已经被接收的连接
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();
        server.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel){
                        socketChannel.pipeline().addLast(new DiscardServerHandler());
                    }
                })
                .option(ChannelOption.SO_BACKLOG,128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
    }

    static class DiscardServerHandler extends ChannelInboundHandlerAdapter{

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg){
            System.out.println("channelRead method,message:"+msg);
            // 丢弃消息
            ((ByteBuf) msg).release();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
            System.out.println("exceptionCaught method");
            cause.printStackTrace();
            // 出现异常关闭连接
            ctx.close();
        }
    }

}
