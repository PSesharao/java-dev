package com.org.msscbeerservice.service;

import java.util.UUID;

import org.springframework.data.domain.PageRequest;

import com.org.msscbeerservice.entity.BeerDto;
import com.org.msscbeerservice.entity.BeerPagedList;
import com.org.msscbeerservice.entity.BeerStyleEnum;

public interface BeerService {
	BeerDto getBeerById(UUID id, Boolean showInventoryOnHand);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeer(UUID id, BeerDto beerDto);

	void deleteBeerById(UUID id);

	BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest of, Boolean showInventoryOnHand);

	BeerDto getByUpc(String upc);
}
