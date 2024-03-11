package aiims.assets.record.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aiims.assets.record.models.Departments;
import aiims.assets.record.repositories.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;


    public List<Departments> findAll() {
        return departmentRepo.findAll();
    }

    public Departments findById(Long id) {
        return departmentRepo.findById(id).orElse(null);
    }

    public Departments save(Departments department) {
        return departmentRepo.save(department);
    }

    public void deleteById(Long id) {
        departmentRepo.deleteById(id);
    }

//	public Departments save(Departments department) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}
