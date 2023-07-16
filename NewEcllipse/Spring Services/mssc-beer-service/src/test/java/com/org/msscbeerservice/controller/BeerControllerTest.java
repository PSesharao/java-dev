package com.org.msscbeerservice.controller;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.anyBoolean;

import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.msscbeerservice.entity.BeerDto;
import com.org.msscbeerservice.entity.BeerStyleEnum;
import com.org.msscbeerservice.service.BeerService;

//@RunWith(SpringRunner.class)
//@WebMvcTest(BeerController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BeerControllerTest {

	@MockBean
	BeerService beerService;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	static BeerDto validBeer;

	@BeforeAll
	public static void setUp() {
		validBeer = BeerDto.builder().id(UUID.randomUUID()).beerName("Mango Bobs").beerStyle(BeerStyleEnum.PALE_ALE)
				.price(new BigDecimal("2334")).upc("0631234200036").build();
	}

	@Test
	public void getBeer() throws Exception {
		BeerDto validBeer1 = BeerDto.builder().id(UUID.randomUUID()).beerName("Beer1").beerStyle(BeerStyleEnum.PALE_ALE)
				.upc("0631234200036").build();
		given(beerService.getBeerById(any(UUID.class), anyBoolean())).willReturn(validBeer1);

		mockMvc.perform(get("/api/v1/beer/" + validBeer1.getId().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())

				.andExpect(jsonPath("$.id", is(validBeer1.getId().toString())))
				.andExpect(jsonPath("$.beerName", is("Beer1")));
	}

	@Test
	public void handlePost() throws Exception {
		// given
		BeerDto beerDto = validBeer;
		beerDto.setId(null);
		BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		given(beerService.saveNewBeer(any())).willReturn(savedDto);

		mockMvc.perform(post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
				.andExpect(status().isCreated());

	}

	@Test
	public void handleUpdate() throws Exception {
		// given
		BeerDto beerDto = validBeer;
		beerDto.setId(null);
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		// when
		mockMvc.perform(
				put("/api/v1/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
				.andExpect(status().isNoContent());

		then(beerService).should().updateBeer(any(), any());

	}

}