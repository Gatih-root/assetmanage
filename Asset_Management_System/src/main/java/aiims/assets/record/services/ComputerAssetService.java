package aiims.assets.record.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aiims.assets.record.models.Departments;
import aiims.assets.record.exception.NotFoundException;
import aiims.assets.record.models.ComputerAsset;
import aiims.assets.record.repositories.ComputerAssetRepository;
import aiims.assets.record.services.DepartmentService;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerAssetService {
	@Autowired
    private final ComputerAssetRepository computerAssetRepository;
	@Autowired
	private final DepartmentService departmentService;
	
    @Autowired
    public ComputerAssetService(ComputerAssetRepository computerAssetRepository, DepartmentService departmentService) {
        this.computerAssetRepository = computerAssetRepository;
        this.departmentService = departmentService;
    }
    

	


    public List<ComputerAsset> getAllAssets() {
        return computerAssetRepository.findAll();
    }

    public ComputerAsset getAssetById(Long id) {
        return computerAssetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Computer Asset not found with id: " + id));
    }

    public ComputerAsset createAsset(ComputerAsset asset) {
        return computerAssetRepository.save(asset);
    }

    public ComputerAsset updateAsset(Long id, ComputerAsset asset) {
        if (!computerAssetRepository.existsById(id)) {
            throw new NotFoundException("Computer Asset not found with id: " + id);
        }
        asset.setId(id);
        return computerAssetRepository.save(asset);
    }

    public void deleteAsset(Long id) {
        if (!computerAssetRepository.existsById(id)) {
            throw new NotFoundException("Computer Asset not found with id: " + id);
        }
        computerAssetRepository.deleteById(id);
    }

    public List<ComputerAsset> getAllComputerAssetsByDepartment(String department) {
        return computerAssetRepository.findByDepartment(department);
    }

    public ComputerAsset getComputerAssetByIdAndDepartment(Long id, String department) {
        Optional<ComputerAsset> optionalAsset = computerAssetRepository.findByDepartmentAndId(department, id);
        return optionalAsset.orElseThrow(() -> new NotFoundException("Computer Asset not found with id: " + id + " and department: " + department));
    }

    
	
}
