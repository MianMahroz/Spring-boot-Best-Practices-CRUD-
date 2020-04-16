
package com.starzplay.payment.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "payment_plan")
public class PaymentPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "currency", precision = 22)
    private String currency;

    @Column(name = "duration", precision = 22)
    private String duration;

    @Column(name = "gross_amount", precision = 22)
    private double grossAmount;

    @Column(name = "net_amount", precision = 22)
    private double netAmount;

    @Column(name = "tax_amount", precision = 22)
    private double taxAmount;

    @Column(name = "payment_plan_id", insertable = false, updatable = false)
    private long paymentPlanId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_plan_id", referencedColumnName = "id", nullable = false)
    //    @JsonManagedReference
    @JsonIgnore
    private PaymentMethod paymentMethod;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(double grossAmount) {
        this.grossAmount = grossAmount;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentPlan() {
    }

    public long getPaymentPlanId() {
        return paymentPlanId;
    }

    public void setPaymentPlanId(long paymentPlanId) {
        this.paymentPlanId = paymentPlanId;
    }

}
