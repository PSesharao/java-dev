package id.test.springboottesting.exception;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Profile("test")
@ControllerAdvice
public class ExceptionHandling  {
	
}
