package com.example.academiapw3.controller;

import com.example.academiapw3.service.FichaTreino.FichaTreinoService;
import com.example.academiapw3.service.FichaTreino.FichaTreinoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private FichaTreinoService service;

	@GetMapping("/")
	public String home(ModelMap modelMap) {
		modelMap.addAttribute("fichasTreino", service.buscarTodos());
		return "fichaTreino/lista";
	}
}
