package com.mindtree.springmvcapp.service.impl;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.springmvcapp.dto.FlightDto;
import com.mindtree.springmvcapp.entity.Flight;
import com.mindtree.springmvcapp.repository.FlightRepository;
import com.mindtree.springmvcapp.service.FlightService;

/*@RunWith(SpringRunner.class)
@WebMvcTest(value = FlightServiceImpl.class)
@WithMockUser*/


@SpringBootTest
public class FlightServiceImplTest {
	

	/*@Autowired
	private MockMvc mockMvc;*/

	//@Autowired
	
	  @MockBean
	//@Autowired
    FlightRepository flightRepository ;


	/*@Autowired 
	private FlightConverter flightConverter ;
	*/
	
	/*@Autowired 
	private CustomerRepository customerRepository;
	*/
	
	//@MockBean
	//private FlightService flightService= new FlightServiceImpl(flightRepository, flightConverter, customerRepository);
	@Autowired 
    FlightService flightService;

	@Test
	public void testcreateFlight() {
		// fail("Not yet implemented");
		FlightDto flightDto = new FlightDto();
		flightDto.setName("MockFlight");
		flightDto.setDestination("MockDest");
		flightDto.setSource("MockSource");
		
		//Flight flight = new Flight(1111, "Emirates", "Src", "Dst");
		Flight flight = new Flight();
		/*flight.setName("MockFlight");
		flight.setId(1000);
		flight.setDestination("MockDest");
		flight.setSource("MockSource");*/
				//flightConverter.dtoToEntity(flightDto);
				
		//System.out.println(flight);
		
		//System.out.println("Hello "+flightRepository.save(flight));
		//Mockito.when(flightRepository.save(any())).thenReturn(flight);
		doReturn(flight).when(flightRepository).save(any());
		
		Flight flightExpected =
				flightService.createFlight(flightDto);
		// flightRepository.save(flight);
		Assertions.assertNotNull(flightExpected, "The saved flight should not be null");
	}

}
