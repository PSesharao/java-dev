package com.org.msscbeerorderservice.web.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.org.msscbeerorderservice.domain.BeerOrderLine;
import com.org.msscbeerorderservice.services.beer.BeerService;
import com.org.msscbeerorderservice.web.model.BeerDto;
import com.org.msscbeerorderservice.web.model.BeerOrderLineDto;

public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {

	private BeerService beerService;
	private BeerOrderLineMapper beerOrderLineMapper;

	@Autowired
	public void setBeerService(BeerService beerService) {
		this.beerService = beerService;
	}

	@Autowired
	@Qualifier("delegate")
	public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
		this.beerOrderLineMapper = beerOrderLineMapper;
	}

	@Override
	public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
		BeerOrderLineDto orderLineDto = beerOrderLineMapper.beerOrderLineToDto(line);
		Optional<BeerDto> beerDtoOptional = beerService.getBeerByUpc(line.getUpc());

		beerDtoOptional.ifPresent(beerDto -> {
			orderLineDto.setBeerName(beerDto.getBeerName());
			orderLineDto.setBeerStyle(beerDto.getBeerStyle());
			orderLineDto.setPrice(beerDto.getPrice());
			orderLineDto.setBeerId(beerDto.getId());
		});

		return orderLineDto;
	}
}
