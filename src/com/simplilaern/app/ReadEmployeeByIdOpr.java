package com.simplilaern.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Employee;

public class ReadEmployeeByIdOpr {

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
			
			int empId = 10;
			
			System.out.println("Read Employee with Id : "+empId);
						
			//start transaction
			session.beginTransaction();
			
			//read emp by id using sesssion.get
			Employee emp = session.get(Employee.class,empId);
			
			System.out.println("Fetched Emploee : "+emp);
			
			//close session
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
