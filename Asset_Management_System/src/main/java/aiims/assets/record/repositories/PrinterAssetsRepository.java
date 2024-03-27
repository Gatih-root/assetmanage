package aiims.assets.record.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aiims.assets.record.models.ComputerAsset;
import aiims.assets.record.models.PrinterAssets;

@Repository
public interface PrinterAssetsRepository extends JpaRepository<PrinterAssets, Long> {
	   public List<PrinterAssets> findByDepartment(String department);
	   public List<PrinterAssets> findByDepartmentAndType(String department,String type);
	   public Optional<PrinterAssets> findByDepartmentAndId(String department,Long id);
	   public List<PrinterAssets> findByType(String type);
	  
	
}