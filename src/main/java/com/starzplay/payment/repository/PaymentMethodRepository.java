
package com.starzplay.payment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.starzplay.payment.model.PaymentMethod;


@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    public PaymentMethod findByname(String name);


}
