package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import dbLayer.DbConnection;

import javax.swing.JButton;

import controlLayer.CtrLogin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUILogin {
	
	//declare connection object
	Connection connection = null;
	
	private JFrame frmLogIn;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPassword;
	private JLabel lblLblimage;
	
	//declare global variables
	public int securityLevel;
	public boolean access;
	private JButton btnLogIn;
	public String username;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GUILogin window = new GUILogin();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}


	public GUILogin() {
		//initialize variables
		initialize();
	}

	private void initialize() {
		
		//run connector method in dbConnection class which returns connection
		connection = DbConnection.DbConnector();
		//set variables to defaults
		securityLevel = 0;
		access = false;
		
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log in");
		frmLogIn.setBounds(100, 100, 529, 352);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(190, 84, 76, 50);
		frmLogIn.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(190, 128, 76, 50);
		frmLogIn.getContentPane().add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(276, 85, 200, 35);
		frmLogIn.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(276, 137, 200, 35);
		frmLogIn.getContentPane().add(passwordFieldPassword);
		
		lblLblimage = new JLabel("");
		lblLblimage.setIcon(new ImageIcon("C:\\Users\\MPJ\\workspace\\ProjectHotel\\icons\\Login-icon.png"));
		lblLblimage.setBounds(23, 85, 142, 144);
		frmLogIn.getContentPane().add(lblLblimage);
		
		btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//checks for correct username and password, returns integer, if rs.next is true, securityLevel wont be equal to 0
				securityLevel = checkLoginData();
				//set access base on security level
				checkCount(securityLevel);
			}
		});
		btnLogIn.setBounds(394, 194, 82, 35);
		frmLogIn.getContentPane().add(btnLogIn);
	}
	
	public int checkLoginData(){
		
		//create obj in CtrLogin class
		CtrLogin ctrLogObj = new CtrLogin();
		//declare variables and initialize them to the text in the fields
		String username = textFieldUsername.getText();
		String password = passwordFieldPassword.getText();
		
		//*encrypts entered password to match encrypted password in the database
		password = decodePassword(password);
		
		//check if entered values exist in the database
		securityLevel = ctrLogObj.checkLoginData(username, password);
		
		return securityLevel;
	}
	
	public void checkCount(int securityLevel){
		
		//case 1 and 2, user exists in the database, default incorrect information
		switch(securityLevel){
		
			case 1:{
				
				setAccess(securityLevel);
				break;
			}
			case 2:{
				
				setAccess(securityLevel);
				break;
			}
			default: {
				
				JOptionPane.showMessageDialog(null, "Username or password are not correct");
				textFieldUsername.setText(null);
				passwordFieldPassword.setText(null);
			}
		}
		
	}
	
	private void dispose(){
		
		username = textFieldUsername.getText();
		frmLogIn.dispose();
		GUIMain main = new GUIMain(access, username);
		main.setVisible(true);
	}
	
	private void setAccess(int securityLevel){
		
		
		//set access base on security level
		if(securityLevel == 1){
			
			access = true;
		}
		else{
			
			access = false;
		}
		
		dispose();
	}
	
	private String decodePassword(String password){
		
		//declare
		String result = "";
		char ch;
		
		//change every character in password, return new password
		for(int i = 0; i< password.length(); i++){
			
			ch = password.charAt(i);
			ch += 2;
			result = result + ch;
			
		}
		
		return result;
	}
}
