package com.org.msscbeerinventoryservice.web.mappers;

import org.mapstruct.Mapper;

import com.org.msscbeerinventoryservice.domain.BeerInventory;
import com.org.msscbeerinventoryservice.web.model.BeerInventoryDto;

/**
 * Created by jt on 2019-05-31.
 */
@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
