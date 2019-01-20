package com.alrabiah.dto;

import javax.validation.constraints.Size;

public class RatingDTO {
    @Size(min = 1 ,max = 10 ,message = "please rate 1-10")
    private int rate;
    private String ratepros;
    private String ratecons;

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
