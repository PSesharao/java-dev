package com.mindtree.challenge.service;

import com.mindtree.challenge.entity.Laptop;

public interface LaptopService {
	public Laptop createLaptop(Laptop laptop);
	
	public Laptop updateLaptop(long serno , String bname);
}
