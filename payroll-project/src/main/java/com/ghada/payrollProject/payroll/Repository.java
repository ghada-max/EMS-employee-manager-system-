package com.ghada.payrollProject.payroll;

import com.ghada.payrollProject.payroll.Payroll;
import com.ghada.payrollProject.payroll.enums.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Payroll,Integer> {
    Optional<Payroll> findByEmployeeid(Integer employeeid);
    List<Payroll> findByPaymenttype(String paymentType);
}
