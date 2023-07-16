package com.mindtree.springJpaManytoMany.exception;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentSubjectHandler {
	@ExceptionHandler(Exception.class)

	public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception exception) {

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "StudentSubjectProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}


	@ExceptionHandler(StudentException.class)
	public ResponseEntity<Map<String, Object>> handleStudentExceptions(StudentException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "StudentSubjectProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@ExceptionHandler(SubjectException.class)
	public ResponseEntity<Map<String, Object>>  handleSubjectExceptions(SubjectException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "StudentSubjectProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
