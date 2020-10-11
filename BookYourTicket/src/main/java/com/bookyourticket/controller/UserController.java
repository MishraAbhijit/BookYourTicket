package com.bookyourticket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookyourticket.dto.Login;
import com.bookyourticket.dto.UIProperties;
import com.bookyourticket.entity.User;
import com.bookyourticket.messaging.RegistrationMessageSender;
import com.bookyourticket.services.SecurityService;
import com.bookyourticket.services.UserServices;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class UserController extends UIProperties{

	@Autowired
	private UserServices userServices;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private RegistrationMessageSender registrationMessageSender;
	@RequestMapping("/login")
	public ModelAndView showLogin(HttpSession session)
	{
		logger.info("===== Inside Show Login =====");
		System.out.println(".... Login .....");
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping("/registration")
	public ModelAndView showSignup(HttpSession session)
	{
		logger.info("===== Inside Show SignUp =====");
		System.out.println("===== Signup =====");
		ModelAndView modelAndView = new ModelAndView("signup");
		return modelAndView;
	}
	
	@GetMapping("/processSignUp")
	public ModelAndView processSignup(HttpSession session,User user)
	{
		logger.info("===== Processing SignUp =====");
		System.out.println("===== Process Signup =====");
		System.out.println(user);
		boolean saveUser = userServices.saveUser(session,user);
		System.out.println("===== Sending mail To User =====");
		if(saveUser)
		{
			try {
				registrationMessageSender.send(user.getUserName(),user.getEmail());
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@GetMapping("/processLogin")
	public ModelAndView processLogin(HttpSession session,Login login)
	{
		logger.info("===== Process Login =====");
		System.out.println(login);
		boolean loginResponse = securityService.login(login.getEmail(), login.getPassword());
		
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

}
