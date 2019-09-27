package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Train {
    private String from;
    private String to;
    private Date date;
    private Date departure;

    public Train() {
    }

    public Train(Train train) {
        super();
        this.from = train.getFrom();
        this.to = train.getTo();
        this.date = train.date;
        this.departure = train.departure;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Date getDate() {
        return date;
    }

    public Date getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatDeparture = new SimpleDateFormat("HH:mm");
        return "Departure: " + from +
                " -> " + to +
                ", Date: " + formatDate.format(date) +
                ", Time: " + formatDeparture.format(departure);
    }
}