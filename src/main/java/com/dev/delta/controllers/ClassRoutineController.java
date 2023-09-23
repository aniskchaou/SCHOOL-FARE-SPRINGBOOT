package com.dev.delta.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.delta.entities.ClassRoutine;
import com.dev.delta.services.ClassRoutineService;

@Controller
public class ClassRoutineController {
	/**
	 * classRoutineService
	 */
	@Autowired
	private ClassRoutineService classRoutineService;

	/**
	 * getclasses
	 * @param model
	 * @return
	 */
	@GetMapping("/classroutines")
	public String getclasses(Model model) {
		List<ClassRoutine> countrries = classRoutineService.getClassRoutines();
		model.addAttribute("classroutines", countrries);
		return "classroutine/index";
	}

	/**
	 * addClassRoutine
	 * @param classRoutine
	 * @param model
	 * @return
	 */
	@PostMapping("/addclassroutine")
	public String addClassRoutine(ClassRoutine classRoutine, Model model) {
		classRoutineService.save(classRoutine);
		return "redirect:/classroutines";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/classroutine/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		ClassRoutine classRoutine = classRoutineService.findById(id).get();
		model.addAttribute("media", classRoutine);

		return "classroutine/edit";
	}

	/**
	 * updateClassRoutine
	 * @param id
	 * @param classRoutine
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateclassroutine/{id}")
	public String updateClassRoutine(@PathVariable("id") long id, @Validated ClassRoutine classRoutine, 
			BindingResult result,
			Model model) {

		classRoutineService.save(classRoutine);
		return "redirect:/classroutines";
	}

	/**
	 * deleteClassRoutine
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteclassroutine/{id}")
	@Transactional
	public String deleteClassRoutine(@PathVariable("id") Long id) {
		classRoutineService.delete(id);
		return "redirect:/classroutines";
	}

	@GetMapping("/addclassroutine")
	public String addBook(Model model) {
		return "classroutine/add";
	}
}
