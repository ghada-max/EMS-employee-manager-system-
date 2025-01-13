package com.ghada.Leaveproject.leave;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Ems/leaves")
public class controller {

    private final service serv;

    public controller(service serv) {
        this.serv = serv;
    }

    @PostMapping("/createLeave")
    public ResponseEntity<String> createEmployee(@RequestParam Integer id,@Valid @RequestBody leave leave) {

        String Response=serv.createLeave(id,leave);
        return new ResponseEntity<>(Response, HttpStatus.OK);

    }

    @PostMapping("/updateLeave/{leaveid}")
    public ResponseEntity<String> updateLeave(@PathVariable Integer leaveid, @Valid @RequestBody leave leave) {

        String Response=serv.updateLeave(leaveid,leave);
        return new ResponseEntity<>(Response,HttpStatus.OK);

    }




    @GetMapping("/getALlLeaves")
    public ResponseEntity<Optional<List<leave>>> getALlLeaves(@RequestParam Integer id) {
        Optional<List<leave>> Response=serv.getAllLeaves(id);
        return new  ResponseEntity<>(Response,HttpStatus.OK);

    }

    @GetMapping("/getALlLeavesEmployee")
    public ResponseEntity<List<leave>> getALlLeavesEmployee(@RequestParam Integer id) {
        List<leave> Response=serv.getALlLeavesEmployee(id);
        return new  ResponseEntity<>(Response,HttpStatus.OK);

    }
    @GetMapping("/getLeaveById/{id}")
    public ResponseEntity<Optional<leave>> getLeaveById(@RequestParam Integer emloyeeid,@PathVariable Integer id) {
        Optional<leave> Response= Optional.ofNullable(serv.getLeaveById(emloyeeid, id));
        return new  ResponseEntity<>(Response,HttpStatus.OK);

    }




}
