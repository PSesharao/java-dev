package com.cms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String> {

		Admin findByAusername(String ausername);
}
