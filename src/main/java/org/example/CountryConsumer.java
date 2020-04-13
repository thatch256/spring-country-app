package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CountryConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryConsumer.class);
    private CountryRepository countryRepository;

    public CountryConsumer(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @RabbitListener(queues = "${country.amqp.queue}")
    public void processCountry(Country country) {
        LOGGER.info("Consumer: " + country);
        LOGGER.info("Country Created " + countryRepository.save(country));
    }
}
