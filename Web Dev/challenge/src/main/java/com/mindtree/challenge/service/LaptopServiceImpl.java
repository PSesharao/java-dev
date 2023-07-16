package com.mindtree.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.challenge.entity.Laptop;
import com.mindtree.challenge.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService {

	@Autowired
	private LaptopRepository laptopRepository;

	@Override
	public Laptop createLaptop(Laptop laptop) {

		return laptopRepository.save(laptop);
	}

	@Override
	public Laptop updateLaptop(long sernum, String bname) {
		Laptop existing = laptopRepository.findById(sernum).orElse(null);
		if (existing != null) {
			existing.setBrand(bname);
			laptopRepository.save(existing);
			return existing;
		}
		return null;
	}

}
