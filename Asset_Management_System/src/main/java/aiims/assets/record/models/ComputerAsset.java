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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    private String type;

    @Column(nullable = true)
    private String department;

    @Column(nullable = true)
    private String floorNo;

    @Column(nullable = true)
    private String room;

    @Column(nullable = true)
    private String makeModelSerialNoValue;

    @Column(nullable = true)
    private String serialNumber;

    @Column(nullable = true)
    private String computer_name;

    @Column(nullable = true)
    private String cpu_generation;

    @Column(nullable = true)
    private String cpu_type;

    @Column(nullable = true)
    private String cpu_ram;

    @Column(nullable = true)
    private String os;

    @Column(nullable = true)
    private String os_activated;

    @Column(nullable = true)
    private String aiimsLAN;

    @Column(nullable = true)
    private String deviceConnected;

    @Column(nullable = true)
    private String connectedDevicesDesc;

    @Column(nullable = true)
    private String endPointIp;

    @Column(nullable = true)
    private String edrInstalled;

    @Column(nullable = true)
    private String edr;

    @Column(nullable = true)
    private String edrOther;

    @Column(nullable = true)
    private String usbAllowed;

    @Column(nullable = true)
    private String usbModel;

    @Column(nullable = true)
    private String usbSerailNo;

    @Column(nullable = true)
    private String nacInstalled;

    @Column(nullable = true)
    private String mayaInstalled;

    @Column(nullable = true)
    private String mayaRevokedReason;

    @Column(nullable = true)
    private String mac;

    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private String mtnlConnection;

    @Column(nullable = true)
    private String mtnlConnectionDesc;

    @Column(nullable = true)
    private String ciiApplication;

    @Column(nullable = true)
    private String aiimsInternet;

    @Column(nullable = true)
    private String eofficeAccess;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
