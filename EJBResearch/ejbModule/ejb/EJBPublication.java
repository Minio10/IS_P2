package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class EJBPublication
 */
@Stateless
@LocalBean
public class EJBPublication implements EJBPublicationRemote, EJBPublicationLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(name = "TestPersistence")
    private EntityManager em;
	
    public EJBPublication() {
        // TODO Auto-generated constructor stub
    }
    
    public void getAllPub() {
    	
    	String jpql = "SELECT s FROM Publication s";
    	TypedQuery<Publication> typedQuery = em.createQuery(jpql, Publication.class);
    	List<Publication> mylist = typedQuery.getResultList();
    	
    	jpql = "Select r FROM Researcher r";
    	TypedQuery<Researcher> typedQuery2 = em.createQuery(jpql, Researcher.class);
    	List<Researcher> listRes = typedQuery2.getResultList();
    	// Gets all info from Publications
    	for(Publication p: mylist) {
    		System.out.println("Publication");
    		System.out.println("Name: " + p.getName() + " Type: " + p.getType() + " Publication Date: " + p.getPubDate());    
    		System.out.print("Authored by: ");
    		// Gets Publication's authors
    		for(Researcher r: listRes) {
    			List<Publication> temp = r.getPubli();
    			if(temp.contains(p)) {
    				System.out.print(r.getName()+",");
    			}
    		}
    		System.out.println();
    	}
    }
    
    public void titlePubInfo(String title) {
    	
    	String jpql = "SELECT s FROM Publication s";
    	TypedQuery<Publication> typedQuery = em.createQuery(jpql, Publication.class);
    	List<Publication> mylist = typedQuery.getResultList();
    	
    	jpql = "Select r FROM Researcher r";
    	TypedQuery<Researcher> typedQuery2 = em.createQuery(jpql, Researcher.class);
    	List<Researcher> listRes = typedQuery2.getResultList();
    	
    	for(Publication p: mylist) {
    		if(p.getName().equals(title)) {
    			System.out.println("Publication");
        		System.out.println("Name: " + p.getName() + " Type: " + p.getType() + " Publication Date: " + p.getPubDate());    
        		System.out.print("Authored by: ");
        		for(Researcher r: listRes) {
        			List<Publication> temp = r.getPubli();
        			if(temp.contains(p)) {
        				System.out.print(r.getName()+",");
        			}
        		}
        		System.out.println();    		
    		}
    	}
    }
    
    public void resNamePubs(String name) {
    	
    	String jpql = "SELECT s FROM Researcher s";
    	TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class);
    	List<Researcher> mylist = typedQuery.getResultList();
    	
    	for(Researcher r: mylist) {
    		if(r.getName().equals(name)) {
    			System.out.println("Author: " + r.getName());
    			List<Publication> pubs = r.getPubli();
    			for(Publication p: pubs) {
    				System.out.println("Publication");
            		System.out.println("Name: " + p.getName() + " Type: " + p.getType() + " Publication Date: " + p.getPubDate());
    			}
    		}
    	}
    }
    

}
