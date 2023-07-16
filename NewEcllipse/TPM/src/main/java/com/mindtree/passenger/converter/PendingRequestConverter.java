package com.mindtree.passenger.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.passenger.dto.PassengerDto;
import com.mindtree.passenger.entity.PendingRequest;

@Component
public class PendingRequestConverter {
	public PassengerDto entityToDto(PendingRequest brand) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(brand, PassengerDto.class);
	}

	public PendingRequest dtoToEntity(PassengerDto brandDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(brandDto, PendingRequest.class);

	}
}
