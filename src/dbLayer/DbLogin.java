package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DbLogin {

	Connection connection;
	
	public DbLogin(){
		
	}
	
	public int loginQuery(String username, String password){
		
		//declare
		int securityLevel;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		//run connection
		connection = DbConnection.DbConnector();
		try{
			
			//ensure security level in on 0
			securityLevel = 0;
			//set query
			query = "Select * from Employee where username=? and password=? ";
			
			pst = connection.prepareStatement(query);
			//replace question marks with entered variables
			pst.setString(1, username);
			pst.setString(2, password);
			//execute
			rs = pst.executeQuery();
			
			//if values were matched set security level to its equivalent row in database
			while(rs.next()){
				
				securityLevel = rs.getInt("security_level");
			}
			
			//close
			rs.close();
			pst.close();
		}
		catch(Exception e1){
			
			System.out.println("An Error occurred while building the query");
			return (Integer) null;
		}
		
		return securityLevel;
		
	}
}
