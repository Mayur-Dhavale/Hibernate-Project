package com.jbk.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.jbk.entity.Employee;

public class EmployeeInfo {
	
	public static Employee getEmployee(boolean b) {
		Scanner scanner=new Scanner(System.in);
		long id;
		if(b==true) {
			System.out.println("Enter ID");
			 id=scanner.nextLong();
			}
		else {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		 id=Long.parseLong(timestamp);
		}
		System.out.println("Enter Name");
		String name=scanner.next();
		System.out.println("Enter Dept");
		String dept=scanner.next();
		System.out.println("Enter Salary");
		double salary=scanner.nextDouble();
		
		Employee employee=new Employee(id, name, dept, salary);
		
		return employee;
		
	}

}
