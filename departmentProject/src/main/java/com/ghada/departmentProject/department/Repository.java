package com.ghada.departmentProject.department;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<department,Integer> {
}
