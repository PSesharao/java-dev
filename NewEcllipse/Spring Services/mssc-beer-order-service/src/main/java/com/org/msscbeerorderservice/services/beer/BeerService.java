package com.org.msscbeerorderservice.services.beer;

import java.util.Optional;
import java.util.UUID;

import com.org.msscbeerorderservice.web.model.BeerDto;

public interface BeerService {
	Optional<BeerDto> getBeerById(UUID uuid);

	Optional<BeerDto> getBeerByUpc(String upc);
}
