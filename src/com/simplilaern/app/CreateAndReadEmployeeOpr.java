package com.simplilaern.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Employee;

public class CreateAndReadEmployeeOpr {

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
			Employee emp = new Employee("Sam", "Millar", 4005, "Engineering");
			
			//start transaction
			session.beginTransaction();
			
			System.out.println("Saving the employee object ...");
			//save / map the emp object.
			session.save(emp);
			
			//commit transaction
			session.getTransaction().commit();
			
			// Read Operation
				
				System.out.println("Read employee ...");
				
				session = factory.getCurrentSession();
				session.beginTransaction();
				System.out.println("Getting Employee with id :"+emp.getId());
				
				Employee fetchedEmp = session.get(Employee.class, emp.getId());
				
				System.out.println("Fetched Employee : "+fetchedEmp);
			
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
