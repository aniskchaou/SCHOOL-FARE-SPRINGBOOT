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

import com.dev.delta.entities.Classroom;
import com.dev.delta.services.ClassroomService;

@Controller
public class ClassroomController {
	/**
	 * classroomService
	 */
	@Autowired
	private ClassroomService classroomService;

	/**
	 * getclasses
	 * @param model
	 * @return
	 */
	@GetMapping("/classrooms")
	public String getclasses(Model model) {
		List<Classroom> countrries = classroomService.getClassrooms();
		model.addAttribute("classrooms", countrries);
		return "classroom/index";
	}

	@GetMapping("/addclassroom")
	public String addAssignement(Model model) {
		return "classroom/add";
	}

	/**
	 * addClassroom
	 * @param classroom
	 * @param model
	 * @return
	 */
	@PostMapping("/addclassroom")
	public String addClassroom(Classroom classroom, Model model) {
		classroomService.save(classroom);
		return "redirect:/classrooms";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/classroom/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Classroom classroom = classroomService.findById(id).get();
		model.addAttribute("classroom", classroom);

		return "classroom/edit";
	}

	/**
	 * updateClassroom
	 * @param id
	 * @param classroom
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateclassroom/{id}")
	public String updateClassroom(@PathVariable("id") long id, @Validated Classroom classroom, 
			BindingResult result,
			Model model) {

		classroomService.save(classroom);
		return "redirect:/classrooms";
	}

	/**
	 * deleteClassroom
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteclassroom/{id}")
	@Transactional
	public String deleteClassroom(@PathVariable("id") Long id) {
		classroomService.delete(id);
		return "redirect:/classrooms";
	}


}
