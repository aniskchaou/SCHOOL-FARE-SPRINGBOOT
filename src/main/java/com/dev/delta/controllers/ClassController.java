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

import com.dev.delta.entities.Class;
import com.dev.delta.services.ClassService;

@Controller
public class ClassController {
	/**
	 * classService
	 */
	@Autowired
	private ClassService classService;

	/**
	 * getclasses
	 * @param model
	 * @return
	 */
	@GetMapping("/classes")
	public String getclasses(Model model) {
		List<Class> countrries = classService.getClasss();
		model.addAttribute("classes", countrries);
		return "class/index";
	}

	@GetMapping("/addclass")
	public String addAssignement(Model model) {
		return "class/add";
	}

	/**
	 * addClass
	 * @param class
	 * @param model
	 * @return
	 */
	@PostMapping("/addclass")
	public String addClass(Class classs, Model model) {
		classService.save(classs);
		return "redirect:/classes";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/class/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Class classs = classService.findById(id).get();
		model.addAttribute("media", classs);

		return "class/edit";
	}

	/**
	 * updateClass
	 * @param id
	 * @param class
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateclass/{id}")
	public String updateClass(@PathVariable("id") long id, @Validated Class classs, 
			BindingResult result,
			Model model) {

		classService.save(classs);
		return "redirect:/classes";
	}

	/**
	 * deleteClass
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteclass/{id}")
	@Transactional
	public String deleteClass(@PathVariable("id") Long id) {
		classService.delete(id);
		return "redirect:/classes";
	}


}
