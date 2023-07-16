package com.mindtree.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.mindtree.entity.Car;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.mindtree.entity" })
public class BeanFactExampleApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BeanFactExampleApplication.class, args);
		Car car = context.getBean(Car.class);
		car.show();
		car.play();
	}
}
