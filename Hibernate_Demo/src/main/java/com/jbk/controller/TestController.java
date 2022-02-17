package com.jbk.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import com.jbk.entity.Employee;
import com.jbk.service.EmployeeInfo;
import com.jbk.service.EmployeeService;

public class TestController {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		EmployeeService service=new EmployeeService();
		int choice;
		char ch;
      do {
    	  System.out.println("1.Save Employee");
    	  System.out.println("2.Delete Employee");
    	  System.out.println("3.update Employee");
    	  System.out.println("4.List Of Employee");
    	  System.out.println("5.Order By");
    	  System.out.println("6.Restriction");
    	  System.out.println("7.Projection");
    	  System.out.println("8.Query");
    	  System.out.println("Enter your choice");
		  choice=scanner.nextInt();
		  switch (choice) {
		case 1:{
	        Employee employee=EmployeeInfo.getEmployee(false);
		Serializable id= service.saveEmployee(employee);
		if(id!=null) {
			System.out.println("Saved Successfully with id="+id);
			
		}
		else {
			System.out.println("Somthing wrong");
		}
			break;
		}
		case 2:{
			System.out.println("Enter Id to deleted");
			long id=scanner.nextLong();
		String msg=	service.deleteEmployee(id);
		System.out.println(msg);
			break;
		}
		case 3:{
			Employee employee=EmployeeInfo.getEmployee(true);
			String msg=service.updateEmployee(employee);
			System.out.println(msg);
			
			
			
			break;
		}	
		case 4:{
			
			List<Employee> list=service.listOfEmployee();
			for (Employee employee : list) {
				System.out.println(employee);
			}
			
			
			
			break;
		}	
          case 5:{
			
			List<Employee> list=service.orderBy();
			for (Employee employee : list) {
				System.out.println(employee);
			}
			
			
			
			break;
		}	
          case 6:{
  			
  		List<Employee>list=	service.restrictionEx();
  		for (Employee employee : list) {
			System.out.println(employee);
		}
  		break;
          
          }
          case 7:{
    			
       List list=  service.projectionEx();
        double cnt=(Double) list.get(0);
       System.out.println(cnt);
        		
        		break;
                
                }
          case 8:{
  			
       List<Employee> list=service.queryEx();
        for (Employee emp : list) {
        	System.out.println(emp);
		
	     }
       
 		
               		break;
                       
                       }
        			
  			
  		  default:
			break;
		}
		  System.out.println("Do you want to continue y/n");
		  ch=scanner.next().charAt(0);
		  
	} while (ch!='Y' || ch!='y');
		
	}

}
