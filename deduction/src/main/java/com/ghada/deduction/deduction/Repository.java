package com.ghada.deduction.deduction;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<deduction,Integer> {
}
