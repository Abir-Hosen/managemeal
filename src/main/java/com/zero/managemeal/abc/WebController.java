package com.zero.managemeal.abc;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zero.managemeal.role.RoleService;
import com.zero.managemeal.user.User;
import com.zero.managemeal.user.UserService;

@Controller
public class WebController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping(value= {"/", "/welcome"})
	public String showCheckUserTypeAndRedirect(HttpSession session) {
	
		logger.info("Inside 'Basic Controller' - 'showGeneral' Mehod! - Info");
		logger.debug("Inside 'Basic Controller' - 'showGeneral' Mehod! - Debug");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		User user = userService.findByEmail(email);
		String role ="";
		if(user!=null) {
			role =  user.getRole().getName();
			session.setAttribute("user", user);
			session.setAttribute("id", user.getId());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("name", user.getFirstname()+" "+user.getLastname());
		}
		if(role.equals(ConstantFactory.ADMIN)) {
			return "redirect:/admin";
		}else if(role.equals(ConstantFactory.MANAGE)) {
			return "redirect:/manage";
		}else if(role.equals(ConstantFactory.MEMBER)) {
			return "redirect:/member";
		}else if(role.equals(ConstantFactory.USER)) {
			return "redirect:/user";
		}else {
			return "redirect:/anonymous";
		}
	}
 
	@RequestMapping(value = {"/admin"})
	public ModelAndView adminPanel(HttpSession session) {
		
		if(session.getAttribute("name")==null) {
			showCheckUserTypeAndRedirect(session);
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdmin", true);
		mv.addObject("title", "Meal Manager :: Administration");
		return mv;
	}

	@RequestMapping(value = {"/manage"})
	public ModelAndView managerPanel(HttpSession session) {

		if(session.getAttribute("name")==null) {
			showCheckUserTypeAndRedirect(session);
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManager", true);
		mv.addObject("title", "Meal Manager :: Management");
		return mv;
	}

	@RequestMapping(value = {"/member"})
	public ModelAndView memberPanel(HttpSession session) {

		if(session.getAttribute("name")==null) {
			showCheckUserTypeAndRedirect(session);
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickMember", true);
		mv.addObject("title", "Meal Manager :: Member");
		return mv;
	}

	@RequestMapping(value = {"/user"})
	public ModelAndView userPanel(HttpSession session) {

		if(session.getAttribute("name")==null) {
			showCheckUserTypeAndRedirect(session);
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickUser", true);
		mv.addObject("title", "Meal Manager :: User");
		return mv;
	}
	
	@RequestMapping(value = {"/anonymous"})
	public ModelAndView showHome() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAnonymous", true);
		mv.addObject("title", "Meal Manager");
		return mv;
	}

	
	@RequestMapping(value= {"/login"})
	public ModelAndView showLogin(@RequestParam(name = "message", required = false) String message) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickLogin", true);
		mv.addObject("title", "Meal Manager  :: Login");
		
		if(message!=null) {
			if(message.equals("error")) {
				mv.addObject("message", "Login error!");
			}
		}
		return mv;
	}
	
	@RequestMapping(value= {"/signup"}, method = RequestMethod.GET)
	public ModelAndView viewSignUp(@RequestParam(name = "message", required = false) String message) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickSignUp", true);
		mv.addObject("title", "Meal Manager  :: SignUp");
		mv.addObject("user", new User());
		
		if(message!=null) {
			if(message.equals("alreadyRegistered!")) {
				mv.addObject("message", "Alredy registered with this email!");
			}else if(message.equals("passwordMismatched!")) {
				mv.addObject("message", "Confirm Password doesn't match with Password!!");
			}else if(message.equals("input_error!")) {
				mv.addObject("message", "Invalid input fields!");
			}
		}
		return mv;
	}
	
	@RequestMapping(value= {"/signup"}, method = RequestMethod.POST)
	public String createSignUp(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		
		if(userService.findByEmail(user.getEmail()) !=null) {
			return "redirect:/signup?message=alreadyRegistered!";
		}else if(!user.getPassword().equals(user.getConfirmPassword())) {
			return "redirect:/signup?message=passwordMismatched!";
		}else if(bindingResult.hasErrors()) {
			model.addAttribute("userClickSignUp", true);
			return "page";
		}else {
			user.setRole(roleService.findByName(ConstantFactory.MEMBER));
			user.setSuperUser(userService.findByEmail("manager@gmail.com"));
			userService.signUp(user);
			return "redirect:/login";
		}
	}

}
