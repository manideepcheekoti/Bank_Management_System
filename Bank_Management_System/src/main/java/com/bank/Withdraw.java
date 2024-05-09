package com.bank;

import org.hibernate.Session;


public class Withdraw {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		int id; 
		double withdraw;
		session.beginTransaction();
		id = KeyboardUtil.getInt("Enter your Id");
		customer c1 = (customer) session.get(customer.class, id);
		if(c1 == null) {
			System.out.println("No data found for Id : " + id);
		}else {
			withdraw = KeyboardUtil.getDouble("Enter the amount you want to withdraw : ");
			if(withdraw > c1.getBalance()) {
				System.out.println("Insufficient Balance");
			}
			c1.setBalance(c1.getBalance() - withdraw);
			session.getTransaction().commit();
			System.out.println("Withdraw successful");
			System.out.println("Your current balance is : " + c1.getBalance());
		}
	}
}
