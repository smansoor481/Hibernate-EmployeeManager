package com.hibernate.ems.EmployeeManagement;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
    	System.out.println("Employee Management System");
    	while(true)
    	{
    		System.out.println("Press-1 ---> Read Employee");
    		System.out.println("Press-2 ---> Add Employee");
    		System.out.println("Press-3 ---> Remove Employee");
    		System.out.println("Press-4 ---> Update Employee Details");
    		System.out.println("Press-5 ---> Exit the System..");
    		int choice = sc.nextInt();
    		switch(choice) {
            case 1:
                readEmployee(); 
                break;
            case 2:
                addEmployee();  
                break;
            case 3:
                removeEmployee();  
                break;
            case 4:
                updateEmployeeDetails();  
                break;
            case 5:
                System.out.println("Exiting the system...");
                return;
            default:
            	System.out.println("Invalid input...");
                return;
    		}
    	}
    	 
    }
    
	private static void readEmployee() {
		// TODO Auto-generated method stub
		 
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory =  configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Enter the read Id");
		
		Employee obj = session.get(Employee.class, sc.nextInt());
		
		if(obj != null)
		{
			System.out.println("Id: "+obj.getId());
			System.out.println("Name: "+obj.getName());
			System.out.println("Salary: "+obj.getSalary());
			System.out.println("Phone: "+obj.getPhone());
			System.out.println("Email: "+obj.getEmail());
			System.out.println("Type: "+obj.getType());
		}
		else
		{
			System.out.println("Emp id is not present");
		}
		
		transaction.commit();
		session.close();
		factory.close();		
		
	}
	
	private static void addEmployee() {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory =  configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee emp = new Employee();
		System.out.println("Enter the Employee ID");
		emp.setId(sc.nextInt());
		System.out.println("Enter the Employee Name");
		emp.setName(sc.next());
		System.out.println("Enter the Employee Salary");
		emp.setSalary(sc.nextInt());
		System.out.println("Enter the Employee phone");
		emp.setPhone(sc.nextInt());
		System.out.println("Enter the Employee Email");
		emp.setEmail(sc.next());
		System.out.println("Enter the Employee Type");
		emp.setType(sc.next());
		
		
		System.out.println("Id: "+emp.getId());
		System.out.println("Name: "+emp.getName());
		System.out.println("Salary: "+emp.getSalary());
		System.out.println("Phone: "+emp.getPhone());
		System.out.println("Email: "+emp.getEmail());
		System.out.println("Type: "+emp.getType());
		
		session.persist(emp);
		transaction.commit();
		session.close();
		factory.close();
		
		
	}
    
	private static void removeEmployee() {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory =  configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Enter the Emp Id want to remove from the data");
		
		Employee obj = session.get(Employee.class, sc.nextInt());
		
		if(obj != null)
		{
			session.remove(obj);
		}
		else
		{
			System.out.println("Emp id is not present");
		}
		
		transaction.commit();
		session.close();
		factory.close();
		
		
	}
    
	private static void updateEmployeeDetails() {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory =  configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Enter the update Id");
		
		Employee obj = session.get(Employee.class, sc.nextInt());
		
		if(obj != null)
		{
			System.out.println("What do you want to update?");
			System.out.println("1. Name");
			System.out.println("2. Salary");
			System.out.println("3. Phone");
			System.out.println("4. Email");
			System.out.println("5. Type");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the updated name");
				obj.setName(sc.next());
				session.update(obj);
				System.out.println("Name is updated successfully..!");
				break;
			case 2:
				System.out.println("Enter the updated Salary");
				obj.setSalary(sc.nextInt());
				session.update(obj);
				System.out.println("Salary is updated successfully..!");
				break;
			case 3:
				System.out.println("Enter the updated Phone");
				obj.setPhone(sc.nextInt());
				session.update(obj);
				System.out.println("Phone is updated successfully..!");
				break;
			case 4:
				System.out.println("Enter the updated Email");
				obj.setEmail(sc.next());
				session.update(obj);
				System.out.println("Email is updated successfully..!");
				break;
			case 5: 
				System.out.println("Enter the updated type");
				obj.setType(sc.next());
				session.update(obj);
				System.out.println("Type is updated successfully..!");
			default:
				break;
			}
		}
		transaction.commit();
		session.close();
		factory.close();
		
		
	}
    
   
     
}
