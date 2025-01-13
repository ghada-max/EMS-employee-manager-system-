package com.ghada.Employeeproject.employee;
import com.ghada.Employeeproject.employee.employee;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service {
    @Autowired
    private Repository repo;
    public String createEmployee( @Valid employee empl) {

         employee employeeToSave = new employee();
         employeeToSave.setName(empl.getName());
         employeeToSave.setCategoryid(empl.getCategoryid());
         employeeToSave.setDepartmentid(empl.getDepartmentid());
         employeeToSave.setEmail(empl.getEmail());
         employeeToSave.setContact(empl.getContact());
        employeeToSave.setLeavebalance(0);


        repo.save(employeeToSave);

     return "employee created successfully";
    }

    public String updateEmployee(Integer id, @Valid employee empl) {
       return repo.findById(id).map(foundedEmployee -> {
            foundedEmployee.setName(empl.getName());
            foundedEmployee.setContact(empl.getContact());
            foundedEmployee.setEmail(empl.getEmail());
            foundedEmployee.setCategoryid(empl.getCategoryid());
            foundedEmployee.setDepartmentid(empl.getDepartmentid());
           foundedEmployee.setLeavebalance(empl.getLeavebalance());

           repo.save(foundedEmployee);
            return "employee updated successfully";

        }).orElseThrow(()->new EntityNotFoundException("employee not found"));



    }

    public String updateEmployeeLeaveBalance(Integer id) {
        return repo.findById(id).map(foundedEmployee -> {
            foundedEmployee.setLeavebalance(foundedEmployee.getLeavebalance()+1);

            repo.save(foundedEmployee);
            return "employee Leave Balance updated successfully";

        }).orElseThrow(()->new EntityNotFoundException("employee not found"));



    }

    public String updateEmployeeDeduction(Integer id,Double leaveded) {
        return repo.findById(id).map(foundedEmployee -> {
            foundedEmployee.setLeavededuction(leaveded);

            repo.save(foundedEmployee);
            return "employee  updated successfully";

        }).orElseThrow(()->new EntityNotFoundException("employee not found"));



    }

    public List<employee> getAllEmployee() {
        return repo.findAll();
    }

    public String deleteEmployee(Integer id)  {
        String Response="";
        Optional<employee> empl= repo.findById(id);
        if(empl.isPresent()){
            repo.deleteById(id);
            Response="Employee deleted sucessufully";
        }else{
            Response="Employee Not found";

        }
        return Response;
    }

    public employee getEmployeById(Integer id) {
        return repo.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Employee not found with ID: " + id));
    }

}
