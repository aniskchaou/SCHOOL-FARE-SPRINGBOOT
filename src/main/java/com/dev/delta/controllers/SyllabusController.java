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

import com.dev.delta.entities.Syllabus;
import com.dev.delta.services.SyllabusService;

@Controller
public class SyllabusController {
	/**
	 * syllabusService
	 */
	@Autowired
	private SyllabusService syllabusService;

	/**
	 * getsyllabus
	 * @param model
	 * @return
	 */
	@GetMapping("/syllabus")
	public String getsyllabus(Model model) {
		List<Syllabus> countrries = syllabusService.getSyllabuss();
		model.addAttribute("syllabus", countrries);
		return "syllabus/index";
	}

	@GetMapping("/addsyllabus")
	public String addAssignement(Model model) {
		return "syllabus/add";
	}

	/**
	 * addSyllabus
	 * @param syllabus
	 * @param model
	 * @return
	 */
	@PostMapping("/addsyllabus")
	public String addSyllabus(Syllabus syllabus, Model model) {
		syllabusService.save(syllabus);
		return "redirect:/syllabus";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/syllabus/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Syllabus syllabus = syllabusService.findById(id).get();
		model.addAttribute("media", syllabus);

		return "syllabus/edit";
	}

	/**
	 * updateSyllabus
	 * @param id
	 * @param syllabus
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatesyllabus/{id}")
	public String updateSyllabus(@PathVariable("id") long id, @Validated Syllabus syllabus, 
			BindingResult result,
			Model model) {

		syllabusService.save(syllabus);
		return "redirect:/syllabus";
	}

	/**
	 * deleteSyllabus
	 * @param id
	 * @return
	 */
	@GetMapping("/deletesyllabus/{id}")
	@Transactional
	public String deleteSyllabus(@PathVariable("id") Long id) {
		syllabusService.delete(id);
		return "redirect:/syllabus";
	}


}
