package demo.mq.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author imnot
 */
public class ProducerDemo {

	private static final String QUEUE_NAME = "queue01";
	private static final String HOST = "123.57.251.225";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setPort(15672);
		factory.setUsername("admin");
		factory.setPassword("admin");
		
		Connection conn = factory.newConnection();
		Channel channel =conn.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		String msg = "Hello World!";  
		
		channel.basicPublish("", QUEUE_NAME , null , msg.getBytes());
		System.out.println("发送  message[" + msg + "] to "+ QUEUE_NAME +" success!");  

	    channel.close();  
	    conn.close();
	}
}
