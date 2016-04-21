package dbLayer;

import java.sql.*;

import javax.swing.*;

public class DbConnection {
	
	static String url;
	private static String driver;
	private static String databaseName;
	private static String userName;
	private static String password;
	
	static Connection con;
	private static DatabaseMetaData dma;
	private static DbConnection  instance;
	
	public static Connection DbConnector(){
		
		driver = "jdbc:sqlserver://kraka.ucn.dk:1433";
		databaseName = ";databaseName=dmaj0914_2Sem_4";
		userName = ";user=dmaj0914_2Sem_4 ";
		password = ";password=IsAllowed";
		
//		driver = "jdbc:sqlserver://localhost:1433";
//		databaseName = ";databaseName=Hotel_v2_1";
//		userName = ";user=sa";
//		password = ";password=Masterkey";
		
		url = driver + databaseName + userName + password;
		
		try{
			
			//load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//connect to database
			con = DriverManager.getConnection(url);
			//set autocommit
			con.setAutoCommit(true);
			// get meta data
			dma = con.getMetaData(); 
			
			return con;
		}
		catch(Exception e1){
			
			//JOptionPane.showMessageDialog(null, "Unable to connect to the database");
			System.out.println("Unable to connect to the database");
			return null;
		}
	}
	
	public static DbConnection getInstance(){
        
		if (instance == null){
        	
          instance = new DbConnection();
        }
        
		return instance;
    }
	
    public static void closeConnection(){
       	
    	try{
            
    		con.close();
        }
         catch (Exception e){
        	 
        	 JOptionPane.showMessageDialog(null,"Error occurred while closing the connection");
         }
    }
}
