package com.ty.manytomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourse {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = new Student();
		student1.setName("Karthi");
		student1.setAge(22);

		Student student2 = new Student();
		student2.setName("Peter");
		student2.setAge(23);

		List<Student> studentsList1 = new ArrayList<Student>();
		studentsList1.add(student1);
		studentsList1.add(student2);

		List<Student> studentsList2 = new ArrayList<Student>();
		studentsList2.add(student2);

		Course course1 = new Course();
		course1.setName("java");
		course1.setDuration("1 year");
		course1.setStudent(studentsList1);

		Course course2 = new Course();
		course2.setName("SQL");
		course2.setDuration("2 months");
		course2.setStudent(studentsList1);

		Course course3 = new Course();
		course3.setName("HTML");
		course3.setDuration("3 months");
		course3.setStudent(studentsList2);

		List<Course> coursesList1 = new ArrayList<Course>();
		coursesList1.add(course1);
		coursesList1.add(course2);

		List<Course> coursesList2 = new ArrayList<Course>();
		coursesList2.add(course1);
		coursesList2.add(course2);
		coursesList2.add(course3);

		student1.setCourse(coursesList1);
		student2.setCourse(coursesList2);

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();

	}

}
