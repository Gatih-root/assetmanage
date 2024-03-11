package aiims.assets.record.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aiims.assets.record.models.Departments;

public interface DepartmentRepo extends JpaRepository<Departments,Long>{
	public Optional<Departments> findByDepartment(String department);

}
