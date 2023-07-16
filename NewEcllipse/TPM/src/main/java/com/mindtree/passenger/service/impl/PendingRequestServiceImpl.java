
package com.mindtree.passenger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.passenger.converter.PendingRequestConverter;
import com.mindtree.passenger.dto.PassengerDto;
import com.mindtree.passenger.entity.PendingRequest;
import com.mindtree.passenger.repository.PendingRequestRepository;
import com.mindtree.passenger.service.PendingRequestService;

@Service
public class PendingRequestServiceImpl implements PendingRequestService {

	@Autowired
	private PendingRequestRepository pendingRequestRepository;
	@Autowired
	private PendingRequestConverter pendingRequestConverter;
	@Override
	public PendingRequest makeRequest(PassengerDto passengerDto) {
		PendingRequest pendingRequest = pendingRequestConverter.dtoToEntity(passengerDto);
				
		return pendingRequestRepository.save(pendingRequest);
	}

}
