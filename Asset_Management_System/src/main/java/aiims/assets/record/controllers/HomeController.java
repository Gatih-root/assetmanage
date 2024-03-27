package aiims.assets.record.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import aiims.assets.record.models.Employe;
import aiims.assets.record.repositories.UserRepo;
import aiims.assets.record.services.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

	@ModelAttribute
	public void commonUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			String userid = p.getName();
			Optional<Employe> employe = userRepo.findByUserid(userid);
			m.addAttribute("user", employe);
		}

	}

	@GetMapping("/")
	public String index() {
		return "login";
	}

//	@GetMapping("/register")
//	public String register() {
//		return "register";
//	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	/*
	 * @GetMapping("/user/profile") public String profile(Principal p, Model m) {
	 * String email = p.getName(); User user = userRepo.findByEmail(email);
	 * m.addAttribute("user", user); return "profile"; }
	 * 
	 * @GetMapping("/user/home") public String home() { return "home"; }
	 */

	/*@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute Employe employe, HttpSession session, Model m) {

		// System.out.println(user);

		Employe u = userService.saveUser(employe);

		if (u != null) {
			// System.out.println("save sucess");
			session.setAttribute("msg", "Register successfully");

		} else {
			// System.out.println("error in server");
			session.setAttribute("msg", "Something wrong server");
		}
		return "redirect:/register";
	}*/

}
