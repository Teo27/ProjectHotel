package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DbSecurityLevel {

	
	public DbSecurityLevel(){
		
	}
	
	public ArrayList<Integer> getAllSecurityLevels(){
		
		ArrayList<Integer> securityLevelList = new ArrayList<>();
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select level_number from security_level";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			while(rs.next()){

				securityLevelList.add(rs.getInt("level_number"));
			}
		}
		catch(Exception e){
			
			System.out.println("Error while building the query");
		}
		
		return securityLevelList;
	}
}
