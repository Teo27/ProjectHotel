package controlLayer;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dbLayer.DbDepartment;
import dbLayer.DbSecurityLevel;
import modelLayer.MdlEmployee;

public class CtrDepartment {
	
	
	public CtrDepartment(){
		
	}
	
	public void updateDepartment(MdlEmployee mdlEmpObj){
		
		int departmentNumber = mdlEmpObj.getDepartmentNumber();
		int ssn = mdlEmpObj.getSsn();
		int securityLevel = mdlEmpObj.getSecurityLevel();
		DbDepartment dbDepObj = new DbDepartment();
		
		if(securityLevel == 1){
			
			boolean newDepartment = false;
			
			newDepartment = dbDepObj.checkDepartment(departmentNumber);
			checkNewDepartment(newDepartment, departmentNumber, ssn);
		}
		else{
			
			dbDepObj.updateNumberOfEmployees(departmentNumber);
		}
	}
	
	private void checkNewDepartment(boolean newDepartment, int departmentNumber, int ssn){
				
		if(newDepartment == false){
			
			DbDepartment dbDepObj = new DbDepartment();
			int action = JOptionPane.showConfirmDialog(null, "Do you want to overwrite the manager of department #" + departmentNumber+ " ?", "Delete", JOptionPane.YES_NO_OPTION);
			
			if(action == 0){
				
				dbDepObj.updateDepartmentManager(departmentNumber, ssn);
			}
			else{
				
				dbDepObj.updateNumberOfEmployees(departmentNumber);		
			}
		}
	}
	
	public void updateDepartmentManager(MdlEmployee mdlEmpObj){
		
		int departmentNumber = mdlEmpObj.getDepartmentNumber();
		int ssn = mdlEmpObj.getSsn();
		int securityLevel = mdlEmpObj.getSecurityLevel();
		DbDepartment dbDepObj = new DbDepartment();
		
		if(securityLevel == 1){
			
			//int action = JOptionPane.showConfirmDialog(null, "Do you want to overwrite the manager of department #" + departmentNumber+ " ?", "Delete", JOptionPane.YES_NO_OPTION);
			int action = 0;
			if(action == 0){
				
				dbDepObj.updateDepartmentManager(departmentNumber, ssn);
			}
		}
	}
	
	public void deleteDepartmentManager( int securityLevel, int ssn, int departmentNumber){
		
		DbDepartment dbDepObj = new DbDepartment();
		
		if(securityLevel == 1){
		
			ssn = 0;
			dbDepObj.updateDepartmentManager(departmentNumber, ssn);
		}
	}
	
	public ArrayList<Integer> getAllDepartments(){
		
		ArrayList<Integer> departmentList = new ArrayList<>();
		DbDepartment dbDepObj = new DbDepartment();
		
		departmentList = dbDepObj.getAllDepartments();
		
		return departmentList;
	}
}
