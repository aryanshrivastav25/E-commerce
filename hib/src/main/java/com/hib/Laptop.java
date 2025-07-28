package com.hib;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// @Embeddable // Embeddable annotation is used to indicate that the class is an embeddable class.
// Every variable of embeddable class will become a column of an existing table where it is used.
@Entity
public class Laptop {
    @Id
    private int lid;
    private String brand;
    private String model;
    private int ram;

    @ManyToOne
    private Alien alien;

    Laptop()
    {

    }
    
    public Laptop(int lid, String brand, String model, int ram) {
        this.lid = lid;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
    }

    public int getLid() {
        return lid;
    }
    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }

    public Alien getAlien() {
        return alien;
    }
    public void setAlien(Alien alien) {
        this.alien = alien;
    }
    
    @Override
    public String toString() {
        return "Laptop [lid=" + lid + ", brand=" + brand + ", model=" + model + ", ram=" + ram + "]";
    }
}
