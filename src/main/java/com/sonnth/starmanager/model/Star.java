package com.sonnth.starmanager.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "stars")
@Component
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;
    private String galaxyName;
    @Min(0)
    private double luminosity;
    @Min(0)
    private double distance;

    public Star() {
    }

    public Star(String name, String type, String galaxyName, double luminosity, double distance) {
        this.name = name;
        this.type = type;
        this.galaxyName = galaxyName;
        this.luminosity = luminosity;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGalaxyName() {
        return galaxyName;
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
