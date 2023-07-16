package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Phone;
import com.mindtree.exception.daoexception.PhoneDaoException;

public interface PhoneDao {
	boolean insertPhoneToDB(Phone phone) throws PhoneDaoException ;

	List<Phone> getAllPhonesFromDB() throws PhoneDaoException ;
}
