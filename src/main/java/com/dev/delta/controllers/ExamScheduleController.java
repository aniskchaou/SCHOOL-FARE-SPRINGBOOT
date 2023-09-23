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

import com.dev.delta.entities.ExamSchedule;
import com.dev.delta.services.ExamScheduleService;

@Controller
public class ExamScheduleController {
	/**
	 * examScheduleService
	 */
	@Autowired
	private ExamScheduleService examScheduleService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/examschedules")
	public String getCountries(Model model) {
		List<ExamSchedule> countrries = examScheduleService.getExamSchedules();
		model.addAttribute("examschedules", countrries);
		return "examschedule/index";
	}

	@GetMapping("/addexamschedule")
	public String getCountriess(Model model) {

		return "examschedule/add";
	}

	/**
	 * addExamSchedule
	 * @param examSchedule
	 * @param model
	 * @return
	 */
	@PostMapping("/addexamschedule")
	public String addExamSchedule(ExamSchedule examSchedule, Model model) {
		examScheduleService.save(examSchedule);
		return "redirect:/examschedules";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/examschedule/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		ExamSchedule examSchedule = examScheduleService.findById(id).get();
		model.addAttribute("media", examSchedule);

		return "examschedule/edit";
	}

	/**
	 * updateExamSchedule
	 * @param id
	 * @param examSchedule
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateexamschedule/{id}")
	public String updateExamSchedule(@PathVariable("id") long id, @Validated ExamSchedule examSchedule, 
			BindingResult result,
			Model model) {

		examScheduleService.save(examSchedule);
		return "redirect:/examschedules";
	}

	/**
	 * deleteExamSchedule
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteexamschedule/{id}")
	@Transactional
	public String deleteExamSchedule(@PathVariable("id") Long id) {
		examScheduleService.delete(id);
		return "redirect:/examschedules";
	}
}
