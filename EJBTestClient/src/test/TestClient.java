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
 	 

		// TODO Auto-generated method stub
		
		Context context;
		try (InputStream input = new FileInputStream("jndi.properties")){
			Properties jndiProperties = new Properties();
			
			jndiProperties.load(input);
			
			context = new InitialContext(jndiProperties);
		}
		EJBResearchRemote cr = (EJBResearchRemote) context.lookup("EJBResearch/EJBResearch!ejb.EJBResearchRemote");
		cr.InfoSkill("Python");
		
		
		 
	}

}
