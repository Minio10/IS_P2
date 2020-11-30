package soap.info;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.EJBResearchRemote;

public class SoapInfo {
	/*
	
							R  E S E A R C H E R S
																*/
	
public String infoResearcher(String name)throws NamingException, IOException,FileNotFoundException {
		
		
		String res;
		Context context;
		
		Properties jndiProperties = new Properties();

		 

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
	
		
			
			
			context = new InitialContext(jndiProperties);
			EJBResearchRemote cr = (EJBResearchRemote) context.lookup("EJBResearch/EJBResearch!ejb.EJBResearchRemote");

			res = 	cr.InfoNameResearcher(name);
			return res;
			
		
	}

	public String getAllRes() throws NamingException, IOException,FileNotFoundException {
		
		String res;
		Context context;
		
		Properties jndiProperties = new Properties();

		 

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
	
		
			
			
			context = new InitialContext(jndiProperties);
			EJBResearchRemote cr = (EJBResearchRemote) context.lookup("EJBResearch/EJBResearch!ejb.EJBResearchRemote");

			res = 	cr.InfoResearchers();
			return res;
		
	}
	
	public String resFromSkill(String skill)throws NamingException, IOException,FileNotFoundException {
		String res;
		Context context;
		
		Properties jndiProperties = new Properties();

		 

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
	
		
			
			
			context = new InitialContext(jndiProperties);
			EJBResearchRemote cr = (EJBResearchRemote) context.lookup("EJBResearch/EJBResearch!ejb.EJBResearchRemote");

			res = 	cr.InfoSkill(skill);
			return res;
		
		
	}
	

}
