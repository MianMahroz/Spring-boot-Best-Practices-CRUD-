
package com.starzplay.payment.dto;


import java.util.List;
import javax.validation.Valid;


public class PaymentDto {

    @Valid
    private List<PaymentMethodDto> paymentMethods;

    public PaymentDto() {
    }

    public List<PaymentMethodDto> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethodDto> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

}
