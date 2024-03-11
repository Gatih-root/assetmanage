package aiims.assets.record.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tbl_assets")
public class Assets {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String type;
	private String pcName;
	private String ups_model_no;
	private String printer_serial_no;
	private String status;
	private Date yearOfPurchase;
	private String username;
	private String center;
	private String department;
	private String contact;
	private String printer_interface;
	private String pc_make;
	private String ledgerNo;
	private String ipAddress;
	private String macAddress;
	private String osSp;
	private String avStatus;
	private String accessLevel;
	private String softwareDetails;
	private String hardwareConnected;
	private String makeModelSerialNo;
	private String makeModelSerialNoValue;
	private String floorNo;
	private String roomNo;
	private String os_type;
	private String avName;
	private String networkConnectivity;
	private String inWarranty;
	private Date warranty_period;
	private String configuration_cpu;
	private String configuration_ram;
	private String configuration_hdd;
	private String configuration_other;
	private String cpu_generation;
	private String os_activated;
	private String os_circle;
	private String deviceConnected;
	private String connectedDevices;
	private String mtnlConnection;
	private String mtnlConnectionDesc;
	private String ciiAplication;
	private String aiimsInternet;
	private String eofficeAccess;
    private String printerName;
    private String manufacturer;
    private String model;
    private String serialNumber;
    
   
    private String upsName; 
    private String room;
    private String batterytype;

 

   
    private String capacity;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPcName() {
		return pcName;
	}
	public void setPcName(String pcName) {
		this.pcName = pcName;
	}
	public String getUps_model_no() {
		return ups_model_no;
	}
	public void setUps_model_no(String ups_model_no) {
		this.ups_model_no = ups_model_no;
	}
	public String getPrinter_serial_no() {
		return printer_serial_no;
	}
	public void setPrinter_serial_no(String printer_serial_no) {
		this.printer_serial_no = printer_serial_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getYearOfPurchase() {
		return yearOfPurchase;
	}
	public void setYearOfPurchase(Date yearOfPurchase) {
		this.yearOfPurchase = yearOfPurchase;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPrinter_interface() {
		return printer_interface;
	}
	public void setPrinter_interface(String printer_interface) {
		this.printer_interface = printer_interface;
	}
	public String getPc_make() {
		return pc_make;
	}
	public void setPc_make(String pc_make) {
		this.pc_make = pc_make;
	}
	public String getLedgerNo() {
		return ledgerNo;
	}
	public void setLedgerNo(String ledgerNo) {
		this.ledgerNo = ledgerNo;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getOsSp() {
		return osSp;
	}
	public void setOsSp(String osSp) {
		this.osSp = osSp;
	}
	public String getAvStatus() {
		return avStatus;
	}
	public void setAvStatus(String avStatus) {
		this.avStatus = avStatus;
	}
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getSoftwareDetails() {
		return softwareDetails;
	}
	public void setSoftwareDetails(String softwareDetails) {
		this.softwareDetails = softwareDetails;
	}
	public String getHardwareConnected() {
		return hardwareConnected;
	}
	public void setHardwareConnected(String hardwareConnected) {
		this.hardwareConnected = hardwareConnected;
	}
	public String getMakeModelSerialNo() {
		return makeModelSerialNo;
	}
	public void setMakeModelSerialNo(String makeModelSerialNo) {
		this.makeModelSerialNo = makeModelSerialNo;
	}
	public String getMakeModelSerialNoValue() {
		return makeModelSerialNoValue;
	}
	public void setMakeModelSerialNoValue(String makeModelSerialNoValue) {
		this.makeModelSerialNoValue = makeModelSerialNoValue;
	}
	public String getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getOs_type() {
		return os_type;
	}
	public void setOs_type(String os_type) {
		this.os_type = os_type;
	}
	public String getAvName() {
		return avName;
	}
	public void setAvName(String avName) {
		this.avName = avName;
	}
	public String getNetworkConnectivity() {
		return networkConnectivity;
	}
	public void setNetworkConnectivity(String networkConnectivity) {
		this.networkConnectivity = networkConnectivity;
	}
	public String getInWarranty() {
		return inWarranty;
	}
	public void setInWarranty(String inWarranty) {
		this.inWarranty = inWarranty;
	}
	public Date getWarranty_period() {
		return warranty_period;
	}
	public void setWarranty_period(Date warranty_period) {
		this.warranty_period = warranty_period;
	}
	public String getConfiguration_cpu() {
		return configuration_cpu;
	}
	public void setConfiguration_cpu(String configuration_cpu) {
		this.configuration_cpu = configuration_cpu;
	}
	public String getConfiguration_ram() {
		return configuration_ram;
	}
	public void setConfiguration_ram(String configuration_ram) {
		this.configuration_ram = configuration_ram;
	}
	public String getConfiguration_hdd() {
		return configuration_hdd;
	}
	public void setConfiguration_hdd(String configuration_hdd) {
		this.configuration_hdd = configuration_hdd;
	}
	public String getConfiguration_other() {
		return configuration_other;
	}
	public void setConfiguration_other(String configuration_other) {
		this.configuration_other = configuration_other;
	}
	public String getCpu_generation() {
		return cpu_generation;
	}
	public void setCpu_generation(String cpu_generation) {
		this.cpu_generation = cpu_generation;
	}
	public String getOs_activated() {
		return os_activated;
	}
	public void setOs_activated(String os_activated) {
		this.os_activated = os_activated;
	}
	public String getOs_circle() {
		return os_circle;
	}
	public void setOs_circle(String os_circle) {
		this.os_circle = os_circle;
	}
	public String getDeviceConnected() {
		return deviceConnected;
	}
	public void setDeviceConnected(String deviceConnected) {
		this.deviceConnected = deviceConnected;
	}
	public String getConnectedDevices() {
		return connectedDevices;
	}
	public void setConnectedDevices(String connectedDevices) {
		this.connectedDevices = connectedDevices;
	}
	public String getMtnlConnection() {
		return mtnlConnection;
	}
	public void setMtnlConnection(String mtnlConnection) {
		this.mtnlConnection = mtnlConnection;
	}
	public String getMtnlConnectionDesc() {
		return mtnlConnectionDesc;
	}
	public void setMtnlConnectionDesc(String mtnlConnectionDesc) {
		this.mtnlConnectionDesc = mtnlConnectionDesc;
	}
	public String getCiiAplication() {
		return ciiAplication;
	}
	public void setCiiAplication(String ciiAplication) {
		this.ciiAplication = ciiAplication;
	}
	public String getAiimsInternet() {
		return aiimsInternet;
	}
	public void setAiimsInternet(String aiimsInternet) {
		this.aiimsInternet = aiimsInternet;
	}
	public String getEofficeAccess() {
		return eofficeAccess;
	}
	public void setEofficeAccess(String eofficeAccess) {
		this.eofficeAccess = eofficeAccess;
	}
	public String getPrinterName() {
		return printerName;
	}
	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getUpsName() {
		return upsName;
	}
	public void setUpsName(String upsName) {
		this.upsName = upsName;
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
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
    
}
