package aiims.assets.record.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aiims.assets.record.exception.NotFoundException;
import aiims.assets.record.models.ComputerAsset;
import aiims.assets.record.repositories.ComputerAssetRepository;

import java.util.List;

@Service
public class ComputerAssetService {
	@Autowired
    private final ComputerAssetRepository computerAssetRepository;

    @Autowired
    public ComputerAssetService(ComputerAssetRepository computerAssetRepository) {
        this.computerAssetRepository = computerAssetRepository;
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
}
