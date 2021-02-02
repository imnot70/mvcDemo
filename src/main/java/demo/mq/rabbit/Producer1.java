package demo.mq.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

/**
 * @author imnot
 */ // 可靠生产
// https://www.rabbitmq.com/confirms.html
public class Producer1 {

    public static void main(String[] args){
        // 1、创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2、设置连接属性
        factory.setHost("123.57.251.225");
        factory.setPort(15672);
        factory.setUsername("admin");
        factory.setPassword("admin");
//        factory.setHandshakeTimeout(Integer.MAX_VALUE);
        Connection connection = null;
        Channel channel = null;
        try {
            // 3、从连接工厂获取连接
            connection = factory.newConnection("生产者");
            // 4、从链接中创建通道
            channel = connection.createChannel();

            // 进入confirm模式， 每次发送消息，处理之后会返回一个对应的回执消息
            // 增加监听器
            final ArrayList<String> queues = new ArrayList<String>();
            channel.addConfirmListener(new ConfirmListener() {
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    // deliveryTag 同一个channel中此条消息的编号 。
                    // 业务..
                    System.out.println("受理成功 " + queues.get((int) deliveryTag) + " " + multiple);
                }

                public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                    // 失败重发
                    // queues.get((int) deliveryTag)
                    System.out.println("受理失败 " + deliveryTag);
                }
            });
            // 定义fanout类型的交换器
            channel.exchangeDeclare("ps_test", "fanout");

            for (int i = 0; i < 10; i++) {
                // 消息内容
                String message = "Hello Confirm " + i;
                queues.add(message);
                // 发送消息到ps_test交换器上
                AMQP.BasicProperties basicProperties = new AMQP.BasicProperties();
                channel.basicPublish("ps_test", "", basicProperties, message.getBytes());
                System.out.println("消息 " + message + " 已发送！");
            }

            // 等待20秒
            Thread.sleep(20 * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7、关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }

            // 8、关闭连接
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
