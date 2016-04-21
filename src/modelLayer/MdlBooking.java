package modelLayer;

public class MdlBooking {

	private int id;
	private String customerUsername;
	private String employeeUsername;
	private java.sql.Date bookedFrom;
	private java.sql.Date bookedTill;
	private int roomNumber;
	private String roomType;
	private String rates;
	private int numberOfPeople;
	private float price;
	private int discount;
	private float discountAmmount;
	
	public MdlBooking(){
		
	}
	
	public MdlBooking(int id, String customerUsername, String employeeUsername, java.sql.Date bookedFrom, java.sql.Date bookedTill, int roomNumber, String roomType, String rates, int numberOfPeople, float price, int discount, float discountAmmount ){
		
		this.id = id;
		this.customerUsername = customerUsername;
		this.employeeUsername = employeeUsername;
		this.bookedFrom = bookedFrom;
		this.bookedTill = bookedTill;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.rates = rates;
		this.numberOfPeople = numberOfPeople;
		this.price = price;
		this.discount = discount;
		this.discountAmmount = discountAmmount;
	}

	
	public float getDiscountAmmount() {
		return discountAmmount;
	}

	public void setDiscountAmmount(float discountAmmount) {
		this.discountAmmount = discountAmmount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public String getEmployeeUsername() {
		return employeeUsername;
	}

	public java.sql.Date getBookedFrom() {
		return bookedFrom;
	}

	public java.sql.Date getBookedTill() {
		return bookedTill;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public String getRates() {
		return rates;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}

	public void setBookedFrom(java.sql.Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public void setBookedTill(java.sql.Date bookedTill) {
		this.bookedTill = bookedTill;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setRates(String rates) {
		this.rates = rates;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	
	
	
}
