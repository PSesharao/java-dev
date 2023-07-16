package com.mindtree.passenger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.passenger.converter.PassengerConverter;
import com.mindtree.passenger.dto.PassengerDto;
import com.mindtree.passenger.entity.Passenger;
import com.mindtree.passenger.entity.Train;
import com.mindtree.passenger.repository.PassengerRepository;
import com.mindtree.passenger.repository.TrainRepository;
import com.mindtree.passenger.service.PassengerService;
@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private PassengerConverter passengerConverter;
	@Autowired
	private TrainRepository trainRepository;

	@Override
	public Passenger registerPassenger(PassengerDto passengerDto) {
		Train train = trainRepository.findById(passengerDto.getTrainId()).get();
		Passenger passenger = passengerConverter.dtoToEntity(passengerDto);
		train.getPassengerList().add(passenger);
		passenger.setTrain(train);
		return passengerRepository.save(passenger);
	}

}
