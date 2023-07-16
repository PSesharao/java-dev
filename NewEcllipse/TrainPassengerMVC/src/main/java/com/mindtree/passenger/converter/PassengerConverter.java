
package com.mindtree.passenger.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.passenger.dto.PassengerDto;
import com.mindtree.passenger.entity.Passenger;

@Component
public class PassengerConverter {
	public PassengerDto entityToDto(Passenger brand) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(brand, PassengerDto.class);
	}

	public Passenger dtoToEntity(PassengerDto brandDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(brandDto, Passenger.class);

	}
}
