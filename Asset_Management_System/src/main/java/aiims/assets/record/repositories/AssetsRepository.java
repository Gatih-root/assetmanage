package aiims.assets.record.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aiims.assets.record.models.Assets;

public interface AssetsRepository extends JpaRepository<Assets, Long> {
	public List<Assets> findByType(String type);
    public List<Assets> findByDepartmentAndType(String department,String type);
    public Optional<Assets> findByIdAndDepartment(Long id, String department);
    public List<Assets> findByDepartmentAndTypeNotIn(String department,String[] types);
    
}



