package com.example.academiapw3.controller;

import com.example.academiapw3.service.FichaTreino.FichaTreinoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "fichaTreino/lista";
	}
}
