package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

import net.proteanit.sql.DbUtils;
import controlLayer.CtrBooking;
import controlLayer.CtrCustomer;
import controlLayer.CtrInvoice;
import controlLayer.CtrRates;
import controlLayer.CtrRoom;
import controlLayer.CtrRoomType;
import modelLayer.MdlBooking;
import modelLayer.MdlCustomer;
import modelLayer.MdlRates;
import modelLayer.MdlRoom;
import modelLayer.MdlRoomType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JRadioButton;

public class GUIInvoice extends JFrame {

	private JPanel contentPane;
	private JTable tableInvoice;
	private static boolean invoiceSuccess = false; //if invoice was confirmed, used in static function on exit
	
	//data passed from customer
	public static String customerUsername;
	public String name;//
	public String surname;//
	public String gender;
	public String country;//
	public String city;//
	public String street;//
	public String zipCode;//
	public String customerType;//
	public String contact;//
	
	//data passed from booking
	public java.sql.Date bookedFrom;//
	public java.sql.Date bookedTill;//
	public java.sql.Date checkedIn;//
	public java.sql.Date checkedOut;//
	public static int bookingId;
	public String employeeUsername;
	public String roomNumber;//
	public String roomType;//
	public String rates;//
	public int numberOfPeople;//
	
	//data passed from rooms, room type and rates
	
	public int roomCapacity;
	
	public float roomTypePrice;
	public int roomTypeCapacity;
	
	public boolean breakfast;
	public boolean lunch;
	public boolean dinner;
	
	//invoice
	
	public int numberOfDays;
	public float charges;
	public float credit;
	public float balance;
	public float total;
	
	//gui
	public JComboBox comboBoxPaymentTypeI;
	public JComboBox comboBoxPaidI;
	public JComboBox comboBoxPaymentOverdueI;
	private JRadioButton rdbtnDiscountPercent;
	private JRadioButton rdbtnDiscountAmmount;
	
	public int id;
	public String paymentType;
	public String paymentDeadline;
	public int discount = 0;
	public float discountAmmount = 0;
	public boolean paid;
	public boolean paymentOverdue;
	private JTextField textFieldDiscountPercent;
	private JButton btnOk;
	
	private JTextArea textPaneInvoice;
	private JTextField textFieldDiscountAmmount;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIInvoice frame = new GUIInvoice(customerUsername, bookingId);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIInvoice(String customerUsername, int bookingId) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				deleteInvoice();
			}
		});
	
		this.customerUsername = customerUsername;
		this.bookingId = bookingId;
		
		//this.customerUsername = "xxx";
		//this.bookingId = 10;
		
		
		initialize();
		loadData();
    	setTextPane();
    	insertCurrentInvoice();
    	lastInserted();
	}

	public void deleteInvoice(){
		
		if(invoiceSuccess == false){
			
			CtrInvoice ctrInvObj = new CtrInvoice();
			ctrInvObj.deleteInvoice();
		}
		
	}
	
	public void initialize(){
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaymentTypeI = new JLabel("Payment type");
		lblPaymentTypeI.setBounds(38, 37, 132, 28);
		lblPaymentTypeI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblPaymentTypeI);
		
		comboBoxPaymentTypeI = new JComboBox();
		comboBoxPaymentTypeI.setBounds(180, 42, 149, 20);
		comboBoxPaymentTypeI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updatePaymentType();
			}
		});
		comboBoxPaymentTypeI.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Credit Card", "Voucher", "Business Voucher", "Advance", "Online Payment", "Mobile Pay"}));
		contentPane.add(comboBoxPaymentTypeI);
		
		JLabel lblPaidI = new JLabel("Paid");
		lblPaidI.setBounds(38, 153, 132, 28);
		lblPaidI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblPaidI);
		
		comboBoxPaidI = new JComboBox();
		comboBoxPaidI.setBounds(180, 153, 149, 20);
		comboBoxPaidI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updatePaid();
			}
		});
		comboBoxPaidI.setModel(new DefaultComboBoxModel(new String[] {"no", "yes"}));
		contentPane.add(comboBoxPaidI);
		
		JLabel lblPaymentOverdueI = new JLabel("Payment overdue");
		lblPaymentOverdueI.setBounds(38, 192, 132, 28);
		lblPaymentOverdueI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblPaymentOverdueI);
		
		comboBoxPaymentOverdueI = new JComboBox();
		comboBoxPaymentOverdueI.setBounds(180, 197, 149, 20);
		comboBoxPaymentOverdueI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updatePaymentOverdue();
			}
		});
		comboBoxPaymentOverdueI.setModel(new DefaultComboBoxModel(new String[] {"no", "yes"}));
		contentPane.add(comboBoxPaymentOverdueI);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(339, 42, 645, 178);
		contentPane.add(scrollPane);
		
		tableInvoice = new JTable();
		scrollPane.setViewportView(tableInvoice);
		
		textFieldDiscountPercent = new JTextField();
		textFieldDiscountPercent.setBounds(180, 81, 149, 20);
		textFieldDiscountPercent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				updateDiscount();
			}
		});
		contentPane.add(textFieldDiscountPercent);
		textFieldDiscountPercent.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(895, 601, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				confirm();
			}
		});
		contentPane.add(btnOk);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 231, 946, 359);
		contentPane.add(scrollPane_1);
		
		textPaneInvoice = new JTextArea();
		scrollPane_1.setViewportView(textPaneInvoice);
		
		rdbtnDiscountPercent = new JRadioButton("Discount (%)");
		rdbtnDiscountPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnDiscountPercent.isSelected()){
					
					convertToPercent();
					discountAmmount = 0;
					textFieldDiscountPercent.setEditable(true);
					textFieldDiscountAmmount.setEditable(false);
					textFieldDiscountAmmount.setText(null);
					rdbtnDiscountAmmount.setSelected(false);
					updateDiscount();		
					}
			}
		});
		rdbtnDiscountPercent.setBounds(38, 80, 109, 23);
		contentPane.add(rdbtnDiscountPercent);
		
		rdbtnDiscountAmmount = new JRadioButton("Discount (dkk)");
		rdbtnDiscountAmmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnDiscountAmmount.isSelected()){
					
					convertToAmmount();
					discount = 0;
					textFieldDiscountAmmount.setEditable(true);
					textFieldDiscountPercent.setEditable(false);
					textFieldDiscountPercent.setText(null);
					rdbtnDiscountPercent.setSelected(false);
					updateDiscount();
					}
			}
		});
		rdbtnDiscountAmmount.setBounds(38, 121, 109, 23);
		contentPane.add(rdbtnDiscountAmmount);
		
		textFieldDiscountAmmount = new JTextField();
		textFieldDiscountAmmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				updateDiscountAmmount();
			}
		});
		textFieldDiscountAmmount.setColumns(10);
		textFieldDiscountAmmount.setBounds(180, 122, 149, 20);
		contentPane.add(textFieldDiscountAmmount);
	}
	
	public void loadData(){
		
		String currentDate;
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		MdlCustomer mdlCusObj = new MdlCustomer();
		CtrCustomer ctrCusObj = new CtrCustomer();
		MdlBooking mdlBookObj = new MdlBooking();
		CtrBooking ctrBookObj = new CtrBooking();
		MdlRoom	mdlRoomObj = new MdlRoom();
		CtrRoom ctrRoomObj = new CtrRoom();
		MdlRoomType mdlRoomTypeObj = new MdlRoomType();
		CtrRoomType ctrRoomTypeObj = new CtrRoomType();
		MdlRates mdlRatesObj = new MdlRates();
		CtrRates ctrRatesObj = new CtrRates();
		
		try{
			
		mdlCusObj = ctrCusObj.selectFromTableCustomer(customerUsername);
		mdlBookObj = ctrBookObj.selectFromTableBooking(Integer.toString(bookingId));
		
		currentDate = dateFormat.format(date);
		
		name = mdlCusObj.getName();
		surname = mdlCusObj.getSurname();
		gender = mdlCusObj.getGender();
		country = mdlCusObj.getCountry();
		city = mdlCusObj.getCity();
		street = mdlCusObj.getStreet();
		zipCode = mdlCusObj.getZipCode();
		contact = mdlCusObj.getContact();
		customerType = mdlCusObj.getCustomerType();
		
		bookedFrom = mdlBookObj.getBookedFrom();
		bookedTill = mdlBookObj.getBookedTill();
		checkedIn = ctrBookObj.getCheckInDate(bookingId);
		checkedOut = java.sql.Date.valueOf(currentDate);
		employeeUsername = mdlBookObj.getEmployeeUsername();
		roomNumber = Integer.toString(mdlBookObj.getRoomNumber());
		roomType = mdlBookObj.getRoomType();
		rates = mdlBookObj.getRates();
		numberOfPeople = mdlBookObj.getNumberOfPeople();
		discount = mdlBookObj.getDiscount();
		
		mdlRoomObj = ctrRoomObj.selectFromTableRoom(roomNumber);
		mdlRoomTypeObj = ctrRoomTypeObj.selectFromTableRoomType(roomType);
		mdlRatesObj = ctrRatesObj.selectFromTableRates(rates);
		
		roomCapacity = mdlRoomObj.getCapacity();
		roomTypePrice = mdlRoomTypeObj.getPrice();
		roomTypeCapacity = mdlRoomTypeObj.getCapacity();
		breakfast = mdlRatesObj.isBreakfast();
		lunch = mdlRatesObj.isLunch();
		dinner = mdlRatesObj.isDinner();
		
		
		if(comboBoxPaidI.getSelectedItem() == "yes"){
			
			paid = true;
		}
		else{
			
			paid = false;
		}
		
		if(comboBoxPaymentOverdueI.getSelectedItem() == "yes"){
			
			paid = true;
		}
		else{
			
			paid = false;
		}
		
		rdbtnDiscountPercent.setSelected(true);
		textFieldDiscountAmmount.setEditable(false);
		textFieldDiscountPercent.setText(Integer.toString(discount));
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Error while loading the data");
		}
			
	}
	
	public void setTextPane(){
		
		CtrInvoice ctrInvObj = new CtrInvoice();
		String textHead;
		String textBooking;
		String textCharges;
		String textFinal;
		
		numberOfDays = ctrInvObj.numberOfDays(bookedFrom, checkedOut);
		
		if(numberOfDays == 0){
			
			numberOfDays = 1;
		}
		
		
		textHead = ctrInvObj.CustomerInfoToString(name, surname, country, city, street, zipCode, contact, customerType);
		textBooking = ctrInvObj.BookingInfoToString(bookedFrom, bookedTill, checkedIn, checkedOut, roomNumber, roomType, rates, numberOfPeople, numberOfDays);
		textCharges = ctrInvObj.ChargesInfoString(roomCapacity, roomTypePrice, breakfast, lunch, dinner, numberOfDays, discount, discountAmmount);

		textFinal = textHead + textBooking +textCharges;
		
		textPaneInvoice.setText(textFinal);
	}
	
	public void lastInserted(){
		
		ResultSet rs;
		CtrInvoice ctrInvObj = new CtrInvoice();
		
		rs = ctrInvObj.lastUpdated();
		try {
			
			while(rs.next()){
				
				id = rs.getInt("id");
			}
			
			tableInvoice.setModel(DbUtils.resultSetToTableModel(ctrInvObj.lastUpdated()));
		} 
		catch (SQLException e) {
			
			System.out.println("Error while getting last inserted invoice");
		}
	}
	
	public void insertCurrentInvoice(){
		
		CtrInvoice ctrInvObj = new CtrInvoice();
		boolean success = false;
				
		try{
			
	if(numberOfDays == 0){
				
				numberOfDays = 1;
			}
			
			
			total = ctrInvObj.calculatetTotal(roomTypePrice, breakfast, lunch, dinner, numberOfDays, discount); 
			paymentType = (String) comboBoxPaymentTypeI.getSelectedItem();
			paymentDeadline = ctrInvObj.setPaymentDeadline(paymentType);
			paid = false;
			paymentOverdue = false;
			
			if(comboBoxPaidI.getSelectedItem()== "yes"){
				
				paid = true;
			}
			
			if(comboBoxPaymentOverdueI.getSelectedItem()== "yes"){
				
				paymentOverdue = true;
			}
			
			success = ctrInvObj.addInvoice(name, surname, employeeUsername, total, paymentType, paymentDeadline, paid, paymentOverdue);
			
			if(success != true){
		
				JOptionPane.showMessageDialog(null, "An Error has accured while saving the invoice data");
			}

		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
		}
	}
	
	public void updatePaymentType(){
		
		boolean success = false;
		CtrInvoice ctrInvObj = new CtrInvoice();
		paymentType = (String) comboBoxPaymentTypeI.getSelectedItem();
		
		if(paymentType == "Advance"){
			
			comboBoxPaidI.setSelectedItem("yes");
			paid = true;
		}
		
		success = ctrInvObj.updatePaymentType(paymentType, id, paid);
		
		if(success == false){
			
			JOptionPane.showMessageDialog(null, "An Error has accured while saving the invoice data");
		}
		
		lastInserted();
	}
	
	public void updatePaid(){
		
		boolean success = false;
		CtrInvoice ctrInvObj = new CtrInvoice();
		paid = false;
		
		if(comboBoxPaidI.getSelectedItem()== "yes"){
			
			paid = true;
		}
		
		success = ctrInvObj.updatePaid(paid, id);
		
		if(success == false){
			
			JOptionPane.showMessageDialog(null, "An Error has accured while saving the invoice data");
		}
		lastInserted();
	}
	
	public void updatePaymentOverdue(){
		
		boolean success = false;
		CtrInvoice ctrInvObj = new CtrInvoice();
		paymentOverdue = false;
		
		if(comboBoxPaymentOverdueI.getSelectedItem() == "yes"){
			
			paymentOverdue = true;
		}
		
		success = ctrInvObj.updatePaymentOverdue(paymentOverdue, id);
		
		if(success == false){
			
			JOptionPane.showMessageDialog(null, "An Error has accured while saving the invoice data");
		}
		lastInserted();
	}
	
	public void updateDiscount(){
		
		boolean success;
		CtrInvoice ctrInvObj = new CtrInvoice();

			
			if(textFieldDiscountPercent.getText().length() == 0){
				
				discount = 0;
			}
			else{
				
				discount = Integer.parseInt(textFieldDiscountPercent.getText());
			}
			
			
			if(discount < 0 || discount >100){
				
				discount = 0;
			}
			
			if(numberOfDays == 0){
				
				numberOfDays = 1;
			}
			
			
			total = ctrInvObj.calculatetTotal(roomTypePrice, breakfast, lunch, dinner, numberOfDays, discount);
			
				
			success = ctrInvObj.updatePrice(total, id);
			setTextPane();
				
			if(success == false){
					
				JOptionPane.showMessageDialog(null, "An Error has accured while saving the invoice data");
			}
			lastInserted();
	}
	
	public void updateDiscountAmmount(){
		
		boolean success;
		CtrInvoice ctrInvObj = new CtrInvoice();
		
		if(numberOfDays == 0){
			
			numberOfDays = 1;
		}
		
		
		float price = ctrInvObj.calculatetTotal(roomTypePrice, breakfast, lunch, dinner, numberOfDays, 0);
					
			if(textFieldDiscountAmmount.getText().length() == 0){
				
				discountAmmount = 0;
			}
			else{
				
				discountAmmount = Float.parseFloat(textFieldDiscountAmmount.getText());
			}
			
			if(discountAmmount < 0 || discountAmmount> price){
				
				discountAmmount = 0;
			}
			
		
			if(numberOfDays == 0){
				
				numberOfDays = 1;
			}
			
			total = ctrInvObj.calculatetTotalAmmount(roomTypePrice, breakfast, lunch, dinner, numberOfDays, discountAmmount);		
			
			success = ctrInvObj.updatePrice(total, id);
			setTextPane();
				
			if(success == false){
					
				JOptionPane.showMessageDialog(null, "An Error has accured while saving the invoice data");
			}
			lastInserted();
	}
	
	public void convertToPercent(){
		
		CtrInvoice ctrInvObj = new CtrInvoice();
		float price;
		boolean success = false;
		
		discountAmmount = Float.parseFloat(textFieldDiscountAmmount.getText());
		
		if(numberOfDays == 0){
			
			numberOfDays = 1;
		}
		
		
		price = ctrInvObj.calculatetTotal(roomTypePrice, breakfast, lunch, dinner, numberOfDays, 0);
		
		discount = Math.round(discountAmmount /  (price / 100));
		price = ctrInvObj.calculatetTotal(roomTypePrice, breakfast, lunch, dinner, numberOfDays, discount);
		
		success = ctrInvObj.updatePrice(total, id);
		setTextPane();
			
		if(success == false){
				
			JOptionPane.showMessageDialog(null, "An Error has accured while saving the invoice data");
		}
		lastInserted();
		
		textFieldDiscountPercent.setText(Integer.toString(discount));
	}
	
	public void convertToAmmount(){
		
		CtrInvoice ctrInvObj = new CtrInvoice();
		float price;
		
		discount = Integer.parseInt(textFieldDiscountPercent.getText());
		
		if(numberOfDays == 0){
			
			numberOfDays = 1;
		}
		
		
		price = ctrInvObj.calculatetTotal(roomTypePrice, breakfast, lunch, dinner, numberOfDays, 0);
		
		discountAmmount = price / 100 * discount;
		textFieldDiscountAmmount.setText(Float.toString(discountAmmount));
	}
	
	public void confirm(){
		
		
		String absolutePath = "";
		boolean success = false;
		CtrInvoice ctrInvObj = new CtrInvoice();
		String content = textPaneInvoice.getText();
		String fileName = name + "_" + surname + "_" + id;
		float price = ctrInvObj.calculatetTotal(roomTypePrice, breakfast, lunch, dinner, numberOfDays, 0);
		
		//convert ammount to discount
		if(discountAmmount != 0){
			convertToPercent();
		}
		
		//update price
		price = ctrInvObj.calculatetTotal(roomTypePrice, breakfast, lunch, dinner, numberOfDays, discount);
		
		//update table
		success = ctrInvObj.updatePrice(price, id);
		
		if(success == false){
			
			JOptionPane.showMessageDialog(null, "An Error has accured while saving the invoice data");
		}
		
		String path = "C:\\Users\\MPJ\\Desktop\\invoice\\";
		
		try{
		
		FileWriter writer = new FileWriter( path + fileName + ".txt");		
		BufferedWriter bw = new BufferedWriter (writer);
		textPaneInvoice.write( bw ); 
		bw.close();
		textPaneInvoice.requestFocus();
		
		invoiceSuccess = true;
		
		}
		catch(Exception e){
			
			System.out.println("Error while saving text file");
		}
		dispose();
	}
}
