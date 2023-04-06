package br.com.luciano.main;

import br.com.luciano.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InsertPersonMain {
	
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("curso-JPA-Hibernate_PU");

	public static void main(String[] args) {	
		
		Person person = Person.builder()
				.firstName("Luciano")
				.lastName("Oliveira")
				.build();
		
		save(person);
	}
	
	public static void save(Person Person) {
		
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(Person);
		
		em.getTransaction().commit();
		em.close();
	}

}
