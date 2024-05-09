package com.bank;

import org.hibernate.Session;


public class Deposit {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSession();
		int id;
		double deposit;
		session.beginTransaction();
		id = KeyboardUtil.getInt("Enter your Id : ");
		customer c1 = (customer) session.get(customer.class, id);
		if(c1 == null) {
			System.out.println("No data found for the Id : " + id);
		}else {
			deposit = KeyboardUtil.getDouble("Enter the amount you want to deposit : ");
			c1.setBalance(c1.getBalance() + deposit);
			session.getTransaction().commit();
			System.out.println("Deposit successful");
			System.out.println("Your current balance is : " + c1.getBalance());
		}
		
		
		
	}
}
