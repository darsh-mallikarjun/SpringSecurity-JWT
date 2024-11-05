package com.application.springsecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {
	
	
	@GetMapping("/")
	public String greet(HttpServletRequest http) {
		
		return "Welcome" + http.getSession().getId();
	}

}
