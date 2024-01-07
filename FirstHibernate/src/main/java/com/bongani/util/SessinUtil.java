package com.bongani.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessinUtil {
	
	private static SessionFactory session ;
	
	static {
		try {
			if(session==null)
				session = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return session;
			
		
	}

}
