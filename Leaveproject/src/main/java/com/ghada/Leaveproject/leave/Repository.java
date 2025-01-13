package com.ghada.Leaveproject.leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<leave,Integer> {
    Integer findLeaveBalanceByEmloyeeid(@Param("id") Integer id);


    List<leave> findAllByEmloyeeid(@Param("emloyeeid") Integer emloyeeid);
}
