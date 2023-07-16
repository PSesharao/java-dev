package com.mindtree.springmvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springmvcapp.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
