package com.ta.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta.Service.TestControllerImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")

public class TestController {

	String calculation;
	@Autowired TestControllerImpl obj;


	@RequestMapping(value = "testAPI", method = RequestMethod.GET)

	public ResponseEntity<?> testApi(@RequestParam String operation, @RequestParam int n1, @RequestParam int n2)
			throws Exception {
		int ans = 0;

// requestParam.put("Status", "Success");
// requestParam.put("Hello", "World");
		switch (operation) {
		case "add":
			ans = obj.add(n1, n2);
			break;
		case "sub":
			ans = obj.sub(n1, n2);
			break;
		case "multiply":
			ans = obj.multiplication(n1, n2);
			break;
		case "division":

			ans = obj.division(n1, n2);
			break;

		}

		return new ResponseEntity<>(ans, HttpStatus.OK);
	}
}
