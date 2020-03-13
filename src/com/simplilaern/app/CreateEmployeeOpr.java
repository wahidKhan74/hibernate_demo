package com.simplilaern.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Employee;

public class CreateEmployeeOpr {

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
			// insert operation
			// create a employee object.
			System.out.println("Creating new Employee object ...");
			Employee emp = new Employee("John", "Doe", 10238843, "Engineering");
			
			//start transaction
			session.beginTransaction();
			
			System.out.println("Saving the employee object ...");
			//save / map the emp object.
			session.save(emp);
			
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
