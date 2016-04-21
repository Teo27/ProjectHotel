package controlLayer;

import java.util.ArrayList;

import dbLayer.DbCustomerType;
import dbLayer.DbSecurityLevel;

public class CtrSecurityLevel {

	
	public CtrSecurityLevel(){
		
	}
	
	public ArrayList getAllSecurityLevels(){
		
		ArrayList<Integer> securityLevelList = new ArrayList<>();
		DbSecurityLevel dbSecLvlObj = new DbSecurityLevel();
		
		securityLevelList = dbSecLvlObj.getAllSecurityLevels();
		
		return securityLevelList;
	}
}
