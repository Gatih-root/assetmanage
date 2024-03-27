package aiims.assets.record.repositories;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aiims.assets.record.models.ComputerAsset;

@Repository
public interface ComputerAssetRepository extends JpaRepository<ComputerAsset, Long> {
	   public List<ComputerAsset> findByDepartmentAndType(String department,String type);
	   public Optional<ComputerAsset> findByDepartmentAndId(String department,Long id);
	   public List<ComputerAsset> findByType(String type);
	   public List<ComputerAsset> findByDepartment(String department);
	  
}
