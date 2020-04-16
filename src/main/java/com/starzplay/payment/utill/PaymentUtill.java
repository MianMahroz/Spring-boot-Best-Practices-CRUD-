
package com.starzplay.payment.utill;


import org.modelmapper.ModelMapper;
import com.starzplay.payment.dto.PaymentMethodDto;
import com.starzplay.payment.model.PaymentMethod;


public class PaymentUtill {

    private static ModelMapper mapper;

    public static ModelMapper getMapper() {
        if (mapper == null)
            return new ModelMapper();
        return mapper;
    }

    public static PaymentMethod customPaymentMapperDtoToPojo(PaymentMethodDto methodDto) {
        PaymentMethod paymentMethod = getMapper().map(methodDto, PaymentMethod.class);
        if (null != paymentMethod.getPaymentPlans()) {
            paymentMethod.getPaymentPlans().stream().forEach(plan -> {
                plan.setPaymentMethod(paymentMethod);
            });
        }
        return paymentMethod;
    }

    public static PaymentMethod customPaymentMapper(PaymentMethod paymentMethod, PaymentMethodDto methodDto) {
        methodDto.setId(paymentMethod.getId());
        return customPaymentMapperDtoToPojo(methodDto);
    }
}
