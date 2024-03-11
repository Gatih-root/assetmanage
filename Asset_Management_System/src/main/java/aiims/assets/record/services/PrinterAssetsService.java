package aiims.assets.record.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aiims.assets.record.exception.NotFoundException;
import aiims.assets.record.models.PrinterAssets;
import aiims.assets.record.repositories.PrinterAssetsRepository;

import java.util.List;

@Service
public class PrinterAssetsService {
	@Autowired
    private final PrinterAssetsRepository printerAssetsRepository;

    @Autowired
    public PrinterAssetsService(PrinterAssetsRepository printerAssetsRepository) {
        this.printerAssetsRepository = printerAssetsRepository;
    }

    public List<PrinterAssets> getAllAssets() {
        return printerAssetsRepository.findAll();
    }

    public PrinterAssets getAssetById(Long id) {
        return printerAssetsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Printer Asset not found with id: " + id));
    }

    public PrinterAssets createAsset(PrinterAssets asset) {
        return printerAssetsRepository.save(asset);
    }

    public PrinterAssets updateAsset(Long id, PrinterAssets asset) {
        if (!printerAssetsRepository.existsById(id)) {
            throw new NotFoundException("Printer Asset not found with id: " + id);
        }
        asset.setId(id);
        return printerAssetsRepository.save(asset);
    }

    public void deleteAsset(Long id) {
        if (!printerAssetsRepository.existsById(id)) {
            throw new NotFoundException("Printer Asset not found with id: " + id);
        }
        printerAssetsRepository.deleteById(id);
    }

	
}
