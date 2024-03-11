package aiims.assets.record.controllers;

import java.util.*;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aiims.assets.record.models.ComputerAsset;
import aiims.assets.record.models.Employe;
import aiims.assets.record.models.PrinterAssets;
import aiims.assets.record.models.UPSAssets;
import aiims.assets.record.repositories.UserRepo;
import aiims.assets.record.services.ComputerAssetService;
import aiims.assets.record.services.PrinterAssetsService;
import aiims.assets.record.services.UPSAssetsService;
import aiims.assets.record.services.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private ComputerAssetService computerAssetService;

    @Autowired
    private UPSAssetsService upsAssetService;

    @Autowired
    private PrinterAssetsService printerAssetService;

	@ModelAttribute
	public void commonUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			String userid = p.getName();
			Employe employe = userRepo.findByUserid(userid);
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
	
	
	//Assets  Endpoints
	
	
	
	@GetMapping("/computer-assets")
    public String getAllComputerAssets(Model model) {
        List<ComputerAsset> computerAssets = computerAssetService.getAllAssets();
        model.addAttribute("computerAssets", computerAssets);
        return "computer-assets";
    }

    @GetMapping("/ups-assets")
    public String getAllUPSAssets(Model model) {
        List<UPSAssets> upsAssets = upsAssetService.getAllAssets();
        model.addAttribute("upsAssets", upsAssets);
        return "ups-assets";
    }

    @GetMapping("/printer-assets")
    public String getAllPrinterAssets(Model model) {
        List<PrinterAssets> printerAssets = printerAssetService.getAllAssets();
        model.addAttribute("printerAssets", printerAssets);
        return "printer-assets";
    }

    // Add more endpoints as needed for other types of assets

}
