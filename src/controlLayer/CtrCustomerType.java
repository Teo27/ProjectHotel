package controlLayer;

import java.util.ArrayList;

import dbLayer.DbCustomerType;
import dbLayer.DbRates;

public class CtrCustomerType {

	
	public CtrCustomerType(){
		
		
	}
	
	public ArrayList getAllCustomerTypes(){
		
		ArrayList<String> customerTypeList = new ArrayList<>();
		DbCustomerType dbCusTypeObj = new DbCustomerType();
		
		customerTypeList = dbCusTypeObj.getAllCustomerTypes();
		
		return customerTypeList;
	}
}
