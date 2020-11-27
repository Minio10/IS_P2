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
    
    public void InfoSkill(String skill) {
    	
    	
    	
    	String jpql = "Select r FROM Researcher r";
    	TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class);
    	List<Researcher> mylist = typedQuery.getResultList();
    	
    	for(int i = 0; i < mylist.size();i++) {
    		List<Skill> skills = mylist.get(i).getSkills();
    		for(int j = 0; j < skills.size();j++) {
    			if(skills.get(j).getName().equals(skill)) {
    	    		System.out.println("Name:" + mylist.get(i).getName()+ " Citations: " + mylist.get(i).getCitations() + " Publications: " + mylist.get(i).getPublications() + " Reads:" + mylist.get(i).getReads());

    			}
    		}
    	}
    	
    	
    }
    
    
    
    //Obtain all from researchers
    public  void InfoResearchers() {
    	
    	
    	String jpql = "SELECT s FROM Researcher s";
    	TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class);
    	List<Researcher> mylist = typedQuery.getResultList();
    	
    	jpql = "Select i FROM Institution i";
    	TypedQuery<Institution> typedQuery2 = em.createQuery(jpql, Institution.class);
    	List<Institution> listInstu = typedQuery2.getResultList();
    	
    	
    	
    	for (Researcher st : mylist) {
    		System.out.println("Name:" + st.getName()+ " Citations: " + st.getCitations() + " Publications: " + st.getPublications() + " Reads:" + st.getReads());
    		List<Skill> as1 = st.getSkills();  
			System.out.println("Skills");
    		for(int i = 0; i < as1.size();i++) {
    			System.out.println(as1.get(i).getName());
    		}
    		List <Publication>as2 = st.getPubli();
    		System.out.println("Publications");
    		for(int j = 0;j < as2.size();j++) {
    			System.out.println(as2.get(j).getName());
    		}
    		for(int h = 0;h < listInstu.size();h++) {
    			List<Researcher> res = listInstu.get(h).getInstiResearchers();
    			if(res.contains(st) ){
    				System.out.println("Institution: "+ listInstu.get(h).getName());
    			}
    		}
    	}
    	// Close an application-managed entity manager.
    	// Close the factory, releasing any resources that it holds.
    	
    	
    	
    	
    }

}
