package rest.inst;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import ejb.EJBInstitution;
@RequestScoped
@Path("/institution")
public class RestInst {
	@EJB
	EJBInstitution bean;
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public String showAll() throws FileNotFoundException, IOException, NamingException {
		System.out.println("showing all institutions...");
		String inst;
		inst= bean.getAllInfo();
		return inst;
	}
	
	@GET
	@Path("/getInst/{institution}")
	@Produces(MediaType.APPLICATION_JSON)
	public String showInst(@PathParam("institution") String instu) throws FileNotFoundException, IOException, NamingException {
		System.out.println("showing institution "+instu+"...");
		String inst;
		inst=bean.InstiName(instu);
		return inst;
		
	}
	
	@GET
	@Path("/getInstFromRes/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String showInstFromRes(@PathParam("name") String name) throws FileNotFoundException, IOException, NamingException {
		
		System.out.println("showing insitution from researcher "+name+"...");
		String inst;
		inst=bean.InstiResName(name);
		return inst;
	}
}
