
package com.starzplay.payment.dto;


import javax.validation.constraints.NotEmpty;


public class PaymentPlanDto {

    private long id;

    private double netAmount;

    private double taxAmount;

    private double grossAmount;

    @NotEmpty(message = "currency must not be empty or null")
    private String currency;

    @NotEmpty(message = "duration must not be empty or null")
    private String duration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public PaymentPlanDto() {
    }

}
