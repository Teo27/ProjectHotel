package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelLayer.MdlRoom;
import modelLayer.MdlRoomType;

public class DbRoomType {

	
	public DbRoomType(){
		
	}
	
	public ResultSet refreshTableRoomType(){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select * from Room_type";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			return rs;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
	}
	
	public MdlRoomType selectFromTableRoomType(String selectedRoomTypeName){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		MdlRoomType mdlRoomTypeObj = new MdlRoomType();
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "select * from Room_type where type_name = '"+ selectedRoomTypeName +"'";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				mdlRoomTypeObj.setTypeName(rs.getString("type_name"));
				mdlRoomTypeObj.setPrice(Float.parseFloat(rs.getString("price")));
				mdlRoomTypeObj.setCapacity(rs.getInt("capacity"));
			}
			
			pst.close();
			
			return mdlRoomTypeObj;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		

	}
	
	public boolean insertRoomType(MdlRoomType mdlRoomTypeObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "INSERT INTO Room_type (type_name, price, capacity) VALUES(?,?,?)";
			pst = connection.prepareStatement(query);
			success = false;
			
			pst.setString(1, mdlRoomTypeObj.getTypeName());
			pst.setFloat(2, mdlRoomTypeObj.getPrice());
			pst.setInt(3, mdlRoomTypeObj.getCapacity());
			
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
	
	public boolean updateRoomType(MdlRoomType mdlRoomTypeObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "Update room_Type set type_name = '"+ mdlRoomTypeObj.getTypeName() + "', price = '"+ mdlRoomTypeObj.getPrice() + "', capacity = '"+ mdlRoomTypeObj.getCapacity()   +"' where type_name = '"+  mdlRoomTypeObj.getTypeName() +"' ";
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
	
	public boolean deleteRoomType(String typeName){
		
		boolean success = false;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		
		try{
			
			query = "Delete from room_type where type_name = '"+ typeName +"'";
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
	
	public ArrayList<String> getAllRoomTypes(){
		
		ArrayList<String> roomTypeList = new ArrayList<>();
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select [type_name] from room_type";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			while(rs.next()){

				roomTypeList.add(rs.getString("type_name"));
			}
		}
		catch(Exception e){
			
			System.out.println("Error while building the query");
		}
		
		return roomTypeList;
	}
}
