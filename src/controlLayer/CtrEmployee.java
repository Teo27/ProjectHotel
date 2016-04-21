package controlLayer;

import java.sql.ResultSet;
import java.util.Random;

import modelLayer.MdlEmployee;
import dbLayer.DbEmployee;

public class CtrEmployee {
	
	String password = "00000";
	
	public CtrEmployee(){
		
	}
	
	public ResultSet refreshTableEmp(){
		
		ResultSet rs;
		DbEmployee empDbObj = new DbEmployee();
		
		rs = empDbObj.refreshTableEmployee();

		return rs;
	}
	
	public MdlEmployee selectFromTableEmployee(String selectedUsername){
		
		DbEmployee dbEmpObj = new DbEmployee();
		MdlEmployee mdlEmpObj = new MdlEmployee();
		
		mdlEmpObj = dbEmpObj.selectFromTableEmployee(selectedUsername);
		
		return mdlEmpObj;
	}
	
	public boolean addEmployee(String username, int securityLevel, String name, 
			String surname, String gender, String country, String city, String street, String zipCode, 
			String contact, float salary, String employedSince, String contractType, int ssn, int departmentNumber){
		
		MdlEmployee mdlEmpObj = new MdlEmployee();
		DbEmployee dbEmpObj = new DbEmployee();
		CtrDepartment ctrDepObj = new CtrDepartment();
		 
		boolean success = false;
				
		password = generatePassword();
		password = encryptPassword(password);
		
		mdlEmpObj.setUsername(username); 
		mdlEmpObj.setPassword(password);
		mdlEmpObj.setSecurityLevel(securityLevel);
		mdlEmpObj.setName(name);
		mdlEmpObj.setSurname(surname);
		mdlEmpObj.setGender(gender);
		mdlEmpObj.setCountry(country);
		mdlEmpObj.setCity(city);
		mdlEmpObj.setStreet(street);
		mdlEmpObj.setZipCode(zipCode);
		mdlEmpObj.setContact(contact);
		mdlEmpObj.setSalary(salary);
		mdlEmpObj.setEmployedSince(employedSince);
		mdlEmpObj.setContractType(contractType);
		mdlEmpObj.setSsn(ssn);
		mdlEmpObj.setDepartmentNumber(departmentNumber);
		
		try{
			
			success = dbEmpObj.insertEmployee(mdlEmpObj);
			if(success == true){
				
				ctrDepObj.updateDepartment(mdlEmpObj);
			}
		}
		catch(Exception e){
			
			System.out.println("Error while creating an Employee Object.");
		}
		
		return success;
	}
	
	public boolean updateEmployee(String username, int securityLevel, String name, 
			String surname, String gender, String country, String city, String street, String zipCode, 
			String contact, float salary, String employedSince, String contractType, int ssn, int departmentNumber){
		
		MdlEmployee mdlEmpObj = new MdlEmployee();
		DbEmployee dbEmpObj = new DbEmployee();
		CtrDepartment ctrDepObj = new CtrDepartment();
		boolean success = false;
		
		mdlEmpObj.setUsername(username); 
		mdlEmpObj.setPassword(password);
		mdlEmpObj.setSecurityLevel(securityLevel);
		mdlEmpObj.setName(name);
		mdlEmpObj.setSurname(surname);
		mdlEmpObj.setGender(gender);
		mdlEmpObj.setCountry(country);
		mdlEmpObj.setCity(city);
		mdlEmpObj.setStreet(street);
		mdlEmpObj.setZipCode(zipCode);
		mdlEmpObj.setContact(contact);
		mdlEmpObj.setSalary(salary);
		mdlEmpObj.setEmployedSince(employedSince);
		mdlEmpObj.setContractType(contractType);
		mdlEmpObj.setSsn(ssn);
		mdlEmpObj.setDepartmentNumber(departmentNumber);
		
		try{
			
			success = dbEmpObj.updateEmployee(mdlEmpObj);
			if(success == true){
				
				ctrDepObj.updateDepartmentManager(mdlEmpObj);
			}
		}
		catch(Exception e){
			
			System.out.println("Error while creating an Employee Object.");
		}
		
		return success;
	}
	
	public boolean deleteEmployee(String username, int securityLevel, int ssn, int departmentNumber){
		
		DbEmployee dbEmpObj = new DbEmployee();
		CtrDepartment ctrDepObj = new CtrDepartment();
		boolean success = false;
		
		try{
			
			success = dbEmpObj.deleteEmployee(username);
			
			if(success == true){
				
				ctrDepObj.deleteDepartmentManager(securityLevel, ssn, departmentNumber);
			}
		}
		catch(Exception e){
			
			System.out.println("Error while deleting an Employee.");
		}
		
		return success;
	}
	
	public ResultSet searchEmployee(String selection, String searchEmployee){
		
		DbEmployee dbEmpObj = new DbEmployee();
		ResultSet rs;
		
		try{
			
			rs = dbEmpObj.searchEmployee(selection, searchEmployee);
		}
		catch(Exception e){
			
			System.out.println("Error while searching an Employee.");
			return null;
		}
		
		return rs;
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
	 
	 
	 public String checkInputData(String username, int securityLevel, String name, 
				String surname, String gender, String country, String city, String street, String zipCode, 
				String contact, float salary, String employedSince, String contractType, int ssn, int departmentNumber){
		 		 
		 CtrData ctrEmpDatObj = new CtrData();
		 String errorMessage = "";
		 
		 errorMessage =  ctrEmpDatObj.checkUsername(username);
		 errorMessage =  ctrEmpDatObj.checkSecurityLevel(securityLevel);
		 errorMessage =  ctrEmpDatObj.checkName(name);
		 errorMessage =  ctrEmpDatObj.checkSurname(surname);
		//errorMessage =  ctrEmpDatObj.checkGender(gender);
		 errorMessage =  ctrEmpDatObj.checkCountry(country);
		 errorMessage =  ctrEmpDatObj.checkCity(city);
		// errorMessage =  ctrEmpDatObj.checkStreet(street);
		 errorMessage =  ctrEmpDatObj.checkZipCode(zipCode);
		 errorMessage =  ctrEmpDatObj.checkContact(contact);
		 errorMessage =  ctrEmpDatObj.checkContractType(contractType);
		 errorMessage =  ctrEmpDatObj.checkSsn(ssn);
		 errorMessage =  ctrEmpDatObj.checkDepartmentNumber(departmentNumber);
 
		 return errorMessage;
	 }
}
