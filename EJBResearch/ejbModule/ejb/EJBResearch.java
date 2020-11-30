package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



/**
 * Session Bean implementation class EJBResearch
 */
@Stateless
@LocalBean
public class EJBResearch implements EJBResearchRemote, EJBResearchLocal {

    @PersistenceContext(name = "TestPersistence")
    private EntityManager em;
    public EJBResearch() {
        // TODO Auto-generated constructor stub
    }
    
    public String InfoNameResearcher(String name) {
    	
    	String jpql = "Select r FROM Researcher r";
    	TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class);
    	List<Researcher> mylist = typedQuery.getResultList();
    	
    	jpql = "Select i FROM Institution i";
    	TypedQuery<Institution> typedQuery2 = em.createQuery(jpql, Institution.class);
    	List<Institution> instiList = typedQuery2.getResultList();
    	
    	String temp ="";
    	
    	for(Researcher r: mylist) {
    		if(r.getName().equals(name)) {
    			System.out.println("Researcher");
    			temp += "Researcher";
	    		System.out.println("Name: " + r.getName()+ " Citations: " + r.getCitations() + " Publications: " + r.getPublications() + " Reads:" + r.getReads());
	    		temp += "Name: " + r.getName()+ " Citations: " + r.getCitations() + " Publications: " + r.getPublications() + " Reads:" + r.getReads();
	    		List <Publication> pubs = r.getPubli();
	    		for(Publication p: pubs) {
	    			System.out.println("Publications");
	    			temp += "Publications";
	    			System.out.println("Name: " + p.getName() + " Type: " + p.getType() + " Publication Date: " + p.getPubDate());
	    			temp+= "Name: " + p.getName() + " Type: " + p.getType() + " Publication Date: " + p.getPubDate();
	    		}
	    		List<Skill> skills = r.getSkills();
	    		for(Skill s: skills) {
	    			System.out.println("Skills");
	    			temp += "Skills";
	    			System.out.println("Name: " + s.getName());
	    			temp += "Name: " + s.getName();
	    		}
	    		for(Institution inst: instiList) {
	    			if(inst.getInstiResearchers().contains(r)) {
	    				System.out.println("Institution");
	    				temp += "Institution";
	    				System.out.println("Name: "+ inst.getName() + " Location: " + inst.getLocation()+" Department: "+ inst.getDepartment());
	    				temp += "Name: "+ inst.getName() + " Location: " + inst.getLocation()+" Department: "+ inst.getDepartment();
	    			}
	    		}
	    		
    		}
    	}
    	return temp;
    }
    
    public String InfoSkill(String skill) {
    	
    	
    	
    	String jpql = "Select r FROM Researcher r";
    	TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class);
    	List<Researcher> mylist = typedQuery.getResultList();
    	
    	jpql = "Select i FROM Institution i";
    	TypedQuery<Institution> typedQuery2 = em.createQuery(jpql, Institution.class);
    	List<Institution> instiList = typedQuery2.getResultList();
    	String temp = "";
    	
    	for(int i = 0; i < mylist.size();i++) {
    		List<Skill> skills = mylist.get(i).getSkills();
    		for(int j = 0; j < skills.size();j++) {
    			if(skills.get(j).getName().equals(skill)) {
    				System.out.println("Researcher");
    	    		System.out.println("Name: " + mylist.get(i).getName()+ " Citations: " + mylist.get(i).getCitations() + " Publications: " + mylist.get(i).getPublications() + " Reads:" + mylist.get(i).getReads());
    	    		System.out.println("Publications");
    	    		temp += "Researcher";
    	    		temp += "Name: " + mylist.get(i).getName()+ " Citations: " + mylist.get(i).getCitations() + " Publications: " + mylist.get(i).getPublications() + " Reads:" + mylist.get(i).getReads();
    	    		temp += "Publications";
    	    		List<Publication> publi = mylist.get(i).getPubli();
    	    		for(Publication p: publi) {
    	    			System.out.println("Name: " + p.getName() + " Type: " + p.getType() + " Publication Date: " + p.getPubDate());
    	    			temp += "Name: " + p.getName() + " Type: " + p.getType() + " Publication Date: " + p.getPubDate();
    	    		}
    	    		for(Institution inst: instiList) {
    	    			if(inst.getInstiResearchers().contains(mylist.get(i))) {
    	    				System.out.println("Institution");
    	    				temp += "Institution";
    	    				System.out.println("Name: "+ inst.getName() + " Location: " + inst.getLocation()+" Department: "+ inst.getDepartment());
    	    				temp += "Name: "+ inst.getName() + " Location: " + inst.getLocation()+" Department: "+ inst.getDepartment();

    	    			}
    	    		}
    			}
    		}
    		
    	}
    	return temp;
    	
    	
    }
    
    
    
    //Obtain all from researchers
    public  String InfoResearchers() {
    	
    	
    	String jpql = "SELECT s FROM Researcher s";
    	TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class);
    	List<Researcher> mylist = typedQuery.getResultList();
    	
    	jpql = "Select i FROM Institution i";
    	TypedQuery<Institution> typedQuery2 = em.createQuery(jpql, Institution.class);
    	List<Institution> listInstu = typedQuery2.getResultList();
    	
    	
    	String temp = "";
    	for (Researcher st : mylist) {
    		System.out.println("Researcher");
    		temp += "Researcher";
    		temp += "Name:" + st.getName()+ " Citations: " + st.getCitations() + " Publications: " + st.getPublications() + " Reads:" + st.getReads();
    		System.out.println("Name:" + st.getName()+ " Citations: " + st.getCitations() + " Publications: " + st.getPublications() + " Reads:" + st.getReads());
    		List<Skill> as1 = st.getSkills();  
			System.out.println("Skills");
			temp += "Skills";
    		for(int i = 0; i < as1.size();i++) {
    			System.out.println(as1.get(i).getName());
    			temp += as1.get(i).getName();
    		}
    		List <Publication>as2 = st.getPubli();
    		System.out.println("Publications");
    		temp += "Publications";
    		for(int j = 0;j < as2.size();j++) {
    			System.out.println("Name: " + as2.get(j).getName() + " Type: " + as2.get(j).getType() + " Publication Date: " + as2.get(j).getPubDate());
    			temp += "Name: " + as2.get(j).getName() + " Type: " + as2.get(j).getType() + " Publication Date: " + as2.get(j).getPubDate();
    		}
    		for(int h = 0;h < listInstu.size();h++) {
    			List<Researcher> res = listInstu.get(h).getInstiResearchers();
    			if(res.contains(st) ){
    				System.out.println("Institution");
    				temp += "Institution";
    				System.out.println("Name: "+ listInstu.get(h).getName() + " Location: " + listInstu.get(h).getLocation()+" Department: "+ listInstu.get(h).getDepartment());
    				temp += "Name: "+ listInstu.get(h).getName() + " Location: " + listInstu.get(h).getLocation()+" Department: "+ listInstu.get(h).getDepartment();
    			}
    		}
    	}
    	// Close an application-managed entity manager.
    	// Close the factory, releasing any resources that it holds.
    	
    	
    	return temp;
    	
    }

}
