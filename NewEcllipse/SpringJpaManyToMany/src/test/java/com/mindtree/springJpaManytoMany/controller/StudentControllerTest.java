
package com.mindtree.springJpaManytoMany.controller;

import static org.junit.Assert.*;

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

import com.mindtree.springJpaManytoMany.springJpaManytoMany;
import com.mindtree.springJpaManytoMany.dto.StudentDto;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = springJpaManytoMany.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetStudentInfo() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/getstudents/physics"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\"Header\": \"StudentSubjectProject\",\"Error\": false,\"message :\": [{\"name \": \"rohith\",\"marks report \": \"90.0/100\"},{\"name \": \"sesharao\",\"marks report \": \"60.0/100\"}],\"HttpRequest \": \"ACCEPTED\"}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test public void testAddStudent() throws JSONException {
  
  StudentDto studentDto = new StudentDto(); studentDto.setName("virat");
  HttpEntity<StudentDto> entity = new HttpEntity<StudentDto>(studentDto,
  headers);
  
  ResponseEntity<String> response =
  restTemplate.exchange(createURLWithPort("/addstudent"), HttpMethod.POST,
  entity, String.class);
  
  //String expected ="{\"Header\": \"StudentSubjectProject\",\"Error\": false,\"message :\": [{\"name \": \"rohith\",\"marks report \": \"90.0/100\"},{\"name \": \"sesharao\",\"marks report \": \"60.0/100\"}],\"HttpRequest \": \"ACCEPTED\"}"
  ;
  
  String expected =
  "{\"Header\": \"StudentSubjectProject\", \"Error\": false,\"message :\": {\"name\": \"virat\"},\"HttpRequest \": \"ACCEPTED\"}"
  ;
  
  JSONAssert.assertEquals(expected, response.getBody(), false); }

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
