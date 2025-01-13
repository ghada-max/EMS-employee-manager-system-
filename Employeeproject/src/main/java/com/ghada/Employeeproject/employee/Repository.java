package com.ghada.Employeeproject.employee;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<employee,Integer> {
}
