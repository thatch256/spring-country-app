package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Country {

    @Id @GeneratedValue
    private int id;

    @NotNull
    private String name, capitalName;

    @NotNull @Min(value = 0, message = "Population cannot be negative!")
    private int population;

    public Country() {
    }

    public Country(@NotNull String name, @NotNull String capitalName, @NotNull @Min(value = 0, message = "Population cannot be negative!") int population) {
        this.name = name;
        this.capitalName = capitalName;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setBothNames(String name, String capitalName) {
        this.name = name;
        this.capitalName = capitalName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capitalName='" + capitalName + '\'' +
                ", population=" + population +
                '}';
    }
}