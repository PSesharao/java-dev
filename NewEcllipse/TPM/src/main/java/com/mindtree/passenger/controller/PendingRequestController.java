
package com.mindtree.passenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.passenger.converter.PendingRequestConverter;
import com.mindtree.passenger.dto.PassengerDto;
import com.mindtree.passenger.entity.Passenger;
import com.mindtree.passenger.entity.PendingRequest;
import com.mindtree.passenger.repository.PendingRequestRepository;
import com.mindtree.passenger.service.PassengerService;
import com.mindtree.passenger.service.PendingRequestService;

@Controller
public class PendingRequestController {
	@Autowired
	private PendingRequestConverter pendingRequestConverter;
	@Autowired
	private PendingRequestService pendingRequestService;
	@Autowired 
	private PassengerService passengerService;
	@Autowired
	private PendingRequestRepository pendingRequestRepository;
	
	@RequestMapping("/makeRequest")

	@ResponseBody
	public PendingRequest makeRequest(PassengerDto passengerDto) {

		return pendingRequestService.makeRequest(passengerDto);
	}
	
	@RequestMapping("/getPendingRequests")

	@ResponseBody
	public List<PendingRequest> getPendingRequests() {

		return pendingRequestRepository.findAll();
	}
	
	@RequestMapping("/approveRequest/{pendingId}")

	@ResponseBody
	public Passenger approveRequest( @PathVariable(value = "pendingId")  long pendingId) {
		PendingRequest pendingRequest = pendingRequestRepository.findById(pendingId).get();
		
		PassengerDto passengerDto = pendingRequestConverter.entityToDto(pendingRequest);
		System.out.println(passengerDto);
		pendingRequestRepository.deleteById(pendingId);
		return passengerService.registerPassenger(passengerDto);
	}
}
