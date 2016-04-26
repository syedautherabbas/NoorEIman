package com.nooreiman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nooreiman.dao.DataDao;
import com.nooreiman.model.Ayat;
import com.nooreiman.model.Surah;
import com.nooreiman.model.Translation;

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
	public List<Ayat> getAllAyatList() throws Exception {
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
public Surah getSurahById(long id) throws Exception {
	// TODO Auto-generated method stub
	return dataDao.getSurahById(id);
}


@Override
public List<Surah> getSurahList() throws Exception {

	return dataDao.getSurahList();
}

@Override
public Ayat getSpecificAyatsfromSurah(long surahid, long ayatid) throws Exception {
	return dataDao.getSpecificAyatsfromSurah(surahid, ayatid);
	
}

@Override
public List<Translation> getTranslationList() throws Exception {
	// TODO Auto-generated method stub
	return dataDao.getTranslationList();
}


@Override
public Translation getTranslationById(long id) throws Exception {
	// TODO Auto-generated method stub
	return dataDao.getTranslationById(id);
}


@Override
public List<Translation> getTranslationListBySpecificSurah(long id) throws Exception {
	// TODO Auto-generated method stub
	return dataDao.getTranslationListBySpecificSurah(id);
}

@Override
public Translation getSpecificTranslationfromSurah(long surahid, long ayatid) throws Exception {
	// TODO Auto-generated method stub
	return dataDao.getSpecificTranslationfromSurah(surahid, ayatid);
}


}
