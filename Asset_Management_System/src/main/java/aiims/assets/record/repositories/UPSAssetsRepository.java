package aiims.assets.record.repositories;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aiims.assets.record.models.ComputerAsset;
import aiims.assets.record.models.PrinterAssets;
import aiims.assets.record.models.UPSAssets;

@Repository
public interface UPSAssetsRepository extends JpaRepository<UPSAssets, Long> {
	   public List<UPSAssets> findByDepartmentAndType(String department,String type);
	   public Optional<UPSAssets> findByDepartmentAndId(String department,Long id);
	   public List<UPSAssets> findByType(String type);
	   public List<UPSAssets> findByDepartment(String department);
}
