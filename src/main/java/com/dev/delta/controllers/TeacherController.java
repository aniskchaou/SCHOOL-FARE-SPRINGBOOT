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

import com.dev.delta.entities.Teacher;
import com.dev.delta.services.TeacherService;

@Controller
public class TeacherController {
	/**
	 * teacherService
	 */
	@Autowired
	private TeacherService teacherService;

	/**
	 * getteachers
	 * @param model
	 * @return
	 */
	@GetMapping("/teachers")
	public String getteachers(Model model) {
		List<Teacher> countrries = teacherService.getTeachers();
		model.addAttribute("teachers", countrries);
		return "teacher/index";
	}

	@GetMapping("/addteacher")
	public String addAssignement(Model model) {
		return "teacher/add";
	}

	/**
	 * addTeacher
	 * @param teacher
	 * @param model
	 * @return
	 */
	@PostMapping("/addteacher")
	public String addTeacher(Teacher teacher, Model model) {
		teacherService.save(teacher);
		return "redirect:/teachers";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacher/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Teacher teacher = teacherService.findById(id).get();
		model.addAttribute("media", teacher);

		return "teacher/edit";
	}

	/**
	 * updateTeacher
	 * @param id
	 * @param teacher
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateteacher/{id}")
	public String updateTeacher(@PathVariable("id") long id, @Validated Teacher teacher, 
			BindingResult result,
			Model model) {

		teacherService.save(teacher);
		return "redirect:/teachers";
	}

	/**
	 * deleteTeacher
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteteacher/{id}")
	@Transactional
	public String deleteTeacher(@PathVariable("id") Long id) {
		teacherService.delete(id);
		return "redirect:/teachers";
	}


}
