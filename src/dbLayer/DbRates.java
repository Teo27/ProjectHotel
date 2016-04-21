package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelLayer.MdlRates;
import modelLayer.MdlRoomType;

public class DbRates {

	public DbRates(){
		
	}
	
	public ResultSet refreshTableRates(){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select * from Rates";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			return rs;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
	}
	
	public MdlRates selectFromTableRates(String selectedRatesName){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		MdlRates mdlRatesObj = new MdlRates();
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "select * from Rates where name = '"+ selectedRatesName +"'";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				mdlRatesObj.setName(rs.getString("name"));
				mdlRatesObj.setBreakfast(rs.getBoolean("breakfast"));
				mdlRatesObj.setLunch(rs.getBoolean("lunch"));
				mdlRatesObj.setDinner(rs.getBoolean("dinner"));
			}
			
			pst.close();
			
			return mdlRatesObj;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
	}
	
	public boolean insertRates(MdlRates mdlRatesObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "INSERT INTO rates (name, breakfast, lunch, dinner) VALUES(?,?,?,?)";
			pst = connection.prepareStatement(query);
			success = false;
			
			pst.setString(1, mdlRatesObj.getName());
			pst.setBoolean(2, mdlRatesObj.isBreakfast());
			pst.setBoolean(3, mdlRatesObj.isLunch());
			pst.setBoolean(4, mdlRatesObj.isDinner());
			
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
	
	public boolean updateRates(MdlRates mdlRatesObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "Update rates set name = '"+ mdlRatesObj.getName() + "', breakfast = '"+ mdlRatesObj.isBreakfast() + "', lunch = '"+ mdlRatesObj.isLunch() + "', dinner = '"+ mdlRatesObj.isDinner()  +"' where name = '"+  mdlRatesObj.getName() +"' ";
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
	
	public boolean deleteRates(String name){
		
		boolean success = false;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		
		try{
			
			query = "Delete from rates where name = '"+ name +"'";
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
	
	public ArrayList getAllRates(){
		
		ArrayList<String> ratesList = new ArrayList<>();
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select name from rates";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			while(rs.next()){

				ratesList.add(rs.getString("name"));
			}
		}
		catch(Exception e){
			
			System.out.println("Error while building the query");
		}
		
		return ratesList;
	}
}
