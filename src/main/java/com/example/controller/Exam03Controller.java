package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	@Autowired
	private ServletContext application;

	@RequestMapping("")
	public String index() {
		return "exam03";
	}

	@RequestMapping("/result")
	public String result(int num1, int num2, int num3) {
		Integer exTax = num1 + num2 + num3;
		Integer inTax = (int) (exTax * 1.1);

		application.setAttribute("exTax", String.format("%,d", exTax));
		application.setAttribute("inTax", String.format("%,d", inTax));

		return "exam03-result";

	}
}
