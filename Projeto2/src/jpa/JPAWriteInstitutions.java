package jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import common.GetInstitutionInfo;
import common.Institution;

public class JPAWriteInstitutions {
	public static void main(String[] args){

	List<Institution> mylist = GetInstitutionInfo.get();
	EntityManagerFactory emf = Persistence
	.createEntityManagerFactory("TestPersistence");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	for (Institution it : mylist)
		em.persist(it);
	tx.commit();
	// after commit we have :
	for (Institution it1 : mylist)
		System.out.println(it1);
	// Close an application-managed entity manager.
	em.close();
	//Close the factory, releasing any sources that it holds.
	emf.close();
		}
}
