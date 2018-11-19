package com.example.demo;

import javax.persistence.*;

@Entity
public class OptionType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    private String type;

    private String tripClass;

    private int numPassenger;

    @OneToOne
    private Flight flight;

    public OptionType() {
    }

    public OptionType(String type, String tripClass, int numPassenger) {
        this.type = type;
        this.tripClass = tripClass;
        this.numPassenger = numPassenger;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTripClass() {
        return tripClass;
    }

    public void setTripClass(String tripClass) {
        this.tripClass = tripClass;
    }

    public int getNumPassenger() {
        return numPassenger;
    }

    public void setNumPassenger(int numPassenger) {
        this.numPassenger = numPassenger;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
