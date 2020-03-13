package com.simplilaern.app;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Employee;

public class ReadAllEmployeesOpr {

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
						
			//start transaction
			session.beginTransaction();
			
			//preapre select query
			//select * from employee;
			//
			// HQL -> persistance object
			
			// From class  // from employee
//			1 .String hql = "FROM Employee";
//			
//			2. Query query = session.createQuery(hql);
//			
//			3. List <Employee>list = query.getResultList();
			
			
			List <Employee>listOfEmp = session.createQuery("from Employee as e").getResultList();
			
			//select first_name from employee;
//			List <String>list = session.createQuery("select e.firstName from Employee e").getResultList();
			
//			display(listOfEmp);
			System.out.println("---------------------------------------");
			
			//select *  from employees where last_name = "Doe";
			
			listOfEmp = session.createQuery("from Employee emp where emp.lastName='Doe' or emp.firstName='Marry' order by emp.firstName DESC ").getResultList();		
			
			display(listOfEmp);
			System.out.println("---------------------------------------");
			
			
	
			//select *  from employees where last_name  like  'Ki%';
			//select *  from employees where last_name  like  '%Ki';
			listOfEmp = session.createQuery("from Employee emp where emp.firstName like '%yy' ").getResultList();		
			
//			display(listOfEmp);
			System.out.println("---------------------------------------");
			
			//close session
			session.close();
			
			System.out.print("Done!");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		
		

	}//main
	
	// display
	private static void display(List <Employee> listOfEmp) {		
		for(Employee emp : listOfEmp) {			
			System.out.println(emp);			
		}
	}

}
