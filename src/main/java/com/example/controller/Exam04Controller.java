package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.Exam04Form;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	@ModelAttribute
	public Exam04Form setUpForm() {
		return new Exam04Form();
	}

	@RequestMapping("")
	public String index() {
		return "exam04";
	}

	@RequestMapping("/result")
	public String result(Exam04Form form, Model model) {
		User user = new User();
		user.setName(form.getName());
		user.setAge(form.getIntAge());
		user.setComment(form.getComment());
		model.addAttribute("user", user);
		return "exam04-result";

	}
}
