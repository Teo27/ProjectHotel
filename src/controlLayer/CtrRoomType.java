package controlLayer;

import java.sql.ResultSet;
import java.util.ArrayList;

import modelLayer.MdlRoom;
import modelLayer.MdlRoomType;
import dbLayer.DbRoom;
import dbLayer.DbRoomType;

public class CtrRoomType {

	
	public CtrRoomType(){
		
	}
	
	public ResultSet refreshTableRoomType(){
		
		ResultSet rs;
		DbRoomType dbRoomTypeObj = new DbRoomType();
		
		rs = dbRoomTypeObj.refreshTableRoomType();

		return rs;
	}
	
	public MdlRoomType selectFromTableRoomType(String selectedRoomTypeName){
		
		DbRoomType dbRoomTypeObj = new DbRoomType();
		MdlRoomType mdlRoomTypeObj = new MdlRoomType();
		
		mdlRoomTypeObj = dbRoomTypeObj.selectFromTableRoomType(selectedRoomTypeName);
		
		return mdlRoomTypeObj;
	}
	
	public boolean addRoomType(String typeName, float price, int capacity){
		
		MdlRoomType mdlRoomTypeObj = new MdlRoomType();
		DbRoomType dbRoomTypeObj = new DbRoomType();
		 
		boolean success = false;

		
		mdlRoomTypeObj.setTypeName(typeName); 
		mdlRoomTypeObj.setPrice(price);
		mdlRoomTypeObj.setCapacity(capacity);
	
		try{
			
			success = dbRoomTypeObj.insertRoomType(mdlRoomTypeObj);
		}
		catch(Exception e){
			
			System.out.println("Error while creating a Room type");
		}
		
		return success;
	}
	
	public boolean updateRoomType(String typeName, float price, int capacity){
		
		MdlRoomType mdlRoomTypeObj = new MdlRoomType();
		DbRoomType dbRoomTypeObj = new DbRoomType();
		boolean success = false;
		
		mdlRoomTypeObj.setTypeName(typeName); 
		mdlRoomTypeObj.setPrice(price);
		mdlRoomTypeObj.setCapacity(capacity);
		
		try{
			
			success = dbRoomTypeObj.updateRoomType(mdlRoomTypeObj);
		}
		catch(Exception e){
			
			System.out.println("Error while updating an Room Type.");
		}
		
		return success;
	}
	
	public boolean deleteRoomType(String typeName){
		
		DbRoomType dbRoomTypeObj = new DbRoomType();
		boolean success = false;
		
		try{
			
			success = dbRoomTypeObj.deleteRoomType(typeName);
		}
		catch(Exception e){
			
			System.out.println("Error while deleting a Room type.");
		}
		
		return success;
	}
	
	 public String checkInputData(String typeName, float price, int capacity){
 		 
		 CtrData ctrRoomDatObj = new CtrData();
		 String errorMessage = "";
		 
		 errorMessage =  ctrRoomDatObj.checkTypeName(typeName);
		 errorMessage =  ctrRoomDatObj.checkPrice(price);
		 errorMessage =  ctrRoomDatObj.checkCapacity(capacity);
		 
		 return errorMessage;
	 }
	
	public ArrayList getAllRoomTypes(){
		
		ArrayList<String> roomTypeList = new ArrayList<>();
		DbRoomType dbRoomTypeObj = new DbRoomType();
		
		roomTypeList = dbRoomTypeObj.getAllRoomTypes();
		
		return roomTypeList;
	}
}
