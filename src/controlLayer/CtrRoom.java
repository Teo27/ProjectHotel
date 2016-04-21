package controlLayer;

import java.sql.ResultSet;

import modelLayer.MdlEmployee;
import modelLayer.MdlRoom;
import dbLayer.DbEmployee;
import dbLayer.DbRoom;

public class CtrRoom {

	
	public CtrRoom(){
		
	}
	
	public ResultSet refreshTableRoom(){
		
		ResultSet rs;
		DbRoom dbRoomObj = new DbRoom();
		
		rs = dbRoomObj.refreshTableRoom();

		return rs;
	}
	
	public MdlRoom selectFromTableRoom(String selectedRoomNumber){
		
		DbRoom dbRoomObj = new DbRoom();
		MdlRoom mdlRoomObj = new MdlRoom();
		
		mdlRoomObj = dbRoomObj.selectFromTableRoom(selectedRoomNumber);
		
		return mdlRoomObj;
	}
	
	public boolean addRoom(int roomNumber, int capacity){
		
		MdlRoom mdlRoomObj = new MdlRoom();
		DbRoom dbRoomObj = new DbRoom();
		 
		boolean success = false;

		
		mdlRoomObj.setRoomNumber(roomNumber); 
		mdlRoomObj.setCapacity(capacity);
	
		try{
			
			success = dbRoomObj.insertRoom(mdlRoomObj);
		}
		catch(Exception e){
			
			System.out.println("Error while creating a Room");
		}
		
		return success;
	}
	
	public boolean updateRoom(int roomNumber, int capacity){
		
		MdlRoom mdlRoomObj = new MdlRoom();
		DbRoom dbRoomObj = new DbRoom();
		boolean success = false;
		
		mdlRoomObj.setRoomNumber(roomNumber); 
		mdlRoomObj.setCapacity(capacity);
		
		try{
			
			success = dbRoomObj.updateRoom(mdlRoomObj);
		}
		catch(Exception e){
			
			System.out.println("Error while creating an Employee Object.");
		}
		
		return success;
	}
	
	public boolean deleteRoom(int roomNumber){
		
		DbRoom dbRoomObj = new DbRoom();
		boolean success = false;
		
		try{
			
			success = dbRoomObj.deleteRoom(roomNumber);
		}
		catch(Exception e){
			
			System.out.println("Error while deleting a Room.");
		}
		
		return success;
	}
	
public ResultSet searchRoom(String selection, String searchRoom){
		
		DbRoom dbRoomObj = new DbRoom();
		ResultSet rs;
		
		try{
			
			rs = dbRoomObj.searchRoom(selection, searchRoom);
		}
		catch(Exception e){
			
			System.out.println("Error while searching for a Room.");
			return null;
		}
		
		return rs;
	}
	
	 public String checkInputData(int roomNumber, int capacity){
		 		 
		 CtrData ctrRoomDatObj = new CtrData();
		 String errorMessage = "";
		 
		 errorMessage =  ctrRoomDatObj.checkRoomNumber(roomNumber);
		 errorMessage =  ctrRoomDatObj.checkCapacity(capacity);
		 
		 return errorMessage;
	 }
}
