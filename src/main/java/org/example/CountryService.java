package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    public Country addCountry(String name, String capitalName, int population) {
        return countryRepository.save(new Country(name, capitalName, population));
    }

}
