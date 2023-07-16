package com.mindtree.springapp.controller;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.springapp.converter.HospitalConverter;
import com.mindtree.springapp.dto.HospitalDto;
import com.mindtree.springapp.entity.Hospital;
import com.mindtree.springapp.exception.HospitalException;
import com.mindtree.springapp.service.HospitalService;

@RestController
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private HospitalConverter hospitalConverter ;

	/*@GetMapping
	public List<Hospital> getAllHospitals() {
		return hospitalService.getAllHospitals();
	}

	@PostMapping
	public Hospital createHospital(@RequestBody Hospital hospital) {
		hospitalService.createHospital(hospital);
		for (Doctor doctor : hospital.getDoctors()) {
			doctor.setHospital(hospital);
			doctorService.createDoctor(doctor);
		}
		return hospital;
	}

	@GetMapping("/{id}")
	public Hospital getHospitalByID(@PathVariable(value = "id") String hospitalId) {
		return hospitalService.getHospitalByID(hospitalId);
	}*/
	
	@PostMapping("/addhosp")
	public ResponseEntity<Map<String, Object>> addHospital(@RequestBody HospitalDto hospitaldto) throws HospitalException{
		Hospital hospital= hospitalConverter.dtoToEntity(hospitaldto);
		hospitalService.createHospital(hospital);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "LaptopProject");
		response.put("Error", false);
		response.put("message :", hospitalConverter.entityToDto(hospital));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
