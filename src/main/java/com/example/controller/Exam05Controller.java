package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Repository.MemberRepository;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
	@Autowired
	private MemberRepository repository;

	@RequestMapping("")
	public String index() {
		return "exam05";
	}

	@RequestMapping("/result")
	public String result(String amName, Model model) {
		model.addAttribute("memberList", repository.findByAmName(amName));
		return "exam05-result";

	}

}
