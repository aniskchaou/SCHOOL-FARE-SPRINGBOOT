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

import com.dev.delta.entities.Exam;
import com.dev.delta.services.ExamService;

@Controller
public class ExamController {
	/**
	 * examService
	 */
	@Autowired
	private ExamService examService;

	/**
	 * getexams
	 * @param model
	 * @return
	 */
	@GetMapping("/exams")
	public String getexams(Model model) {
		List<Exam> countrries = examService.getExams();
		model.addAttribute("exams", countrries);
		return "exam/index";
	}

	@GetMapping("/addexam")
	public String addAssignement(Model model) {
		return "exam/add";
	}

	/**
	 * addExam
	 * @param exam
	 * @param model
	 * @return
	 */
	@PostMapping("/addexam")
	public String addExam(Exam exam, Model model) {
		examService.save(exam);
		return "redirect:/exams";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/exam/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Exam exam = examService.findById(id).get();
		model.addAttribute("media", exam);

		return "exam/edit";
	}

	/**
	 * updateExam
	 * @param id
	 * @param exam
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateexam/{id}")
	public String updateExam(@PathVariable("id") long id, @Validated Exam exam, 
			BindingResult result,
			Model model) {

		examService.save(exam);
		return "redirect:/exams";
	}

	/**
	 * deleteExam
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteexam/{id}")
	@Transactional
	public String deleteExam(@PathVariable("id") Long id) {
		examService.delete(id);
		return "redirect:/exams";
	}


}
