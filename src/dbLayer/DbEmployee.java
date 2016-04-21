package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelLayer.MdlEmployee;

public class DbEmployee {

	public DbEmployee(){
		
	}
	
	public ResultSet refreshTableEmployee(){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select * from Employee";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			return rs;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
	}
	
	public MdlEmployee selectFromTableEmployee(String selectedUsername){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		MdlEmployee mdlEmpObj = new MdlEmployee();
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "select * from Employee where username = '"+ selectedUsername +"'";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				mdlEmpObj.setUsername(rs.getString("username"));
				mdlEmpObj.setSecurityLevel(Integer.parseInt(rs.getString("security_level")));
				mdlEmpObj.setName(rs.getString("name"));
				mdlEmpObj.setSurname(rs.getString("surname"));
				mdlEmpObj.setGender(rs.getString("gender"));
				mdlEmpObj.setCountry(rs.getString("country"));
				mdlEmpObj.setCity(rs.getString("city"));
				mdlEmpObj.setStreet(rs.getString("street"));
				mdlEmpObj.setZipCode(rs.getString("zip_code"));
				mdlEmpObj.setContact(rs.getString("contact"));
				mdlEmpObj.setSalary(Float.parseFloat(rs.getString("salary")));
				mdlEmpObj.setEmployedSince(rs.getString("employed_since"));
				mdlEmpObj.setContractType(rs.getString("contract_type"));
				mdlEmpObj.setSsn(Integer.parseInt(rs.getString("ssn")));
				mdlEmpObj.setDepartmentNumber(Integer.parseInt(rs.getString("department_number")));

			}
			
			pst.close();
			return mdlEmpObj;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		

	}
	
	public boolean insertEmployee(MdlEmployee mdlEmpObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "INSERT INTO Employee (username, password, security_level, name, surname, gender, country, city, street, zip_code, contact, salary, employed_since, contract_type, ssn, department_number ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(query);
			success = false;
			
			pst.setString(1, mdlEmpObj.getUsername());
			pst.setString(2, mdlEmpObj.getPassword());
			pst.setString(3, Integer.toString(mdlEmpObj.getSecurityLevel()));
			pst.setString(4, mdlEmpObj.getName());
			pst.setString(5, mdlEmpObj.getSurname());
			pst.setString(6, mdlEmpObj.getGender());
			pst.setString(7, mdlEmpObj.getCountry());
			pst.setString(8, mdlEmpObj.getCity());
			pst.setString(9, mdlEmpObj.getStreet());
			pst.setString(10, mdlEmpObj.getZipCode());
			pst.setString(11, mdlEmpObj.getContact());
			pst.setString(12, Float.toString(mdlEmpObj.getSalary()));
			pst.setString(13, mdlEmpObj.getEmployedSince());
			pst.setString(14, mdlEmpObj.getContractType());
			pst.setString(15, Integer.toString(mdlEmpObj.getSsn()));
			pst.setString(16, Integer.toString(mdlEmpObj.getDepartmentNumber()));
			
			pst.execute();
			pst.close();
			success = true;
			
			return success;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return (Boolean) null;
		}
	}
	
	public boolean updateEmployee(MdlEmployee mdlEmpObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "Update Employee set username = '"+ mdlEmpObj.getUsername() +"' , security_level = '"+ mdlEmpObj.getSecurityLevel() +"' , name= '"+ mdlEmpObj.getName() +"', surname = '"+ mdlEmpObj.getSurname()+"', gender= '"+ mdlEmpObj.getGender() +"', country = '"+ mdlEmpObj.getCountry() 
					+"', city = '"+ mdlEmpObj.getCity() +"', street = '"+ mdlEmpObj.getStreet() +"', zip_code = '"+ mdlEmpObj.getZipCode() +"', contact = '"+mdlEmpObj.getContact()+"', salary = '"+ mdlEmpObj.getSalary()
					+"', employed_since = '"+ mdlEmpObj.getEmployedSince() +"', contract_type= '"+ mdlEmpObj.getContractType() +"', ssn = '"+ mdlEmpObj.getSsn() +"', department_number = '"+ mdlEmpObj.getDepartmentNumber() +"' where username = '"+ mdlEmpObj.getUsername() +"' ";
			pst = connection.prepareStatement(query);
			success = false;
			
			pst.execute();
			pst.close();
			success = true;
			
			return success;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return (Boolean) null;
		}
	}
	
	public boolean deleteEmployee(String username){
		
		boolean success = false;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		
		try{
			
			query = "Delete from Employee where username = '"+ username +"'";
			pst = connection.prepareStatement(query);
			
			pst.execute();
			pst.close();
			success = true;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return (Boolean) null;
		}
		
		return success;
	}
	
	public ResultSet searchEmployee(String selection, String searchEmployee){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		Statement  st;
		ResultSet rs;
				
	try{
					
			query = "Select * from Employee where "+ selection +" LIKE '%"+searchEmployee+"%' ";
			st = connection.createStatement();
			rs = st.executeQuery(query);
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		
		return rs;
	}
	
	public int getMaxSecurityLevel(){
		
		int securityLevel = 0;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		ResultSet rs;
		
		try{
			
			query = "Select max(level_number) from security_level";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()){
				
				securityLevel =  ((Number) rs.getObject(1)).intValue();
			}
		
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
		}
		
		return securityLevel;
	}
	
	public int getMaxDepartmentNumber(){
		
		int departmentNumber = 0;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		ResultSet rs;
		
		try{
			
			query = "Select max(department_number) from department";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				departmentNumber =  ((Number) rs.getObject(1)).intValue();
			}
		
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
		}
		
		return departmentNumber;
	}
	
}
