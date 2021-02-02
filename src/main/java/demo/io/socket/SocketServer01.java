package demo.io.socket;

import demo.constants.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author imnot
 */
public class SocketServer01 {

    private static final String RESULT_1 = "result1";
    private static final String RESULT_2 = "result2";

    public static void main(String[] args) throws Exception {
        test02();
    }

    /***
     * @description 处理结束后server关闭，程序停止
     * @author zhangpeng
     * @date 2021/1/31 下午5:30
     */
    public static void test01() throws IOException {
        ServerSocket server = new ServerSocket(Constants.SOCKET_PORT);
        // 等待连接
        Socket socket = server.accept();
        // 获取输入流，并读取内容
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        System.out.println("ThreadId:" + Thread.currentThread().getId());
        while ((len = inputStream.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len, StandardCharsets.UTF_8));
            System.out.println(sb.toString());
        }

        // 返回内容
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("test response".getBytes(StandardCharsets.UTF_8));

        inputStream.close();
        outputStream.close();
        socket.close();
        server.close();
    }

    /**
     * 方法会一直循环
     * @throws IOException
     */
    public static void test02() throws IOException{
        ExecutorService service = Executors.newFixedThreadPool(2<<10);
        ServerSocket serverSocket = new ServerSocket(Constants.SOCKET_PORT);
        while(true){
            Socket socket = serverSocket.accept();

            Runnable runnable = () -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    int len;
                    byte[] buffer = new byte[1024];
                    while ((len = inputStream.read(buffer)) != -1) {
                        String result = new String(buffer, 0, len, StandardCharsets.UTF_8);
                        System.out.println(result);
                        outputStream.write(result.getBytes(StandardCharsets.UTF_8));
                        socket.shutdownOutput();
                    }

                    inputStream.close();
                    outputStream.close();
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            };
            service.submit(runnable);
        }
    }
}
