package aiims.assets.record.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Table(name="tbl_department")

@Entity
public class Departments {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long id;
	
	private String department;

	@Override
	public String toString() {
		return "Department [id=" + id + ", department=" + department + "]";
	}

	
}
