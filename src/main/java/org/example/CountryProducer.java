package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class CountryProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryProducer.class);
    private RabbitTemplate rabbitTemplate;

    public CountryProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String queue, Country country) {
        this.rabbitTemplate.convertAndSend(queue, country);
        LOGGER.info("Producer Message Sent");
    }
}
