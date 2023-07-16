package com.org.msscbeerclient.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.net.URI;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.org.msscbeerclient.entity.BeerDto;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BreweryClientTest {
	@Autowired
	BreweryClient client;

	@Test
	void testgetBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
		log.info(dto.toString());
	}

	@Test
	void testsaveNewBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		URI uri = client.saveNewBeer(beerDto);
		assertNotNull(uri);
		log.info(uri.toString());
	}

	@Test
	void testUpdateBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		client.updateBeer(UUID.randomUUID(), beerDto);
	}

	@Test
	void testDeleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}
}
