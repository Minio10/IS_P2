package jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import common.GetPublicationInfo;
import common.Publication;

public class JPAWritePublications {
	public static void main(String[] args){

	List<Publication> mylist = GetPublicationInfo.get();
	EntityManagerFactory emf = Persistence
	.createEntityManagerFactory("TestPersistence");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	for (Publication pb : mylist)
		em.persist(pb);
	tx.commit();
	// after commit we have :
	for (Publication pb1 : mylist)
		System.out.println(pb1);
	// Close an application-managed entity manager.
	em.close();
	//Close the factory, releasing any sources that it holds.
	emf.close();
		}
}
