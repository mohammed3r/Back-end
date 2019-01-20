package com.alrabiah.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "RATING")
public class RatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rateid;
    @ManyToOne
    private TicketsEntity ticket;
    @Min(1)
    @Max(10)
    private int rate;
    private String ratepros;
    private String ratecons;


    public long getRateid() {
        return rateid;
    }

    public void setRateid(long rateid) {
        this.rateid = rateid;
    }

    public TicketsEntity getTicket() {
        return ticket;
    }

    public void setTicket(TicketsEntity ticket) {
        this.ticket = ticket;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getRatepros() {
        return ratepros;
    }

    public void setRatepros(String ratepros) {
        this.ratepros = ratepros;
    }

    public String getRatecons() {
        return ratecons;
    }

    public void setRatecons(String ratecons) {
        this.ratecons = ratecons;
    }
}