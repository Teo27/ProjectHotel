package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelLayer.MdlCustomer;
import modelLayer.MdlInvoice;
import modelLayer.MdlRates;

public class DbInvoice {

	public DbInvoice(){
		
	}
	
	public ResultSet refreshTableInvoice(){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select * from Invoice";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			return rs;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
	}
	
	public MdlInvoice selectFromTableInvoice(String selectedId){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		MdlInvoice mdlInvObj = new MdlInvoice();
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "select * from Invoice where id = '"+ selectedId +"'";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				mdlInvObj.setId(rs.getInt("id"));
				mdlInvObj.setName(rs.getString("name"));
				mdlInvObj.setSurname(rs.getString("surname"));
			}
			
			pst.close();
			return mdlInvObj;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		

	}
	
	public ResultSet lastUpdated(){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		int id = -1;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "select * from invoice SELECT TOP 1 (id) FROM invoice ORDER BY id DESC";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			while(rs.next()){
				
				id = rs.getInt("id");
			}
			
			rs.close();
			pst.close();
			
			query = "select * from invoice where id = ?";
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			return rs;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
	}
	
	public boolean updatePaymentType(MdlInvoice mdlInvObj){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		boolean success = false;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = " Update Invoice set payment_type = '"+ mdlInvObj.getPaymentType() +"' where id = '"+ mdlInvObj.getId() +"' ";
			pst = connection.prepareStatement(query);
			success = false;
			
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
	
	public boolean updatePaymentDeadline(MdlInvoice mdlInvObj){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		boolean success = false;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = " Update Invoice set payment_deadline = '"+ mdlInvObj.getPaymentDeadline() +"' where id = '"+ mdlInvObj.getId() +"' ";
			pst = connection.prepareStatement(query);
			success = false;
			
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
	
	public boolean updatePaid(MdlInvoice mdlInvObj){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		boolean success = false;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = " Update Invoice set paid = '"+ mdlInvObj.isPaid() +"' where id = '"+ mdlInvObj.getId() +"' ";
			pst = connection.prepareStatement(query);
			success = false;
			
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
	
	public boolean updatePaymentOverdue(MdlInvoice mdlInvObj){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		boolean success = false;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = " Update Invoice set payment_overdue = '"+ mdlInvObj.isPaymentOverdue() +"' where id = '"+ mdlInvObj.getId() +"' ";
			pst = connection.prepareStatement(query);
			success = false;
			
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
	
	public boolean updatePrice(MdlInvoice mdlInvObj){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		boolean success = false;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = " Update Invoice set price = '"+ mdlInvObj.getPrice() +"' where id = '"+ mdlInvObj.getId() +"' ";
			pst = connection.prepareStatement(query);
			success = false;
			
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
	
	public boolean insertInvoice(MdlInvoice mdlInvObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "INSERT INTO invoice (name, surname, employee, price, payment_type, payment_deadline, paid, payment_overdue) VALUES(?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(query);
			success = false;
			
			pst.setString(1, mdlInvObj.getName());
			pst.setString(2, mdlInvObj.getSurname());
			pst.setString(3, mdlInvObj.getEmployee());
			pst.setFloat(4, mdlInvObj.getPrice());
			pst.setString(5, mdlInvObj.getPaymentType());
			pst.setString(6, mdlInvObj.getPaymentDeadline());
			pst.setBoolean(7, mdlInvObj.isPaid());
			pst.setBoolean(8, mdlInvObj.isPaymentOverdue());
			
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
	
	public void deleteInvoice(int id){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		
		try{
			
			query = "Delete from Invoice where id = '"+ id +"'";
			pst = connection.prepareStatement(query);
			
			pst.execute();
			pst.close();
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
		}
	}
	
	public ResultSet searchInvoice(String selection, String searchInvoice){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		Statement  st;
		ResultSet rs;
				
	try{
		
			query = "Select * from invoice where "+ selection +" LIKE '%"+searchInvoice+"%' ";
			st = connection.createStatement();
			rs = st.executeQuery(query);

		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		
		return rs;
	}
}
