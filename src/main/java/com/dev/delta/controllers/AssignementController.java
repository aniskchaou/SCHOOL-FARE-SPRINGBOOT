package com.dev.delta.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.delta.entities.Assignement;
import com.dev.delta.services.AssignementService;


@Controller
public class AssignementController {
	/**
	 * assignementService
	 */
	@Autowired
	private AssignementService assignementService;

	/**
	 * getassignements
	 * @param model
	 * @return
	 */
	@GetMapping("/assignements")
	public String getassignements(Model model) {
		List<Assignement> countrries = assignementService.getAssignements();
		model.addAttribute("assignements", countrries);
		return "assignement/index";
	}

	@GetMapping("/addassignement")
	public String addAssignement(Model model) {
		return "assignement/add";
	}

	/**
	 * addAssignement
	 * @param assignement
	 * @param model
	 * @return
	 */
	@PostMapping("/addassignement")
	public String addAssignement(Assignement assignement, Model model) {
		assignementService.save(assignement);
		return "redirect:/assignements";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/assignement/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Assignement assignement = assignementService.findById(id).get();
		model.addAttribute("assignements", assignement);

		return "assignement/edit";
	}

	/**
	 * updateAssignement
	 * @param id
	 * @param assignement
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateassignement/{id}")
	public String updateAssignement(@PathVariable("id") long id, @Validated Assignement assignement, 
			BindingResult result,
			Model model) {

		assignementService.save(assignement);
		return "redirect:/assignements";
	}

	/**
	 * deleteAssignement
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteassignement/{id}")
	@Transactional
	public String deleteAssignement(@PathVariable("id") Long id) {
		assignementService.delete(id);
		return "redirect:/assignements";
	}


}
