package aiims.assets.record.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aiims.assets.record.exception.NotFoundException;
import aiims.assets.record.models.UPSAssets;
import aiims.assets.record.repositories.UPSAssetsRepository;

import java.util.List;

@Service
public class UPSAssetsService {
	@Autowired
    private final UPSAssetsRepository upsAssetsRepository;

    @Autowired
    public UPSAssetsService(UPSAssetsRepository upsAssetsRepository) {
        this.upsAssetsRepository = upsAssetsRepository;
    }

    public List<UPSAssets> getAllAssets() {
        return upsAssetsRepository.findAll();
    }

    public UPSAssets getAssetById(Long id) {
        return upsAssetsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("UPS Asset not found with id: " + id));
    }
    
    public UPSAssets getUPSAssetByIdAndDepartment(Long id, String department) {
        return upsAssetsRepository.findByDepartmentAndId(department, id)
                .orElseThrow(() -> new NotFoundException("UPS Asset not found with id: " + id + " in department: " + department));
    }
    
    public List<UPSAssets> getAllUPSAssetsByDepartment(String department) {
        return upsAssetsRepository.findByDepartment(department);
    }

    public UPSAssets createAsset(UPSAssets asset) {
        return upsAssetsRepository.save(asset);
    }

    public UPSAssets updateAsset(Long id, UPSAssets asset) {
        if (!upsAssetsRepository.existsById(id)) {
            throw new NotFoundException("UPS Asset not found with id: " + id);
        }
        asset.setId(id);
        return upsAssetsRepository.save(asset);
    }

    public void deleteAsset(Long id) {
        if (!upsAssetsRepository.existsById(id)) {
            throw new NotFoundException("UPS Asset not found with id: " + id);
        }
        upsAssetsRepository.deleteById(id);
    }

	
}
