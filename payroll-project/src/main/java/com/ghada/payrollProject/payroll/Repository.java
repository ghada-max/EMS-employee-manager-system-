package com.ghada.payrollProject.payroll;

import com.ghada.payrollProject.payroll.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Payroll,Integer> {
    Optional<Payroll> findByEmployeeid(Integer employeeid);
}
