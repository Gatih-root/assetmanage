package aiims.assets.record.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aiims.assets.record.entity.Employe;
import aiims.assets.record.repository.UserRepo;
import aiims.assets.record.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

	@ModelAttribute
	public void commonUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			Employe employe = userRepo.findByEmail(email);
			m.addAttribute("user", employe);
		}
	}

	@GetMapping("/profile")
	public String profile() {
		return "admin_profile";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute Employe employe, HttpSession session, Model m) {

		// System.out.println(user);

		Employe u = userService.saveUser(employe);

		if (u != null) {
			// System.out.println("save success");
			session.setAttribute("msg", "Register successfully");

		} else {
			// System.out.println("error in server");
			session.setAttribute("msg", "Something wrong server");
		}
		return "redirect:/register";
	}
}
