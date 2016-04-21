package controlLayer;

import java.sql.ResultSet;
import java.util.ArrayList;

import modelLayer.MdlRates;
import modelLayer.MdlRoomType;
import dbLayer.DbCustomerType;
import dbLayer.DbRates;
import dbLayer.DbRoomType;

public class CtrRates {

	
	public CtrRates(){
		
	}
	
	public ResultSet refreshTableRates(){
		
		ResultSet rs;
		DbRates dbRatesObj = new DbRates();
		
		rs = dbRatesObj.refreshTableRates();

		return rs;
	}
	
	public MdlRates selectFromTableRates(String selectedRatesName){
		
		DbRates dbRatesObj = new DbRates();
		MdlRates mdlRatesObj = new MdlRates();
		
		mdlRatesObj = dbRatesObj.selectFromTableRates(selectedRatesName);
		
		return mdlRatesObj;
	}
	
	public boolean addRates(String name, boolean breakfast, boolean lunch, boolean dinner){
		
		MdlRates mdlRatesObj = new MdlRates();
		DbRates dbRatesObj = new DbRates();
		 
		boolean success = false;

		
		mdlRatesObj.setName(name); 
		mdlRatesObj.setBreakfast(breakfast);
		mdlRatesObj.setLunch(lunch);
		mdlRatesObj.setDinner(dinner);
	
		try{
			
			success = dbRatesObj.insertRates(mdlRatesObj);
		}
		catch(Exception e){
			
			System.out.println("Error while creating a Room type");
		}
		
		return success;
	}
	
	public boolean updateRates(String name, boolean breakfast, boolean lunch, boolean dinner){
		
		MdlRates mdlRatesObj = new MdlRates();
		DbRates dbRatesObj = new DbRates();
		boolean success = false;
		
		mdlRatesObj.setName(name); 
		mdlRatesObj.setBreakfast(breakfast);
		mdlRatesObj.setLunch(lunch);
		mdlRatesObj.setDinner(dinner);
		
		try{
			
			success = dbRatesObj.updateRates(mdlRatesObj);
		}
		catch(Exception e){
			
			System.out.println("Error while updating an Room Type.");
		}
		
		return success;
	}
	
	public boolean deleteRates(String name){
		
		DbRates dbRatesObj = new DbRates();
		boolean success = false;
		
		try{
			
			success = dbRatesObj.deleteRates(name);
		}
		catch(Exception e){
			
			System.out.println("Error while deleting a Room type.");
		}
		
		return success;
	}
	
 public String checkInputData(String name){
 		 
		 CtrData ctrRatesObj = new CtrData();
		 String errorMessage = "";
		 
		 errorMessage =  ctrRatesObj.checkName(name);
		 
		 return errorMessage;
	 }
	
	
	public ArrayList getAllRates(){
		
		ArrayList<String> ratesList = new ArrayList<>();
		DbRates dbRatesObj = new DbRates();
		
		ratesList = dbRatesObj.getAllRates();
		
		return ratesList;
	}
}
