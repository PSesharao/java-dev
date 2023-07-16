package com.mindtree.jspapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.jspapp.model.UserLog;

public interface UserLogRepository extends CrudRepository<UserLog, String> {

}
