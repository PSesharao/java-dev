package com.mindtree.shopping.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.shopping.ShoppingApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetCustomerInfo() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("getCustomerInfo/9491957471"),
				HttpMethod.GET, entity, String.class);
        
		
		String ex = "{\r\n"
				+ "    \"Header\": \"ShoppingCartProject\",\r\n"
				+ "    \"Error\": false,\r\n"
				+ "    \"message \": [\r\n"
				+ "        {\r\n"
				+ "            \"totalOrderCost\": 0\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"HttpRequest \": \"ACCEPTED\"\r\n"
				+ "}";
		
		JSONAssert.assertEquals(ex, response.getBody(), false);
	}
	
	@Test
	public void testResourceNotFoundError() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("getCustomerInfo/949195747"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\r\n"
				+ "    \"Header\": \"ShoppingCartProject\",\r\n"
				+ "    \"Error\": true,\r\n"
				+ "    \"message :\": \"No customer found with phone number 949195747\",\r\n"
				+ "    \"HttpRequest \": \"BAD_REQUEST\"\r\n"
				+ "}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}


}
