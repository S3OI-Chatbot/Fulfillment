package models.requests;

import com.google.gson.annotations.SerializedName;

public class Parameters {
    private String films;
    private String number;
    @SerializedName("number-integer")
    private int hoeveelheid;
    @SerializedName("films.original")
    private String filmsOriginal;
    @SerializedName("number.original")
    private String numberOriginal;
    @SerializedName("no-input")
    private double noInput;
    @SerializedName("no-match")
    private double noMatch;

    public Parameters() {
    }

    public Parameters(String films, String number, int hoeveelheid, String filmsOriginal, String numberOriginal, double noInput, double noMatch) {
        this.films = films;
        this.number = number;
        this.hoeveelheid = hoeveelheid;
        this.filmsOriginal = filmsOriginal;
        this.numberOriginal = numberOriginal;
        this.noInput = noInput;
        this.noMatch = noMatch;
    }

    public String getFilms() {
        return films;
    }

    public void setFilms(String films) {
        this.films = films;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFilmsOriginal() {
        return filmsOriginal;
    }

    public void setFilmsOriginal(String filmsOriginal) {
        this.filmsOriginal = filmsOriginal;
    }

    public String getNumberOriginal() {
        return numberOriginal;
    }

    public void setNumberOriginal(String numberOriginal) {
        this.numberOriginal = numberOriginal;
    }

    public double getNoInput() {
        return noInput;
    }

    public void setNoInput(double noInput) {
        this.noInput = noInput;
    }

    public double getNoMatch() {
        return noMatch;
    }

    public void setNoMatch(double noMatch) {
        this.noMatch = noMatch;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }
}
