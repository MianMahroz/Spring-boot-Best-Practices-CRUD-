
package com.starzplay.payment.dto;


import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;


public class PaymentMethodDto {

    private long id;
    @NotEmpty(message = "name must not be empty or null")
    private String name;

    @NotEmpty(message = "displayName must not be empty or null")
    private String displayName;

    @NotEmpty(message = "paymentType must not be empty or null")
    private String paymentType;

    @Valid
    private List<PaymentPlanDto> paymentPlans;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<PaymentPlanDto> getPaymentPlans() {
        return paymentPlans;
    }

    public void setPaymentPlans(List<PaymentPlanDto> paymentPlans) {
        this.paymentPlans = paymentPlans;
    }

    public PaymentMethodDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
