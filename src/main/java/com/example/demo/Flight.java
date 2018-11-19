package com.example.demo;

import com.example.demo.security.User;

import javax.persistence.*;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String flightNumber;
    @ManyToOne
    private Airport from;
    @ManyToOne
    private Airport to;

    private String departure;
//    private Date departure;
    private String arrival;
//    private Date arrival;
    private Integer duration;
    private Double priceEconomy;
    private Double priceBusiness;
    private String aircraft;

    @ManyToOne
    private User user;

    @OneToOne
    private OptionType option1;

    public Flight() {
    }

    public Flight(String flightNumber, Airport from, Airport to, String departure, String arrival, Integer duration, Double priceEconomy, Double priceBusiness, String aircraft) {
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.arrival = arrival;
        this.duration = duration;
        this.priceEconomy = priceEconomy;
        this.priceBusiness = priceBusiness;
        this.aircraft = aircraft;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getPriceEconomy() {
        return priceEconomy;
    }

    public void setPriceEconomy(Double priceEconomy) {
        this.priceEconomy = priceEconomy;
    }

    public Double getPriceBusiness() {
        return priceBusiness;
    }

    public void setPriceBusiness(Double priceBusiness) {
        this.priceBusiness = priceBusiness;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OptionType getOption1() {
        return option1;
    }

    public void setOption1(OptionType option1) {
        this.option1 = option1;
    }
}
