package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer",Customer.class);
		
		List<Customer> customerList = query.getResultList();
		
		return customerList;
	}

}
