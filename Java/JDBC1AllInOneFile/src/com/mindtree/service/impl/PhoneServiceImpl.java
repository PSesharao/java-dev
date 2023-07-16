package com.mindtree.service.impl;

import java.util.List;

import com.mindtree.dao.PhoneDao;
import com.mindtree.dao.impl.PhoneDaoImpl;
import com.mindtree.entity.Phone;
import com.mindtree.exception.daoexception.PhoneDaoException;
import com.mindtree.exception.serviceexception.PhoneServiceException;
import com.mindtree.service.PhoneService;

public class PhoneServiceImpl implements PhoneService {
	private static PhoneDao phoneDao = new PhoneDaoImpl();

	@Override
	public boolean insertPhoneToDB(Phone phone) throws PhoneServiceException {
		try {
			return phoneDao.insertPhoneToDB(phone);
		} catch (PhoneDaoException e) {
			
			throw new PhoneServiceException("Something is wrong in DB ",e);
		}
	}

	@Override
	public List<Phone> getAllPhonesFromDB() throws PhoneServiceException {
		try {
			return phoneDao.getAllPhonesFromDB();
		} catch (PhoneDaoException e) {
			throw new PhoneServiceException("Something is wrong in DB ",e);
		}
	}
}
