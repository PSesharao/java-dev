package com.cms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.model.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, String> {

	Library findByLusername(String lusername);
}
