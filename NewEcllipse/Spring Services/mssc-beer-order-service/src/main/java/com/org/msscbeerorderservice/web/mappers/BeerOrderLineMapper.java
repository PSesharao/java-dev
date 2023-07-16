package com.org.msscbeerorderservice.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import com.org.msscbeerorderservice.domain.BeerOrderLine;
import com.org.msscbeerorderservice.web.model.BeerOrderLineDto;


@Mapper(uses = {DateMapper.class })
@DecoratedWith(BeerOrderLineMapperDecorator.class)
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
