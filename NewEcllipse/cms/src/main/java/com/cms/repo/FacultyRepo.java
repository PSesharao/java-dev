package com.cms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.model.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, String> {

	Faculty findByFusername(String fusername);

}
