package com.tcs.project.sash.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.project.sash.repository.UserRepository;

@Controller
@RequestMapping("sash")
public class HomeController
{
	@Autowired
	private UserRepository users;
	
	@RequestMapping("/")
	public ModelAndView index()	{
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("home")
	public ModelAndView home()	{
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	
	@PostMapping("login")
	public ModelAndView login(HttpServletRequest request)
	{		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || password == null)
		{
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("alert", "Invailed Credentails...!!!");
			return mv;
		}
		else
		{
			if(users.findByUsernameAndPassword(username, password) != null)
			{
				ModelAndView mv = new ModelAndView("home");
				mv.addObject("username", username);
				mv.addObject("username", password);
				return mv;
			}

			ModelAndView mv = new ModelAndView("home");
			return mv;
		}
	}
}
