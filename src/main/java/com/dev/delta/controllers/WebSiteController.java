package com.dev.delta.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.delta.entities.Category;

import com.dev.delta.services.CategoryService;


@Controller
public class WebSiteController {

	

	
	/**
	 * addCategory
	 * @param category
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String homepage(Model model) {
		
		return "website/index";
	}
	
	@GetMapping("/contact")
	public String contact(Model model) {
		
		return "website/index";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		
		return "website/about";
	}
	
	@GetMapping("/teacher")
	public String teacher(Model model) {
		
		return "website/teacher";
	}
	
	@GetMapping("/vehicle")
	public String vehicle(Model model) {
		
		return "website/vehicle";
	}
	
	
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		return "dashboard/dashboard";
	}

	@GetMapping("/login")
	public String login(Model model) {
		/*Long id = 1L;
		InformationHotel informationHotel = informationService.findById(id);
		String lang=informationHotel.getLang();
		model.addAttribute("hotel", informationHotel);
		model.addAttribute("menu", websiteMenuI18nRepository.findByLang(lang));
		model.addAttribute("login", websiteSignInI18nRepository.findByLang(lang));
		model.addAttribute("footer", websiteFooterI18nRepository.findByLang(lang));*/
		return "auth/login";
	}
	
	
	

	
}
