package aiims.assets.record.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tbl_computer_asset")
public class ComputerAsset {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long id;

    
    private String type;
    private String department;
    private String floorNo;
    private String room;
    private String makeModelSerialNoValue;
    private String serialNumber;
    private String computer_name;
    private String cpu_generation;
    private String cpu_type;
    private String cpu_ram;
    private String os;
    private String os_activated;
    private String aiimsLAN;
    private String deviceConnected;
    private String connectedDevicesDesc;
    private String endPointIp;
    private String edrInstalled;
    private String edr;
    private String edrOther;
    private String usbAllowed;
    private String usbModel;
    private String usbSerailNo;
    private String nacInstalled;
    private String mayaInstalled;
    private String mayaRevokedReason;
    private String mac;
    private String username;
    private String mtnlConnection;
    private String mtnlConnectionDesc;
    private String ciiApplication;
    private String aiimsInternet;
    private String eofficeAccess;
    

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

	public String getMakeModelSerialNoValue() {
		return makeModelSerialNoValue;
	}

	public void setMakeModelSerialNoValue(String makeModelSerialNoValue) {
		this.makeModelSerialNoValue = makeModelSerialNoValue;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getComputer_name() {
		return computer_name;
	}

	public void setComputer_name(String computer_name) {
		this.computer_name = computer_name;
	}

	public String getCpu_generation() {
		return cpu_generation;
	}

	public void setCpu_generation(String cpu_generation) {
		this.cpu_generation = cpu_generation;
	}

	public String getCpu_type() {
		return cpu_type;
	}

	public void setCpu_type(String cpu_type) {
		this.cpu_type = cpu_type;
	}

	public String getCpu_ram() {
		return cpu_ram;
	}

	public void setCpu_ram(String cpu_ram) {
		this.cpu_ram = cpu_ram;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOs_activated() {
		return os_activated;
	}

	public void setOs_activated(String os_activated) {
		this.os_activated = os_activated;
	}

	public String getAiimsLAN() {
		return aiimsLAN;
	}

	public void setAiimsLAN(String aiimsLAN) {
		this.aiimsLAN = aiimsLAN;
	}

	public String getDeviceConnected() {
		return deviceConnected;
	}

	public void setDeviceConnected(String deviceConnected) {
		this.deviceConnected = deviceConnected;
	}

	public String getConnectedDevicesDesc() {
		return connectedDevicesDesc;
	}

	public void setConnectedDevicesDesc(String connectedDevicesDesc) {
		this.connectedDevicesDesc = connectedDevicesDesc;
	}

	public String getEndPointIp() {
		return endPointIp;
	}

	public void setEndPointIp(String endPointIp) {
		this.endPointIp = endPointIp;
	}

	public String getEdrInstalled() {
		return edrInstalled;
	}

	public void setEdrInstalled(String edrInstalled) {
		this.edrInstalled = edrInstalled;
	}

	public String getEdr() {
		return edr;
	}

	public void setEdr(String edr) {
		this.edr = edr;
	}

	public String getEdrOther() {
		return edrOther;
	}

	public void setEdrOther(String edrOther) {
		this.edrOther = edrOther;
	}

	public String getUsbAllowed() {
		return usbAllowed;
	}

	public void setUsbAllowed(String usbAllowed) {
		this.usbAllowed = usbAllowed;
	}

	public String getUsbModel() {
		return usbModel;
	}

	public void setUsbModel(String usbModel) {
		this.usbModel = usbModel;
	}

	public String getUsbSerailNo() {
		return usbSerailNo;
	}

	public void setUsbSerailNo(String usbSerailNo) {
		this.usbSerailNo = usbSerailNo;
	}

	public String getNacInstalled() {
		return nacInstalled;
	}

	public void setNacInstalled(String nacInstalled) {
		this.nacInstalled = nacInstalled;
	}

	public String getMayaInstalled() {
		return mayaInstalled;
	}

	public void setMayaInstalled(String mayaInstalled) {
		this.mayaInstalled = mayaInstalled;
	}

	public String getMayaRevokedReason() {
		return mayaRevokedReason;
	}

	public void setMayaRevokedReason(String mayaRevokedReason) {
		this.mayaRevokedReason = mayaRevokedReason;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getCiiApplication() {
		return ciiApplication;
	}

	public void setCiiApplication(String ciiApplication) {
		this.ciiApplication = ciiApplication;
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

    // Constructor, getters and setters
    
}
