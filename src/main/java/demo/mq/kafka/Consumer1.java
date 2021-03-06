package demo.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author imnot
 */
public class Consumer1 {
    public static void main(String[] args) {
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.59.130:9092");
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG, "duanjt_test");

        try (KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(p)) {
			// 订阅消息
			kafkaConsumer.subscribe(Collections.singletonList(Producer1.topic));

			while (true) {
			    @SuppressWarnings("deprecation")
				ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
			    for (ConsumerRecord<String, String> record : records) {
			        System.out.println(String.format("topic:%s,offset:%d,消息:%s",
			                record.topic(), record.offset(), record.value()));
			    }
			}
		}
    }
}
