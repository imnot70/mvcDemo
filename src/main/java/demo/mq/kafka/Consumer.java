package demo.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author imnot
 */
public class Consumer {

	private static final String SERVER = "192.168.91.128:9092";
	private static final String TOPIC = "test_topic";
	private static final String GROUP = "group.demo";

	public static void main(String[] args) {

		Properties properties = new Properties();
		// key序列化器
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		// 值序列化器
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP);
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVER);

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
		consumer.subscribe(Collections.singletonList(TOPIC));

		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
				for (ConsumerRecord<String, String> record : records) {
					System.out.println(record.key());
					System.out.println(record.value());
					System.out.println(record.offset());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			consumer.close();
		}

	}

}
