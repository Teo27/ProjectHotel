package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DbCustomerType {

	public DbCustomerType(){
		
	}
	
	public ArrayList getAllCustomerTypes(){
		
		ArrayList<String> customerTypeList = new ArrayList<>();
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select type_name from customer_type";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			while(rs.next()){

				customerTypeList.add(rs.getString("type_name"));
			}
		}
		catch(Exception e){
			
			System.out.println("Error while building the query");
		}
		
		return customerTypeList;
	}
	
}
