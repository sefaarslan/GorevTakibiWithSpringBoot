package com.gorevtakibi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gorevtakibi.model.Authority;
import com.gorevtakibi.model.User;
import com.gorevtakibi.service.AuthorityService;
import com.gorevtakibi.service.UserService;


@Controller 
public class MainController {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;

	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_USER")) {
			return "redirect:/user/welcome";
		} else { // it means that this username exists
			return "redirect:/admin/welcome";
		} 
		
	}

	// Login form
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			// user has already logged in
			return "redirect:/";
		} else {
			return "login";
		}
	}

	// Login form
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			// user has already logged in
			return "redirect:/";
		} else {
			// to make available for binding, we need default user
			model.addAttribute("user", new User());
			return "register";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid User user, BindingResult result, HttpServletRequest request) {
		

		if (result.hasErrors()) {
			return "register";
		} else {
		
			if (!(user.getUsername() == null)) {
				userService.save(user);
				Authority auth = new Authority();
				auth.setUsername(user.getUsername());
				auth.setRole("ROLE_USER");
				authorityService.save(auth);
				return "redirect:/";
			} else { // it means that this username exists
				return "redirect:/register?error";
			} 
		}	
	}
}