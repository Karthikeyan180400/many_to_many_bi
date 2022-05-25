package com.ty.manytomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonCab {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person1 = new Person();
		person1.setName("Karthi");
		person1.setMobile(11112222);
		person1.setAddress("15th cross, BTM Layout");

		Person person2 = new Person();
		person2.setName("Peter");
		person2.setMobile(22223333);
		person2.setAddress("10th cross,Marathahalli");

		Person person3 = new Person();
		person3.setName("Nishanth");
		person3.setMobile(33334444);
		person3.setAddress("2nd Cross,Thirupur");

	/*	List<Person> personsList1 = new ArrayList<Person>();
		personsList1.add(person1);
		personsList1.add(person2);

		List<Person> personsList2 = new ArrayList<Person>();
		personsList2.add(person1);
		personsList2.add(person3); */

		Cab cab1 = new Cab();
		cab1.setDriverName("Murugesh");
		cab1.setMobile(44445555);
		//cab1.setPerson(personsList1);

		Cab cab2 = new Cab();
		cab2.setDriverName("Sathish");
		cab2.setMobile(55556666);
	//	cab2.setPerson(personsList2);

		List<Cab> cabsList1 = new ArrayList<Cab>();
		cabsList1.add(cab1);

		List<Cab> cabsList2 = new ArrayList<Cab>();
		cabsList2.add(cab2);

		List<Cab> cabsList3 = new ArrayList<Cab>();
		cabsList3.add(cab1);
		cabsList3.add(cab2);

		person1.setCab(cabsList3);
		person2.setCab(cabsList1);
		person3.setCab(cabsList2);

		entityTransaction.begin();
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityManager.persist(cab1);
		entityManager.persist(cab2);
		entityTransaction.commit();

	}

}
