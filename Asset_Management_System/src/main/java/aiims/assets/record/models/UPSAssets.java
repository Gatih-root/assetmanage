package aiims.assets.record.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="tbl_ups_asset" )
public class UPSAssets {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long id;
    
   
    private String ups_name; 

   
    private String type;

    
    private String department;

    
    private String floorNo;

   
    private String room;

    
    private String batterytype;

    
    private String serialNumber;

    private String username;
    
    private String capacity;
    
//    private Date yearOfPurchase;
    
    private String yearOfPurchase;

	public String getYearOfPurchase() {
		return yearOfPurchase;
	}

	public void setYearOfPurchase(String yearOfPurchase) {
		this.yearOfPurchase = yearOfPurchase;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUps_name() {
		return ups_name;
	}

	public void setUps_name(String ups_name) {
		this.ups_name = ups_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getBatterytype() {
		return batterytype;
	}

	public void setBatterytype(String batterytype) {
		this.batterytype = batterytype;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

//	public Date getYearOfPurchase() {
//		return yearOfPurchase;
//	}
//
//	public void setYearOfPurchase(Date yearOfPurchase) {
//		this.yearOfPurchase = yearOfPurchase;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    // Constructor, getters and setters
    
  
}
