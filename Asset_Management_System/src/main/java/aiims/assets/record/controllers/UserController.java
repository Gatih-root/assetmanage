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
			//String email = p.getName();
			String userid = p.getName();
			Employe employe = userRepo.findByUserid(userid);
			m.addAttribute("user", employe);
		}

	}

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	
	// Computer Assets Endpoints
	
	
/*	@GetMapping("/computer-assets")
	public ResponseEntity<List<ComputerAsset>> getAllComputerAssets(Principal principal) {
	    String department = userService.getUserDepartment(principal.getName());
	    List<ComputerAsset> computerAssets = computerAssetService.getAllComputerAssetsByDepartment(department);
	    return new ResponseEntity<>(computerAssets, HttpStatus.OK);
	}

	@GetMapping("/computer-assets/{id}")
	public ResponseEntity<ComputerAsset> getComputerAssetById(@PathVariable Long id, Principal principal) {
	    String department = userService.getUserDepartment(principal.getName());
	    ComputerAsset computerAsset = computerAssetService.getComputerAssetByIdAndDepartment(id, department);
	    return new ResponseEntity<>(computerAsset, HttpStatus.OK);
	}

	@PostMapping("/computer-assets")
	public ResponseEntity<ComputerAsset> createComputerAsset(@RequestBody ComputerAsset computerAsset,
	        Principal principal) {
	    String department = userService.getUserDepartment(principal.getName());
	    computerAsset.setDepartment(department);
	    ComputerAsset createdAsset = computerAssetService.createAsset(computerAsset);
	    return new ResponseEntity<>(createdAsset, HttpStatus.CREATED);
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

	@DeleteMapping("/computer-assets/{id}")
	public ResponseEntity<Void> deleteComputerAsset(@PathVariable Long id, Principal principal) {
	    String department = userService.getUserDepartment(principal.getName());
	    computerAssetService.deleteAsset(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	
	// End points for UPS Assets

	    @GetMapping("/ups-assets")
	    public ResponseEntity<List<UPSAssets>> getAllUPSAssets(Principal principal) {
	        String department = userService.getUserDepartment(principal.getName());
	        List<UPSAssets> upsAssets = upsAssetService.getAllUPSAssetsByDepartment(department);
	        return new ResponseEntity<>(upsAssets, HttpStatus.OK);
	    }

	    @GetMapping("/ups-assets/{id}")
	    public ResponseEntity<UPSAssets> getUPSAssetById(@PathVariable Long id, Principal principal) {
	        String department = userService.getUserDepartment(principal.getName());
	        UPSAssets upsAsset = upsAssetService.getUPSAssetByIdAndDepartment(id, department);
	        return new ResponseEntity<>(upsAsset, HttpStatus.OK);
	    }

	    @PostMapping("/ups-assets")
	    public ResponseEntity<UPSAssets> createUPSAsset(@RequestBody UPSAssets upsAsset, Principal principal) {
	        String department = userService.getUserDepartment(principal.getName());
	        upsAsset.setDepartment(department);
	        UPSAssets createdAsset = upsAssetService.createAsset(upsAsset);
	        return new ResponseEntity<>(createdAsset, HttpStatus.CREATED);
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
    public ResponseEntity<List<PrinterAssets>> getAllPrinterAssets(Principal principal) {
        String department = userService.getUserDepartment(principal.getName());
        List<PrinterAssets> printerAssets = printerAssetService.getAllAssetsByDepartment(department);
        return new ResponseEntity<>(printerAssets, HttpStatus.OK);
    }

    @GetMapping("/printer-assets/{id}")
    public ResponseEntity<PrinterAssets> getPrinterAssetById(@PathVariable Long id, Principal principal) {
        String department = userService.getUserDepartment(principal.getName());
        PrinterAssets printerAsset = printerAssetService.getAssetByIdAndDepartment(id, department);
        return new ResponseEntity<>(printerAsset, HttpStatus.OK);
    }

    @PostMapping("/printer-assets")
    public ResponseEntity<PrinterAssets> createPrinterAsset(@RequestBody PrinterAssets printerAsset,
            Principal principal) {
        String department = userService.getUserDepartment(principal.getName());
        printerAsset.setDepartment(department);
        PrinterAssets createdAsset = printerAssetService.createAsset(printerAsset);
        return new ResponseEntity<>(createdAsset, HttpStatus.CREATED);
    }

    @PutMapping("/printer-assets/{id}")
    public ResponseEntity<PrinterAssets> updatePrinterAsset(@PathVariable Long id,
            @RequestBody PrinterAssets printerAsset, Principal principal) {
        String department = userService.getUserDepartment(principal.getName());
        PrinterAssets existingAsset = printerAssetService.getAssetByIdAndDepartment(id, department);
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
    }*/

}
