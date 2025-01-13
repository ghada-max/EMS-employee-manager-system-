package com.ghada.Leaveproject.leave;

import com.ghada.Leaveproject.leave.communication.leaveClient;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class service {

    @Autowired
    Repository repo;

    @Autowired
    leaveClient leaveclient;



    public String createLeave(Integer id, leave leave) {

        leave leaveToSave = new leave();
        leaveToSave.setEmloyeeid(id);
        leaveToSave.setDetails(leave.getDetails());
        leaveToSave.setEndDay(leave.getEndDay());
        leaveToSave.setStartDay(leave.getStartDay());
        leaveToSave.setLeaveType(leave.getLeaveType());
        long numberOfDays = ChronoUnit.DAYS.between(leave.getStartDay().toInstant(), leave.getEndDay().toInstant());
        leaveToSave.setNumberOfDay((int) numberOfDays);


        repo.save(leaveToSave);
        try {
            String response = leaveclient.updateEmployeeLeaveBalance(id);
            return "Leave created successfully. " + response;
        } catch (Exception e) {
            return "Leave created successfully, but failed to update leave balance: " + e.getMessage();
        }

    }

    public String updateLeave( Integer leaveid, leave leave) {

        return repo.findById(leaveid).map(updatingleave->
                {
                    updatingleave.setLeaveType(leave.getLeaveType());
                    updatingleave.setEndDay(leave.getEndDay());
                    updatingleave.setStartDay(leave.getStartDay());
                    updatingleave.setDetails(leave.getDetails());
                     repo.save(updatingleave);
                    return "leave updated succssfully";
                }
                ).orElseThrow(()-> new EntityNotFoundException("leave Not Found"));
    }

    public Optional<List<leave>> getAllLeaves(Integer emloyeeid) {
        return Optional.ofNullable(repo.findAllByEmloyeeid(emloyeeid));

    }

    public leave getLeaveById(Integer emloyeeid, Integer leaveid) {
       Optional<List<leave>> list=getAllLeaves(emloyeeid);
       return list.orElse(Collections.emptyList())
               .stream().filter(leave->leave.getId().equals(leaveid)).findFirst().orElse(null);

    }


    public List<leave> getALlLeavesEmployee(Integer id) {
        return repo.findAll();
    }
}
