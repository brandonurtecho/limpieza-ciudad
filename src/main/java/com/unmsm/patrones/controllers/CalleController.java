package com.unmsm.patrones.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unmsm.patrones.models.entity.Calle;
import com.unmsm.patrones.models.entity.Distrito;
import com.unmsm.patrones.models.service.IDistritoService;

@Controller
@RequestMapping("/calle")
@SessionAttributes("calle")
public class CalleController {

	@Autowired
	private IDistritoService distritoService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
			RedirectAttributes flash) {

		Distrito distrito = distritoService.findOne(clienteId);

		if (distrito == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		Calle calle = new Calle();
		calle.setDistrito(distrito);

		model.put("calle", calle);
		model.put("titulo", "Crear Factura");

		return "calle/form";
	}
		
	@PostMapping("/form")
	public String guardar(@Valid Calle calle, 
			BindingResult result, Model model,
			//@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			//@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, 
			RedirectAttributes flash,
			SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear Factura");
			return "calle/form";
		}
/*
		if (itemId == null || itemId.length == 0) {
			model.addAttribute("titulo", "Crear Factura");
			model.addAttribute("error", "Error: La factura NO puede no tener líneas!");
			return "factura/form";
		}
		*/
		distritoService.saveCalle(calle);
		status.setComplete();

		flash.addFlashAttribute("success", "Calle sucia agregada con exito!");

		return "redirect:/ver/" + calle.getDistrito().getId();
	} 
	

}
