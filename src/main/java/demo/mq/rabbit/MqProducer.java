package demo.mq.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author zhangpeng
 * @description
 * @date 2020-08-03 11:40 下午
 **/
public class MqProducer {

    private static final String HOST="192.168.243.130";
    private static final Integer PORT=5672;
    private static final String USER_NAME="guest";
    private static final String PASSWORD="guest";

    private RabbitTemplate template;
}
