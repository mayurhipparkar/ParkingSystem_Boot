package com.rt.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HomeApiController {
	
	@GetMapping("/")
	public String data() {
		return "this is json data";
		
	}
	

}
