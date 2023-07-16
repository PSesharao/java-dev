package com.mindtree.springapp.controller;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.springapp.converter.DoctorConverter;
import com.mindtree.springapp.dto.DoctorDto;
import com.mindtree.springapp.entity.Doctor;
import com.mindtree.springapp.entity.Hospital;
import com.mindtree.springapp.exception.DoctorException;
import com.mindtree.springapp.exception.serviceexception.HospitalServiceException;
import com.mindtree.springapp.service.impl.DoctorServiceImpl;
import com.mindtree.springapp.service.impl.HospitalServiceImpl;

@RestController
public class DoctorController {
	@Autowired
	private HospitalServiceImpl hospitalService;

	@Autowired
	private DoctorServiceImpl doctorService;

	@Autowired
	private DoctorConverter doctorConverter;

	@PostMapping("/adddoctor/{id}")
	public ResponseEntity<Map<String, Object>> addHospital(@PathVariable(value = "id") int hid,
			@RequestBody List<DoctorDto> doctordtoList) throws DoctorException {
		Hospital hospital = null;
		try {
			hospital = hospitalService.getHospitalByID(hid);
		} catch (HospitalServiceException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new DoctorException(e);
		}
		Map<String, Object> response = new LinkedHashMap<>();
		List<Doctor> docList = new ArrayList<Doctor>();
		for (DoctorDto docDto : doctordtoList) {
			Doctor doctor = doctorConverter.dtoToEntity(docDto);
			doctor.setHospital(hospital);
			doctorService.createDoctor(doctor);
			docList.add(doctor);
		}
		hospital.setDoctors(docList);

		response.put("Header", "HospitalDoctorProject");
		response.put("Error", false);
		response.put("message :", doctordtoList);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
