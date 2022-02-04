package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.Exam01Form;

@Controller
@RequestMapping("/exam01")
public class Exam01Controller {
	@Autowired
	public Exam01Form setUpForm() {
		return new Exam01Form();
	}

	@RequestMapping("")
	public String index() {
		return "exam01";
	}

	@RequestMapping("/result")
	public String result(Exam01Form form, Model model) {
		model.addAttribute("name", form.getName());
		return "exam01-result";
	}
}
