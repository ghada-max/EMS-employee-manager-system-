package com.ghada.attendanceproject.attendance;

import com.ghada.attendanceproject.attendance.CompanyHours.CompanyHour;
import com.ghada.attendanceproject.attendance.communication.attendanceClient;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.auth.AuthStateCacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
public class service {
    @Autowired
    repository repo;
    @Autowired
    attendanceClient attendanceclient;

    public final CompanyHour companyhours;

    public service(CompanyHour companyhours) {
        this.companyhours = companyhours;
    }

    public String createAttendance(attendance attd) {
        LocalDate today = LocalDate.now(); // Remove fractional seconds
        attd.setDate(today);
        attd.setClockInTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        attd.setClockOutTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        repo.save(attd);
        return "attendance created successfully";
    }

    public String updateClockOut(Integer employeeid) {
        LocalDate today = LocalDate.now(); // Remove fractional seconds

       // repo.findByDate(today).orElseThrow(()->new EntityNotFoundException("no attendances created yet today"));
        repo.findByEmployeeidAndDate(employeeid,today).map( foundedAttendance ->{
            foundedAttendance.setClockOutTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));//automatically
            foundedAttendance.setMarkedAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));//automatically
            foundedAttendance.setMarkedBy("admin");//automatically
            Integer presenceHours = (int) Duration.between(foundedAttendance.getClockInTime(), foundedAttendance.getClockOutTime()).toHours();
            Integer AbsenceHours=companyhours.workHour-presenceHours;
            attendanceclient.updateEmployeeAbsentHours(employeeid,AbsenceHours);

            System.out.println(AbsenceHours);
            return repo.save(foundedAttendance);
        }).orElseThrow(()->  new EntityNotFoundException("Attendance with employeeId "+ employeeid + " not found"));
      return "attendance outClock update successfully";
    }
}
