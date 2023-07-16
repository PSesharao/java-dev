package com.mindtree.passenger.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.passenger.dto.TrainDto;
import com.mindtree.passenger.entity.Train;


@Component
public class TrainConverter {
	public TrainDto entityToDto(Train train) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(train, TrainDto.class);
	}

	public Train dtoToEntity(TrainDto trainDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(trainDto, Train.class);

	}
}
