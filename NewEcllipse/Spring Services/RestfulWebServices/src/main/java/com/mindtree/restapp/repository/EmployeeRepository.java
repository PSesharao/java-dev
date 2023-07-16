package com.mindtree.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.restapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
