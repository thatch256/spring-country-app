package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountrySender {
    @Bean
    public CommandLineRunner sendCountry(@Value("${country.amqp.queue}") String destination, CountryProducer countryProducer) {
        return args -> {
            Country country = new Country();
            country.setName("USA");
            country.setCapitalName("Washington D.C.");
            country.setPopulation(200);
            countryProducer.send(destination, country);
        };
    }
}
