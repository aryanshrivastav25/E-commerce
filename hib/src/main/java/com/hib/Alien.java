package com.hib;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="Alien_table") // Changing the name of a table
// or @Table(name="Alien_table")
public class Alien 
{
    @Id
    private int aid;

    // @Column(name="Alien_name") // Maps the variable with the column name in table, if column not exist, create a new column in update mode of xml file
    private String aname;

    // @Transient // If we don't want to store this in database / map this column to the database
    private String atech;

    @OneToMany(mappedBy = "alien")
    private List<Laptop> laptops;

    public List<Laptop> getLaptops() {
        return laptops;
    }
    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
    public int getAid() 
    {
        return aid;
    }
    public void setAid(int aid) 
    {
        this.aid = aid;
    }

    public String getAname() 
    {
        return aname;
    }
    public void setAname(String aname) 
    {
        this.aname = aname;
    }

    public String getAtech() 
    {
        return atech;
    }
    public void setAtech(String atech) 
    {
        this.atech = atech;
    }

    @Override
    public String toString() {
        return "Alien [aid=" + aid + ", aname=" + aname + ", atech=" + atech + ", laptops=" + laptops + "]";
    }
}
