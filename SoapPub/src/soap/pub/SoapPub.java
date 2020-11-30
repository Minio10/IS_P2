package soap.pub;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.EJBPublicationRemote;

public class SoapPub {

public String infoPublication(String title) throws NamingException, IOException,FileNotFoundException {
			
	String pub;
	Context context;
	Properties jndiProperties= new Properties();
	
	jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

	jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

	jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
	
	
	context = new InitialContext(jndiProperties);
	EJBPublicationRemote cr = (EJBPublicationRemote) context.lookup("EJBResearch/EJBPublication!ejb.EJBPublicationRemote");
	
	pub = cr.titlePubInfo(title);
	return pub;
	
	
	}

	public String getAllPub() throws NamingException, IOException,FileNotFoundException {
		
		String pub;
		Context context;
		Properties jndiProperties = new Properties();
		
		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
		context = new InitialContext(jndiProperties);
		EJBPublicationRemote cr = (EJBPublicationRemote) context.lookup("EJBResearch/EJBPublication!ejb.EJBPublicationRemote");
		
		pub = cr.getAllPub();
		return pub;
	}
	
	public String pubFromRes(String name)throws NamingException, IOException,FileNotFoundException {
		String pub;
		Context context;
		Properties jndiProperties = new Properties();
		
		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
	
		
		context = new InitialContext(jndiProperties);
		EJBPublicationRemote cr = (EJBPublicationRemote) context.lookup("EJBResearch/EJBPublication!ejb.EJBPublicationRemote");
		
		pub=cr.resNamePubs(name);
		return pub;
	}
}
