package modelLayer;

public class MdlEmployee {

	
	private String username;
	private String password;
	private int securityLevel;
	private String name;
	private String surname;
	private String gender;
	private String country;
	private String city;
	private String street;
	private String zipCode;
	private String contact; 
	private float salary;
	private String employedSince;
	private String contractType;
	private int ssn;
	private int departmentNumber;
	
	public MdlEmployee(){
		
	}
	
	public MdlEmployee(String username, String password, int securityLevel, String name, String surname, 
			String gender, String country, String city, String street, String zipCode, String contact, 
			float salary, String employedSince, String contractType, int ssn, int departmentNumber){
		
		this.username = username;
		this.password = password;
		this.securityLevel = securityLevel;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.contact = contact;
		this.salary = salary;
		this.employedSince = employedSince;
		this.contractType = contractType;
		this.ssn = ssn;
		this.departmentNumber = departmentNumber;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getSecurityLevel() {
		return securityLevel;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getContact() {
		return contact;
	}

	public float getSalary() {
		return salary;
	}

	public String getEmployedSince() {
		return employedSince;
	}

	public String getContractType() {
		return contractType;
	}

	public int getSsn() {
		return ssn;
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public void setEmployedSince(String employedSince) {
		this.employedSince = employedSince;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}


	
	
}
