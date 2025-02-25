package com.ghada.departmentProject.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class service {
    @Autowired
    Repository repo;
    public String createDepartment(department dep) {
        department depart=department.builder()
                .name(dep.getName())
                .category(dep.getCategory())
                .salary(dep.getCategory().getSalary())
                .build();
        repo.save(depart);
        return "department created successfully";
    }
    public String EditDepartment(Integer id,department department) {
        repo.findById(id).map(
                (foundedDepartment->{
                    foundedDepartment.setName(department.getName());
                    foundedDepartment.setCategory(department.getCategory());
                    return repo.save(foundedDepartment);
                })
        ).orElse(null);
        return "department updated successfully";
    }
    public String DeleteDepartment(Integer id) {
        repo.deleteById(id);
        return "department deleted successfully";
    }

    public Optional<department> GetDepartmentById(Integer id) {
       return  repo.findById(id);
    }
}
