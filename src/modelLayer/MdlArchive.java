package modelLayer;

public class MdlArchive {

	private int id;
	private String name;
	private String surname;
	private String country;
	private String city;
	private String street;
	private String zipCode;
	private String contact;
	private java.sql.Date bookedFrom;
	private java.sql.Date bookedTill;
	private java.sql.Date checkedIn;
	private java.sql.Date checkedOut;
	private int roomNumber;
	
	public MdlArchive(){
		
	}
	
	public MdlArchive(int id, String name, String surname, String country, String city, String street, 
			String zipCode, String contact, java.sql.Date bookedFrom, java.sql.Date bookedTill, java.sql.Date checkedIn, java.sql.Date CheckedOut, int roomNumber){
		
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.bookedFrom = bookedFrom;
		this.bookedTill = bookedTill;
		this.checkedIn = checkedIn;
		this.checkedOut = checkedOut;
		this.roomNumber = roomNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
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

	public java.sql.Date getBookedFrom() {
		return bookedFrom;
	}

	public java.sql.Date getBookedTill() {
		return bookedTill;
	}

	public java.sql.Date getCheckedIn() {
		return checkedIn;
	}

	public java.sql.Date getCheckedOut() {
		return checkedOut;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public void setBookedFrom(java.sql.Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public void setBookedTill(java.sql.Date bookedTill) {
		this.bookedTill = bookedTill;
	}

	public void setCheckedIn(java.sql.Date checkedIn) {
		this.checkedIn = checkedIn;
	}

	public void setCheckedOut(java.sql.Date checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	
	
}
