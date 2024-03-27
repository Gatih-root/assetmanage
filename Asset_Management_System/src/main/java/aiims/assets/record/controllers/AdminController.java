package aiims.assets.record.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aiims.assets.record.models.ComputerAsset;
import aiims.assets.record.models.Departments;
import aiims.assets.record.models.Employe;
import aiims.assets.record.models.PrinterAssets;
import aiims.assets.record.models.UPSAssets;
import aiims.assets.record.repositories.ComputerAssetRepository;
import aiims.assets.record.repositories.DepartmentRepo;
import aiims.assets.record.repositories.PrinterAssetsRepository;
import aiims.assets.record.repositories.UPSAssetsRepository;
import aiims.assets.record.repositories.UserRepo;
import aiims.assets.record.services.ComputerAssetService;
import aiims.assets.record.services.DepartmentService;
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
	 private DepartmentService departmentService;
	@Autowired
	 private ComputerAssetService computerAssetService;
	@Autowired
	 private UPSAssetsService upsAssetService;
	@Autowired
	 private PrinterAssetsService printerAssetService;
	
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private ComputerAssetRepository computerAssetRepository;
	@Autowired
	private UPSAssetsRepository upsAssetsRepository;
	
	@Autowired
	private PrinterAssetsRepository printerAssetsRepository;
	@Autowired
	private UserRepo userRepo;

	@ModelAttribute
	public void commonUser(Principal p, Model m) {
		if (p != null) {
//			String email = p.getName();
			String userid = p.getName();
//			Employe employe = userRepo.findByEmail(email);
			Employe employe = userRepo.findByUserid(userid).orElse(null);
			m.addAttribute("user", employe);
		}
	}

	@GetMapping("/profile")
	public String profile() {
		return "redirect:/admin/employees";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List<Departments> departments = departmentService.findAll();
		 System.out.println();
		 model.addAttribute("departments", departments);
		return "register";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute Employe employe, HttpSession session, Model m) {
		Employe employeUserId = userRepo.findByUserid(employe.getUserid()).orElse(null);
		if(employeUserId!=null) {
			session.setAttribute("msg", "User already exits");
			return "redirect:/admin/register";
		}
		
		
		Employe u = userService.saveUser(employe);

		if (u != null) {
			
			session.setAttribute("msg", "Register successfully " + u.getPassword());
		}
		else {
		// System.out.println("error in server");
			session.setAttribute("msg", "Something went wrong");
		}
		return "redirect:/admin/register";
	}
	  @GetMapping("/employees")
	    public String listEmployees(Model model) {
	        List<Employe> employees = userService.getAllEmploye();
	        model.addAttribute("employees", employees);
	        return "admin_profile";
	    }
	
	@PostMapping("/add_department")
	public String add_department(@ModelAttribute Departments department , HttpSession session, Model m) {
		Departments dp=departmentService.save(department);
		if(dp!=null) {
			session.setAttribute("msg", "department  added sucessfuly");
		}
		else {
			session.setAttribute("msg", "Something wrong server");
		}
		 return "redirect:/admin/add";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		 List<Departments> departments = departmentService.findAll();
		 System.out.println();
		 model.addAttribute("departments", departments);
		return "add";
	}
	//update department
	
	@GetMapping("/update_department/{id}")
    public String departmentupdate(@PathVariable("id") Long id,Model model){
		Departments department =departmentRepo.getDepartmentById(id);
    	
    	model.addAttribute("department",department);
    	return"update_department";
    
    	
    }
	@PostMapping("/update_department/{id}")
    public String updateDepartment(@PathVariable("id") long id, @Validated Departments department, BindingResult result, Model model) {
      if (result.hasErrors()) {
        return "update_department";
      }
      department.setId(id);
      departmentRepo.save(department);
      return "redirect:/admin/add";
    }
	
	//delete departent

    @GetMapping("/department_delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
    	departmentService.deleteById(id);;
        return "redirect:/admin/add";
    }

    


  //for employe update 
    
    @GetMapping("/Update/{id}")
    public String showformforUpdate(@PathVariable("id") Long id,Model model){
    	Employe employe=userRepo.getEmployeById(id);
    	
    	model.addAttribute("employe",employe);
    	return"update_employe";
    
    	
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Validated Employe employe, BindingResult result, Model model) {
      if (result.hasErrors()) {
        return "update_employe";
      }
      employe.setId(id);
      userRepo.save(employe);
      return "redirect:/admin/employees";
    }
    
    
    
    //for delete
    
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
    	Employe  employe = userRepo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
      userRepo.delete(employe);
      return "redirect:/admin/employees";
    }
    @PostMapping("/{userId}/status")
    public ResponseEntity<?> updateUserStatus(@PathVariable String userId, @RequestParam String newStatus) {
        userService.updateUserStatus(userId, newStatus);
        return ResponseEntity.ok("User status updated successfully");
    }
    
    //for unblock employee
    
    @GetMapping("/unblock/{id}")
    public String unblockUser(@PathVariable("id") long id) {
        Employe user = userRepo.findById(id)
                               .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setStatus("ACTIVE"); // Assuming "ACTIVE" means unblocked
        userRepo.save(user);
        return "redirect:/admin/employees"; // Redirect to user list page or wherever appropriate
    }
    
    @GetMapping("/lock/{id}")
    public String blockUser(@PathVariable("id") long id) {
        Employe user = userRepo.findById(id)
                               .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setStatus("DISABELED"); // Assuming "DEACTIVE" means blocked
        userRepo.save(user);
        return "redirect:/admin/employees"; // Redirect to user list page or wherever appropriate
    }





    
    
	
	//Assets  Endpoints
	
	
	
	@GetMapping("/computer-assets")
    public String getAllComputerAssets(Model model, Principal principal) {
		String userid = principal.getName();
	    String department = userService.getUserDepartment(userid);
	    
	    model.addAttribute("userid", userid);
	    model.addAttribute("department", department);
        List<ComputerAsset> computerAssets = computerAssetService.getAllAssets();
        model.addAttribute("computerAssets", computerAssets);
        return "computer-assets";
    }

    @GetMapping("/ups-assets")
    public String getAllUPSAssets(Model model, Principal principal) {
		String userid = principal.getName();
	    String department = userService.getUserDepartment(userid);
	    
	    model.addAttribute("userid", userid);
	    model.addAttribute("department", department);
        List<UPSAssets> upsAssets = upsAssetService.getAllAssets();
        model.addAttribute("upsAssets", upsAssets);
        return "ups-assets";
    }

    @GetMapping("/printer-assets")
    public String getAllPrinterAssets(Model model, Principal principal) {
		String userid = principal.getName();
	    String department = userService.getUserDepartment(userid);
	    
	    model.addAttribute("userid", userid);
	    model.addAttribute("department", department);
        List<PrinterAssets> printerAssets = printerAssetService.getAllAssets();
        model.addAttribute("printerAssets", printerAssets);
        return "printer-assets";
    }
    
   
    


}
