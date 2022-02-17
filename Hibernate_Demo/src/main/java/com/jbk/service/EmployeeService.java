package com.jbk.service;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.jbk.config.HibernateConfiguration;
import com.jbk.entity.Employee;

public class EmployeeService {
	
	public Serializable saveEmployee(Employee employee) {

		SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
        Session session= sessionFactory.openSession();
       Transaction transaction= session.beginTransaction();
        Serializable id =  session.save(employee);
		transaction.commit();
		session.close();
        return id;
		
	}
	public String deleteEmployee(long id) {
		SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
         Employee emp=new Employee();
        emp.setId(id);
        session.delete(emp);
        transaction.commit();
		return "deleted";
		
	}
	public String updateEmployee(Employee employee) {
		SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        
        session.update(employee);
        transaction.commit();
		return "updated";
		
	}
	public List<Employee> listOfEmployee() {
		SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
        Session session= sessionFactory.openSession();
         Criteria criteria=session.createCriteria(Employee.class);
         List<Employee>list=criteria.list();
		return list;
		
	}
	public List<Employee> orderBy() {
		SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
        Session session= sessionFactory.openSession();
         Criteria criteria=session.createCriteria(Employee.class);
         criteria.setFirstResult(0);
         criteria.setMaxResults(3);
         //criteria.addOrder(Order.desc("name"));
         List<Employee>list=criteria.list();
		return list;
		
	}
	public List<Employee> restrictionEx(){
		SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
        Session session= sessionFactory.openSession();
         Criteria criteria=session.createCriteria(Employee.class);
        // Criterion crt=Restrictions.eq("name", "sagar");// GIVES MENTIONED DATA
        // Criterion crt=Restrictions.between("salary", 21000d, 23000d);//GIVES IN BETWEEN VALUE IN RANGE
          //Criterion crt=Restrictions.like("name", "_i%");//GIVES LAST VALUE
         //Criterion crt=Restrictions.in("salary", 21000d,22000d,30000d);
          Criterion criterion1=Restrictions.eq("dept", "it");
          Criterion criterion2=Restrictions.eq("name", "vivek");
          Criterion crt= Restrictions.and(criterion1,criterion2);// USE AND LOGIC GATE GIVES OUTPUT

         criteria.add(crt);
         
         
          List<Employee> list=criteria.list();
		   return list;
		
		
	}
	public List projectionEx(){
		SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
        Session session= sessionFactory.openSession();
         Criteria criteria=session.createCriteria(Employee.class);
        
         //criteria.setProjection(Projections.count("id"));//COUNT NUMBRER
         criteria.setProjection(Projections.max("salary"));// GIVES MAX VALUE
         
          List list=criteria.list();
		   return list;
		
		
	}
	public List queryEx(){
		SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
        Session session= sessionFactory.openSession();
    Query qry=   session.createQuery("from Employee where id=:empid") ;
    qry.setLong("empid", 20211008154806l);
      
         
          List list=qry.list();
		   return list;
		
		
	}
	
	
	

}
