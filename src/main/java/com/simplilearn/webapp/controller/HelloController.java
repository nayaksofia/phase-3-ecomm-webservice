package com.simplilearn.webapp.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	 public String helloWorld() {
		return "Hello to New Spring Boot App!!!!";	 
	 }
	
	//Example-1 > Note: In web browser write as--> http://localhost:8080/hello?name=John%20Smith
	
	@RequestMapping("/hello")
	 public String showMessage(@PathParam("name") String name) {
		return "Hello, Today is good Day!  " + name;	 
	 }
	
	
	//Example-2 > Note: In web  browser write as--> http://localhost:8080/hi/userid3434
	
	@RequestMapping("/hi/{id}")
	 public String showMessage2(@PathVariable("id") String id) {
		return "Hi, Today is good Day! " + id;	 
	 }
	
}
