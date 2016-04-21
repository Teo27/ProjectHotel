package controlLayer;

import java.sql.ResultSet;
import java.util.Random;

import modelLayer.MdlCustomer;
import modelLayer.MdlEmployee;
import dbLayer.DbCustomer;
import dbLayer.DbEmployee;

public class CtrCustomer {

	String password = "00000";
	
	public CtrCustomer(){
		
		
	}
	
	public ResultSet refreshTableCustomer(){
		
		ResultSet rs;
		DbCustomer cusDbObj = new DbCustomer();
		
		rs = cusDbObj.refreshTableCustomer();

		return rs;
	}
	
	public MdlCustomer selectFromTableCustomer(String selectedUsername){
		
		DbCustomer dbCusObj = new DbCustomer();
		MdlCustomer mdlCusObj = new MdlCustomer();
		
		mdlCusObj = dbCusObj.selectFromTableCustomer(selectedUsername);
		
		return mdlCusObj;
	}
	
	
	public boolean addCustomer(String username, String name, 
			String surname, String customerType, String gender, String country, String city, String street, String zipCode, String contact){
		
 		MdlCustomer mdlCusObj = new MdlCustomer();
 		DbCustomer dbCusObj = new DbCustomer();
	 
		boolean success = false;
				
    	password = generatePassword();
		password = encryptPassword(password);
		
		mdlCusObj.setUsername(username); 
		mdlCusObj.setPassword(password);
		mdlCusObj.setName(name);
		mdlCusObj.setSurname(surname);
		mdlCusObj.setCustomerType(customerType);
		mdlCusObj.setGender(gender);
		mdlCusObj.setCountry(country);
		mdlCusObj.setCity(city);
		mdlCusObj.setStreet(street);
		mdlCusObj.setZipCode(zipCode);
		mdlCusObj.setContact(contact);
	
		try{
			
			success = dbCusObj.insertCustomer(mdlCusObj);
		}
		catch(Exception e){
			
			System.out.println("Error while creating a Customer Object.");
		}
		
		return success;
	}
	
	public boolean updateCustomer(String username, String name, 
			String surname, String customerType, String gender, String country, String city, String street, String zipCode, String contact){
		
		MdlCustomer mdlCusObj = new MdlCustomer();
		DbCustomer dbCusObj = new DbCustomer();
		boolean success = false;
		
		mdlCusObj.setUsername(username); 
		mdlCusObj.setPassword(password);
		mdlCusObj.setName(name);
		mdlCusObj.setSurname(surname);
		mdlCusObj.setCustomerType(customerType);
		mdlCusObj.setGender(gender);
		mdlCusObj.setCountry(country);
		mdlCusObj.setCity(city);
		mdlCusObj.setStreet(street);
		mdlCusObj.setZipCode(zipCode);
		mdlCusObj.setContact(contact);
		
		try{
			
			success = dbCusObj.updateCustomer(mdlCusObj);
		}
		catch(Exception e){
			
			System.out.println("Error while creating a Customer Object.");
		}
		
		return success;
	}
	
	public boolean deleteCustomer(String username){
		
		DbCustomer dbCusObj = new DbCustomer();
		boolean success = false;
		
		try{
			
			success = dbCusObj.deleteCustomer(username);
		}
		catch(Exception e){
			
			System.out.println("Error while deleting a Customer.");
		}
		
		return success;
	}
	
	public ResultSet searchCustomer(String selection, String searchCustomer){
		
		DbCustomer dbCusObj = new DbCustomer();
		ResultSet rs;
		
		try{
			
			rs = dbCusObj.searchCustomer(selection, searchCustomer);
		}
		catch(Exception e){
			
			System.out.println("Error while searching a Customer.");
			return null;
		}
		
		return rs;
	}
	
	 public String checkInputData(String username, String name, 
				String surname, String customerTupe, String genderC, String country, String city, String street, String zipCode, String contact){
		 		 
		 CtrData ctrCusDatObj = new CtrData();
		 String errorMessage = "";
		 
		 errorMessage =  ctrCusDatObj.checkUsername(username);
		 errorMessage =  ctrCusDatObj.checkName(name);
		 errorMessage =  ctrCusDatObj.checkSurname(surname);
		 errorMessage =  ctrCusDatObj.checkGender(genderC);
		 errorMessage =  ctrCusDatObj.checkCountry(country);
		 errorMessage =  ctrCusDatObj.checkCity(city);
		 //errorMessage =  ctrCusDatObj.checkStreet(street);
		 errorMessage =  ctrCusDatObj.checkZipCode(zipCode);
		 errorMessage =  ctrCusDatObj.checkContact(contact);


		 return errorMessage;
	 }
	 
	 
		public String getPassword(){
			
			password = decodePassword();
			return password;
		}
		
		 private String encryptPassword(String password){
			 
			 String result = "";
			 char ch;
			 
			 for(int i = 0; i< password.length(); i++){
				 
				 ch = password.charAt(i);
				 ch = (char) (ch + 2);
				 result = result + ch;
				 
			 }
			 
			 return result;
		 }
		 
		 private String decodePassword(){
			 
			 String result = "";
			 char ch;
			 
			 for(int i = 0; i< password.length(); i++){
				 
				 ch = password.charAt(i);
				 ch -= 2;
				 result += ch;
				 
			 }
			 

			 return result;
		 }
		 
		 private String generatePassword(){
			 
			 String newPassword = "";
			 char ch;
			 Random r = new Random();
			 
				for (int i = 0; i<4; i++){
						
				ch = (char) (r.nextInt((122 - 97) + 1) + 97);
				newPassword += ch;
				ch = (char) (r.nextInt((90 - 65) + 1) + 65);
				newPassword += ch;
				}
				
				for (int i = 0; i<2; i++){
					
					ch = (char) (r.nextInt((57 - 48) + 1) + 48);
					newPassword += ch;
				}
			 
			password = newPassword;
			
			return password;
		 }
}
