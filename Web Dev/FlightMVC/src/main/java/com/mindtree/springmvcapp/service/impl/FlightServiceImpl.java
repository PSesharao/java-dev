package com.mindtree.springmvcapp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springmvcapp.converter.FlightConverter;
import com.mindtree.springmvcapp.dto.FlightDto;
import com.mindtree.springmvcapp.entity.Customer;
import com.mindtree.springmvcapp.entity.Flight;
import com.mindtree.springmvcapp.repository.CustomerRepository;
import com.mindtree.springmvcapp.repository.FlightRepository;
import com.mindtree.springmvcapp.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
	private FlightRepository flightRepository;
	
    
	//private FlightConverter flightConverter;
	//@Autowired*/
    
    
    @Autowired
	private CustomerRepository customerRepository;

	/*FlightServiceImpl(FlightRepository flightRepository, FlightConverter flightConverter,
			CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
		this.flightConverter = flightConverter;
		this.flightRepository = flightRepository;
	}
*/
    
    
	@Override
	public Flight createFlight(FlightDto flightDto) {
		ModelMapper mapper = new ModelMapper();
		return flightRepository.save( mapper.map(flightDto , Flight.class));
	}

	@Override
	public Flight getDeptById(long flightId) {
		return null;
	}

	@Override
	public void bookFlight(String flightname, long customerId) {

		Flight flight = flightRepository.findByName(flightname);
		Customer customer = customerRepository.findById(customerId).orElse(null);
		customer.setFlight(flight);
		flight.getCustomerList().add(customer);
		flightRepository.save(flight);
		customerRepository.save(customer);
	}
	

}
