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

import com.dev.delta.entities.Subject;
import com.dev.delta.services.SubjectService;

@Controller
public class SubjectController {
	/**
	 * subjectService
	 */
	@Autowired
	private SubjectService subjectService;

	/**
	 * getsubjects
	 * @param model
	 * @return
	 */
	@GetMapping("/subjectss")
	public String getsubjects(Model model) {
		List<Subject> countrries = subjectService.getSubjects();
		model.addAttribute("subjects", countrries);
		return "subject/index";
	}

	@GetMapping("/addsubject")
	public String addAssignement(Model model) {
		return "subject/add";
	}

	/**
	 * addSubject
	 * @param subject
	 * @param model
	 * @return
	 */
	@PostMapping("/addsubject")
	public String addSubject(Subject subject, Model model) {
		subjectService.save(subject);
		return "redirect:/subjectss";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/subject/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Subject subject = subjectService.findById(id).get();
		model.addAttribute("media", subject);

		return "subject/edit";
	}

	/**
	 * updateSubject
	 * @param id
	 * @param subject
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatesubject/{id}")
	public String updateSubject(@PathVariable("id") long id, @Validated Subject subject, 
			BindingResult result,
			Model model) {

		subjectService.save(subject);
		return "redirect:/subjectss";
	}

	/**
	 * deleteSubject
	 * @param id
	 * @return
	 */
	@GetMapping("/deletesubject/{id}")
	@Transactional
	public String deleteSubject(@PathVariable("id") Long id) {
		subjectService.delete(id);
		return "redirect:/subjectss";
	}


}
