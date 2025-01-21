package com.ghada.attendanceproject.attendance;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/Ems/attendance")
public class controller {
    private final service serv;

    public controller(service serv) {
        this.serv = serv;
    }

    @PostMapping("/createAttendance")
    private ResponseEntity<String> createAttendance(@RequestBody attendance attd)
    {
        String Response=serv.createAttendance(attd);
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }

    @PostMapping("/updateOutClock")
    private ResponseEntity<String> updateOutClock(@RequestParam Integer employeeid)
    {
        String Response=serv.updateClockOut(employeeid);
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }



}
