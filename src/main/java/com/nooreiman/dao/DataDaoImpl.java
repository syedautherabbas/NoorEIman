package com.nooreiman.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.nooreiman.model.Ayat;
import com.nooreiman.model.Surah;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addAyat(Ayat ayat) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(ayat);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Ayat getAyatById(long id) throws Exception {
		session = sessionFactory.openSession();
		Ayat ayat = (Ayat) session.load(Ayat.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return ayat;
	}

	@Override
	public List<Ayat>  getAyatListBySpecificSurah(long id)
	{
		
		session = sessionFactory.openSession();
		
				
				Query query =session.createQuery("from Ayat a where a.chapter ="+id);
				List<Ayat> ayatList =query.list();
		return ayatList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ayat> getAyatList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Ayat> ayatList = session.createCriteria(Ayat.class)
				.list();
		tx.commit();
		session.close();
		return ayatList;
	}
	
	@Override
	public boolean deleteAyat(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Ayat.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
	
	
@Override
	public List<Surah> getSurahList() throws Exception {
	session = sessionFactory.openSession();
	tx = session.beginTransaction();
	List<Surah> surahList = session.createCriteria(Surah.class).list();
	tx.commit();
	session.close();
	
	return surahList;
	}

@Override
public Ayat getSpecificAyatsfromSurah(long surahid, long ayatid) throws Exception {
	session = sessionFactory.openSession();
	
	
	Query query =session.createQuery("from Ayat a where a.chapter =:surahid and a.verse=:ayatid");
	query.setLong("surahid", surahid);
	query.setLong("ayatid", ayatid);
	Ayat ayat =(Ayat) query.uniqueResult();
return ayat;

}
	

}
