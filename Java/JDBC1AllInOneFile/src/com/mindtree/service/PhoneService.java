package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Phone;
import com.mindtree.exception.serviceexception.PhoneServiceException;

public interface PhoneService {
	boolean insertPhoneToDB(Phone phone) throws PhoneServiceException;

	List<Phone> getAllPhonesFromDB() throws PhoneServiceException;

}
