package aiims.assets.record.models;

import java.util.Date;
import java.util.Set;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_users")
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String department;
	private String username;

	private String mobileNo;

	private String email;

	private String password;

	private String role;
	private String status;
	private String userid;
	private Date lastlogin;
	
	private int invaledAttemts;
	
	  
	

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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public Date getLastlogin() {
		return lastlogin;
	}


	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}



	public int getInvaledAttemts() {
		return invaledAttemts;
	}


	public void setInvaledAttemts(int invaledAttemts) {
		this.invaledAttemts = invaledAttemts;
	}


	@Override
	public String toString() {
		return "Employe [id=" + id + ", department=" + department + ", username=" + username + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", password=" + password + ", role=" + role + ", status=" + status + ", userid="
				+ userid + ", lastlogin=" + lastlogin + ", InvaledAttemts=" + invaledAttemts + "]";
	}


	public void setAccountNonLocked(boolean b) {
		// TODO Auto-generated method stub
		
	}




	


	

}
