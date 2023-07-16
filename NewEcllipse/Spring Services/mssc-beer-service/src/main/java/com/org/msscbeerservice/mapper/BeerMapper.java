package com.org.msscbeerservice.mapper;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import com.org.msscbeerservice.domain.Beer;
import com.org.msscbeerservice.entity.BeerDto;

@Mapper(uses = { DateMapper.class })
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
	BeerDto beerToBeerDto(Beer beer);

	Beer beerDtoToBeer(BeerDto beerDto);

	BeerDto beerToBeerDtoWithInventory(Beer beer);
}
