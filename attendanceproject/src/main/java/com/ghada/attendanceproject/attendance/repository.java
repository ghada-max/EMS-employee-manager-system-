package com.ghada.attendanceproject.attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface repository extends JpaRepository<attendance,Integer> {
    Optional<List<attendance>> findByDate(LocalDateTime today);

    //Optional<attendance> findByEmployeeid(Integer employeeid);
    Optional<attendance> findByEmployeeidAndDate(Integer employeeid, LocalDate date);

}

