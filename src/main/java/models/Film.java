package models;

import java.sql.Time;

public class Film {
    private int id;
    private String name;
    private int ageLimit;
    private double price;
    private boolean realistic;
    private Time duration;
    private int breaks;

    public Film() {
    }

    public Film(int id, String name, int ageLimit, double price, boolean realistic, Time duration, int breaks) {
        this.id = id;
        this.name = name;
        this.ageLimit = ageLimit;
        this.price = price;
        this.realistic = realistic;
        this.duration = duration;
        this.breaks = breaks;
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

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRealistic() {
        return realistic;
    }

    public void setRealistic(boolean realistic) {
        this.realistic = realistic;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public int getBreaks() {
        return breaks;
    }

    public void setBreaks(int breaks) {
        this.breaks = breaks;
    }
}
