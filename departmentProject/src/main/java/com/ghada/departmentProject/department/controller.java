package com.ghada.departmentProject.department;

import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Ems/Department")
public class controller {


    @Autowired
    Repository repo;
    private final service serv;

    public controller(service serv) {
        this.serv = serv;
    }

    @PostMapping("/createDepartment")
    public ResponseEntity<String> createDepartment(@RequestBody department department)
    {
        String Response=serv.createDepartment(department);
        return new  ResponseEntity<>(Response, HttpStatus.OK);
    }
    @PostMapping("updateDepartment/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Integer id,@RequestBody department dep)
    {
        String Response=serv.EditDepartment(id,dep);
        return new  ResponseEntity<>(Response, HttpStatus.OK);
    }
    @DeleteMapping("/DeleteDepartmentById/{id}")
    public ResponseEntity<String> DeleteDepartment(@PathVariable Integer id)
    {
        String Response=serv.DeleteDepartment(id);
        return new  ResponseEntity<>(Response, HttpStatus.OK);
    }

    @GetMapping("/GetDepartmentById/{id}")
    public ResponseEntity<Optional<department>> GetDepartmentById(@PathVariable Integer id)
    {
        Optional<department> Response=serv.GetDepartmentById(id);
        return new  ResponseEntity<>(Response, HttpStatus.OK);
    }
    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<department>> getAll()
    {
        List<department> deps=repo.findAll();
        return new  ResponseEntity<>(deps, HttpStatus.OK);
    }

}
