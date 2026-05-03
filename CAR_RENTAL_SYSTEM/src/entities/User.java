package entities;

public class User {

	private String adhaarId;
	private String name;
	private String mobileNo;
	private String emailId;
	private String licenseNumber;
	public User(String adhaarId, String name, String mobileNo, String emailId, String licenseNumber) {
		super();
		this.adhaarId = adhaarId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.licenseNumber = licenseNumber;
	}
	public String getAdhaarId() {
		return adhaarId;
	}
	public void setAdhaarId(String adhaarId) {
		this.adhaarId = adhaarId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
	
}
