package loader;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import common.Institution;
import common.Publication;
import common.Researcher;
import common.Skill;

public class Loader {
	
	public static void main(String[] args){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Skills
		Skill sk1 = new Skill("C");
		Skill sk2 =new Skill("Java");
		Skill sk3 = new Skill("Python");
		
		em.persist(sk1);
		em.persist(sk2);
		em.persist(sk3);
		
		ArrayList<Skill> as1= new ArrayList<Skill>();
		ArrayList<Skill> as2= new ArrayList<Skill>();
		
		as1.add(sk1);
		as2.add(sk2);
		as1.add(sk3);
		
		
		//Publications
		Publication pb1 = new Publication("The Hangover","Classico","02/02/2020");
		Publication pb2 = new Publication("El Classico","Espetaculo","02/03/2020");
		Publication pb3 = new Publication("Arsenal","Invincibles","02/04/2020");
		Publication pb4 = new Publication("La Remontada","Classico","02/05/2020");
		Publication pb5 = new Publication("Agora ja podes","Vintage","02/06/2020");
		
		em.persist(pb1);
		em.persist(pb2);
		em.persist(pb3);
		em.persist(pb4);
		em.persist(pb5);


		
		ArrayList<Publication> al1 = new ArrayList<Publication>();
		ArrayList<Publication> al2 = new ArrayList<Publication>();
		ArrayList<Publication> al3 = new ArrayList<Publication>();
		ArrayList<Publication> al4 = new ArrayList<Publication>();
		ArrayList<Publication> al5 = new ArrayList<Publication>();
		
		al1.add(pb1);
		al2.add(pb2);
		al3.add(pb3);
		al4.add(pb4);
		al5.add(pb5);
		

		
		// Researchers

		
		Researcher rs1 = new Researcher("Alfredo Simões",5,5,10,al1,as1);
		Researcher rs2 = new Researcher("Rui Jacare",10,7,8,al2,as2);
		Researcher rs3 = new Researcher("Jose Perna",20,4,3,al3,as2);
		Researcher rs4 = new Researcher("Flavio Morgado",13,2,1,al4,as1);
		Researcher rs5 = new Researcher("Rui Da Bola",21,23,30,al5,as2);
		
		em.persist(rs1);
		em.persist(rs2);
		em.persist(rs3);
		em.persist(rs4);
		em.persist(rs5);
		
		
		ArrayList<Researcher> list1 = new ArrayList<Researcher>();
		ArrayList<Researcher> list2 = new ArrayList<Researcher>();
		ArrayList<Researcher> list3 = new ArrayList<Researcher>();
		
		list1.add(rs1);
		list1.add(rs2);
		list2.add(rs3);
		list2.add(rs4);
		list3.add(rs5);
		
		// Institutions
		
		Institution inst1 = new Institution("Universidade de Coimbra","Coimbra","DEI");
		Institution inst2 = new Institution("Universidade de Aveiro","Aveiro","DABOFIA");
		Institution inst3 = new Institution("Universidade de Lisboa","Lisboa","DARQ");
		
		inst1.setInstiResearchers(list1);
		inst2.setInstiResearchers(list2);
		inst3.setInstiResearchers(list3);
		
		em.persist(inst1);
		em.persist(inst2);
		em.persist(inst3);
		
		em.getTransaction().commit();
		em.close();
		emf.close();


		
		


		





		
		
		
		
	}

}
