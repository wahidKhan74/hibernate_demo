package com.simplilaern.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Employee;

public class UpdateEmployeeOpr {

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
			
			int empId = 6;
			
			
			//start transaction
			session.beginTransaction();
			
			Employee emp = session.get(Employee.class, empId);
			
			System.out.println("Befor Update");
			System.out.println(emp);
			
			System.out.println("Updating Employee ....");
			emp.setFirstName("Malik");
			emp.setLastName("S");
			
			
			session.getTransaction().commit();
			System.out.println("After Update");
			
			
			System.out.println(emp);
			
//			session.createQuery("update Employee emp set emp.firstName='NewName' where emp.id ="+empId).executeUpdate();
//			session.getTransaction().commit();
			
			//close session
			session.close();
			
			System.out.println("Done!");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		
		

	}

}
