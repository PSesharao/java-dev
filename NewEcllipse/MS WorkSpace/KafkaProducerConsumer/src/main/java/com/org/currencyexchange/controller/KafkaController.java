package com.org.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.currencyexchange.service.Producer;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	@Autowired
	private Producer producer ;
	
	@PostMapping(value = "/post")
	public void sendMessage(@RequestParam("message") String message ) {
		producer.publishToTopic(message) ;
	}
}
