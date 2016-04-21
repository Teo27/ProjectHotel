package modelLayer;

public class MdlInvoice {

	private int id;
	private String name;
	private String surname;
	private String employee;
	private float price;
	private String paymentType;
	private String paymentDeadline;
	private boolean paid;
	private boolean paymentOverdue;
	
	public MdlInvoice(){
		
	}
	
	public MdlInvoice(int id, String name, String surname, String employee, float price, String paymentType, String paymentDeadline, boolean paid, boolean paymentOverdue){
		
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.employee = employee;
		this.price = price;
		this.paymentType = paymentType;
		this.paymentDeadline = paymentDeadline;
		this.paid = paid;
		this.paymentOverdue = paymentOverdue;
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

	public String getEmployee() {
		return employee;
	}

	public float getPrice() {
		return price;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public String getPaymentDeadline() {
		return paymentDeadline;
	}

	public boolean isPaid() {
		return paid;
	}

	public boolean isPaymentOverdue() {
		return paymentOverdue;
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

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setPaymentDeadline(String paymentDeadline) {
		this.paymentDeadline = paymentDeadline;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public void setPaymentOverdue(boolean paymentOverdue) {
		this.paymentOverdue = paymentOverdue;
	}
	
	
}
