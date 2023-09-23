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

import com.dev.delta.entities.Parent;
import com.dev.delta.services.ParentService;

@Controller
public class ParentController {
	/**
	 * parentService
	 */
	@Autowired
	private ParentService parentService;

	/**
	 * getparents
	 * @param model
	 * @return
	 */
	@GetMapping("/parents")
	public String getparents(Model model) {
		List<Parent> countrries = parentService.getParents();
		model.addAttribute("parents", countrries);
		return "parent/index";
	}

	@GetMapping("/addparent")
	public String addAssignement(Model model) {
		return "parent/add";
	}

	/**
	 * addParent
	 * @param parent
	 * @param model
	 * @return
	 */
	@PostMapping("/addparent")
	public String addParent(Parent parent, Model model) {
		parentService.save(parent);
		return "redirect:/parents";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/parent/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Parent parent = parentService.findById(id).get();
		model.addAttribute("media", parent);

		return "parent/edit";
	}

	/**
	 * updateParent
	 * @param id
	 * @param parent
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateparent/{id}")
	public String updateParent(@PathVariable("id") long id, @Validated Parent parent, 
			BindingResult result,
			Model model) {

		parentService.save(parent);
		return "redirect:/parents";
	}

	/**
	 * deleteParent
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteparent/{id}")
	@Transactional
	public String deleteParent(@PathVariable("id") Long id) {
		parentService.delete(id);
		return "redirect:/parents";
	}

	@GetMapping("/addparents")
	public String addBook(Model model) {
		return "parent/add";
	}
}
