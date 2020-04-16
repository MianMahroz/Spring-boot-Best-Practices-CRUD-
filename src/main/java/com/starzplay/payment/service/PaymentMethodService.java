
package com.starzplay.payment.service;


import org.springframework.stereotype.Service;
import com.starzplay.payment.dto.PaymentDto;


@Service
public interface PaymentMethodService {

    public PaymentDto savePaymentMethods(PaymentDto paymentDto);

    public PaymentDto getPaymentMethods();

    public PaymentDto filterByName(String name);

    public PaymentDto filterByPaymentPlanId(long id);
    
    public PaymentDto updatePaymentPlan(long id,PaymentDto paymentDto);

}
