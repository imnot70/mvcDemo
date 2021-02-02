package demo.mq.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author imnot
 */
public class Producer {
	
	private static final String SERVER="192.168.91.128:9092";
	private static final String TOPIC="test_topic";

	public static void main(String[] args) {
		
		Properties properties = new Properties();
		// key序列化器
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		// 重试次数
		properties.put(ProducerConfig.RETRIES_CONFIG,10);
		// 值序列化器
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,SERVER);
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		ProducerRecord<String, String> record = new ProducerRecord<String,String>(TOPIC,"kafka_demo","hello");
		
		Future<RecordMetadata> result = producer.send(record);
		if(result !=null) {
			System.out.println(result);
			RecordMetadata metaData;
			try {
				metaData = result.get();
				if(metaData !=null) {
					System.out.println(metaData.topic());
					System.out.println(metaData.offset());
				}
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		producer.close();
	}
	
}
