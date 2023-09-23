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

import com.dev.delta.entities.Section;
import com.dev.delta.services.SectionService;

@Controller
public class SectionController {
	/**
	 * sectionService
	 */
	@Autowired
	private SectionService sectionService;

	/**
	 * getsections
	 * @param model
	 * @return
	 */
	@GetMapping("/sections")
	public String getsections(Model model) {
		List<Section> countrries = sectionService.getSections();
		model.addAttribute("sections", countrries);
		return "section/index";
	}

	@GetMapping("/addsection")
	public String addAssignement(Model model) {
		return "section/add";
	}

	/**
	 * addSection
	 * @param section
	 * @param model
	 * @return
	 */
	@PostMapping("/addsection")
	public String addSection(Section section, Model model) {
		sectionService.save(section);
		return "redirect:/sections";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/section/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Section section = sectionService.findById(id).get();
		model.addAttribute("media", section);

		return "section/edit";
	}

	/**
	 * updateSection
	 * @param id
	 * @param section
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatesection/{id}")
	public String updateSection(@PathVariable("id") long id, @Validated Section section, 
			BindingResult result,
			Model model) {

		sectionService.save(section);
		return "redirect:/sections";
	}

	/**
	 * deleteSection
	 * @param id
	 * @return
	 */
	@GetMapping("/deletesection/{id}")
	@Transactional
	public String deleteSection(@PathVariable("id") Long id) {
		sectionService.delete(id);
		return "redirect:/sections";
	}


}
