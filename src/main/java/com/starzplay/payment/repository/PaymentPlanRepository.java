
package com.starzplay.payment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.starzplay.payment.model.PaymentPlan;


@Repository
public interface PaymentPlanRepository extends JpaRepository<PaymentPlan, Long> {

    @Query(value = "Select * from payment_plan where id=:id", nativeQuery = true)
    public PaymentPlan filterByPaymentPlanId(long id);
}
