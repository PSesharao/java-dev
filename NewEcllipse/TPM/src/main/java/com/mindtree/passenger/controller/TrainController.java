package com.mindtree.passenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.passenger.converter.TrainConverter;
import com.mindtree.passenger.dto.TrainDto;
import com.mindtree.passenger.entity.Train;
import com.mindtree.passenger.repository.TrainRepository;

@Controller
public class TrainController {
	@Autowired
	private TrainRepository trainRepository;
	@Autowired
	private TrainConverter trainConverter;
	@RequestMapping("/registerTrain")
	@ResponseBody
	public Train registerPassenger(TrainDto trainDto) {
		
		return trainRepository.save(trainConverter.dtoToEntity(trainDto));
	}
	
	@RequestMapping("/getTriansBySourceAndDestination/{source}/{destination}")
	@ResponseBody
	public List<Train> getTriansBySourceAndDestination( @PathVariable(value = "source") String source ,  @PathVariable(value = "destination") String destination)
	{
		
		return trainRepository.getTriansBySourceAndDestination(source, destination);
		
	}
}
