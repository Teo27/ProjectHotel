package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelLayer.MdlCustomer;
import modelLayer.MdlEmployee;

public class DbCustomer {

	public DbCustomer(){
		
	}
	
	public ResultSet refreshTableCustomer(){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select * from Customer";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			return rs;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
	}
	
	public MdlCustomer selectFromTableCustomer(String selectedUsername){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		MdlCustomer mdlCusObj = new MdlCustomer();
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "select * from Customer where username = '"+ selectedUsername +"'";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				mdlCusObj.setUsername(rs.getString("username"));
				mdlCusObj.setName(rs.getString("name"));
				mdlCusObj.setSurname(rs.getString("surname"));
				mdlCusObj.setCustomerType(rs.getString("customer_type"));
				mdlCusObj.setGender(rs.getString("gender"));
				mdlCusObj.setCountry(rs.getString("country"));
				mdlCusObj.setCity(rs.getString("city"));
				mdlCusObj.setStreet(rs.getString("street"));
				mdlCusObj.setZipCode(rs.getString("zip_code"));
				mdlCusObj.setContact(rs.getString("contact"));
			}
			
			pst.close();
			return mdlCusObj;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		

	}
	
	public boolean insertCustomer(MdlCustomer mdlCusObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "INSERT INTO Customer (username, password, name, surname, customer_type, gender, country, city, street, zip_code, contact) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(query);
			success = false;
			
			pst.setString(1, mdlCusObj.getUsername());
			pst.setString(2, mdlCusObj.getPassword());
			pst.setString(3, mdlCusObj.getName());
			pst.setString(4, mdlCusObj.getSurname());
			pst.setString(5, mdlCusObj.getCustomerType());
			pst.setString(6, mdlCusObj.getGender());
			pst.setString(7, mdlCusObj.getCountry());
			pst.setString(8, mdlCusObj.getCity());
			pst.setString(9, mdlCusObj.getStreet());
			pst.setString(10, mdlCusObj.getZipCode());
			pst.setString(11, mdlCusObj.getContact());
			
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
	
	public boolean updateCustomer(MdlCustomer mdlCusObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "Update Customer set username = '"+ mdlCusObj.getUsername() +"' , name= '"+ mdlCusObj.getName() +"', surname = '"+ mdlCusObj.getSurname() +"', customer_type= '" + mdlCusObj.getCustomerType() +"', gender= '" + mdlCusObj.getGender() + "', country = '"+ mdlCusObj.getCountry() 
					+"', city = '"+ mdlCusObj.getCity() +"', street = '"+ mdlCusObj.getStreet() +"', zip_code = '"+ mdlCusObj.getZipCode() +"', contact = '"+mdlCusObj.getContact()+"' where username = '"+ mdlCusObj.getUsername() +"' ";
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
	
	
	public boolean deleteCustomer(String username){
		
		boolean success = false;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		
		try{
			
			query = "Delete from Customer where username = '"+ username +"'";
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
	
	public ResultSet searchCustomer(String selection, String searchCustomer){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		Statement  st;
		ResultSet rs;
				
	try{
		
			query = "Select * from customer where "+ selection +" LIKE '%"+searchCustomer+"%' ";
			st = connection.createStatement();
			rs = st.executeQuery(query);

		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		
		return rs;
	}
	
	public int getMaxCustomerType(){
		
		int customerType = 0;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		ResultSet rs;
		
		try{
			
			query = "Select max(type_number) from customer_type";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()){
				
				customerType =  ((Number) rs.getObject(1)).intValue();
			}
		
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
		}
		
		return customerType;
	}
	
}
