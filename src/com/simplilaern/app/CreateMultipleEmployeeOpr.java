package com.simplilaern.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Employee;

public class CreateMultipleEmployeeOpr {

	public static void main(String[] args) {
		
		//1. create session factory 
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		//2.create a session (open a session)
		Session session = factory.getCurrentSession();
		
		// 3. perform operations
		try {
			// 1. insert operation
			// create  employees object.
			System.out.println("Creating new Employee object ...");
			Employee emp1 = new Employee("Marryyyyyyyyy", "Doe", 500, "Engineering");
			Employee emp2 = new Employee("Kiieee", "Smith", 300, "public");
			Employee emp3 = new Employee("Kimmyyy", "Doe", 200, "public");
			Employee emp4 = new Employee("Kixyzz", "Abc", 100, "pqr");
			
			//2. start transaction
			session.beginTransaction();
			
			System.out.println("Saving the employee object ...");
			
			//3.save / map the employees object.
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			
			//commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.print("Done!");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		
		

	}

}
