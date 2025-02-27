package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.MamiferosRepository;
import eus.birt.dam.repository.SedesVeterinariaRepository;

@Controller

public class MainController {
	

	@Autowired
   	private MamiferosRepository mamiferosRepository;
	@Autowired
   	private SedesVeterinariaRepository sedesRepository;

	@GetMapping ({"/", "", "welcome"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping ({"/mamiferos"})
	public String getAnimales(Model model) {
		model.addAttribute("mamiferos", mamiferosRepository.findAll());
		return "mamiferos";
	}
	
	@GetMapping ({"/sedes"})
	public String getSedes(Model model) {
		model.addAttribute("sedes", sedesRepository.findAll());
		return "sedesVeterinaria";
	}
	
	
}
