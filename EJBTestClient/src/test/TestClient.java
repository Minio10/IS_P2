package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.EJBInstitutionRemote;
import ejb.EJBPublicationRemote;
import ejb.EJBResearchRemote;



public class TestClient {

	public static void main(String[] args) throws NamingException, IOException,FileNotFoundException {
 	 

		// TODO Auto-generated method stub
		
		Context context;
		try (InputStream input = new FileInputStream("jndi.properties")){
			Properties jndiProperties = new Properties();
			
			jndiProperties.load(input);
			
			context = new InitialContext(jndiProperties);
		}
		EJBResearchRemote cr = (EJBResearchRemote) context.lookup("EJBResearch/EJBResearch!ejb.EJBResearchRemote");
		cr.InfoSkill("Python");
//		cr.InfoResearchers();
//		cr.InfoNameResearcher("Rui Jacare");
		
//		EJBPublicationRemote pr = (EJBPublicationRemote) context.lookup("EJBResearch/EJBPublication!ejb.EJBPublicationRemote");
//		pr.getAllPub();
//		pr.titlePubInfo("Arsenal");
//		pr.resNamePubs("Jose Perna");
		
//		EJBInstitutionRemote cr = (EJBInstitutionRemote) context.lookup("EJBResearch/EJBInstitution!ejb.EJBInstitutionRemote");
//		cr.getAllInfo();
//		cr.InstiResName("Jose Perna");
//		cr.InstiName("Universidade de Coimbra");
		
		
		
		
		
		 
	}

}
