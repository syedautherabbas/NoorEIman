package com.nooreiman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nooreiman.dao.DataDao;
import com.nooreiman.model.Ayat;
import com.nooreiman.model.Surah;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addAyat(Ayat Ayat) throws Exception {
		return dataDao.addAyat(Ayat);
	}

	@Override
	public Ayat getAyatById(long id) throws Exception {
		return dataDao.getAyatById(id);
	}

	@Override
	public List<Ayat> getAyatList() throws Exception {
		return dataDao.getAyatList();
	}

	@Override
	public boolean deleteAyat(long id) throws Exception {
		return dataDao.deleteAyat(id);
	}
	
@Override
	public List<Ayat> getAyatListBySpecificSurah(long id) throws Exception {
	
	
		return dataDao.getAyatListBySpecificSurah(id);
	}
	
@Override
public List<Surah> getSurahList() throws Exception {

	return dataDao.getSurahList();
}
}
