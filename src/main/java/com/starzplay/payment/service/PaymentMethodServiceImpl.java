
package com.starzplay.payment.service;


import static com.starzplay.payment.utill.PaymentUtill.customPaymentMapper;
import static com.starzplay.payment.utill.PaymentUtill.customPaymentMapperDtoToPojo;
import static com.starzplay.payment.utill.PaymentUtill.getMapper;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.starzplay.payment.dto.PaymentDto;
import com.starzplay.payment.dto.PaymentMethodDto;
import com.starzplay.payment.model.PaymentMethod;
import com.starzplay.payment.model.PaymentPlan;
import com.starzplay.payment.repository.PaymentMethodRepository;
import com.starzplay.payment.repository.PaymentPlanRepository;


@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentPlanRepository paymentPlanRepository;

    @Override
    public PaymentDto savePaymentMethods(PaymentDto paymentDto) {
        paymentDto.getPaymentMethods().stream().forEach(paymentMethod -> {
            paymentMethodRepository.save(customPaymentMapperDtoToPojo(paymentMethod));
        });
        return paymentDto;
    }

    @Override
    public PaymentDto getPaymentMethods() {
        PaymentDto paymentDto = new PaymentDto();
        List<PaymentMethodDto> paymentMethodList = paymentMethodRepository.findAll().stream().map(paymentMethod -> {

            return getMapper().map(paymentMethod, PaymentMethodDto.class);
        }).collect(Collectors.toList());
        paymentDto.setPaymentMethods(paymentMethodList);
        return paymentDto;
    }

    @Override
    public PaymentDto filterByName(String name) {
        PaymentDto dto = new PaymentDto();
        PaymentMethodDto method = getMapper().map(paymentMethodRepository.findByname(name), PaymentMethodDto.class);
        dto.setPaymentMethods(Arrays.asList(method));
        return dto;

    }

    @Override
    public PaymentDto filterByPaymentPlanId(long id) {
        PaymentDto paymentDto = new PaymentDto();
        PaymentPlan p = paymentPlanRepository.filterByPaymentPlanId(id);
        paymentDto
                .setPaymentMethods(Arrays
                        .asList(getMapper()
                                .map(paymentMethodRepository
                                        .getOne(p.getPaymentPlanId()), PaymentMethodDto.class)));
        return paymentDto;
    }

    @Override
    public PaymentDto updatePaymentPlan(long id, PaymentDto paymentDto) {
        Optional<PaymentMethod> method = paymentMethodRepository.findById(id);
        if (method.isPresent()) {
            paymentDto.setPaymentMethods(Arrays.asList(getMapper()
                    .map(paymentMethodRepository
                            .save(customPaymentMapper(method.get(), paymentDto.getPaymentMethods().get(0))),
                            PaymentMethodDto.class)));
            return paymentDto;
        }
        return null;
    }

}
