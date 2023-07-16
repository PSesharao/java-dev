package com.mindtree.BikeShowRoom.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.BikeShowRoom.dto.BrandDto;
import com.mindtree.BikeShowRoom.entity.Brand;
@Component
public class BrandConverter {
	public BrandDto entityToDto(Brand brand) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(brand, BrandDto.class);
	}

	public Brand dtoToEntity(BrandDto brandDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(brandDto, Brand.class);

	}
}
