package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eus.birt.dam.domain.SedesVeterinaria;
import eus.birt.dam.repository.SedesVeterinariaRepository;

@Controller
public class SedesVeterinariaController {
	

	@Autowired
   	private SedesVeterinariaRepository sedesRepository;
	
	@GetMapping("sedes/new")
	public String initCreationForm(Model model) {
		SedesVeterinaria sede = new SedesVeterinaria();
		model.addAttribute("sede", sede);
		return "sedesForm";
	}
	
	@PostMapping("sedes/new/submit")
	public String processCreationForm(@ModelAttribute SedesVeterinaria sede) {
		sedesRepository.save(sede);
		return "redirect:/sedes";
	}
	
	@GetMapping("sedes/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("sede", sedesRepository.findById(id));
		return "sedesForm";
	}
	
	@GetMapping("sedes/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		sedesRepository.deleteById(id);
	return "redirect:/sedes";
	}

}
