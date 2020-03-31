package org.sid.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {

	@RequestMapping("test")
	public String test2() {
		return "Test";
	}
	
	@GetMapping("")
	public String GET() {
		return "GET";
	}
	@PostMapping("")
	public String post() {
		return "POST";
	}
	@PutMapping("")
	public String put() {
		return "PUT";
	}
	@DeleteMapping("")
	public String delete() {
		return "DELETE";
	}
	
	
}
