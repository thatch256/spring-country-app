package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CountryController {

    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> index() {
        return countryService.getCountries();
    }

    @GetMapping("/country/{name}")
    public Country show(@PathVariable String name) {
        return countryService.getCountryByName(name);
    }

    @GetMapping("/countries/{name}/population")
    public int population(@PathVariable String name) {
        return countryService.getCountryByName(name).getPopulation();
    }

    @PostMapping("/countries/{name}/country")
    ResponseEntity<?> add(@PathVariable String name, @RequestBody Country country) {
        // Country createdCountry = new Country(name, country.getCapitalName(), country.getPopulation());
        Country createdCountry = countryService.addCountry(name, country.getCapitalName(), country.getPopulation());

        if (createdCountry == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.newInstance().path("/countries").build().toUri(); // .fromCurrentRequest().path("{name}").buildAndExpand(createdCountry.getName()).toUri();
        return ResponseEntity.created(location).build();
    }
}
