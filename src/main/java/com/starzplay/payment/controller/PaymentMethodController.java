
package com.starzplay.payment.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.starzplay.payment.dto.PaymentDto;
import com.starzplay.payment.service.PaymentMethodService;


@RestController
@RequestMapping("api/v1.0/configuration/")
@Validated
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping("payment-methods")
    public ResponseEntity<?> savePaymentMethods(@Valid @RequestBody PaymentDto paymentDto) {
        return new ResponseEntity<>(paymentMethodService.savePaymentMethods(paymentDto), HttpStatus.CREATED);
    }

    @GetMapping("payment-methods")
    public ResponseEntity<?> getPaymentMethods() {
        return new ResponseEntity<>(paymentMethodService.getPaymentMethods(), HttpStatus.OK);
    }

    @GetMapping(value = "payment-methods", params = "name")
    public ResponseEntity<PaymentDto> filterByName(String name) {
        return new ResponseEntity<>(paymentMethodService.filterByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "payment-methods", params = "id")
    public ResponseEntity<?> filterById(long id) {
        return new ResponseEntity<>(paymentMethodService.filterByPaymentPlanId(id), HttpStatus.OK);
    }

    @PutMapping(value = "payment-methods", params = "payment-methods")
    public ResponseEntity<?> updatePaymentMethods(@RequestParam(name = "payment-methods") long id, @Valid @RequestBody PaymentDto paymentDto) {
        return new ResponseEntity<>(paymentMethodService.updatePaymentPlan(id, paymentDto), HttpStatus.OK);
    }

}
