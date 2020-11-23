package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import common.Researcher;

public class JPAReadInstitutions {
	public static void main(String[] args){
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager em = emf.createEntityManager();
	String jpql = "SELECT s FROM Student s";
	TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class);
	List<Researcher> mylist = typedQuery.getResultList();
	for (Researcher rs : mylist)
		System.out.println(rs);
	// Close an application-managed entity manager.
	em.close();
	// Close the factory, releasing any resources that it holds.
	emf.close();
	}
}