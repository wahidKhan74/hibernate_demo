package com.simplilaern.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Employee;

public class DeleteEmployeeOpr {

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
			
			
			int empId = 7;	
			
			//start transaction
			session.beginTransaction();
			
			Employee emp = session.get(Employee.class, empId);
			
			System.out.println("Befor Delete");
			System.out.println(emp);
			
			//delete by object
//			session.delete(emp);
			
			session.createQuery("delete from Employee emp where emp.id=8").executeUpdate();
			
			session.getTransaction().commit();
			
			
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
