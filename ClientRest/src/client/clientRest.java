package client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb.EJBInstitutionRemote;
import ejb.EJBPublicationRemote;
import ejb.EJBResearchRemote;



public class clientRest {
	public static void main(String[] args)throws NamingException, IOException,FileNotFoundException {
		Scanner opt = new Scanner(System.in);
		String info;
		int option;
		boolean ficar=true;
		Context context;
		
		Properties jndiProperties = new Properties();

		 

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
			
		context = new InitialContext(jndiProperties);
		EJBResearchRemote cr = (EJBResearchRemote) context.lookup("EJBResearch/EJBResearch!ejb.EJBResearchRemote");
		EJBPublicationRemote pr = (EJBPublicationRemote) context.lookup("EJBResearch/EJBPublication!ejb.EJBPublicationRemote");
		EJBInstitutionRemote ir = (EJBInstitutionRemote) context.lookup("EJBResearch/EJBInstitution!ejb.EJBInstitutionRemote");
		
		while(ficar) {
			System.out.println("Escolha o que pretende visualizar:\n 1-Todas as Instituições \n 2-Instituição \n 3-Instituição de researcher  \n 4-Todos os Researcher \n 5-Researcher \n 6-Researcher com Skill \n 7-Todas as publicacoes \n 8-Publicacao \n 9- Publicacoes de Researcher \n 10-Sair");
			option= opt.nextInt();
			if(option==1) {
				Client client = ClientBuilder.newClient();
				WebTarget target = client.target("http://localhost:8080/restInst/rest/institution/getall");
				Response response = target.request().get();
				String value = response.readEntity(String.class);
				System.out.println("RESPOSTA:"+value);
				response.close();
			}else if(option==2) {
				Client client = ClientBuilder.newClient();
				String inst="";
				System.out.println("Escreva o nome da instituicao que pretende ver:\n");
				while(inst.equals("")) {
					inst=opt.nextLine();
				}
				WebTarget target = client.target("http://localhost:8080/restInst/rest/institution/getInst/"+inst);
				Response response = target.request().get();
				String value = response.readEntity(String.class);
				System.out.println("RESPOSTA:"+value);
				response.close();
			}else if(option==3) {
				Client client = ClientBuilder.newClient();
				String res="";
				System.out.println("Escreva o nome do researcher da instituicao:\n");
				while(res.equals("")) {
					res=opt.nextLine();
				}		
				WebTarget target = client.target("http://localhost:8080/restInst/rest/institution/getInstFromRes/"+res);
				Response response = target.request().get();
				String value = response.readEntity(String.class);
				System.out.println("RESPOSTA:"+value);
				response.close();
			}else if(option==4) {
				
				info=cr.InfoResearchers();
				System.out.println(info);
			}else if(option==5) {
				String res="";
				System.out.println("Escreva o nome do researcher:\n");
				while(res.equals("")) {
					res=opt.nextLine();
				}
				System.out.println(cr.InfoNameResearcher(res));
			}else if(option==6) {
				String res="";
				System.out.println("Escreva o nome da skill:\n");
				while(res.equals("")) {
					res=opt.nextLine();
				}
				System.out.println(cr.InfoSkill(res));
			}else if(option==7) {
				System.out.println(pr.getAllPub());
			}else if(option==8) {
				String res="";
				System.out.println("Escreva o nome da publicacao:\n");
				while(res.equals("")) {
					res=opt.nextLine();
				}
				System.out.println(pr.titlePubInfo(res));
			}else if(option==9) {
				String res="";
				System.out.println("Escreva o nome do researcher:\n");
				while(res.equals("")) {
					res=opt.nextLine();
				}
				System.out.println(pr.resNamePubs(res));
			}
			else if(option==10) {
				ficar=false;
				System.out.println("A sair...");
			}else {
				System.out.println("Não reconhecido tente de novo");
			}
		}
	}	
	
	public static void menuResearcher() {
		
	}
}
