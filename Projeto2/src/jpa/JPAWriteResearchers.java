package jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import common.Researcher;
import common.GetResearcherInfo;

public class JPAWriteResearchers {
	public static void main(String[] args){
	List<Researcher> mylist = GetResearcherInfo.get();
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	for (Researcher rs : mylist)
		em.persist(rs);
	tx.commit();
	// after commit we have :
	for (Researcher rs : mylist)
		System.out.println(rs);
	// Close an application-managed entity manager.
	em.close();
	//Close the factory, releasing any sources that it holds.
	emf.close();
	}
}
