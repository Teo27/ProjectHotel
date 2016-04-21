package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

import modelLayer.MdlBooking;
import modelLayer.MdlCustomer;
import modelLayer.MdlEmployee;
import modelLayer.MdlInvoice;
import modelLayer.MdlRates;
import modelLayer.MdlRoom;
import modelLayer.MdlRoomType;
import net.proteanit.sql.DbUtils;
import controlLayer.CtrArchive;
import controlLayer.CtrBooking;
import controlLayer.CtrCustomer;
import controlLayer.CtrCustomerType;
import controlLayer.CtrDepartment;
import controlLayer.CtrEmployee;
import controlLayer.CtrInvoice;
import controlLayer.CtrRates;
import controlLayer.CtrRoom;
import controlLayer.CtrRoomType;
import controlLayer.CtrSecurityLevel;
import controlLayer.CtrStatistics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.SystemColor;

import javax.swing.JTextPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JRadioButton;

import java.awt.Color;

import javax.swing.UIManager;

import dbLayer.DbConnection;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GUIMain extends JFrame {

	//declare static variables
	static boolean access;
	static String username;
	
	//declare connection
	Connection connection;
	
	
	//declare shared variables out of tabbed pane
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JLabel lblUsernameMain;
	private JLabel lblDateMain;
	private JLabel lblConnectionMain;
	private JMenuItem mntmOpenInvoice;
	private JMenuItem mntmHelp;
	
	//declare variable in Pane CUSTOMER
	public String genderC = "male";
	private JTable tableCustomer;
	private JScrollPane scrollPaneC;
	private JTextField textFieldUsernameC;
	private JTextField textFieldNameC;
	private JTextField textFieldSurnameC;
	private JTextField textFieldCountryC;
	private JTextField textFieldCityC;
	private JTextField textFieldStreetC;
	private JTextField textFieldZipCodeC;
	private JTextField textFieldContactC;
	private JTextField textFieldSearchC;
	private JLabel lblUsernameC;
	private JLabel lblNameC;
	private JLabel lblSurnameC;
	private JLabel lblCustomerTypeC;
	private JLabel lblGenderC;
	private JLabel lblCountryC;
	private JLabel lblCityC;
	private JLabel lblStreetC;
	private JLabel lblZipCodeC;
	private JLabel lblContactC;
	private JTextPane textPaneC;
	private JComboBox comboBoxC;
	private JComboBox comboBoxCustomerTypeC;
	private JRadioButton rdbtnGenderFC;
	private JRadioButton rdbtnGenderMC;
	
	//declare variable in Pane BOOKING
	private JTable tableBooking;
	private JTable tableBookingRooms;
	private JScrollPane scrollPaneB;
	private JTextField textFieldSearchB;
	private JTextField textFieldIdB;
	private JTextField textFieldCustomerUsernameB;
	private JTextField textFieldEmployeeUsernameB;
	private JTextField textFieldBookedFromB;
	private JTextField textFieldBookedTilB;
	private JTextField textFieldRoomNumberB;
	private JTextField textFieldSearchBookedFromB;
	private JTextField textFieldSearchBookedTillB;
	private JTextField textFieldDiscountPercentB;
	private JTextField textFieldDiscountAmmountB;
	private JTextField textFieldPriceB;
	private JLabel lblIdB;
	private JLabel lblCustomerUsernameB;
	private JLabel lblEmployeeUsernameB;
	private JLabel lblBookedFromB;
	private JLabel lblBookedTilB;
	private JLabel lblRoomNumberB;
	private JLabel lblRoomTypeB;
	private JLabel lblRatesNumberB;
	private JLabel lblNumberOfPeopleB;
	private JButton btnAddB;
	private JButton btnUpdateB;
	private JButton btnDeleteB;
	private JButton btnRefreshB;
	private JTextPane textPaneB;
	private JRadioButton rbBtnDiscountAmmountB;
	private JRadioButton rbBtnDiscountPercentB;
	private JComboBox comboBoxB;
	private JComboBox comboBoxRoomTypeB;
	private JComboBox comboBoxRatesB;
	private JComboBox comboBoxNumberOfPeopleB;
	
	//declare variable in Pane EMPLOYEE
	public String genderE = "male";
	private JTable tableEmployee;
	private JScrollPane scrollPaneEmployee;
	private JComboBox comboBoxE;
	private JComboBox comboBoxSecurityLevelE;
	private JComboBox comboBoxDepartmentE;
	private JTextField textFieldSearchE;
	private JTextField textFieldUsernameE;
	private JTextField textFieldNameE;
	private JTextField textFieldSurnameE;
	private JTextField textFieldCountryE;
	private JTextField textFieldCityE;
	private JTextField textFieldStreetE;
	private JTextField textFieldZipCodeE;
	private JTextField textFieldContactE;
	private JTextField textFieldSsnE;
	private JTextField textFieldContractTypeE;
	private JTextField textFieldEmployedSinceE;
	private JTextField textFieldSalaryE;
	private JLabel lblUsernameE;
	private JLabel lblSecurityLevelE;
	private JLabel lblNameE;
	private JLabel labelSurnameE;
	private JLabel lblGenderE;
	private JLabel lblCountryE;
	private JLabel lblCityE;
	private JLabel lblStreetE;
	private JLabel lblZipCodeE;
	private JLabel lblContactE;
	private JLabel lblDepartmentNumberE;
	private JLabel lblSsnE;
	private JLabel lblContractTypeE;
	private JLabel lblEmployedSinceE;
	private JLabel lblSalaryE;
	private JButton btnAddE;
	private JButton btnUpdateE;
	private JButton btnDeleteE;
	private JButton btnRefreshE;
	private JRadioButton rdbtnMaleE;
	private JRadioButton rdbtnFemaleE;
	private JTextPane textPaneE;
	
	//declare variable in Pane ROOM
	private JTable tableRoom;
	private JTable tableRoomType;
	private JTable tableRates;
	private JButton btnRefreshR;
	private JButton btnAddR;
	private JButton btnUpdateR;
	private JButton btnDeleteR;
	private JButton btnAddRoomTypeR;
	private JButton btnUpdateRoomTypeR;
	private JButton btnDeleteRoomTypeR;
	private JButton btnAddRatesR;
	private JButton btnUpdateRatesR;
	private JButton btnDeleteRatesR;
	private JComboBox comboBoxR;
	private JComboBox comboBoxRatesBreakfastR;
	private JComboBox comboBoxRatesLunchR;
	private JComboBox comboBoxRatesDinnerR;
	private JComboBox comboBoxCapacityR;
	private JTextField textFieldSearchR;
	private JTextField textFieldRoomNumberR;
	private JTextField textFieldRoomTypeNameR;
	private JTextField textFieldRatesNameR;
	private JTextField textFieldRoomTypePriceR;
	private JTextField textFieldRoomTypeCapacityR;
	private JLabel lblRoomNumberR;
	private JLabel lblCapacityR;
	private JLabel lblRatesBreakfastR;
	private JLabel lblRatesLunchR;
	private JLabel lblRatesDinnerR;
	private JLabel lblRoomTypeCapacityR;
	private JLabel lblRoomTypeNameR;
	private JLabel lblRoomTypePriceR;
	private JLabel lblRatesNameR;
	private JTextPane textPaneR;
	private JTextPane textPaneRoomTypeR;
	private JTextPane textPaneRatesR;
	private JScrollPane scrollRates;
	private JScrollPane scrollPaneRoomType;
	
	//declare variable in Pane ARCHIVE
	private JPanel panelArchive;
	private JTable tableArchive;
	private JTextField textFieldSearchA;
	private JComboBox comboBoxA;

	//declare variable in Pane INVOICE
	private JTable tableInvoice;
	private JTextArea textAreaInvoice;
	private JScrollPane scrollPaneInvoiceText;
	private JComboBox comboBoxSearchI;
	private JTextField textFieldSearchI;
	
	//declare variable in Pane STATISTICS
	private JPanel panelStatistics;
	private JTextField textFieldRegisteredCustomersS;
	private JTextField textFieldDanishCustomersS;
	private JTextField textFieldRegisteredEmployeesS;
	private JTextField textFieldAvarageSalaryS;
	private JTextField textFieldNumberOfRoomsS;
	private JTextField textFieldCheckedInBookingsS;
	private JTextField textFieldNumberOfBookingsS;
	private JTextField textFieldOccupancyRateS;
	private JTextField textFieldAvaragePriceS;
	private JButton btnRefreshS;
	private JLabel lblRooms;
	private JLabel lblNumberOfRoomsS;
	private JLabel lblBooking;
	private JLabel lblNumberOfBookingsS;
	private JLabel lblCheckedInBookingsS;
	private JComboBox comboBoxRoomNumberS;
	private JComboBox comboBoxYearS;


	//launch
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain main = new GUIMain(access, username);
					main.setLocation(0, 0);
					main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//constructor
	public GUIMain(boolean access, String username) {
		
		//set access to show all PANES
		//set username of employee to set label of who is logged in
		this.access = access;
		this.username = username;
			
		//this.access = true;
		//this.username = "default";
		
		//initialize parts available to the employee
		initializeShared();
		initializeBooking();
		initializeCustomer();
		initializeStatistics();
		
		//refresh tables available to the employee
		refreshTableBooking();
		refreshTableCustomer();
		refreshStatistics();
		
		//fill all combo boxes available to the employee
		fillComboBoxRoomS();
		fillComboBoxYearS();
		fillComboBoxNumberOfPeople(10);
		fillComboBoxCustomerTypeC();
		fillComboBoxRoomType();
		fillComboBoxRates();
		
		//show only to user with access (manager)
		if(this.access == true){
			
		//initialize Panes visible to managers only
		initializeEmployee();
		initializeRoom();
		initializeArchive();
		initializeInvoice();
		
		//refresh tables visible to managers only
		refreshTableEmployee();
		refreshTableRoom();
		refreshTableRoomType();
		refreshTableRates();
		refreshTableInvoice();
		refreshTableArchive();
		
		//fill comboBoxes visible to managers only
		fillComboBoxSecurityLevelE();
		fillComboBoxDepartment();
		fillComboBoxCapacity();
		}
		
		//set label of connected user,connection and date, run thread for date, run thread fo connection
		setMainInfoLabels(access);
	}
	
	public void initializeShared(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1603, 875);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnMenu = new JMenu("Menu      ");
		menuBar.add(mnMenu);
		
		//ACCESS to the INVOICE text files only if MANAGE
		if(access == true){
			mntmOpenInvoice = new JMenuItem("Open Invoice");
			mntmOpenInvoice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					openFile();
				}
			});
			mnMenu.add(mntmOpenInvoice);
		}
		mntmHelp = new JMenuItem("Help");
		mnMenu.add(mntmHelp);
		JMenuItem mntmExit = new JMenuItem("Exit                ");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnMenu.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLocation(0, 0);
		contentPane.setLayout(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 42, 1564, 770);
		contentPane.add(tabbedPane);
		
		lblUsernameMain = new JLabel("");
		lblUsernameMain.setBounds(1274, 16, 123, 25);
		lblUsernameMain.setFont(new Font("Tahoma", Font.ITALIC, 13));
		contentPane.add(lblUsernameMain);
		
		lblConnectionMain = new JLabel("");
		lblConnectionMain.setBounds(1541, 11, 46, 37);
		contentPane.add(lblConnectionMain);
		
		lblDateMain = new JLabel("");
		lblDateMain.setBounds(1407, 16, 167, 25);
		lblDateMain.setFont(new Font("Tahoma", Font.ITALIC, 13));
		contentPane.add(lblDateMain);
	}
	
	public void initializeCustomer(){
		
		
		JPanel panelCustomer = new JPanel();
		tabbedPane.addTab("Customer         ", null, panelCustomer, null);
		panelCustomer.setLayout(null);
		
		scrollPaneC = new JScrollPane();
		scrollPaneC.setBounds(359, 85, 1190, 651);
		panelCustomer.add(scrollPaneC);
		
		tableCustomer = new JTable();
		tableCustomer.setBackground(UIManager.getColor("activeCaption"));
		tableCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tableCustomerClick();
			}
		});
		scrollPaneC.setViewportView(tableCustomer);
		
		textFieldUsernameC = new JTextField();
		textFieldUsernameC.setBounds(149, 85, 200, 25);
		panelCustomer.add(textFieldUsernameC);
		textFieldUsernameC.setColumns(10);
		
		textFieldNameC = new JTextField();
		textFieldNameC.setColumns(10);
		textFieldNameC.setBounds(149, 121, 200, 25);
		panelCustomer.add(textFieldNameC);
		
		textFieldSurnameC = new JTextField();
		textFieldSurnameC.setColumns(10);
		textFieldSurnameC.setBounds(149, 157, 200, 25);
		panelCustomer.add(textFieldSurnameC);
		
		textFieldCountryC = new JTextField();
		textFieldCountryC.setColumns(10);
		textFieldCountryC.setBounds(149, 293, 200, 25);
		panelCustomer.add(textFieldCountryC);
		
		textFieldCityC = new JTextField();
		textFieldCityC.setColumns(10);
		textFieldCityC.setBounds(149, 329, 200, 25);
		panelCustomer.add(textFieldCityC);
		
		textFieldStreetC = new JTextField();
		textFieldStreetC.setColumns(10);
		textFieldStreetC.setBounds(149, 365, 200, 25);
		panelCustomer.add(textFieldStreetC);
		
		textFieldZipCodeC = new JTextField();
		textFieldZipCodeC.setColumns(10);
		textFieldZipCodeC.setBounds(149, 401, 200, 25);
		panelCustomer.add(textFieldZipCodeC);
		
		textFieldContactC = new JTextField();
		textFieldContactC.setColumns(10);
		textFieldContactC.setBounds(149, 437, 200, 25);
		panelCustomer.add(textFieldContactC);
		
		lblUsernameC = new JLabel("Username");
		lblUsernameC.setBounds(46, 85, 93, 25);
		panelCustomer.add(lblUsernameC);
		
		lblNameC = new JLabel("Name");
		lblNameC.setBounds(46, 121, 93, 25);
		panelCustomer.add(lblNameC);
		
		lblSurnameC = new JLabel("Surname");
		lblSurnameC.setBounds(46, 157, 93, 25);
		panelCustomer.add(lblSurnameC);
		
		lblCustomerTypeC = new JLabel("Customer type");
		lblCustomerTypeC.setBounds(46, 193, 93, 25);
		panelCustomer.add(lblCustomerTypeC);
		
		lblGenderC = new JLabel("Gender");
		lblGenderC.setBounds(46, 229, 93, 25);
		panelCustomer.add(lblGenderC);
		
		lblCountryC = new JLabel("Country");
		lblCountryC.setBounds(46, 293, 93, 25);
		panelCustomer.add(lblCountryC);
		
		lblCityC = new JLabel("City");
		lblCityC.setBounds(46, 329, 93, 25);
		panelCustomer.add(lblCityC);
		
		lblStreetC = new JLabel("Street");
		lblStreetC.setBounds(46, 365, 93, 25);
		panelCustomer.add(lblStreetC);
		
		lblZipCodeC = new JLabel("Zip code");
		lblZipCodeC.setBounds(46, 401, 93, 25);
		panelCustomer.add(lblZipCodeC);
		
		lblContactC = new JLabel("Contact");
		lblContactC.setBounds(46, 437, 93, 25);
		panelCustomer.add(lblContactC);
		
		textFieldSearchC = new JTextField();
		textFieldSearchC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				searchCustomer();
			}
		});
		textFieldSearchC.setColumns(10);
		textFieldSearchC.setBounds(1329, 54, 220, 25);
		panelCustomer.add(textFieldSearchC);
		
		JButton btnAddC = new JButton("Add");
		btnAddC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addCustomer();
			}
		});
		btnAddC.setBounds(46, 706, 90, 30);
		panelCustomer.add(btnAddC);
		
		JButton btnUpdateC = new JButton("Update");
		btnUpdateC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateCustomer();
			}
		});
		btnUpdateC.setBounds(153, 706, 90, 30);
		panelCustomer.add(btnUpdateC);
		
		JButton btnDeleteC = new JButton("Delete");
		btnDeleteC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteCustomer();
			}
		});
		btnDeleteC.setBounds(259, 706, 90, 30);
		panelCustomer.add(btnDeleteC);
		
		JButton btnRefreshC = new JButton("Refresh");
		btnRefreshC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				refreshTableCustomer();
			}
		});
		btnRefreshC.setBounds(359, 54, 90, 25);
		panelCustomer.add(btnRefreshC);
		
		comboBoxC = new JComboBox();
		comboBoxC.setModel(new DefaultComboBoxModel(new String[] {"Username", "Password", "Name", "Surname", "Customer_type", "Gender", "Country", "City", "Street", "Zip_code", "Contact"}));
		comboBoxC.setBounds(1157, 54, 162, 25);
		panelCustomer.add(comboBoxC);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(48, 530, 301, 165);
		panelCustomer.add(scrollPane_1);
		
		textPaneC = new JTextPane();
		scrollPane_1.setViewportView(textPaneC);
		
		comboBoxCustomerTypeC = new JComboBox();
		comboBoxCustomerTypeC.setBounds(149, 193, 200, 20);
		panelCustomer.add(comboBoxCustomerTypeC);
		
		rdbtnGenderMC = new JRadioButton("Male");
		rdbtnGenderMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnGenderMC.isSelected()){
					genderC = "male";	
					rdbtnGenderFC.setSelected(false);
				}}
		});
		rdbtnGenderMC.setBounds(149, 230, 109, 23);
		panelCustomer.add(rdbtnGenderMC);
		
		rdbtnGenderFC = new JRadioButton("Female");
		rdbtnGenderFC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnGenderFC.isSelected()){
					
				genderC = "female";
				rdbtnGenderMC.setSelected(false);
				}
			}
		});
		rdbtnGenderFC.setBounds(149, 263, 109, 23);
		panelCustomer.add(rdbtnGenderFC);
	}
	
	public void initializeInvoice(){
		
		JPanel panelInvoice = new JPanel();
		tabbedPane.addTab("Invoice         ", null, panelInvoice, null);
		panelInvoice.setLayout(null);
		
		JScrollPane scrollPaneInvoice = new JScrollPane();
		scrollPaneInvoice.setBounds(10, 82, 792, 262);
		panelInvoice.add(scrollPaneInvoice);
		
		tableInvoice = new JTable();
		tableInvoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				tableInvoiceClick();
			}
		});
		scrollPaneInvoice.setViewportView(tableInvoice);
		
		JButton btnRefreshI = new JButton("Refresh");
		btnRefreshI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				refreshTableInvoice();
			}
		});
		btnRefreshI.setBounds(10, 46, 90, 25);
		panelInvoice.add(btnRefreshI);
		
		comboBoxSearchI = new JComboBox();
		comboBoxSearchI.setModel(new DefaultComboBoxModel(new String[] {"ID", "Name", "Surname", "Employee", "Price", "Payment_type", "Payment_deadline", "Paid", "Payment_overdue"}));
		comboBoxSearchI.setBounds(414, 46, 162, 25);
		panelInvoice.add(comboBoxSearchI);
		
		textFieldSearchI = new JTextField();
		textFieldSearchI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				searchInvoice();
			}
		});
		textFieldSearchI.setText((String) null);
		textFieldSearchI.setColumns(10);
		textFieldSearchI.setBounds(582, 46, 220, 25);
		panelInvoice.add(textFieldSearchI);
		
		scrollPaneInvoiceText = new JScrollPane();
		scrollPaneInvoiceText.setBounds(10, 355, 792, 372);
		panelInvoice.add(scrollPaneInvoiceText);
		
		textAreaInvoice = new JTextArea();
		scrollPaneInvoiceText.setViewportView(textAreaInvoice);
	}
	
	public void initializeStatistics(){
		
		
		
		panelStatistics = new JPanel();
		tabbedPane.addTab("Statistics          ", null, panelStatistics, null);
		panelStatistics.setLayout(null);
		
		JLabel lblCustomerS = new JLabel("Customers");
		lblCustomerS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerS.setBounds(43, 111, 91, 27);
		panelStatistics.add(lblCustomerS);
		
		JLabel lblRegisteredCusS = new JLabel("Currently registered:");
		lblRegisteredCusS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRegisteredCusS.setBounds(43, 165, 155, 14);
		panelStatistics.add(lblRegisteredCusS);
		
		textFieldRegisteredCustomersS = new JTextField();
		textFieldRegisteredCustomersS.setEditable(false);
		textFieldRegisteredCustomersS.setBounds(208, 162, 155, 20);
		panelStatistics.add(textFieldRegisteredCustomersS);
		textFieldRegisteredCustomersS.setColumns(10);
		
		JLabel lblDanishCusS = new JLabel("Danish registered");
		lblDanishCusS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDanishCusS.setBounds(43, 190, 155, 14);
		panelStatistics.add(lblDanishCusS);
		
		textFieldDanishCustomersS = new JTextField();
		textFieldDanishCustomersS.setEditable(false);
		textFieldDanishCustomersS.setColumns(10);
		textFieldDanishCustomersS.setBounds(208, 187, 155, 20);
		panelStatistics.add(textFieldDanishCustomersS);
		
		JLabel lblEmployees = new JLabel("Employees");
		lblEmployees.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmployees.setBounds(43, 276, 91, 27);
		panelStatistics.add(lblEmployees);
		
		JLabel lblAvarageSalaryS = new JLabel("Avarage salary");
		lblAvarageSalaryS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAvarageSalaryS.setBounds(43, 342, 155, 14);
		panelStatistics.add(lblAvarageSalaryS);
		
		JLabel lblRegisteredEmpS = new JLabel("Currently registered:");
		lblRegisteredEmpS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRegisteredEmpS.setBounds(43, 317, 155, 14);
		panelStatistics.add(lblRegisteredEmpS);
		
		textFieldRegisteredEmployeesS = new JTextField();
		textFieldRegisteredEmployeesS.setEditable(false);
		textFieldRegisteredEmployeesS.setColumns(10);
		textFieldRegisteredEmployeesS.setBounds(208, 314, 155, 20);
		panelStatistics.add(textFieldRegisteredEmployeesS);
		
		textFieldAvarageSalaryS = new JTextField();
		textFieldAvarageSalaryS.setEditable(false);
		textFieldAvarageSalaryS.setColumns(10);
		textFieldAvarageSalaryS.setBounds(208, 339, 155, 20);
		panelStatistics.add(textFieldAvarageSalaryS);
		
		btnRefreshS = new JButton("Refresh");
		btnRefreshS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				refreshStatistics();
			}
		});
		btnRefreshS.setBounds(43, 682, 89, 23);
		panelStatistics.add(btnRefreshS);
		
		lblRooms = new JLabel("Rooms");
		lblRooms.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRooms.setBounds(43, 422, 91, 27);
		panelStatistics.add(lblRooms);
		
		lblNumberOfRoomsS = new JLabel("Number of rooms");
		lblNumberOfRoomsS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfRoomsS.setBounds(43, 463, 155, 14);
		panelStatistics.add(lblNumberOfRoomsS);
		
		textFieldNumberOfRoomsS = new JTextField();
		textFieldNumberOfRoomsS.setText("");
		textFieldNumberOfRoomsS.setEditable(false);
		textFieldNumberOfRoomsS.setColumns(10);
		textFieldNumberOfRoomsS.setBounds(208, 460, 155, 20);
		panelStatistics.add(textFieldNumberOfRoomsS);
		
		lblBooking = new JLabel("Booking");
		lblBooking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBooking.setBounds(448, 111, 91, 27);
		panelStatistics.add(lblBooking);
		
		lblNumberOfBookingsS = new JLabel("Number of bookings");
		lblNumberOfBookingsS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfBookingsS.setBounds(448, 162, 155, 14);
		panelStatistics.add(lblNumberOfBookingsS);
		
		lblCheckedInBookingsS = new JLabel("Checked-in Bookings");
		lblCheckedInBookingsS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCheckedInBookingsS.setBounds(448, 187, 155, 14);
		panelStatistics.add(lblCheckedInBookingsS);
		
		textFieldCheckedInBookingsS = new JTextField();
		textFieldCheckedInBookingsS.setText("1");
		textFieldCheckedInBookingsS.setEditable(false);
		textFieldCheckedInBookingsS.setColumns(10);
		textFieldCheckedInBookingsS.setBounds(613, 184, 155, 20);
		panelStatistics.add(textFieldCheckedInBookingsS);
		
		textFieldNumberOfBookingsS = new JTextField();
		textFieldNumberOfBookingsS.setText("2");
		textFieldNumberOfBookingsS.setEditable(false);
		textFieldNumberOfBookingsS.setColumns(10);
		textFieldNumberOfBookingsS.setBounds(613, 159, 155, 20);
		panelStatistics.add(textFieldNumberOfBookingsS);
		
		comboBoxRoomNumberS = new JComboBox();
		comboBoxRoomNumberS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getSelectedRoomOccupancy();
			}
		});
		comboBoxRoomNumberS.setBounds(43, 488, 41, 20);
		panelStatistics.add(comboBoxRoomNumberS);
		
		comboBoxYearS = new JComboBox();
		comboBoxYearS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getSelectedRoomOccupancy();
			}
		});
		comboBoxYearS.setBounds(94, 488, 104, 20);
		panelStatistics.add(comboBoxYearS);
		
		textFieldOccupancyRateS = new JTextField();
		textFieldOccupancyRateS.setEditable(false);
		textFieldOccupancyRateS.setBounds(208, 488, 155, 20);
		panelStatistics.add(textFieldOccupancyRateS);
		textFieldOccupancyRateS.setColumns(10);
		
		JLabel lblInvoice = new JLabel("Invoice");
		lblInvoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInvoice.setBounds(448, 284, 91, 27);
		panelStatistics.add(lblInvoice);
		
		JLabel lblAvaragePrice = new JLabel("Avarage price");
		lblAvaragePrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAvaragePrice.setBounds(448, 317, 155, 14);
		panelStatistics.add(lblAvaragePrice);
		
		textFieldAvaragePriceS = new JTextField();
		textFieldAvaragePriceS.setEditable(false);
		textFieldAvaragePriceS.setColumns(10);
		textFieldAvaragePriceS.setBounds(613, 314, 155, 20);
		panelStatistics.add(textFieldAvaragePriceS);
	}
	
	public void initializeArchive(){
			
		panelArchive = new JPanel();
		tabbedPane.addTab("Archive          ", null, panelArchive, null);
		panelArchive.setLayout(null);
		
		JScrollPane scrollPaneArchive = new JScrollPane();
		scrollPaneArchive.setBounds(10, 70, 1539, 661);
		panelArchive.add(scrollPaneArchive);
		
		tableArchive = new JTable();
		scrollPaneArchive.setViewportView(tableArchive);
		
		JButton btnRefreshA = new JButton("Refresh");
		btnRefreshA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				refreshTableArchive();
			}
		});
		btnRefreshA.setBounds(10, 34, 90, 25);
		panelArchive.add(btnRefreshA);
		
		comboBoxA = new JComboBox();
		comboBoxA.setModel(new DefaultComboBoxModel(new String[] {"ID", "Name", "Surname", "Country", "City", "Street", "Zip_code", "Contact\t", "Booked_from", "Booked_til", "Checked_in", "Checked_out", "Room_number"}));
		comboBoxA.setBounds(1157, 34, 162, 25);
		panelArchive.add(comboBoxA);
		
		textFieldSearchA = new JTextField();
		textFieldSearchA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				searchArchive();
			}
		});
		textFieldSearchA.setText((String) null);
		textFieldSearchA.setColumns(10);
		textFieldSearchA.setBounds(1329, 34, 220, 25);
		panelArchive.add(textFieldSearchA);
	}
	
	public void initializeBooking(){
		
		JPanel panelBooking = new JPanel();
		tabbedPane.addTab("Booking          ", null, panelBooking, null);
		panelBooking.setLayout(null);
		
		scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(359, 86, 802, 650);
		panelBooking.add(scrollPaneB);
		
		tableBooking = new JTable();
		tableBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tableBookingClick();
			}
		});
		scrollPaneB.setViewportView(tableBooking);
		
		btnRefreshB = new JButton("Refresh");
		btnRefreshB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				refreshTableBooking();
			}
		});
		btnRefreshB.setBounds(359, 55, 90, 25);
		panelBooking.add(btnRefreshB);
		
		comboBoxB = new JComboBox();
		comboBoxB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchAllCheckIns();
			}
		});
		comboBoxB.setModel(new DefaultComboBoxModel(new String[] {"ID", "Customer_username", "Employee_username", "Room_number", "Room_type", "Rates", "Number_of_people", "Checked_in", "All_Checked_in"}));
		comboBoxB.setBounds(769, 55, 162, 25);
		panelBooking.add(comboBoxB);
		
		textFieldSearchB = new JTextField();
		textFieldSearchB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				searchBooking();
			}
		});
		textFieldSearchB.setColumns(10);
		textFieldSearchB.setBounds(941, 55, 220, 25);
		panelBooking.add(textFieldSearchB);
		
		textFieldIdB = new JTextField();
		textFieldIdB.setEditable(false);
		textFieldIdB.setColumns(10);
		textFieldIdB.setBounds(153, 86, 200, 25);
		panelBooking.add(textFieldIdB);
		
		textFieldCustomerUsernameB = new JTextField();
		textFieldCustomerUsernameB.setColumns(10);
		textFieldCustomerUsernameB.setBounds(153, 122, 200, 25);
		panelBooking.add(textFieldCustomerUsernameB);
		
		textFieldEmployeeUsernameB = new JTextField();
		textFieldEmployeeUsernameB.setEditable(false);
		textFieldEmployeeUsernameB.setColumns(10);
		textFieldEmployeeUsernameB.setBounds(153, 158, 200, 25);
		panelBooking.add(textFieldEmployeeUsernameB);
		
		textFieldBookedFromB = new JTextField();
		textFieldBookedFromB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				calculatePrice();
			}
		});
		textFieldBookedFromB.setColumns(10);
		textFieldBookedFromB.setBounds(153, 194, 200, 25);
		panelBooking.add(textFieldBookedFromB);
		
		textFieldBookedTilB = new JTextField();
		textFieldBookedTilB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				calculatePrice();
			}
		});
		textFieldBookedTilB.setColumns(10);
		textFieldBookedTilB.setBounds(153, 230, 200, 25);
		panelBooking.add(textFieldBookedTilB);
		
		textFieldRoomNumberB = new JTextField();
		textFieldRoomNumberB.setColumns(10);
		textFieldRoomNumberB.setBounds(153, 266, 200, 25);
		panelBooking.add(textFieldRoomNumberB);
		
		lblIdB = new JLabel("ID");
		lblIdB.setBounds(50, 86, 93, 25);
		panelBooking.add(lblIdB);
		
		lblCustomerUsernameB = new JLabel("Customer");
		lblCustomerUsernameB.setBounds(50, 122, 93, 25);
		panelBooking.add(lblCustomerUsernameB);
		
		lblEmployeeUsernameB = new JLabel("Employee");
		lblEmployeeUsernameB.setBounds(50, 158, 93, 25);
		panelBooking.add(lblEmployeeUsernameB);
		
		lblBookedFromB = new JLabel("Booked from");
		lblBookedFromB.setBounds(50, 194, 93, 25);
		panelBooking.add(lblBookedFromB);
		
		lblBookedTilB = new JLabel("Booked til");
		lblBookedTilB.setBounds(50, 230, 93, 25);
		panelBooking.add(lblBookedTilB);
		
		lblRoomNumberB = new JLabel("Room number");
		lblRoomNumberB.setBounds(50, 266, 93, 25);
		panelBooking.add(lblRoomNumberB);
		
		lblRoomTypeB = new JLabel("Room type");
		lblRoomTypeB.setBounds(50, 302, 93, 25);
		panelBooking.add(lblRoomTypeB);
		
		lblRatesNumberB = new JLabel("Rate");
		lblRatesNumberB.setBounds(50, 338, 93, 25);
		panelBooking.add(lblRatesNumberB);
		
		lblNumberOfPeopleB = new JLabel("Number of people");
		lblNumberOfPeopleB.setBounds(50, 374, 93, 25);
		panelBooking.add(lblNumberOfPeopleB);
		
		btnAddB = new JButton("Add");
		btnAddB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addBooking();
			}
		});
		btnAddB.setBounds(46, 706, 90, 30);
		panelBooking.add(btnAddB);
		
		btnUpdateB = new JButton("Update");
		btnUpdateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateBooking();
			}
		});
		btnUpdateB.setBounds(153, 706, 90, 30);
		panelBooking.add(btnUpdateB);
		
		btnDeleteB = new JButton("Delete");
		btnDeleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				deleteBooking();
			}
		});
		btnDeleteB.setBounds(259, 706, 90, 30);
		panelBooking.add(btnDeleteB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1172, 86, 377, 650);
		panelBooking.add(scrollPane);
		
		tableBookingRooms = new JTable();
		tableBookingRooms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tableBookingRoomsClick();
			}
		});
		scrollPane.setViewportView(tableBookingRooms);
		
		textFieldSearchBookedFromB = new JTextField();
		textFieldSearchBookedFromB.setColumns(10);
		textFieldSearchBookedFromB.setBounds(1171, 55, 132, 25);
		panelBooking.add(textFieldSearchBookedFromB);
		
		textFieldSearchBookedTillB = new JTextField();
		textFieldSearchBookedTillB.setColumns(10);
		textFieldSearchBookedTillB.setBounds(1313, 55, 132, 25);
		panelBooking.add(textFieldSearchBookedTillB);
		
		JButton btnSearchB = new JButton("search");
		btnSearchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				searchDate();
			}
		});
		btnSearchB.setBounds(1455, 56, 94, 23);
		panelBooking.add(btnSearchB);
		
		textPaneB = new JTextPane();
		textPaneB.setBounds(50, 600, 299, 95);
		panelBooking.add(textPaneB);
		
		comboBoxRoomTypeB = new JComboBox();
		comboBoxRoomTypeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				calculatePrice();
				setNumberOfPeople();
			}
		});
		comboBoxRoomTypeB.setBounds(153, 302, 196, 20);
		panelBooking.add(comboBoxRoomTypeB);
		
		comboBoxRatesB = new JComboBox();
		comboBoxRatesB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				calculatePrice();
			}
		});
		comboBoxRatesB.setBounds(153, 340, 196, 20);
		panelBooking.add(comboBoxRatesB);
		
		comboBoxNumberOfPeopleB = new JComboBox();
		comboBoxNumberOfPeopleB.setBounds(153, 376, 196, 20);
		panelBooking.add(comboBoxNumberOfPeopleB);
		
		JButton btnCheckInB = new JButton("Check in");
		btnCheckInB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				checkIn();
			}
		});
		btnCheckInB.setBounds(50, 559, 145, 30);
		panelBooking.add(btnCheckInB);
		
		JButton btnCheckOutB = new JButton("Check out");
		btnCheckOutB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkOut();
			}
		});
		btnCheckOutB.setBounds(204, 559, 145, 30);
		panelBooking.add(btnCheckOutB);
		
		JLabel lblPriceB = new JLabel("Price");
		lblPriceB.setBounds(50, 526, 46, 14);
		panelBooking.add(lblPriceB);
		
		textFieldPriceB = new JTextField();
		textFieldPriceB.setEditable(false);
		textFieldPriceB.setText((String) null);
		textFieldPriceB.setColumns(10);
		textFieldPriceB.setBounds(153, 523, 200, 25);
		panelBooking.add(textFieldPriceB);
		
		rbBtnDiscountPercentB = new JRadioButton("Discount (%)");
		rbBtnDiscountPercentB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rbBtnDiscountPercentB.isSelected()){
					
				textFieldDiscountPercentB.setEditable(true);
				textFieldDiscountAmmountB.setEditable(false);
				textFieldDiscountAmmountB.setText(null);
				rbBtnDiscountAmmountB.setSelected(false);
				calculatePrice();
				}
			}
		});
		rbBtnDiscountPercentB.setBounds(50, 431, 109, 23);
		panelBooking.add(rbBtnDiscountPercentB);
		
		rbBtnDiscountAmmountB = new JRadioButton("Discount (dkk)");
		rbBtnDiscountAmmountB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rbBtnDiscountAmmountB.isSelected()){
					
					textFieldDiscountAmmountB.setEditable(true);
					textFieldDiscountPercentB.setEditable(false);
					textFieldDiscountPercentB.setText(null);
					rbBtnDiscountPercentB.setSelected(false);
					calculatePrice();
				}
			}
		});
		rbBtnDiscountAmmountB.setBounds(50, 467, 109, 23);
		panelBooking.add(rbBtnDiscountAmmountB);
		
		textFieldDiscountPercentB = new JTextField();
		textFieldDiscountPercentB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				calculatePrice();
			}
		});
		textFieldDiscountPercentB.setText((String) null);
		textFieldDiscountPercentB.setColumns(10);
		textFieldDiscountPercentB.setBounds(165, 432, 188, 25);
		panelBooking.add(textFieldDiscountPercentB);
		
		textFieldDiscountAmmountB = new JTextField();
		textFieldDiscountAmmountB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				calculatePrice();
			}
		});
		textFieldDiscountAmmountB.setText((String) null);
		textFieldDiscountAmmountB.setColumns(10);
		textFieldDiscountAmmountB.setBounds(165, 468, 188, 25);
		panelBooking.add(textFieldDiscountAmmountB);
		
	}
	
	public void initializeEmployee(){
		
		JPanel panelEmployee = new JPanel();
		tabbedPane.addTab("Employee         ", null, panelEmployee, null);
		panelEmployee.setLayout(null);
		
		btnRefreshE = new JButton("Refresh");
		btnRefreshE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				refreshTableEmployee();
			}
		});
		btnRefreshE.setBounds(359, 54, 90, 25);
		panelEmployee.add(btnRefreshE);
		
		comboBoxE = new JComboBox();
		comboBoxE.setModel(new DefaultComboBoxModel(new String[] {"Username", "Password", "Security_level", "Name", "Surname", "Gender", "Country", "City", "Street", "Zip_code", "Contact", "Salary", "Employed_since", "Contract_type", "Ssn", "Department_number"}));
		comboBoxE.setBounds(1157, 54, 162, 25);
		panelEmployee.add(comboBoxE);
		
		textFieldSearchE = new JTextField();
		textFieldSearchE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				searchEmloyee();
			}
		});
		textFieldSearchE.setColumns(10);
		textFieldSearchE.setBounds(1325, 54, 220, 25);
		panelEmployee.add(textFieldSearchE);
		
		textFieldUsernameE = new JTextField();
		textFieldUsernameE.setColumns(10);
		textFieldUsernameE.setBounds(149, 85, 200, 25);
		panelEmployee.add(textFieldUsernameE);
		
		textFieldNameE = new JTextField();
		textFieldNameE.setColumns(10);
		textFieldNameE.setBounds(149, 157, 200, 25);
		panelEmployee.add(textFieldNameE);
		
		textFieldSurnameE = new JTextField();
		textFieldSurnameE.setColumns(10);
		textFieldSurnameE.setBounds(149, 193, 200, 25);
		panelEmployee.add(textFieldSurnameE);
		
		textFieldCountryE = new JTextField();
		textFieldCountryE.setColumns(10);
		textFieldCountryE.setBounds(149, 265, 200, 25);
		panelEmployee.add(textFieldCountryE);
		
		textFieldCityE = new JTextField();
		textFieldCityE.setColumns(10);
		textFieldCityE.setBounds(149, 301, 200, 25);
		panelEmployee.add(textFieldCityE);
		
		textFieldStreetE = new JTextField();
		textFieldStreetE.setColumns(10);
		textFieldStreetE.setBounds(149, 337, 200, 25);
		panelEmployee.add(textFieldStreetE);
		
		textFieldZipCodeE = new JTextField();
		textFieldZipCodeE.setColumns(10);
		textFieldZipCodeE.setBounds(149, 373, 200, 25);
		panelEmployee.add(textFieldZipCodeE);
		
		textFieldContactE = new JTextField();
		textFieldContactE.setColumns(10);
		textFieldContactE.setBounds(149, 409, 200, 25);
		panelEmployee.add(textFieldContactE);
		
		textFieldSsnE = new JTextField();
		textFieldSsnE.setColumns(10);
		textFieldSsnE.setBounds(149, 557, 200, 25);
		panelEmployee.add(textFieldSsnE);
		
		textFieldContractTypeE = new JTextField();
		textFieldContractTypeE.setColumns(10);
		textFieldContractTypeE.setBounds(149, 521, 200, 25);
		panelEmployee.add(textFieldContractTypeE);
		
		textFieldEmployedSinceE = new JTextField();
		textFieldEmployedSinceE.setColumns(10);
		textFieldEmployedSinceE.setBounds(149, 485, 200, 25);
		panelEmployee.add(textFieldEmployedSinceE);
		
		textFieldSalaryE = new JTextField();
		textFieldSalaryE.setColumns(10);
		textFieldSalaryE.setBounds(149, 449, 200, 25);
		panelEmployee.add(textFieldSalaryE);
		
		lblUsernameE = new JLabel("Username");
		lblUsernameE.setBounds(46, 85, 93, 25);
		panelEmployee.add(lblUsernameE);
		
		lblSecurityLevelE = new JLabel("Security level");
		lblSecurityLevelE.setBounds(46, 121, 93, 25);
		panelEmployee.add(lblSecurityLevelE);
		
		lblNameE = new JLabel("Name");
		lblNameE.setBounds(46, 157, 93, 25);
		panelEmployee.add(lblNameE);
		
		labelSurnameE = new JLabel("Surname");
		labelSurnameE.setBounds(46, 193, 93, 25);
		panelEmployee.add(labelSurnameE);
		
		lblGenderE = new JLabel("Gender");
		lblGenderE.setBounds(46, 229, 93, 25);
		panelEmployee.add(lblGenderE);
		
		lblCountryE = new JLabel("Country");
		lblCountryE.setBounds(46, 265, 93, 25);
		panelEmployee.add(lblCountryE);
		
		lblCityE = new JLabel("City");
		lblCityE.setBounds(46, 301, 93, 25);
		panelEmployee.add(lblCityE);
		
		lblStreetE = new JLabel("Street");
		lblStreetE.setBounds(46, 337, 93, 25);
		panelEmployee.add(lblStreetE);
		
		lblZipCodeE = new JLabel("Zip code");
		lblZipCodeE.setBounds(46, 373, 93, 25);
		panelEmployee.add(lblZipCodeE);
		
		lblContactE = new JLabel("Contact");
		lblContactE.setBounds(46, 409, 93, 25);
		panelEmployee.add(lblContactE);
		
		lblDepartmentNumberE = new JLabel("Department");
		lblDepartmentNumberE.setBounds(46, 593, 93, 25);
		panelEmployee.add(lblDepartmentNumberE);
		
		lblSsnE = new JLabel("Ssn");
		lblSsnE.setBounds(46, 557, 93, 25);
		panelEmployee.add(lblSsnE);
		
		lblContractTypeE = new JLabel("Contract type");
		lblContractTypeE.setBounds(46, 521, 93, 25);
		panelEmployee.add(lblContractTypeE);
		
		lblEmployedSinceE = new JLabel("Employed since");
		lblEmployedSinceE.setBounds(46, 485, 93, 25);
		panelEmployee.add(lblEmployedSinceE);
		
		lblSalaryE = new JLabel("Salary");
		lblSalaryE.setBounds(46, 449, 93, 25);
		panelEmployee.add(lblSalaryE);
		
		btnAddE = new JButton("Add");
		btnAddE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addEmployee();
			}
		});
		btnAddE.setBounds(46, 706, 90, 30);
		panelEmployee.add(btnAddE);
		
		btnUpdateE = new JButton("Update");
		btnUpdateE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateEmployee();
			}
		});
		btnUpdateE.setBounds(153, 706, 90, 30);
		panelEmployee.add(btnUpdateE);
		
		btnDeleteE = new JButton("Delete");
		btnDeleteE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				deleteEmployee();
			}
		});
		btnDeleteE.setBounds(259, 706, 90, 30);
		panelEmployee.add(btnDeleteE);
		
		scrollPaneEmployee = new JScrollPane();
		scrollPaneEmployee.setBounds(359, 85, 1190, 651);
		panelEmployee.add(scrollPaneEmployee);
		
		tableEmployee = new JTable();
		tableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				tableEmployeeClick();
			}
		});
		tableEmployee.setBackground(SystemColor.inactiveCaption);
		scrollPaneEmployee.setViewportView(tableEmployee);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 629, 307, 63);
		panelEmployee.add(scrollPane);
		
		textPaneE = new JTextPane();
		scrollPane.setViewportView(textPaneE);
		
		comboBoxSecurityLevelE = new JComboBox();
		comboBoxSecurityLevelE.setBounds(149, 126, 200, 20);
		panelEmployee.add(comboBoxSecurityLevelE);
		
		rdbtnMaleE = new JRadioButton("Male");
		rdbtnMaleE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnMaleE.isSelected()){
					genderE = "male";	
					rdbtnFemaleE.setSelected(false);
				}
			}
		});
		rdbtnMaleE.setBounds(149, 235, 55, 23);
		panelEmployee.add(rdbtnMaleE);
		
		rdbtnFemaleE = new JRadioButton("Female");
		rdbtnFemaleE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnFemaleE.isSelected()){
					genderE = "female";	
					rdbtnMaleE.setSelected(false);
				}
			}
		});
		rdbtnFemaleE.setBounds(203, 235, 77, 23);
		panelEmployee.add(rdbtnFemaleE);
		
		comboBoxDepartmentE = new JComboBox();
		comboBoxDepartmentE.setBounds(149, 593, 200, 20);
		panelEmployee.add(comboBoxDepartmentE);
	}
	
	public void initializeRoom(){
		
		JPanel panelRoom = new JPanel();
		tabbedPane.addTab("Room             ", null, panelRoom, null);
		panelRoom.setLayout(null);
		
		btnRefreshR = new JButton("Refresh");
		btnRefreshR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshTableRoom();
				refreshTableRoomType();
				refreshTableRates();
			}
		});
		btnRefreshR.setBounds(359, 54, 90, 25);
		panelRoom.add(btnRefreshR);
		
		comboBoxR = new JComboBox();
		comboBoxR.setModel(new DefaultComboBoxModel(new String[] {"Room_number", "Capacity"}));
		comboBoxR.setBounds(459, 54, 162, 25);
		panelRoom.add(comboBoxR);
		
		textFieldSearchR = new JTextField();
		textFieldSearchR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				searchRoom();
			}
		});
		textFieldSearchR.setColumns(10);
		textFieldSearchR.setBounds(631, 54, 220, 25);
		panelRoom.add(textFieldSearchR);
		
		textFieldRoomNumberR = new JTextField();
		textFieldRoomNumberR.setColumns(10);
		textFieldRoomNumberR.setBounds(153, 85, 200, 25);
		panelRoom.add(textFieldRoomNumberR);
		
		lblRoomNumberR = new JLabel("Room number");
		lblRoomNumberR.setBounds(50, 85, 93, 25);
		panelRoom.add(lblRoomNumberR);
		
		lblCapacityR = new JLabel("Capacity");
		lblCapacityR.setBounds(50, 121, 93, 25);
		panelRoom.add(lblCapacityR);
		
		btnAddR = new JButton("Add");
		btnAddR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addRoom();
			}
		});
		btnAddR.setBounds(46, 706, 90, 30);
		panelRoom.add(btnAddR);
		
		btnUpdateR = new JButton("Update");
		btnUpdateR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateRoom();
			}
		});
		btnUpdateR.setBounds(153, 706, 90, 30);
		panelRoom.add(btnUpdateR);
		
		btnDeleteR = new JButton("Delete");
		btnDeleteR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteRoom();
			}
		});
		btnDeleteR.setBounds(259, 706, 90, 30);
		panelRoom.add(btnDeleteR);
		
		textPaneR = new JTextPane();
		textPaneR.setBounds(44, 525, 305, 170);
		panelRoom.add(textPaneR);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(359, 85, 492, 651);
		panelRoom.add(scrollPane_1);
		
		tableRoom = new JTable();
		tableRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tableRoomClick();
			}
		});
		scrollPane_1.setViewportView(tableRoom);
		
		comboBoxCapacityR = new JComboBox();
		comboBoxCapacityR.setBounds(153, 123, 200, 20);
		panelRoom.add(comboBoxCapacityR);
		
		scrollPaneRoomType = new JScrollPane();
		scrollPaneRoomType.setBounds(1177, 85, 372, 232);
		panelRoom.add(scrollPaneRoomType);
		
		tableRoomType = new JTable();
		tableRoomType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				tableRoomTypeClick();
			}
		});
		scrollPaneRoomType.setViewportView(tableRoomType);
		
		lblRoomTypeNameR = new JLabel("Name");
		lblRoomTypeNameR.setBounds(861, 85, 93, 25);
		panelRoom.add(lblRoomTypeNameR);
		
		textFieldRoomTypeNameR = new JTextField();
		textFieldRoomTypeNameR.setText((String) null);
		textFieldRoomTypeNameR.setColumns(10);
		textFieldRoomTypeNameR.setBounds(964, 85, 200, 25);
		panelRoom.add(textFieldRoomTypeNameR);
		
		lblRoomTypePriceR = new JLabel("Price");
		lblRoomTypePriceR.setBounds(861, 121, 93, 25);
		panelRoom.add(lblRoomTypePriceR);
		
		textFieldRoomTypePriceR = new JTextField();
		textFieldRoomTypePriceR.setText((String) null);
		textFieldRoomTypePriceR.setColumns(10);
		textFieldRoomTypePriceR.setBounds(964, 121, 200, 25);
		panelRoom.add(textFieldRoomTypePriceR);
		
		btnAddRoomTypeR = new JButton("Add");
		btnAddRoomTypeR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addRoomType();
			}
		});
		btnAddRoomTypeR.setBounds(864, 287, 90, 30);
		panelRoom.add(btnAddRoomTypeR);
		
		btnUpdateRoomTypeR = new JButton("Update");
		btnUpdateRoomTypeR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateRoomType();
			}
		});
		btnUpdateRoomTypeR.setBounds(971, 287, 90, 30);
		panelRoom.add(btnUpdateRoomTypeR);
		
		btnDeleteRoomTypeR = new JButton("Delete");
		btnDeleteRoomTypeR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteRoomType();
			}
		});
		btnDeleteRoomTypeR.setBounds(1077, 287, 90, 30);
		panelRoom.add(btnDeleteRoomTypeR);
		
		textPaneRoomTypeR = new JTextPane();
		textPaneRoomTypeR.setBounds(864, 208, 303, 68);
		panelRoom.add(textPaneRoomTypeR);
		
		btnAddRatesR = new JButton("Add");
		btnAddRatesR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addRates();
			}
		});
		btnAddRatesR.setBounds(861, 701, 90, 30);
		panelRoom.add(btnAddRatesR);
		
		btnUpdateRatesR = new JButton("Update");
		btnUpdateRatesR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateRates();
			}
		});
		btnUpdateRatesR.setBounds(968, 701, 90, 30);
		panelRoom.add(btnUpdateRatesR);
		
		btnDeleteRatesR = new JButton("Delete");
		btnDeleteRatesR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteRates();
			}
		});
		btnDeleteRatesR.setBounds(1074, 701, 90, 30);
		panelRoom.add(btnDeleteRatesR);
		
		textPaneRatesR = new JTextPane();
		textPaneRatesR.setBounds(861, 596, 303, 94);
		panelRoom.add(textPaneRatesR);
		
		lblRatesNameR = new JLabel("Name");
		lblRatesNameR.setBounds(861, 353, 93, 25);
		panelRoom.add(lblRatesNameR);
		
		textFieldRatesNameR = new JTextField();
		textFieldRatesNameR.setText((String) null);
		textFieldRatesNameR.setColumns(10);
		textFieldRatesNameR.setBounds(964, 353, 200, 25);
		panelRoom.add(textFieldRatesNameR);
		
		scrollRates = new JScrollPane();
		scrollRates.setBounds(1177, 353, 372, 383);
		panelRoom.add(scrollRates);
		
		tableRates = new JTable();
		tableRates.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				tableRatesClick();
			}
		});
		scrollRates.setViewportView(tableRates);
		
		lblRatesBreakfastR = new JLabel("Breakfast");
		lblRatesBreakfastR.setBounds(861, 389, 93, 25);
		panelRoom.add(lblRatesBreakfastR);
		
		lblRatesLunchR = new JLabel("Lunch");
		lblRatesLunchR.setBounds(861, 425, 93, 25);
		panelRoom.add(lblRatesLunchR);
		
		lblRatesDinnerR = new JLabel("Dinner");
		lblRatesDinnerR.setBounds(861, 461, 93, 25);
		panelRoom.add(lblRatesDinnerR);
		
		comboBoxRatesBreakfastR = new JComboBox();
		comboBoxRatesBreakfastR.setModel(new DefaultComboBoxModel(new String[] {"yes", "no"}));
		comboBoxRatesBreakfastR.setBounds(964, 391, 200, 20);
		panelRoom.add(comboBoxRatesBreakfastR);
		
		comboBoxRatesLunchR = new JComboBox();
		comboBoxRatesLunchR.setModel(new DefaultComboBoxModel(new String[] {"yes", "no"}));
		comboBoxRatesLunchR.setBounds(964, 427, 200, 20);
		panelRoom.add(comboBoxRatesLunchR);
		
		comboBoxRatesDinnerR = new JComboBox();
		comboBoxRatesDinnerR.setModel(new DefaultComboBoxModel(new String[] {"yes", "no"}));
		comboBoxRatesDinnerR.setBounds(964, 463, 200, 20);
		panelRoom.add(comboBoxRatesDinnerR);
		
		lblRoomTypeCapacityR = new JLabel("Capacity");
		lblRoomTypeCapacityR.setBounds(861, 157, 93, 25);
		panelRoom.add(lblRoomTypeCapacityR);
		
		textFieldRoomTypeCapacityR = new JTextField();
		textFieldRoomTypeCapacityR.setText((String) null);
		textFieldRoomTypeCapacityR.setColumns(10);
		textFieldRoomTypeCapacityR.setBounds(964, 157, 200, 25);
		panelRoom.add(textFieldRoomTypeCapacityR);
		
	}
	
	//MENU
	
	public void openFile(){
		
		//run file chooser to open invoice text files
		JFileChooser chooser = new JFileChooser();
		
		try{

			//set directory
			chooser.setCurrentDirectory(new java.io.File("C:/Users/MPJ/Desktop/invoice"));
			//set title
			chooser.setDialogTitle("Open invoice...");
			//set what data we want to show ( files only )
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.showOpenDialog(null);
			File file = chooser.getSelectedFile();
			String fileName = file.getAbsolutePath();
			Runtime rt = Runtime.getRuntime();
			Process p =rt.exec( "notepad " + fileName );
		
		}catch(Exception e){
			
			System.out.println("Error while choosing a file");
		}
	}
	
	public void openUserManual(){
		
		//run file chooser to open user manual
		JFileChooser chooser = new JFileChooser();
		
		try{
			
			//set directory
			chooser.setCurrentDirectory(new java.io.File("C:/Users/MPJ/Desktop/userManual"));
			//set title
			chooser.setDialogTitle("Open user manual...");
			//set what data we want to show ( files only )
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.showOpenDialog(null);
			File file = chooser.getSelectedFile();
			String fileName = file.getAbsolutePath();
			Runtime rt = Runtime.getRuntime();
			//CHANGE NOTEPAD
			Process p =rt.exec( "notepad " + fileName );
		}
		catch(Exception e){
			
			System.out.println("Error while opening a tutorial");
		}
	}

	//set main labels
	public void setMainInfoLabels(boolean access){
		
		String usernameText = "";
		
		//TEST
		//username = "DEFAULT";
		
		
		//set label of connected user
		if(access == true){
			
			usernameText += "manager ";
		}
		else{
			
			usernameText += "employee ";
		}
		//add static gloabal variable username
		usernameText += username;
		//set label text
		lblUsernameMain.setText(usernameText);
		
		//run thread to keep track of date and time
		Thread activeTime = new Thread(new Runnable(){

			//declare variable
			String currenctDate = "";
			
			//threds main method
			public void run() {
				
				do{
		
					//declare in what format should be date shown
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					//declare date
					Date date = new Date();
					
					//set curent date to string in this date format
					currenctDate = dateFormat.format(date);
					//set label
					lblDateMain.setText(currenctDate);
					//repeat infinitly
				}while(true);
				
			}
		});
		
		//run thread to keep track if there is a connection to the database
		Thread activeConnection = new Thread( new Runnable(){
			
			//declare connection and set to null
			Connection connection = null;
			
			//threads main method
			public void run(){
				
				try{
					do{
						
						//return connection from dbConnector
						connection = DbConnection.DbConnector();
						
						//if there is no connection, set label to indicate status
						if(connection == null){
							
							lblConnectionMain.setIcon(new ImageIcon("C:\\Users\\MPJ\\workspace\\ProjectHotel\\icons\\Misc-Delete-Database-icon.png"));
						}
						//if there is connection set label to indicate status
						else{
							
							lblConnectionMain.setIcon(new ImageIcon("C:\\Users\\MPJ\\workspace\\ProjectHotel\\icons\\database-check-icon.png"));
						}
						//sleep one second
						Thread.sleep(3000);
						
						//repead infinitly
					}while(true);
				}catch(Exception e){
					
					System.out.println("Error while checking connection to the database");
				}
			}
		});
		
		//start threads
		activeTime.start();
		activeConnection.start();
	}
	
	//EMPLOYEE
	public void refreshTableEmployee(){
		
		//declare obj in control layer
		CtrEmployee empCtrObj = new CtrEmployee();
		
		//set table method refreshTableEmp() returns Result Set
		tableEmployee.setModel(DbUtils.resultSetToTableModel(empCtrObj.refreshTableEmp()));	
		//set employee text fields to null
		setTextFieldsENull();
	}
	
	public void addEmployee(){
		
		//declare obj in control layer
		CtrEmployee ctrEmpObj = new CtrEmployee();
		//declare boolean to state if adding was successful
		boolean success = false;
		//declare password string to be shown on the screen
		String password;
		//declare errror message to determine if there was any error or oncorrect input
		String errorMessage;
		
		//set textPane to null
		textPaneE.setText("");
		
		try{
			
			//declare and initialize variables needed to add employee
			String username = textFieldUsernameE.getText();
			int securityLevel = ((Integer) comboBoxSecurityLevelE.getSelectedItem());
			String name = textFieldNameE.getText();
			String surname = textFieldSurnameE.getText();
			String country = textFieldCountryE.getText();
			String city = textFieldCityE.getText();
			String street = textFieldStreetE.getText();
			String zipCode = textFieldZipCodeE.getText();
			String contact = textFieldContactE.getText();
			float salary = Float.parseFloat(textFieldSalaryE.getText());
			String employedSince = textFieldEmployedSinceE.getText();
			String contractType = textFieldContractTypeE.getText();
			int ssn = Integer.parseInt(textFieldSsnE.getText());
			int departmentNumber = (Integer)comboBoxDepartmentE.getSelectedItem();
			
			//call method in control layer, which returns error message with all incorect input and errors in it, pass all critical variables as arguments
			errorMessage = ctrEmpObj.checkInputData(username, securityLevel, name, surname, genderE, country, city, street, zipCode, contact, salary, employedSince, contractType, ssn, departmentNumber);
			//if there is no error call method add employee in control layer, pass all information inputed as arguments
			if(errorMessage.length() == 0){
				
				//get success to determine if adding was successful or not
				success = ctrEmpObj.addEmployee(username, securityLevel, name, surname, genderE, country, city, street, zipCode, contact, salary, employedSince, contractType, ssn, departmentNumber);
			}
			else{
				
				//if error message contains any errors, print it to the screen
				textPaneE.setText(errorMessage);
			}
			
			//get password which was created in control layer add employee method
			password = ctrEmpObj.getPassword();
			//call add employee method pass succes to determine if employee was added or not
			//pass password to be shown on the screen
			//pass error message to be shown in text pane
			addEmployeeMessage(success, password, errorMessage);

		}
		catch(Exception e){
			
			//let the user know if there is an exception
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
		}
	}
	
	public void updateEmployee(){
		
		//update employee - very same structure as add employee method
		CtrEmployee ctrEmpObj = new CtrEmployee();
		boolean success = false;
		String errorMessage;
		//declare action, which determines if user desides to update employee or not
		int action = 1;
		
		textPaneE.setText("");
		
		try{
		
			String username = textFieldUsernameE.getText();
			int securityLevel = ((Integer) comboBoxSecurityLevelE.getSelectedItem());
			String name = textFieldNameE.getText();
			String surname = textFieldSurnameE.getText();
			String country = textFieldCountryE.getText();
			String city = textFieldCityE.getText();
			String street = textFieldStreetE.getText();
			String zipCode = textFieldZipCodeE.getText();
			String contact = textFieldContactE.getText();
			float salary = Float.parseFloat(textFieldSalaryE.getText());
			String employedSince = textFieldEmployedSinceE.getText();
			String contractType = textFieldContractTypeE.getText();
			int ssn = Integer.parseInt(textFieldSsnE.getText());
			int departmentNumber = (Integer)comboBoxDepartmentE.getSelectedItem();
			
			errorMessage = ctrEmpObj.checkInputData(username, securityLevel, name, surname, genderE, country, city, street, zipCode, contact, salary, employedSince, contractType, ssn, departmentNumber);
						
			if(errorMessage.length() == 0){
				
				//if statemenr comparing security level to determine whether manager or employee is being updated 
				if(securityLevel == 1){
					
					action = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this manager?", "Delete", JOptionPane.YES_NO_OPTION);
				}
				else{
					
					action = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this employee?", "Delete", JOptionPane.YES_NO_OPTION);
				}
				
				//if user selects yes in confirm dialog call update employee method in control layer
				if(action == 0){
					success = ctrEmpObj.updateEmployee(username, securityLevel, name, surname, genderE, country, city, street, zipCode, contact, salary, employedSince, contractType, ssn, departmentNumber);
				}
			}
			else{
				
				textPaneE.setText(errorMessage);
			}
			
			updateEmployeeMessage(success, errorMessage, action);
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
		}
	}
	
	public void deleteEmployee(){
		
		//delete employee
		CtrEmployee ctrEmpObj = new CtrEmployee();
		boolean success = false;
		int action;
		
		textPaneE.setText("");
		
		try{
			
			String username = textFieldUsernameE.getText();
			int securityLevel = ((Integer) comboBoxSecurityLevelE.getSelectedItem());
			int ssn = Integer.parseInt(textFieldSsnE.getText());
			int departmentNumber = (Integer)comboBoxDepartmentE.getSelectedItem();
			
			if(securityLevel == 1){
				
				action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this manager?", "Delete", JOptionPane.YES_NO_OPTION);
			}
			else{
				
				action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?", "Delete", JOptionPane.YES_NO_OPTION);
			}
			
			if(action == 0){
				//get success return from delete employee method, pass all information needed to delete employee and know his possition and department
				success = ctrEmpObj.deleteEmployee(username, securityLevel, ssn, departmentNumber);
				//let user know customer was deleted
				JOptionPane.showMessageDialog(null, "Data deleted");
			}
			
			//refresh table after delete (contains method to set all text field of current pane to null)
			refreshTableEmployee();
			
		}
		catch(Exception e){
			
			//let user know if there is an exepction
			JOptionPane.showMessageDialog(null, "Unable to delete");
		}
		
	}
	
	public void searchEmloyee(){
		
		//declare object in control layer
		CtrEmployee ctrEmpObj = new CtrEmployee();
		//declare result set needed to set table
		ResultSet rs;
		
		//set text employee pane to null
		textPaneE.setText("");
		
		try{
			
			//declare and initialize variables needed to search
			//selection - chosen from combo box employee (contains name of the column in table on sql server) 
			String selection = (String) comboBoxE.getSelectedItem();
			//contains particular string we are looking for in database
			String searchEmployee = textFieldSearchE.getText();
			
			//return result set from control layer
			rs = ctrEmpObj.searchEmployee(selection, searchEmployee);
			//set table using DBUTILS library method and result set
			tableEmployee.setModel(DbUtils.resultSetToTableModel(rs));

		}
		catch(Exception e){
			
			//let user know if there is an excetion
			JOptionPane.showMessageDialog(null, "An error has accrued while searching");
		}
	}
		
	//feedback to user, method called in add employee
	private void addEmployeeMessage(boolean success, String password, String errorMessage){
		
		//if adding employee was successful, show password on message dialog
		if(success == true){
			
			String message =  "            Data saved\n password: " + password + "  ";
			JOptionPane.showMessageDialog(null, message);
			//refresh table employee, set textfields null
			refreshTableEmployee();
		}
		else{
			
			//show error message and warning on the text pane 
			//error message cant determine if username and ssn are unique, show warning message
			textPaneE.setText(errorMessage + "\npplease ensure you have entered unique username and ssn");
			JOptionPane.showMessageDialog(null, "An Error has accured while saving the data");
		}
	}
	
	//feedback for user, method called in update employee
	public void updateEmployeeMessage(boolean success, String errorMessage, int action){
		
		if(action == 0){
			if(success == true){
				
				String message =  "Data updated\n";
				JOptionPane.showMessageDialog(null, message);
				refreshTableEmployee();
			}
			else{
				
				textPaneE.setText(errorMessage + "\nplease ensure you have entered unique username and ssn");
				JOptionPane.showMessageDialog(null, "An Error has accured while updating the data");
			}
		}
	}
	
	//set textfield/comboboxes/rdbtn... based on what user clicks on (on table ) 
	private void tableEmployeeClick(){
		
		try{
			
			//declare clicked row
			int row = tableEmployee.getSelectedRow();
			//get username of selected row
			String selectedUsername = (tableEmployee.getModel().getValueAt(row, 0)).toString();
			CtrEmployee ctrEmpObj = new CtrEmployee();
			MdlEmployee mdlEmpObj = new MdlEmployee();
			
			//call method in control layer, which sets and return model employee object
			mdlEmpObj = ctrEmpObj.selectFromTableEmployee(selectedUsername);
			
			//set the textfield... using model employee object
			textFieldUsernameE.setText(mdlEmpObj.getUsername());
			comboBoxSecurityLevelE.setSelectedItem(mdlEmpObj.getSecurityLevel());
			textFieldNameE.setText(mdlEmpObj.getName());
			textFieldSurnameE.setText(mdlEmpObj.getSurname());
			
			if(mdlEmpObj.getGender().equals("female")){
				rdbtnFemaleE.setSelected(true);
				rdbtnMaleE.setSelected(false);
				genderC = "female";
			}
			else if(mdlEmpObj.getGender().equals("male")) {
				rdbtnMaleE.setSelected(true);
				rdbtnFemaleE.setSelected(false);
				genderC = "male";
			}
			
			textFieldCountryE.setText(mdlEmpObj.getCountry());
			textFieldCityE.setText(mdlEmpObj.getCity());
			textFieldStreetE.setText(mdlEmpObj.getStreet());
			textFieldZipCodeE.setText(mdlEmpObj.getZipCode());
			textFieldContactE.setText(mdlEmpObj.getContact());
			textFieldSalaryE.setText(Float.toString(mdlEmpObj.getSalary()));
			textFieldEmployedSinceE.setText(mdlEmpObj.getEmployedSince());
			textFieldContractTypeE.setText(mdlEmpObj.getContractType());
			textFieldSsnE.setText(Integer.toString(mdlEmpObj.getSsn()));
			comboBoxDepartmentE.setSelectedItem(mdlEmpObj.getDepartmentNumber());			
		}
		catch(Exception e){
			
			//let user know if there is an exception
			JOptionPane.showMessageDialog(null, "Incorrect data");
			//set text fields to null
			setTextFieldsENull();
		}
	}
	
	//fills combo box according to what is in the database
	public void fillComboBoxSecurityLevelE(){
		
		ArrayList<Integer> securityLevelList = new ArrayList<>();
		CtrSecurityLevel ctrSecLvlObj = new CtrSecurityLevel();
		
		//return array list if type integer of all security levels in the database
		securityLevelList = ctrSecLvlObj.getAllSecurityLevels();
		//got through every element of array list 
		for (int securityLevel : securityLevelList) {
			
			//add element to the combo box
			comboBoxSecurityLevelE.addItem(securityLevel);
		}
	}
	
	//fill combo box departmnt according to what is in the database - same as fill comboBoxSecurityLevel()
	public void fillComboBoxDepartment(){
		
		ArrayList<Integer> departmentList = new ArrayList<>();
		CtrDepartment ctrDepObj = new CtrDepartment();
		
		departmentList = ctrDepObj.getAllDepartments();
		
		for (int department : departmentList) {
			
			comboBoxDepartmentE.addItem(department);
		}
	}
	
	//set all text field of pane employee to null
	public void setTextFieldsENull(){
		
		textFieldUsernameE.setText(null);
		textFieldNameE.setText(null);
		textFieldSurnameE.setText(null);
		textFieldCountryE.setText(null);
		textFieldCityE.setText(null);
		textFieldStreetE.setText(null);
		textFieldZipCodeE.setText(null);
		textFieldContactE.setText(null);
		textFieldSalaryE.setText(null);
		textFieldEmployedSinceE.setText(null);
		textFieldContractTypeE.setText(null);
		textFieldSsnE.setText(null);
		textFieldSearchE.setText(null);
	}
	
	//CUSTOMER
	
	public void refreshTableCustomer(){
		
		//declare customer object in control layer
		CtrCustomer ctrCusObj = new CtrCustomer();
		//set table customer using result set returned from refreshTableCustomer in control layer
		tableCustomer.setModel(DbUtils.resultSetToTableModel(ctrCusObj.refreshTableCustomer()));
		//set all textfield on this pane to null
		setTextFieldsCNull();
		//set radio buttons to default possition
		rdbtnGenderMC.setSelected(true);
		rdbtnGenderFC.setSelected(false);
		
	}
	
public void addCustomer(){
		
		//declare customer object in control layer
		CtrCustomer ctrCusObj = new CtrCustomer();
		//declare success to determine whether adding customer was successful or not
		boolean success = false;
		//declare password to be shown on the screen if adding is successful
		String password;
		//delare error message to show all errors and incorrect inputs
		String errorMessage;
		
		//set textPane to null
		textPaneC.setText("");
		
		try{
			
			//declare and initialize all variables inputed by user to add customer
			String username = textFieldUsernameC.getText();
			String name = textFieldNameC.getText();
			String surname = textFieldSurnameC.getText();
			String customerType = (String) comboBoxCustomerTypeC.getSelectedItem();
			String country = textFieldCountryC.getText();
			String city = textFieldCityC.getText();
			String street = textFieldStreetC.getText();
			String zipCode = textFieldZipCodeC.getText();
			String contact = textFieldContactC.getText();
	
			//assign error message to string returned from check input data
			errorMessage = ctrCusObj.checkInputData(username, name, surname, customerType, genderC, country, city, street, zipCode, contact);
			//if there ar no errors or incorrect inputs ( error message is empty) - add customer
			if(errorMessage.length() == 0){
				
				//returns boolean if adding was successful or not
				success = ctrCusObj.addCustomer(username, name, surname, customerType, genderC, country, city, street, zipCode, contact);
			}
			else{
				
				//show error message on text pane
				textPaneC.setText(errorMessage);
			}
			
			//get password which was created in control layer add customer method
			password = ctrCusObj.getPassword();
			//method returns a message to user whether adding was successful or not
			addCustomerMessage(success, password, errorMessage);

		}
		catch(Exception e){
			
			//let user know if there was an exception
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
			//error message doesnt handle string inputs in text fields where integer is expected
			textPaneC.setText("Please ensure that customer type is a number");
		}
	}

	//feedback to user whether adding was successfull or not
	public void addCustomerMessage(boolean success, String password, String errorMessage){
		
		//if adding was successful show password on the screen
		if(success == true){
			
			String message =  "            Data saved\n password: " + password + "  ";
			JOptionPane.showMessageDialog(null, message);
			//refresh table, set text fields to null
			refreshTableCustomer();
		}
		else{
			
			//let user know if adding failed
			textPaneC.setText(errorMessage + "\nplease ensure you have entered unique username");
			JOptionPane.showMessageDialog(null, "An Error has occured while saving the data");
		}
	}
	
public void updateCustomer(){
		
		//declare customer object in control layer
		CtrCustomer ctrCusObj = new CtrCustomer();
		//declare boolean success to determine whether updating was successful or not
		boolean success = false;
		//declare error message to store all errors and incorrect inputs
		String errorMessage;
		//declare action, which determines if user desides to update customer or not
		int action = 1;
		
		textPaneC.setText("");
		
		try{
		
			//declare and initialize variables
			String username = textFieldUsernameC.getText();
			String name = textFieldNameC.getText();
			String surname = textFieldSurnameC.getText();
			String customerType = (String) comboBoxCustomerTypeC.getSelectedItem();
			String country = textFieldCountryC.getText();
			String city = textFieldCityC.getText();
			String street = textFieldStreetC.getText();
			String zipCode = textFieldZipCodeC.getText();
			String contact = textFieldContactC.getText();
			
			//assign error message to string returned from check input data
			errorMessage = ctrCusObj.checkInputData(username, name, surname, customerType, genderC, country, city, street, zipCode, contact);
			//if there ar no errors or incorrect inputs ( error message is empty) - update customer
			if(errorMessage.length() == 0){
				
				//ask user if he reallt wants to update particular customer
				action = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this customer?", "Delete", JOptionPane.YES_NO_OPTION);
				//if answer is yes, update customer
				if(action == 0){
					//returns boolean if adding was successful or not
					success = ctrCusObj.updateCustomer(username, name, surname, customerType, genderC, country, city, street, zipCode, contact);
				}
			}
			else{
				
				//show error message on text pane
				textPaneC.setText(errorMessage);
			}
			
			//feedback for user, whether update was successful or not
			updateCustomerMessage(success, errorMessage, action);
		}
		catch(Exception e){
			
			//let user know if there was an exception
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
		}
	}

	//feedback for user, whether update was successful or not
	public void updateCustomerMessage(boolean success,String errorMessage, int action){
		
		//only if user decides to update customer
		if(action == 0){
			//if update was successful
			if(success == true){
				
				String message =  "Data saved";
				JOptionPane.showMessageDialog(null, message);
				//refresh table customer and set all text fields to null
				refreshTableCustomer();
			}
			else{
				
				//show error message on the screen
				//error message doesnt check if username is unique, show warning on the text pane
				textPaneC.setText(errorMessage + "\nplease ensure you have entered unique username");
				JOptionPane.showMessageDialog(null, "An Error has accured while saving the data");
			}
		}
	}

	public void deleteCustomer(){
		
		//declare customer object in control layer
		CtrCustomer ctrCusObj = new CtrCustomer();
		//declare integer to hold information about whether user desides to delete customer or not
		int action;
		
		//set text pane to null
		textPaneC.setText("");
		
		try{
			
			//declare username and initialize it based on user input
			String username = textFieldUsernameC.getText();	
			//ask user if he really wants to delete this customer
			action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this customer?", "Delete", JOptionPane.YES_NO_OPTION);		
			if(action == 0){
				
				//call delete customer method in control layer
				ctrCusObj.deleteCustomer(username);
				//let user know that data were deleted
				JOptionPane.showMessageDialog(null, "Data deleted");
			}		
		}
		catch(Exception e){
			
			//let user know if there was an exception
			JOptionPane.showMessageDialog(null, "Unable to delete");
		}
		
	}
	
	
	public void searchCustomer(){
		
		//declare customer object in control layer
		CtrCustomer ctrCusObj = new CtrCustomer();
		//declare result set
		ResultSet rs;
		
		//set textpane to null
		textPaneE.setText("");
		
		try{
			
			//declare and initialize selection (matches column name in the database) 
			String selection = (String) comboBoxC.getSelectedItem();
			//declare and initialize string program will look for in the database
			String searchCustomer = textFieldSearchC.getText();
			
			//call method seatch customer in control layer, return result set
			rs = ctrCusObj.searchCustomer(selection, searchCustomer);
			
			//set table model using dbutil library with result set
			tableCustomer.setModel(DbUtils.resultSetToTableModel(rs));

		}
		catch(Exception e){
			
			//if there was en exception let user know
			JOptionPane.showMessageDialog(null, "An error has accrued while searching");
		}
	}
	
	//fill text field/ set combo boxes.. based on clicked row in the customer table
	public void tableCustomerClick(){
		
		try{
			
			//declare and initialize clicked row
			int row = tableCustomer.getSelectedRow();
			//declare and initialize username of clicked row
			String selectedUsername = (tableCustomer.getModel().getValueAt(row, 0)).toString();
			//declare customer oject in model layer
			CtrCustomer ctrCusObj = new CtrCustomer();
			//declare customer object in control layer
			MdlCustomer mdlCusObj = new MdlCustomer();
			
			//return model customer object passing username to the method selectFromTableCustomer as an argument
			mdlCusObj = ctrCusObj.selectFromTableCustomer(selectedUsername);
			
			//set text fields/ comboBoxes/ rdbtns... using customer model object
			textFieldUsernameC.setText(mdlCusObj.getUsername());
			textFieldNameC.setText(mdlCusObj.getName());
			textFieldSurnameC.setText(mdlCusObj.getSurname());
			comboBoxCustomerTypeC.setSelectedItem(mdlCusObj.getCustomerType());
			textFieldCountryC.setText(mdlCusObj.getCountry());
			textFieldCityC.setText(mdlCusObj.getCity());
			textFieldStreetC.setText(mdlCusObj.getStreet());
			textFieldZipCodeC.setText(mdlCusObj.getZipCode());
			textFieldContactC.setText(mdlCusObj.getContact());	
			
			if(mdlCusObj.getGender().equals("female")){
				rdbtnGenderFC.setSelected(true);
				rdbtnGenderMC.setSelected(false);
				genderC = "female";
			}
			else if(mdlCusObj.getGender().equals("male")) {
				rdbtnGenderMC.setSelected(true);
				rdbtnGenderFC.setSelected(false);
				genderC = "male";
			}			
		}
		catch(Exception e){
			
			//let user know if there was an exception and set all textfields to null
			JOptionPane.showMessageDialog(null, "Incorrect data");
			setTextFieldsENull();
		}
	}
	
	//fills combo box customer type based on database
	public void fillComboBoxCustomerTypeC(){
		
		//declare arrayList of type string
		ArrayList<String> customerTypeList = new ArrayList<>();
		//declare customer type object in control layer
		CtrCustomerType ctrCusTypeObj = new CtrCustomerType();
		
		//assigne customer type list to the array list returned calling get all customers method
		customerTypeList = ctrCusTypeObj.getAllCustomerTypes();
		//go through all elements in array list
		for (String customerType : customerTypeList) {
			
			//add element to the combo box
			comboBoxCustomerTypeC.addItem(customerType);
		}
	}
	
	//set all text fields on customer Pane to null
	public void setTextFieldsCNull(){
		
		textFieldUsernameC.setText(null);
		textFieldNameC.setText(null);
		textFieldSurnameC.setText(null);
		textFieldCountryC.setText(null);
		textFieldCityC.setText(null);
		textFieldStreetC.setText(null);
		textFieldZipCodeC.setText(null);
		textFieldContactC.setText(null);
		textFieldSearchC.setText(null);
	}
	
	
	//ROOM
	public void refreshTableRoom(){
		
		//declare room object in control layer
		CtrRoom ctrRoomObj = new CtrRoom();
		//set room table using result set and dbUtils library
		tableRoom.setModel(DbUtils.resultSetToTableModel(ctrRoomObj.refreshTableRoom()));
		//set all text field on Pane Room to null
		setTextFieldsRNull();
		
	}
	
	public void refreshTableRoomType(){
		
		//declare room type object in control layer
		CtrRoomType ctrRoomTypeObj = new CtrRoomType();
		//set room type table using result set and tbUtils library
		tableRoomType.setModel(DbUtils.resultSetToTableModel(ctrRoomTypeObj.refreshTableRoomType()));
		//set all room type textFields to null
		textFieldRoomTypeNameR.setText(null);
		textFieldRoomTypePriceR.setText(null);
		textFieldRoomTypeCapacityR.setText(null);
		//remove and load all items in room type comboBox
		comboBoxRoomTypeB.removeAllItems();
		fillComboBoxRoomType();
	}
	
	public void refreshTableRates(){
		
		//declare rates object for rates class in control layer
		CtrRates ctrRatesObj = new CtrRates();
		//set table rates using result set and dbUtils library
		tableRates.setModel(DbUtils.resultSetToTableModel(ctrRatesObj.refreshTableRates()));
		//set rates textfields to null
		textFieldRatesNameR.setText(null);
		//set rates comboBoxes to default
		comboBoxRatesBreakfastR.setSelectedItem("yes");
		comboBoxRatesLunchR.setSelectedItem("yes");
		comboBoxRatesDinnerR.setSelectedItem("yes");
		//remove and load all items in rates comboBoxe
		comboBoxRatesB.removeAllItems();
		fillComboBoxRates();
	}
	
	public void addRoom(){
		
		//declare room object in control layer
		CtrRoom ctrRoomObj = new CtrRoom();
		//declare boolean to determine whether adding was successful or not
		boolean success = false;
		//declare error message string to hold all errors and incorect inputs
		String errorMessage;
		
		//set text pane to null
		textPaneR.setText("");
		
		try{
			
			//declare and initialize all variables needed as user input to add a room
			int roomNumber = Integer.parseInt(textFieldRoomNumberR.getText());
			int capacity = (Integer) comboBoxCapacityR.getSelectedItem();
			
			//check all errors and incorrect user inputs
			errorMessage = ctrRoomObj.checkInputData(roomNumber, capacity);
			//if there are no errors add a room
			if(errorMessage.length() == 0){
				
				//assign success to boolean returned calling add room method in contol layer
				success = ctrRoomObj.addRoom(roomNumber, capacity);
			}
			else{
				
				//if there is an error, show in on a text pane
				textPaneR.setText(errorMessage);
			}

			//feedback to user
			addRoomMessage(success, errorMessage);

		}
		catch(Exception e){
			
			//if there is an exception let the user know
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
			//if user doesnt input integer where its expected, method goes to catch before error message is shown, show a warning to a user
			textPaneR.setText("Please make sure that all fields are filled with numbers");
		}
	}
	
	public void addRoomType(){
		
		//declare room type object in control layer
		CtrRoomType ctrRoomTypeObj = new CtrRoomType();
		//declare boolean to determine whether adding was successful or not
		boolean success = false;
		//declare error message string to hold all errors and incorect inputs
		String errorMessage;
		
		//set text pane to null
		textPaneRoomTypeR.setText("");
		
		try{
			
			//declare and initialize all variables needed as user input to add a room type
			String typeName = textFieldRoomTypeNameR.getText();
			float price = Float.parseFloat(textFieldRoomTypePriceR.getText());
			int capacity = Integer.parseInt(textFieldRoomTypeCapacityR.getText());
			
			//check all errors and incorrect user inputs
			errorMessage = ctrRoomTypeObj.checkInputData(typeName, price, capacity);
			
			//if there are no errors add a room type
			if(errorMessage.length() == 0){
				
				//assign success to boolean returned calling add room type method in contol layer
				success = ctrRoomTypeObj.addRoomType(typeName, price, capacity);
			}
			else{
				
				//if there is an error, show in on a text pane
				textPaneRoomTypeR.setText(errorMessage);
			}

			//feedback to user
			addRoomTypeMessage(success, errorMessage);

		}
		catch(Exception e){
			
			//if there is an exception let the user know
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
			//if user doesnt input integer where its expected, method goes to catch before error message is shown, show a warning to the user
			textPaneR.setText("Please make sure that all fields are filled with numbers");
		}
	}
	
	public void addRates(){
		
		//declare rates object in control layer
		CtrRates ctrRatesObj = new CtrRates();
		//declare boolean to determine whether adding was successful or not
		boolean success = false;
		//declare error message string to hold all errors and incorect inputs
		String errorMessage;
		
		//set text pane to null
		textPaneRatesR.setText("");
		
		try{
			
			//declare and initialize all variables needed as user input to add a rate
			String name = textFieldRatesNameR.getText();
			boolean breakfast = false;
			boolean lunch = false;
			boolean dinner = false;
			
			if(comboBoxRatesBreakfastR.getSelectedItem()== "yes"){
				
				breakfast = true;
			}
			
			if(comboBoxRatesLunchR.getSelectedItem()== "yes"){
				
				lunch = true;
			}
			
			if(comboBoxRatesDinnerR.getSelectedItem()== "yes"){
				
				dinner = true;
			}
			
			//check all errors and incorrect user inputs
			errorMessage = ctrRatesObj.checkInputData(name);
			
			//if there are no errors add a rate
			if(errorMessage.length() == 0){
				
				//assign success to boolean returned calling add rates method in contol layer
				success = ctrRatesObj.addRates(name, breakfast, lunch, dinner);
			}
			else{
				
				//show error on text pane
				textPaneRatesR.setText(errorMessage);
			}

			//feedback to the user
			addRatesMessage(success, errorMessage);

		}
		catch(Exception e){
			
			//if there is an exception let the user know
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
		}
	}
	
	public void addRoomMessage(boolean success, String errorMessage){
		
		if(success == true){
			
			String message =  "Data saved\n";
			JOptionPane.showMessageDialog(null, message);
			refreshTableRoom();
		}
		else{
			
			textPaneR.setText(errorMessage + "\nplease ensure you have entered unique room number");
			JOptionPane.showMessageDialog(null, "An Error has accured while saving the data");
			//setTextFieldsCNull();
		}
	}
	
	public void addRoomTypeMessage(boolean success, String errorMessage){
		
		if(success == true){
			
			String message =  "Data saved\n";
			JOptionPane.showMessageDialog(null, message);
			refreshTableRoomType();
		}
		else{
			
			textPaneRoomTypeR.setText(errorMessage + "\nplease ensure you have entered unique name");
			JOptionPane.showMessageDialog(null, "An Error has accured while saving the data");
			//setTextFieldsCNull();
		}
	}
	
	public void addRatesMessage(boolean success, String errorMessage){
		
		if(success == true){
			
			String message =  "Data saved\n";
			JOptionPane.showMessageDialog(null, message);
			refreshTableRates();
		}
		else{
			
			textPaneRatesR.setText(errorMessage + "\nplease ensure you have entered unique name");
			JOptionPane.showMessageDialog(null, "An Error has accured while saving the data");
			//setTextFieldsCNull();
		}
	}
	
	public void updateRoomMessage(boolean success, String errorMessage, int action){
		
		if(action == 0){
			if(success == true){
				
				String message =  "Data updated\n";
				JOptionPane.showMessageDialog(null, message);
				refreshTableRoom();
			}
			else{
				
				textPaneR.setText(errorMessage + "\nplease ensure you have entered unique room number");
				JOptionPane.showMessageDialog(null, "An Error has accured while saving the data");
				//setTextFieldsCNull();
			}
		}
	}
	
	public void updateRoomTypeMessage(boolean success, String errorMessage, int action){
		
		if(action == 0){
			if(success == true){
				
				String message =  "Data updated\n";
				JOptionPane.showMessageDialog(null, message);
				refreshTableRoomType();
			}
			else{
				
				textPaneRoomTypeR.setText(errorMessage + "\nplease ensure you have entered unique name");
				JOptionPane.showMessageDialog(null, "An Error has accured while saving the data");
				//setTextFieldsCNull();
			}
		}
	}
	
	public void updateRatesMessage(boolean success, String errorMessage, int action){
		
		if(action == 0){
			if(success == true){
				
				String message =  "Data updated\n";
				JOptionPane.showMessageDialog(null, message);
				refreshTableRates();
			}
			else{
				
				textPaneRatesR.setText(errorMessage + "\nplease ensure you have entered unique name");
				JOptionPane.showMessageDialog(null, "An Error has accured while saving the data");
				//setTextFieldsCNull();
			}
		}
	}
	
	public void setTextFieldsRNull(){
		
		textFieldRoomNumberR.setText(null);
		textFieldSearchR.setText("");
	}
	
	public void tableRoomClick(){
		
		try{
			
			int row = tableRoom.getSelectedRow();
			String selectedRoomNumber = (tableRoom.getModel().getValueAt(row, 0)).toString();
			CtrRoom ctrRoomObj = new CtrRoom();
			MdlRoom mdlRoomObj = new MdlRoom();
			
			mdlRoomObj = ctrRoomObj.selectFromTableRoom(selectedRoomNumber);
			
			textFieldRoomNumberR.setText(Integer.toString(mdlRoomObj.getRoomNumber()));
			comboBoxCapacityR.setSelectedItem(mdlRoomObj.getCapacity());
			
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Incorrect data");
			setTextFieldsENull();
		}
	}
	
	public void tableRoomTypeClick(){
		
		try{
			
			int row = tableRoomType.getSelectedRow();
			String selectedRoomTypeName = (tableRoomType.getModel().getValueAt(row, 0)).toString();
			CtrRoomType ctrRoomTypeObj = new CtrRoomType();
			MdlRoomType mdlRoomTypeObj = new MdlRoomType();
			
			mdlRoomTypeObj = ctrRoomTypeObj.selectFromTableRoomType(selectedRoomTypeName);
			
			textFieldRoomTypeNameR.setText(mdlRoomTypeObj.getTypeName());
			textFieldRoomTypePriceR.setText(Float.toString(mdlRoomTypeObj.getPrice()));
			textFieldRoomTypeCapacityR.setText(Integer.toString(mdlRoomTypeObj.getCapacity()));
			
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Incorrect data");
			setTextFieldsENull();
		}
	}
	
	public void tableRatesClick(){
		
		try{
			
			int row = tableRates.getSelectedRow();
			String selectedRatesName = (tableRates.getModel().getValueAt(row, 0)).toString();
			CtrRates ctrRatesObj = new CtrRates();
			MdlRates mdlRatesObj = new MdlRates();
			
			mdlRatesObj = ctrRatesObj.selectFromTableRates(selectedRatesName);
			
			textFieldRatesNameR.setText(mdlRatesObj.getName());
			
			if(mdlRatesObj.isBreakfast() == false){
				
				comboBoxRatesBreakfastR.setSelectedItem("no");
			}
			else{
				
				comboBoxRatesBreakfastR.setSelectedItem("yes");
			}
			
			if(mdlRatesObj.isLunch() == false){
				
				comboBoxRatesLunchR.setSelectedItem("no");
			}
			else{
				
				comboBoxRatesLunchR.setSelectedItem("yes");
			}
			
			if(mdlRatesObj.isDinner() == false){
				
				comboBoxRatesDinnerR.setSelectedItem("no");
			}
			else{
				
				comboBoxRatesDinnerR.setSelectedItem("yes");
			}
			
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Incorrect data");
			setTextFieldsENull();
		}
	}
	
	public void updateRoom(){
		
		CtrRoom ctrRoomObj = new CtrRoom();
		boolean success = false;
		String errorMessage;
		int action = 1;
		
		textPaneR.setText("");
		
		try{
		
			int roomNumber = Integer.parseInt(textFieldRoomNumberR.getText());
			int capacity = (Integer) comboBoxCapacityR.getSelectedItem();
			
			errorMessage = ctrRoomObj.checkInputData(roomNumber, capacity);
			if(errorMessage.length() == 0){
				
				action = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this room?", "Delete", JOptionPane.YES_NO_OPTION);	
				if(action == 0){
					success = ctrRoomObj.updateRoom(roomNumber, capacity);
				}
			}
			else{
				
				textPaneR.setText(errorMessage);
			}
			
			updateRoomMessage(success, errorMessage, action);
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
		}
	}
	
	public void updateRoomType(){
		
		CtrRoomType ctrRoomTypeObj = new CtrRoomType();
		boolean success = false;
		String errorMessage;
		int action = 1;
		
		textPaneRoomTypeR.setText("");
		
		try{
		
			String typeName = textFieldRoomTypeNameR.getText();
			float price = Float.parseFloat(textFieldRoomTypePriceR.getText());
			int capacity = Integer.parseInt(textFieldRoomTypeCapacityR.getText());
			
			errorMessage = ctrRoomTypeObj.checkInputData(typeName, price, capacity);
			if(errorMessage.length() == 0){
				
				action = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this room type?", "Delete", JOptionPane.YES_NO_OPTION);	
				if(action == 0){
					success = ctrRoomTypeObj.updateRoomType(typeName, price, capacity);
				}
			}
			else{
				
				textPaneRoomTypeR.setText(errorMessage);
			}
			
			updateRoomTypeMessage(success, errorMessage, action);
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
		}
	}
	
	public void updateRates(){
		
		CtrRates ctrRatesObj = new CtrRates();
		boolean success = false;
		String errorMessage;
		int action = 1;
		
		textPaneRatesR.setText("");
		
		try{
		
			String name = textFieldRatesNameR.getText();
			boolean breakfast = false;
			boolean lunch = false;
			boolean dinner = false;
			
			if(comboBoxRatesBreakfastR.getSelectedItem()== "yes"){
				
				breakfast = true;
			}
			
			if(comboBoxRatesLunchR.getSelectedItem()== "yes"){
				
				lunch = true;
			}
			
			if(comboBoxRatesDinnerR.getSelectedItem()== "yes"){
				
				dinner = true;
			}
			
			errorMessage = ctrRatesObj.checkInputData(name);
			
			if(errorMessage.length() == 0){
				
				action = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this rate?", "Delete", JOptionPane.YES_NO_OPTION);	
				if(action == 0){
					success = ctrRatesObj.updateRates(name, breakfast, lunch, dinner);
				}
			}
			else{
				
				textPaneRatesR.setText(errorMessage);
			}
			
			updateRatesMessage(success, errorMessage, action);
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
		}
	}
	
	public void deleteRoom(){
		
		CtrRoom ctrRoomObj = new CtrRoom();
		int action;
		
		textPaneR.setText("");
		
		try{
			
			int roomNumber = Integer.parseInt(textFieldRoomNumberR.getText());	
			
			action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this room?", "Delete", JOptionPane.YES_NO_OPTION);		
			if(action == 0){
				
				ctrRoomObj.deleteRoom(roomNumber);
				JOptionPane.showMessageDialog(null, "Data deleted");
			}
			
			refreshTableRoom();
			
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Unable to delete");
		}
		
	}
	
	public void deleteRoomType(){
		
		CtrRoomType ctrRoomTypeObj = new CtrRoomType();
		boolean success = false;
		int action;
		
		textPaneRoomTypeR.setText("");
		
		try{
			
			String typeName = textFieldRoomTypeNameR.getText();	
			
			action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this room type?", "Delete", JOptionPane.YES_NO_OPTION);		
			if(action == 0){
				success = ctrRoomTypeObj.deleteRoomType(typeName);
				JOptionPane.showMessageDialog(null, "Data deleted");
			}
			
			refreshTableRoomType();
			
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Unable to delete");
		}
		
	}
	
	public void deleteRates(){
		
		CtrRates ctrRatesObj = new CtrRates();
		boolean success = false;
		int action;
		
		textPaneRatesR.setText("");
		
		try{
			
			String name = textFieldRatesNameR.getText();	
			
			action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this rate?", "Delete", JOptionPane.YES_NO_OPTION);		
			if(action == 0){
				success = ctrRatesObj.deleteRates(name);
				JOptionPane.showMessageDialog(null, "Data deleted");
			}
			
			refreshTableRates();
			
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Unable to delete");
		}
		
	}
	
	public void searchRoom(){
		
		CtrRoom ctrRoomObj = new CtrRoom();
		ResultSet rs;
		
		textPaneR.setText("");
		
		try{
			
			String selection = (String) comboBoxR.getSelectedItem();
			String searchCRoom = textFieldSearchR.getText();
			rs = ctrRoomObj.searchRoom(selection, searchCRoom);
			
			tableRoom.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "An error has accrued while searching");
		}
	}
	
	public void fillComboBoxCapacity(){
		
		for (int i = 1; i<=4; i++){
			
			comboBoxCapacityR.addItem(i);
		}

	}
	
	//BOOKING
	
	//method to refresh table ( used in constructor and refresh booking button in action performed method ) 
	public void refreshTableBooking(){
		
		//declare object in CtrBooking class - control layer
		CtrBooking ctrBookObj = new CtrBooking();
		//set table booking using resultset returned from refreshTableBooking method in control layer (DBUtils library used ) 
		tableBooking.setModel(DbUtils.resultSetToTableModel(ctrBookObj.refreshTableBooking()));
		//set all text fields in Booking tabbed pane to null
		setTextFieldsBNull();
		//set text pane to null
		textPaneB.setText("");
		
		//set discount radio buttons and textfield to default possition
		rbBtnDiscountPercentB.setSelected(true);
		textFieldDiscountPercentB.setEditable(true);
		rbBtnDiscountAmmountB.setSelected(false);
		textFieldDiscountAmmountB.setEditable(false);
		
	}
	
	//method which fills textField/ comboBoxex / radio buttons on click on the table by user
	public void tableBookingClick(){
		
		//date format used when converting sql date to string
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			
			//declare row number in the table
			int row = tableBooking.getSelectedRow();
			//declare selected, clicked Id
			String selectedBookingId = (tableBooking.getModel().getValueAt(row, 0)).toString();
			//declare ctrBooking and mdlBooking Objects in CtrBooking class in control layer and MdlBookingclass in model layer
			CtrBooking ctrBookObj = new CtrBooking();
			MdlBooking mdlBookObj = new MdlBooking();
		
			//assign model booking object to returned object from method selectFromTableBooking() passing selected booking ID as argument
			mdlBookObj = ctrBookObj.selectFromTableBooking(selectedBookingId);
			
			//set radio buttons and textfield as not sellected and not editable
			rbBtnDiscountPercentB.setSelected(false);
			rbBtnDiscountAmmountB.setSelected(false);
			textFieldDiscountPercentB.setEditable(false);
			textFieldDiscountAmmountB.setEditable(false);
			
			//fill text field in booking tabbed pane using booking model object
			textFieldIdB.setText(Integer.toString(mdlBookObj.getId()));
			textFieldCustomerUsernameB.setText(mdlBookObj.getCustomerUsername());
			textFieldEmployeeUsernameB.setText(mdlBookObj.getEmployeeUsername());
			textFieldBookedFromB.setText(df.format(mdlBookObj.getBookedFrom()));
			textFieldBookedTilB.setText(df.format(mdlBookObj.getBookedTill()));
			textFieldRoomNumberB.setText(Integer.toString(mdlBookObj.getRoomNumber()));
			textFieldPriceB.setText(Float.toString(mdlBookObj.getPrice()));
			
			//set sellected values of combo boxes using model booking object
			comboBoxRoomTypeB.setSelectedItem(mdlBookObj.getRoomType());
			comboBoxRatesB.setSelectedItem(mdlBookObj.getRates());
			comboBoxNumberOfPeopleB.setSelectedItem(mdlBookObj.getNumberOfPeople());
			
			//set discount 
			textFieldDiscountPercentB.setText(Integer.toString(mdlBookObj.getDiscount()));
			textFieldDiscountPercentB.setEditable(true);
			rbBtnDiscountPercentB.setSelected(true);
			
			//set dates
			textFieldSearchBookedFromB.setText(df.format(mdlBookObj.getBookedFrom()));
			textFieldSearchBookedTillB.setText(df.format(mdlBookObj.getBookedTill()));
			
			//call calculate price method to calculate price based on the text field values
			calculatePrice();
		}
		catch(Exception e){
			
			//if there is an exception let user know
			JOptionPane.showMessageDialog(null, "Incorrect data");
			//set all text fields to null
			setTextFieldsENull();
		}
	}
	
	public void calculatePrice(){
		
		//declare ctrBooking and mdlBooking Objects in CtrBooking class in control layer and MdlBookingclass in model layer 
		MdlBooking mdlBookObj = new MdlBooking();
		CtrBooking ctrBookObj = new CtrBooking();
		//declare boolean percent to determing whether discount is in percent or ammount
		boolean percent = false;
		
		try{
			
			//set values in mdlBookObj by taking them from textFields
			mdlBookObj.setBookedFrom(java.sql.Date.valueOf(textFieldBookedFromB.getText()));
			mdlBookObj.setBookedTill(java.sql.Date.valueOf(textFieldBookedTilB.getText()));
			mdlBookObj.setRoomType((String) comboBoxRoomTypeB.getSelectedItem());
			mdlBookObj.setRates((String) comboBoxRatesB.getSelectedItem());
			
			//if there is a discount in percent, set model obj and set percent to true
			if(textFieldDiscountPercentB.getText().length() > 0){
				
				mdlBookObj.setDiscount(Integer.parseInt(textFieldDiscountPercentB.getText()));
				percent = true;
			}
			
			//if there is a discount in ammount, set model obj and percent to false
			else if(textFieldDiscountAmmountB.getText().length() > 0){
				
				mdlBookObj.setDiscountAmmount(Float.parseFloat(textFieldDiscountAmmountB.getText()));
				percent = false;
			}
			
			//if discount wasnt entered, set it to null and set percent to true
			else{
				
				mdlBookObj.setDiscount(0);
				percent = true;
			}
	
			//assign model object to returned obj calling calculate price method in control layer, passing model obj and boolean percent as argument
			mdlBookObj = ctrBookObj.calculatePrice(mdlBookObj, percent);
			
			//show price in the text field using model object
			textFieldPriceB.setText(Float.toString(mdlBookObj.getPrice()));
			
		}
		catch(Exception e){
		}
	}
	
	//method that fills date from, date till and room number base on the selected option clicked on table rooms in booking tabbed pane
	public void tableBookingRoomsClick(){
				
		try{
			
			//declare row number in the table
			int row = tableBookingRooms.getSelectedRow();
			//declare selected, clicked Id
			String selectedRoomNumber = (tableBookingRooms.getModel().getValueAt(row, 0)).toString();
			//declare ctrBooking and mdlRoom Objects in CtrBooking class in control layer and MdlRoom class in model layer
			CtrBooking ctrBookObj = new CtrBooking();
			MdlRoom mdlRoomObj = new MdlRoom();
		
			//assign model room obj to returned object of selectFromTableBookingRooms method passing room number as argument
			mdlRoomObj = ctrBookObj.selectFromTableBookingRooms(selectedRoomNumber);
			
			//set room number in the booking part using mdl room OBj
			textFieldRoomNumberB.setText(Integer.toString(mdlRoomObj.getRoomNumber()));
			textFieldBookedFromB.setText(textFieldSearchBookedFromB.getText());
			textFieldBookedTilB.setText(textFieldSearchBookedTillB.getText());

		}
		catch(Exception e){
			
			//let user know if there is an excption
			JOptionPane.showMessageDialog(null, "Incorrect data");
			//set text field to null
			setTextFieldsENull();
		}
	}
	
	public void searchDate(){
		
		try{	
			//initialize variables to values entered in text fields
			java.sql.Date bookedFrom =  java.sql.Date.valueOf(textFieldSearchBookedFromB.getText());
			java.sql.Date bookedTill =  java.sql.Date.valueOf(textFieldSearchBookedTillB.getText());
			
			//only continue if 1st date is before 2nd
			if(bookedFrom.compareTo(bookedTill) < 0 ){
				
				//create booking object in control layer
				CtrBooking ctrBookObj = new CtrBooking();
				//declare result set
				ResultSet rs;
				
				//assign result set to returned result set of method search date in control layer
				rs = ctrBookObj.searchDate(bookedFrom, bookedTill);
				//set table of available rooms based on resultset
				tableBookingRooms.setModel(DbUtils.resultSetToTableModel(rs));
			}
			else{
				
				//lets user know that he inputed incorrect dates
				JOptionPane.showMessageDialog(null, "Incorrect dates");
				//set text fields to null
				textFieldSearchBookedFromB.setText(null);
				textFieldSearchBookedTillB.setText(null);
			}
		}
		catch(Exception e){
			
			//if there is an exception let user know that he should use following format
			JOptionPane.showMessageDialog(null, "Incorrect date format (use yyyy-mm-dd)");
		}
	}
	
	public void setNumberOfPeople(){
		
		CtrRoomType ctrRoomTypeObj = new CtrRoomType();
		MdlRoomType mdlRoomTypeObj = new MdlRoomType();
		String roomType = (String) comboBoxRoomTypeB.getSelectedItem();
		
		mdlRoomTypeObj = ctrRoomTypeObj.selectFromTableRoomType(roomType);
		
		comboBoxNumberOfPeopleB.removeAllItems();
		fillComboBoxNumberOfPeople(mdlRoomTypeObj.getCapacity());
		comboBoxNumberOfPeopleB.setSelectedItem(mdlRoomTypeObj.getCapacity());
	}
	
	//add booking method
	public void addBooking(){
		
		//declare booking object in control layer
		CtrBooking ctrBookObj = new CtrBooking();
		//declare boolean success to determine whether adding was successful or not
		boolean success = false;
		//declar boolean successRoomDates to determine whether available dates and room number were entered
		boolean successRoomDates = false;
		//declare string errorMessage to hold all errors and incorrect inputs
		String errorMessage;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int currectRoomNumber;

		//declare discount variables and initialize them to zero
		int discountPercent = 0;
		float discountAmmount = 0;
		
		//set text field to null
		textPaneB.setText("");
		
		try{
			
			//declare and initialize variables needed as user input to textfields and comboBoxes
			String customerUsername = textFieldCustomerUsernameB.getText();
			String employeeUsername = username;
			java.sql.Date bookedFrom = java.sql.Date.valueOf(textFieldBookedFromB.getText());
			java.sql.Date bookedTill = java.sql.Date.valueOf(textFieldBookedTilB.getText());
			int roomNumber = Integer.parseInt(textFieldRoomNumberB.getText());
			String roomType = (String) comboBoxRoomTypeB.getSelectedItem();
			String rates = (String) comboBoxRatesB.getSelectedItem();
			int numberOfPeople = (int) comboBoxNumberOfPeopleB.getSelectedItem();
			float price = Float.parseFloat(textFieldPriceB.getText());
			
			//if text field discount PERCENT is filled initialize discount percent
			if(textFieldDiscountPercentB.getText().length() > 0){
				
				discountPercent = Integer.parseInt(textFieldDiscountPercentB.getText());
			}
			
			//if text field discount AMMOUNT is filled initialize discount ammount ( its only possible to have either discount percent, or discount ammount variable holding any value)
			if(textFieldDiscountAmmountB.getText().length() > 0){
				
				discountAmmount = Float.parseFloat(textFieldDiscountAmmountB.getText());
			}
			
			//assign errorMessage to string returned calling checkInputData in control layer
 			errorMessage = ctrBookObj.checkInputData(customerUsername, employeeUsername, bookedFrom, bookedTill, roomNumber, roomType, rates, numberOfPeople,discountPercent, discountAmmount);
 			//assign boolean seccessRoomDates to returned boolean of method checkRoomAvailability - checks if dates are available for particular room number
 			successRoomDates = checkRoomAvailability(bookedFrom, bookedTill, roomNumber);
 			//if successRoomDates is false, add error to errorMessage
 			errorMessage = confirmRoomAvailability(errorMessage, successRoomDates, roomNumber);
 			
 			//if there are no errors, add a room
 			if(errorMessage.length() == 0){
				
 				//assign success to boolean returned calling add roomMethod, passing all inputed variables as arguments
				success = ctrBookObj.addBooking(customerUsername, employeeUsername, bookedFrom, bookedTill, roomNumber, roomType, rates, numberOfPeople, discountPercent, discountAmmount, price);
			}
			else{
				
				//if there are errors, write them to text pane
				textPaneB.setText(errorMessage);
			}

 			//feedback to user
			addBookingMessage(success, errorMessage, successRoomDates);

		}
		catch(Exception e){
			
			//if there is an exception let user know
			JOptionPane.showMessageDialog(null, "Incorrect input Data");
			//there might be a catch before errorMessage is shown on a textPane, show user a warning
			textPaneB.setText("Please make sure you have entered correct information");
		}
	}
	
	//method checks if room is available in entered date period
	public boolean checkRoomAvailability(java.sql.Date bookedFrom, java.sql.Date bookedTill, int roomNumber){
		
		//declare success to determine whether room is available or not
		boolean success = false;
		//declare booking object in control layer
		CtrBooking ctrBookObj = new CtrBooking();
		//declare variable to hold roomNumber while looping through result set
		int currentRoomNumber;
		//declare result set
		ResultSet rs;
		
		try{
			//check if this room is available in this time interval	 (returns result set with FREE ROOMS )
			rs = ctrBookObj.searchDate(bookedFrom, bookedTill);
			//loop through result set
			while(rs.next()){
					
				//assign room number found in result set to currentRoomNumber
				currentRoomNumber =rs.getInt("room_number");
				//if this roomNumber equals to room number we want to book - room is free
				if(currentRoomNumber == roomNumber){
						
					success = true;
				}
		}
		}catch(Exception e){
			
			//coment for programmer
			System.out.println("Error while searching for room availability");
		}
		
		//method returns boolean success
		return success;
	}
	
	//method updates errorMessage based on boolean success
	public String confirmRoomAvailability(String errorMessage, boolean success, int roomNumber){
		
		if(success == false){
				
			//if success is false - room is not available in particular date period
			errorMessage = errorMessage + "Incorect date input\nPlease ensure entered date is available for room number "+ roomNumber;
			}
		
		return errorMessage;
	}
	
	//update booking method
	public void updateBooking(){
				
		//create booking object in control layer
		CtrBooking ctrBookObj = new CtrBooking();
		
		//set text pane to null
		textPaneB.setText("");
		//update booking based on ID
		int id = Integer.parseInt(textFieldIdB.getText());
		
		//update booking - delete booking and add new afterwards - causes change in ID
		ctrBookObj.deleteBooking(id);
		addBooking();
	}
	
	public void deleteBooking(){
		
		//declare booking object in control layer
		CtrBooking ctrBookObj = new CtrBooking();
		//declare action - users response to confirm dialog
		int action;
		
		//set text pane to null
		textPaneB.setText("");
		
		try{
			
			//declare and initialize integer to value in text field
			int id = Integer.parseInt(textFieldIdB.getText());	
			
			//assign action to user choice in confirm dialog
			action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this booking?", "Delete", JOptionPane.YES_NO_OPTION);		
			if(action == 0){
				
				//if user responds yes - delete booking, pass ID as parameter
				ctrBookObj.deleteBooking(id);
				//let user know that booking was deleted
				JOptionPane.showMessageDialog(null, "Data deleted");
			}
			
			//refresh table booking
			//set variables null
			refreshTableBooking();
			
		}
		catch(Exception e){
			
			//if there is an exception let user know
			JOptionPane.showMessageDialog(null, "Unable to delete");
		}
		
	}
	
	//message to be printed for user
	public void addBookingMessage(boolean success, String errorMessage, boolean successRoomDates){
		
		//if booking was successful and room is available
		if(success == true && successRoomDates == true){
			
			//declare and initialize message
			String message =  "Data saved\n";
			//show message on message dialog
			JOptionPane.showMessageDialog(null, message);
			//refresh table booking, set textfields null
			refreshTableBooking();
		}
		else{
			
			//if there is an error, show it on the text pane
			textPaneB.setText(errorMessage + "\nplease ensure you have entered correct information");
			//if there is an error show it on the screen
			JOptionPane.showMessageDialog(null, "An Error has accured while saving the data");
		}
	}
	
	public void searchBooking(){
		
		//declare booking object in control layer
		CtrBooking ctrBookObj = new CtrBooking();
		//declare result set
		ResultSet rs;
		
		//set text pane to null
		textPaneB.setText("");
		
		try{
			
			//declare and initialize users selection ( column in the database table )
			String selection = (String) comboBoxB.getSelectedItem();
			//declare and initialize what user wants to search for
			String searchBooking = textFieldSearchB.getText();
			//initialize result set to result set returned from control layer
			rs = ctrBookObj.searchBooking(selection, searchBooking);
			
			//set table based on the result set, using DbUtils libarry
			tableBooking.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e){
			
			//if there is an excetion let user know
			JOptionPane.showMessageDialog(null, "An error has accrued while searching");
		}
	}
	
	//used at combo box searchs action listener
	public void searchAllCheckIns(){
		
		//declare selection ( column in the database )
		String selection = (String) comboBoxB.getSelectedItem();
		//declare objectin control layer
		CtrBooking ctrBookObj = new CtrBooking();
		//declare result set
		ResultSet rs;
		
		try{
		
			//if user chooses all check ins on the comboBox
			if(selection == "All_Checked_in"){
				
				//assign result set
				rs = ctrBookObj.searchBooking(selection, null);
				//set table model based on result set
				tableBooking.setModel(DbUtils.resultSetToTableModel(rs));
			}
		}
		catch(Exception e){
			
			//if there is an exception let user know
			JOptionPane.showMessageDialog(null, "An error has accrued while searching");
		}
	}
	
	public void checkIn(){
		
		//declare booking object in control layer
		CtrBooking ctrBookObj = new CtrBooking();
		int id;
		boolean exists = true;
		boolean success = true;
		int action;
		
		try{
			id = Integer.parseInt(textFieldIdB.getText());
			//check if this booking was already checked in
			exists = ctrBookObj.checkExistingCheckIn(id);
			//check if booked from is after (or equal to) current date
			success = ctrBookObj.checkCheckInDate(id);
			
			//let user know its unable to check in
			if(success == false){
				
				JOptionPane.showMessageDialog(null, "Unable to check in, room isnt reserved yet");
			}
			
			//if check in doesnt exist and date is available
			if(exists == false && success == true){
				
				//ask user to confirm
				action = JOptionPane.showConfirmDialog(null, "Are you sure you want to check in?", "Delete", JOptionPane.YES_NO_OPTION);		
				if(action == 0){
					
					//if user confirms - do check in
					ctrBookObj.checkInCurrentDate(id);
					//let user know that check in was successful
					JOptionPane.showMessageDialog(null, "Booking ID: " + id +" checked in");
					//refresh table booking, set text fields to null
					refreshTableBooking();
				}
			}
		}
		catch(Exception e){
			
			//if there is an exception let user know
			JOptionPane.showMessageDialog(null, "Unable to check in");
		}
	}
	
	public void checkOut(){
			
		//when check out button is clicked - update archive first
		archive();	
	}
	
	public void checkOutDelete(){
		
		//delete data after check out
		
		//declare booking object in control layer
		CtrBooking ctrBookObj = new CtrBooking();
		//declare customer object in control layer
		CtrCustomer ctrCusObj = new CtrCustomer();
		//get customer username from text field
		String customerUsername = textFieldCustomerUsernameB.getText();
		//declare result set
		ResultSet rs;
		int counter = 0;
		int id = -1;
		boolean successBooking = false;
		boolean successCustomer = false;
		
		try{
			//resultset contains * from booking
			rs = ctrBookObj.refreshTableBooking();
			//get id from text field
			id = Integer.parseInt(textFieldIdB.getText());
			
			//while result set contins data
			while(rs.next()){
				
				//count how many bookings has particular customer
				if(rs.getString("customer_username").equals(customerUsername)){
					
					//increment counter
					counter++;
				}
			}
			
			//if there is exactly one booking with this username
			if(counter == 1){
				
				//delete booking from database table booking
				successBooking = ctrBookObj.deleteBooking(id);
				//delete customer from database table customer
				successCustomer = ctrCusObj.deleteCustomer(customerUsername);

			}
			//if there is more than one booking with this username
			else if(counter > 1){
				
				//delete from booking only - keep customer in the database
				successBooking = ctrBookObj.deleteBooking(id);
			}
			
			
			//refresh all tables affected
			refreshTableBooking();
			refreshTableArchive();
			refreshTableCustomer();
			
			//if both deletes failed
			if(successCustomer == false && successBooking == false){
				
				System.out.println("Unable to delete");
			}
			
		}catch(Exception e){
			
			System.out.println("Unable to delete");
		}
	}
	
	//set all text field to null
	public void setTextFieldsBNull(){
		
		textFieldIdB.setText(null);
		textFieldCustomerUsernameB.setText(null);
		textFieldEmployeeUsernameB.setText(null);
		textFieldBookedFromB.setText(null);
		textFieldBookedTilB.setText(null);
		textFieldRoomNumberB.setText(null);
		textFieldPriceB.setText(null);
		textFieldDiscountAmmountB.setText(null);
		textFieldDiscountPercentB.setText(null);
	}
	
	//fill combo box room type
	public void fillComboBoxRoomType(){
		
		//declare array list
		ArrayList<String> roomTypeList = new ArrayList<>();
		//declare room type object in control layer
		CtrRoomType ctrRoomTypeObj = new CtrRoomType();
		
		//assign array list
		roomTypeList = ctrRoomTypeObj.getAllRoomTypes();
		
		//go through every element in the array list
		for (String roomType : roomTypeList) {
			
			//add element to the combo box
			comboBoxRoomTypeB.addItem(roomType);
		}
	}
	
	public void fillComboBoxRates(){
		
		ArrayList<String> ratesList = new ArrayList<>();
		CtrRates ctrRatesObj = new CtrRates();
		
		ratesList = ctrRatesObj.getAllRates();
		
		for (String rates : ratesList) {
			
			comboBoxRatesB.addItem(rates);
		}
	}
	
	//fill combo box with predefined values 
	public void fillComboBoxNumberOfPeople(int max){
		
		for(int i = 1; i<= max; i++){
			
			comboBoxNumberOfPeopleB.addItem(i);
			
		}
	}
	
	//ARCHIVE
	
	public void archive(){
		
		String customerUsername;
		String currentDate;
		int id;
		int action;
		ResultSet rs;
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CtrCustomer ctrCusObj = new CtrCustomer();
		MdlCustomer mdlCusObj = new MdlCustomer();
		CtrBooking ctrBookObj = new CtrBooking();
		MdlBooking mdlBookObj = new MdlBooking();
		
		//customer information
		String name;
		String surname;
		String country;
		String city;
		String street;
		String zipCode;
		String contact;
		
		//booking information
		java.sql.Date bookedFrom;
		java.sql.Date bookedTill;
		java.sql.Date checkedIn;
		java.sql.Date checkedOut;
		int roomNumber;
		
		try{
			currentDate = dateFormat.format(date);
			
			customerUsername = textFieldCustomerUsernameB.getText();
			mdlCusObj = ctrCusObj.selectFromTableCustomer(customerUsername);
			id = Integer.parseInt(textFieldIdB.getText());
			mdlBookObj = ctrBookObj.selectFromTableBooking(Integer.toString(id));
			
			name = mdlCusObj.getName();
			surname = mdlCusObj.getSurname();
			country = mdlCusObj.getCountry();
			city = mdlCusObj.getCity();
			street = mdlCusObj.getStreet();
			zipCode = mdlCusObj.getZipCode();
			contact = mdlCusObj.getContact();
			
			bookedFrom = mdlBookObj.getBookedFrom();
			bookedTill = mdlBookObj.getBookedTill();
			
			checkedIn = getCheckInDate(id);
			checkedOut = java.sql.Date.valueOf(currentDate);
			
			roomNumber = mdlBookObj.getRoomNumber();
			
			action = JOptionPane.showConfirmDialog(null, "Are you sure you want to check out?", "Delete", JOptionPane.YES_NO_OPTION);
			if(action == 0){
				addArchive(name, surname, country, city, street, zipCode, contact, bookedFrom, bookedTill, checkedIn, checkedOut, roomNumber);
			}
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Please select booking to check out");
		}
	}
	
	public java.sql.Date getCheckInDate(int id){
		
		java.sql.Date checkedIn;
		CtrBooking ctrBookObj = new CtrBooking();
		
		checkedIn = ctrBookObj.getCheckInDate(id);
		
		return checkedIn;
	}
	
	public void addArchive(String name, String surname, String country, String city, String street, String zipCode, String contact, java.sql.Date bookedFrom, java.sql.Date bookedTill, java.sql.Date checkedIn, java.sql.Date checkedOut, int roomNumber){
		
		boolean success = false;
		CtrArchive ctrArchObj = new CtrArchive();
		String customerUsername = textFieldCustomerUsernameB.getText();
		int id = Integer.parseInt(textFieldIdB.getText());
		
		success = ctrArchObj.addArchive(name, surname, country, city, street, zipCode, contact, bookedFrom, bookedTill, checkedIn, checkedOut, roomNumber);
		
		if(success == true){
			
			Invoice(customerUsername,id);
			refreshTableArchive();
			checkOutDelete();
		}
		else{
			
			JOptionPane.showMessageDialog(null,  "Unable to update archive");
			textPaneB.setText("Please ensure that this booking has been checked in");
		}
	}
	
	public void refreshTableArchive(){
		
		CtrArchive ctrArchObj = new CtrArchive();
		tableArchive.setModel(DbUtils.resultSetToTableModel(ctrArchObj.refreshTableArchive()));
		textPaneB.setText("");
		textFieldSearchA.setText(null);
		
	}
	
	public void searchArchive(){
		
		CtrArchive ctrArchObj = new CtrArchive();
		ResultSet rs;
		
		try{
			
			String selection = (String) comboBoxA.getSelectedItem();
			String searchArchive = textFieldSearchA.getText();
			rs = ctrArchObj.searchArchive(selection, searchArchive);
			
			tableArchive.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "An error has accrued while searching");
		}
	}
	
	//INVOICE
	
	public void Invoice(String username, int id){
		
		GUIInvoice inv = new GUIInvoice(username, id);
		inv.setVisible(true);
		refreshTableInvoice();
	}
	
	public void refreshTableInvoice(){
		
		CtrInvoice ctrInvObj = new CtrInvoice();
		tableInvoice.setModel(DbUtils.resultSetToTableModel(ctrInvObj.refreshTableInvoice()));
	}
	
	public void tableInvoiceClick(){
		
		String path = "C:\\Users\\MPJ\\Desktop\\invoice\\";
		String fileName;
		String name;
		String surname;
		int id;
		File file;
		FileReader reader;
		BufferedReader br;
		
		try{
			
			int row = tableInvoice.getSelectedRow();
			String selectedId = (tableInvoice.getModel().getValueAt(row, 0)).toString();
			CtrInvoice ctrInvObj = new CtrInvoice();
			MdlInvoice mdlInvObj = new MdlInvoice();
			
			mdlInvObj = ctrInvObj.selectFromTableInvoice(selectedId);
			
			name = mdlInvObj.getName();
			surname = mdlInvObj.getSurname();
			id = mdlInvObj.getId();
			
			fileName = name + "_" + surname + "_" + id + ".txt";
			file = new File(path + fileName);
			
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			
			textAreaInvoice.read(br, null);
			br.close();
			textAreaInvoice.requestFocus();
				
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Incorrect data");
			setTextFieldsENull();
		}
	}
	
	public void searchInvoice(){
		
		CtrInvoice ctrInvObj = new CtrInvoice();
		ResultSet rs;
		
		try{
			
			String selection = (String) comboBoxSearchI.getSelectedItem();
			String searchInvoice = textFieldSearchI.getText();
			rs = ctrInvObj.searchInvoice(selection, searchInvoice);
			
			tableInvoice.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "An error has accrued while searching");
		}
	}
		
	//STATISTICS
	
	public void refreshStatistics(){
		
		getAllCustomers();
		getAllEmployees();
		getAllRooms();
		getAllBookings();
		getAvaragePrice();
	}
	
	public void getAllCustomers(){
		
		int registeredCustomers;
		int danishCustomers;
		CtrStatistics ctrStatObj = new CtrStatistics();
		
		registeredCustomers = ctrStatObj.getRegisteredCustomers();
		danishCustomers = ctrStatObj.getDanishCustomers();
		
		textFieldRegisteredCustomersS.setText(Integer.toString(registeredCustomers));
		textFieldDanishCustomersS.setText(Integer.toString(danishCustomers));
	}
	
	public void getAllEmployees(){
		
		int registeredEmployees;
		float avarageSalary;
		CtrStatistics ctrStatObj = new CtrStatistics();
		
		registeredEmployees = ctrStatObj.getRegisteredEmployees();
		avarageSalary = ctrStatObj.getAvarageSalary();
		
		textFieldRegisteredEmployeesS.setText(Integer.toString(registeredEmployees));
		textFieldAvarageSalaryS.setText(Float.toString(avarageSalary));
	}
	
	public void getAllRooms(){
		
		int rooms;
		CtrStatistics ctrStatObj = new CtrStatistics();
		
		rooms = ctrStatObj.getNumberOfRooms();
		
		textFieldNumberOfRoomsS.setText(Integer.toString(rooms));
		
	}
	
	public void getAllBookings(){
		
		int bookings;
		int checkedIn;
		CtrStatistics ctrStatObj = new CtrStatistics();
		
		bookings = ctrStatObj.getNumberOfBookings();
		checkedIn = ctrStatObj.getCheckedIn();
		
		textFieldNumberOfBookingsS.setText(Integer.toString(bookings));
		textFieldCheckedInBookingsS.setText(Integer.toString(checkedIn));
	}
	
	public void getSelectedRoomOccupancy(){
				
		CtrStatistics ctrStatObj = new CtrStatistics();
		int roomNumber = (int) comboBoxRoomNumberS.getSelectedItem();
		int year;
		
		if(comboBoxYearS.getSelectedItem() != null){
			year = (int ) comboBoxYearS.getSelectedItem();
		}
		else{
			
			year = 2015;
		}
		int days = 0;
		
		days = ctrStatObj.getOccupancy(roomNumber, year);
		
		textFieldOccupancyRateS.setText(Integer.toString(days));
		
	}
	
	public void getAvaragePrice(){
		
		float avaragePrice = 0;
		CtrStatistics ctrStatObj = new CtrStatistics();
		
		avaragePrice = ctrStatObj.getAvaragePrice();
		
		textFieldAvaragePriceS.setText(Float.toString(avaragePrice));
	}
	
	public void fillComboBoxYearS(){
		
		for (int i = 2015; i< 2030; i++){
			
			comboBoxYearS.addItem(i);
		}
	}
	
	public void fillComboBoxRoomS(){
		
		ResultSet rs;
		CtrRoom ctrRoomObj = new CtrRoom();
		
		try{
			
			rs = ctrRoomObj.refreshTableRoom();
			while(rs.next()){
				
				comboBoxRoomNumberS.addItem(rs.getInt("Room_number"));
			}
		}
		catch(Exception e){
			
			System.out.println("Error while filling combo box Rooms in statistics");
		}
	}
}
