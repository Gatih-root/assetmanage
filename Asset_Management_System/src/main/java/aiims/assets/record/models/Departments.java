package aiims.assets.record.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="tbl_department")

@Entity
public class Departments {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long id;
	
	private String department;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}

	
  

	@Override
	public String toString() {
		return "Department [id=" + id + ", department=" + department + "]";
	}

	

	
}
