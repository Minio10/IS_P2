package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class EJBInstitution
 */
@Stateless
@LocalBean
public class EJBInstitution implements EJBInstitutionRemote, EJBInstitutionLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(name = "TestPersistence")
    private EntityManager em;
	
    public EJBInstitution() {
        // TODO Auto-generated constructor stub
    }
    
    public void getAllInfo() {
    	
    	String jpql = "Select i FROM Institution i";
    	TypedQuery<Institution> typedQuery = em.createQuery(jpql, Institution.class);
    	List<Institution> listInstu = typedQuery.getResultList();
    	
    	for(Institution i: listInstu) {
    		System.out.println("Institution");
			System.out.println("Name: "+ i.getName() + " Location: " + i.getLocation()+" Department: "+ i.getDepartment());
			System.out.println("Researchers in " + i.getName());
			List<Researcher> listRes = i.getInstiResearchers();
			for(Researcher r: listRes) {
	    		System.out.println("Name: " + r.getName()+ " Citations: " + r.getCitations() + " Publications: " + r.getPublications() + " Reads:" + r.getReads());
			}
    	}
    }
    
    public void InstiName(String name) {
    	
    	String jpql = "Select i FROM Institution i";
    	TypedQuery<Institution> typedQuery = em.createQuery(jpql, Institution.class);
    	List<Institution> listInstu = typedQuery.getResultList();
    	
    	for(Institution i: listInstu) {
    		if(i.getName().equals(name)) {
    			System.out.println("Institution");
    			System.out.println("Name: "+ i.getName() + " Location: " + i.getLocation()+" Department: "+ i.getDepartment());
    			System.out.println("Researchers in " + i.getName());
    			List<Researcher> listRes = i.getInstiResearchers();
    			for(Researcher r: listRes) {
    	    		System.out.println("Name: " + r.getName()+ " Citations: " + r.getCitations() + " Publications: " + r.getPublications() + " Reads:" + r.getReads());
    			}
    		}
    	}
    }
    
    public void InstiResName(String name) {
    	
    	String jpql = "Select i FROM Institution i";
    	TypedQuery<Institution> typedQuery = em.createQuery(jpql, Institution.class);
    	List<Institution> listInstu = typedQuery.getResultList();
    	
    	for(Institution i: listInstu) {
    		List <Researcher> listRes = i.getInstiResearchers();
    		for(Researcher r: listRes) {
    			if(r.getName().equals(name)) {
        			System.out.println("Name: "+ i.getName() + " Location: " + i.getLocation()+" Department: "+ i.getDepartment());
    			}
    		}
    	}
    }

}
