package com.kiramiki.calendar;
//万年历
public class Perpetual {

    private String nowadays;

    private int week = 5;

    private int is_perpetual;

    public String getNowadays() {
        return nowadays;
    }

    public void setNowadays(String nowadays) {
        this.nowadays = nowadays;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getIs_perpetual() {
        return is_perpetual;
    }

    public void setIs_perpetual(int is_perpetual) {
        this.is_perpetual = is_perpetual;
    }
}
