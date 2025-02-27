package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eus.birt.dam.domain.Mamiferos;
import eus.birt.dam.repository.MamiferosRepository;
import eus.birt.dam.repository.SedesVeterinariaRepository;

@Controller
public class MamiferosController {

	@Autowired
   	private MamiferosRepository mamiferosRepository;
	@Autowired
   	private SedesVeterinariaRepository sedesRepository;
	
	@GetMapping("mamiferos/delete/{id}")
	public String initDelete(@PathVariable("id") Long id) {
		mamiferosRepository.deleteById(id);
		return "redirect:/mamiferos";
	}
	
	@GetMapping("mamiferos/new")
	public String initCreationForm(Model model) {
		Mamiferos mamiferos = new Mamiferos();
		model.addAttribute("mamifero", mamiferos);
		model.addAttribute("sedes", sedesRepository.findAll());
		return "mamiferosForm";
	}
	
	@PostMapping("mamiferos/new/submit")
	public String submitCreationForm(@ModelAttribute Mamiferos mamifero) {
		mamiferosRepository.save(mamifero);
		return "redirect:/mamiferos";
	}
	
	@GetMapping("mamiferos/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("mamifero", mamiferosRepository.findById(id));
		model.addAttribute("sedes", sedesRepository.findAll());
		return "mamiferosForm";
	}
}
