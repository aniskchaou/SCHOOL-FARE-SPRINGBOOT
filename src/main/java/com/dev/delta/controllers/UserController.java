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

import com.dev.delta.entities.User;
import com.dev.delta.services.UserService;

@Controller
public class UserController {
	/**
	 * userService
	 */
	@Autowired
	private UserService userService;

	/**
	 * getusers
	 * @param model
	 * @return
	 */
	@GetMapping("/users")
	public String getusers(Model model) {
		List<User> countrries = userService.getUsers();
		model.addAttribute("users", countrries);
		return "user/index";
	}

	/**
	 * addUser
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/adduser")
	public String addUser(User user, Model model) {
		userService.save(user);
		return "redirect:/users";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		User user = userService.findById(id).get();
		model.addAttribute("user", user);

		return "user/edit";
	}

	/**
	 * updateUser
	 * @param id
	 * @param user
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateuser/{id}")
	public String updateUser(@PathVariable("id") long id, @Validated User user, 
			BindingResult result,
			Model model) {

		userService.save(user);
		return "redirect:/users";
	}

	/**
	 * deleteUser
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteuser/{id}")
	@Transactional
	public String deleteUser(@PathVariable("id") Long id) {
		userService.delete(id);
		return "redirect:/users";
	}

	@GetMapping("/adduser")
	public String addBook(Model model) {
		return "user/add";
	}
}
