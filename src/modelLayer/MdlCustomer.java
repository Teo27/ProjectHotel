package modelLayer;

public class MdlCustomer {

	
	private String username;
	private String password;
	private String name;
	private String surname;
	private String customerType;
	private String gender;
	private String country;
	private String city;
	private String street;
	private String zipCode;
	private String contact; 

	public MdlCustomer(){
		
	}
	
	public MdlCustomer(String username, String name, 
			String surname, String customerType, String gender, String country, String city, String street, String zipCode, String contact){
		
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.customerType = customerType;
		this.gender = gender;
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.contact = contact;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getCustomerType() {
		return customerType;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
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
	
	
}
