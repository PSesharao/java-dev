package com.cms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.Student;

public interface StudentRepo extends JpaRepository<Student, String> {

	Student findBySusername(String susername);
	Student deleteBySusername(String susername);
	List<Student> findAll();

}
