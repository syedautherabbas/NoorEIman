package com.nooreiman.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.nooreiman.model.Ayat;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Ayat ayat) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(ayat);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Ayat getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Ayat ayat = (Ayat) session.load(Ayat.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return ayat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ayat> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Ayat> employeeList = session.createCriteria(Ayat.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Ayat.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
