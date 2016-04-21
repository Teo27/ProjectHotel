package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DbDepartment {

	
	public DbDepartment(){
		
	}
	
	public void updateNumberOfEmployees(int departmentNumber){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "UPDATE Department SET number_of_employees = number_of_employees + 1 where department_number = '"+ departmentNumber +"'";
			pst = connection.prepareStatement(query);
			pst.execute();
			pst.close();
						
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
		}
	}
	
	public boolean checkDepartment(int departmentNumber){
		
		boolean newDepartment = true;
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select * from Department where department_number = '"+ departmentNumber +"' ";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				newDepartment = false;
			}
			pst.close();
						
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
		}
		
		return newDepartment;		
	}
	
	public void updateDepartmentManager(int departmentNumber, int ssn){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		
		connection = DbConnection.DbConnector();
		
	try{
			
			query = "UPDATE Department SET mssn = '"+ ssn +"' where department_number = '"+ departmentNumber +"'";
			pst = connection.prepareStatement(query);
			pst.execute();
			
	
			pst.close();
						
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
		}
		
	}
	
	public ArrayList<Integer> getAllDepartments(){
		
		ArrayList<Integer> departmentList = new ArrayList<>();
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select department_number from department";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			while(rs.next()){

				departmentList.add(rs.getInt("department_number"));
			}
		}
		catch(Exception e){
			
			System.out.println("Error while building the query");
		}
		
		return departmentList;
	
	}
}
