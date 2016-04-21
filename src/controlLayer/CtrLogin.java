package controlLayer;

import dbLayer.DbLogin;

public class CtrLogin {
	
	//empty costructor
	public CtrLogin(){
		
	}
	
	public int checkLoginData(String username, String password){
		
		//declare 
		int securityLevel;
		DbLogin dbLogObj;
		
		//initialize
		securityLevel = 0;
		dbLogObj = new DbLogin();
		
		//decipherPassword(password);
		//pass login information to DbLogin class
		securityLevel = dbLogObj.loginQuery(username, password);
		
		//return security level back
		return securityLevel;
	}
}
