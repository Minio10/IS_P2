package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.EJBResearchRemote;



public class TestClient {

	public static void main(String[] args) throws NamingException, IOException,FileNotFoundException {String name = "postgres";
 	  String password = "calmo";
 	  String tablename = "researcher";
 	  String url = "jdbc:postgresql://localhost/postgres";
 	 
 	 try
 	 {
	    	 Connection conn = (Connection) DriverManager.getConnection(url,name, password);
	    	 Statement stmt = (Statement) conn.createStatement();
	    	 ResultSet rs;
	    	 rs = stmt.executeQuery("SELECT * FROM " + tablename);
	    	 while (rs.next())
	    	 {
		    	 Long id = rs.getLong("id");
		    	 String rName = rs.getString("name");
		    	 int citations = rs.getInt("citations");
		    	 int publications = rs.getInt("publications");
		    	 int reads = rs.getInt("reads");
		    	 System.out.println(id + ": " + rName + " " + citations + "-"+publications +"-" +reads);
	    	 }
	    	 conn.close();
	    	 }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	     }

		// TODO Auto-generated method stub
		
		Context context;
		try (InputStream input = new FileInputStream("jndi.properties")){
			Properties jndiProperties = new Properties();
			
			jndiProperties.load(input);
			
			context = new InitialContext(jndiProperties);
		}
		EJBResearchRemote cr = (EJBResearchRemote) context.lookup("EJBResearch/EJBResearch!ejb.EJBResearchRemote");

		cr.InfoResearchers();
		
		
		 
	}

}
