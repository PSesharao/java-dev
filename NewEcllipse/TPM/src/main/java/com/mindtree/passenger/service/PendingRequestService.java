
package com.mindtree.passenger.service;

import com.mindtree.passenger.dto.PassengerDto;
import com.mindtree.passenger.entity.PendingRequest;

public interface PendingRequestService {
	PendingRequest makeRequest(PassengerDto passengerDto);
}
