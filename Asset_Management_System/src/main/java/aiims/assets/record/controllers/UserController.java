package aiims.assets.record.controllers;

import java.util.*;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import aiims.assets.record.models.ComputerAsset;
import aiims.assets.record.models.Departments;
import aiims.assets.record.models.Employe;
import aiims.assets.record.models.PrinterAssets;
import aiims.assets.record.models.UPSAssets;
import aiims.assets.record.repositories.UserRepo;
import aiims.assets.record.services.ComputerAssetService;
import aiims.assets.record.services.PrinterAssetsService;
import aiims.assets.record.services.UPSAssetsService;
import aiims.assets.record.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private ComputerAssetService computerAssetService;

    @Autowired
    private UPSAssetsService upsAssetService;

    @Autowired
    private PrinterAssetsService printerAssetService;
    
    @Autowired
    private UserService userService;

    @ModelAttribute
	public void commonUser(Principal p, Model m) {
		if (p != null) {
//			String email = p.getName();
//			Employe employ = userRepo.findByEmail(email);
			String userid = p.getName();
			Employe employe=userRepo.findByUserid(userid).orElse(null);
			m.addAttribute("user", employe);
		}

	}

	@GetMapping("/profile")
	public String profile(Model model, Principal principal) {
		String userid = principal.getName();
	    String department = userService.getUserDepartment(userid);
	    
	    model.addAttribute("userid", userid);
	    model.addAttribute("department", department);
		return "profile";
	}


/*	@GetMapping("/profile")
	public String profile(Model model, Principal principal) {
	    // Retrieve userid and department from the Principal object
	    String userid = principal.getName();
	    String department = userService.getUserDepartment(userid);
	    
	    // Add userid and department to the model
	    model.addAttribute("userid", userid);
	    model.addAttribute("department", department);
	    
	    return "profile";
	}*/
	
	
	// Computer Assets Endpoints
	
	@GetMapping("/computer-assets")
	public String getComputerAssets(Model model, Principal principal) {
		String userid = principal.getName();
	    String department = userService.getUserDepartment(userid);
	    
	    model.addAttribute("userid", userid);
	    model.addAttribute("department", department);
	    List<ComputerAsset> computerAssets = computerAssetService.getAllComputerAssetsByDepartment(department);
	    model.addAttribute("computerAssets", computerAssets);
	    return "computer-assets"; // Return the Thymeleaf template name
	}
	
	@GetMapping("/computer-assets/{id}")
	public ResponseEntity<ComputerAsset> getComputerAssetById(@PathVariable Long id, Principal principal) {
	    String department = userService.getUserDepartment(principal.getName());
	    ComputerAsset computerAsset = computerAssetService.getComputerAssetByIdAndDepartment(id, department);
	    return new ResponseEntity<>(computerAsset, HttpStatus.OK);
	}
	
	//Add Comp
	@GetMapping("/addcompassets")
	public String addcompassets(Model model, Principal principal) {
	    // Retrieve userid and department from the Principal object
	    String userid = principal.getName();
	    String department = userService.getUserDepartment(userid);
	    
	    // Add userid and department to the model
	    model.addAttribute("userid", userid);
	    model.addAttribute("department", department);
	    
	    // Create a new ComputerAsset object and add it to the model
	    ComputerAsset computerAsset = new ComputerAsset();
	    model.addAttribute("computerAsset", computerAsset);
	    
	    return "/addcompassets"; // Assuming your Thymeleaf template is named addcompassets.html
	}

	@PostMapping("/savecomp")
	public String createComputerAsset(@ModelAttribute ComputerAsset computerAsset, Principal principal) {
        String department = userService.getUserDepartment(principal.getName());
        computerAsset.setDepartment(department);
        ComputerAsset createdAsset = computerAssetService.createAsset(computerAsset);

		
			
		    System.out.println("save success");
			
	
	    return "redirect:/user/addcompassets";
	}
	
	
	@GetMapping("/updatecomp/{id}")
	public String showUpdateComputerAssetForm(@PathVariable Long id, Model model, Principal principal) {
	    String department = userService.getUserDepartment(principal.getName());
	    ComputerAsset computerAsset = computerAssetService.getComputerAssetByIdAndDepartment(id, department);
	    
	    // Check if the computer asset exists
	    if (computerAsset == null) {
	        // Handle the case where the asset is not found
	        // You can redirect to an error page or handle it according to your application's logic
	        return "error"; // Assuming you have an error Thymeleaf template named "error.html"
	    }
	    
	    // Add the computer asset object to the model to populate the form fields
	    model.addAttribute("computerAsset", computerAsset);
	    
	    return "updatecomp"; // Return the Thymeleaf template for the update form
	}
	

	@PutMapping("/computer-assets/{id}")
	public ResponseEntity<ComputerAsset> updateComputerAsset(@PathVariable Long id,
	        @RequestBody ComputerAsset computerAsset, Principal principal) {
	    String department = userService.getUserDepartment(principal.getName());
	    ComputerAsset existingAsset = computerAssetService.getComputerAssetByIdAndDepartment(id, department);
	    computerAsset.setId(id);
	    computerAsset.setDepartment(existingAsset.getDepartment());
	    ComputerAsset updatedAsset = computerAssetService.updateAsset(id, computerAsset);
	    return new ResponseEntity<>(updatedAsset, HttpStatus.OK);
	}

	@DeleteMapping("/deletecomp/{id}")
	public String deleteComputerAsset(@PathVariable Long id, Principal principal) {
	    String department = userService.getUserDepartment(principal.getName());
	    computerAssetService.deleteAsset(id);
	    return "computer-assets";
	}

	
	
	// End points for UPS Assets

	    @GetMapping("/ups-assets")
	    
		public String getUPSAssets(Model model, Principal principal) {
			String userid = principal.getName();
		    String department = userService.getUserDepartment(userid);
		    
		    model.addAttribute("userid", userid);
		    model.addAttribute("department", department);
		    List<UPSAssets> upsAssets = upsAssetService.getAllUPSAssetsByDepartment(department);
		    model.addAttribute("upsAssets",upsAssets);
		    return "ups-assets"; // Return the Thymeleaf template name
		}
		

	    @GetMapping("/ups-assets/{id}")
	    public ResponseEntity<UPSAssets> getUPSAssetById(@PathVariable Long id, Principal principal) {
	        String department = userService.getUserDepartment(principal.getName());
	        UPSAssets upsAsset = upsAssetService.getUPSAssetByIdAndDepartment(id, department);
	        return new ResponseEntity<>(upsAsset, HttpStatus.OK);
	    }
	    
	    //ADD UPS Endpoint
	    @GetMapping("/addupsassets")
	    public String addupsassets(Model model, Principal principal) {
	    	 // Retrieve userid and department from the Principal object
		    String userid = principal.getName();
		    String department = userService.getUserDepartment(userid);
		    
		    // Add userid and department to the model
		    model.addAttribute("userid", userid);
		    model.addAttribute("department", department);
		    
		    
		 // Create a new ComputerAsset object and add it to the model
		    UPSAssets upsAsset = new UPSAssets();
		    model.addAttribute("upsAsset", upsAsset);
		    
	        return "addupsassets"; // Return the Thymeleaf template name
	    }

	    @PostMapping("/saveups")
	    public String createUPSAsset(@ModelAttribute UPSAssets upsAsset, Principal principal) {
	        String department = userService.getUserDepartment(principal.getName());
	        upsAsset.setDepartment(department);
	        UPSAssets createdAsset = upsAssetService.createAsset(upsAsset);
	        System.out.println("save success");
	        
	        return "redirect:/user/addupsassets";
	    }
	   
	    @PutMapping("/ups-assets/{id}")
	    public ResponseEntity<UPSAssets> updateUPSAsset(@PathVariable Long id, @RequestBody UPSAssets upsAsset,
	            Principal principal) {
	        String department = userService.getUserDepartment(principal.getName());
	        UPSAssets existingAsset = upsAssetService.getUPSAssetByIdAndDepartment(id, department);
	        upsAsset.setId(id);
	        UPSAssets updatedAsset = upsAssetService.updateAsset(id, upsAsset);
	        return new ResponseEntity<>(updatedAsset, HttpStatus.OK);
	    }

	    @DeleteMapping("/ups-assets/{id}")
	    public ResponseEntity<Void> deleteUPSAsset(@PathVariable Long id, Principal principal) {
	        String department = userService.getUserDepartment(principal.getName());
	        upsAssetService.deleteAsset(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

    
    
    
 // Printer Assets Endpoints
    
	  
    @GetMapping("/printer-assets")
    public String getAllPrinterAssets(Model model, Principal principal) {
		String userid = principal.getName();
	    String department = userService.getUserDepartment(userid);
	    
	    model.addAttribute("userid", userid);
	    model.addAttribute("department", department);
        List<PrinterAssets> printerAssets = printerAssetService.getAllAssetsByDepartment(department);
        model.addAttribute("printerAssets", printerAssets);
        return "printer-assets"; // Return the Thymeleaf template name
    }

    @GetMapping("/printer-assets/{id}")
    public ResponseEntity<PrinterAssets> getPrinterAssetById(@PathVariable Long id, Principal principal) {
        String department = userService.getUserDepartment(principal.getName());
        PrinterAssets printerAsset = printerAssetService.getAssetByIdAndDepartment(id, department);
        return new ResponseEntity<>(printerAsset, HttpStatus.OK);
    }
    
    @GetMapping("/addprintassets")
    public String addprintassets(Model model, Principal principal) {
    	 // Retrieve userid and department from the Principal object
	    String userid = principal.getName();
	    String department = userService.getUserDepartment(userid);
	    
	    // Add userid and department to the model
	    model.addAttribute("userid", userid);
	    model.addAttribute("department", department);
	    
	    
	 // Create a new ComputerAsset object and add it to the model
	    PrinterAssets printerAsset = new PrinterAssets();
	    model.addAttribute("printersAsset", printerAsset);
	    
        return "addprintassets"; // Return the Thymeleaf template name
    }

    @PostMapping("/saveprint")
    public String createPrinterAsset(@ModelAttribute PrinterAssets printerAsset,
            Principal principal) {
        String department = userService.getUserDepartment(principal.getName());
        printerAsset.setDepartment(department);
        PrinterAssets createdAsset = printerAssetService.createAsset(printerAsset);
        System.out.println("save success");
        return "redirect:/user/addprintassets";
    }
    
    @PutMapping("/printer-assets/{id}")
    public ResponseEntity<PrinterAssets> updatePrinterAsset(@PathVariable Long id,
            @RequestBody PrinterAssets printerAsset, Principal principal) {
        String department = userService.getUserDepartment(principal.getName());
        
        // Check if the printer asset exists and belongs to the user's department
        PrinterAssets existingAsset = printerAssetService.getAssetByIdAndDepartment(id, department);
        if (existingAsset == null) {
            // Printer asset not found for the given ID and department
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // Update the printer asset details
        printerAsset.setId(id);
        printerAsset.setDepartment(existingAsset.getDepartment());
        PrinterAssets updatedAsset = printerAssetService.updateAsset(id, printerAsset);
        
        return new ResponseEntity<>(updatedAsset, HttpStatus.OK);
    }

    @DeleteMapping("/printer-assets/{id}")
    public ResponseEntity<Void> deletePrinterAsset(@PathVariable Long id, Principal principal) {
        String department = userService.getUserDepartment(principal.getName());
        printerAssetService.deleteAsset(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    
    //Add Assets
    
    
    

}
