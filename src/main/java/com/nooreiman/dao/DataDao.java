package com.nooreiman.dao;

import java.util.List;

import com.nooreiman.model.Ayat;
import com.nooreiman.model.Surah;

public interface DataDao {

	public boolean addAyat(Ayat Ayat) throws Exception;
	public Ayat getAyatById(long id) throws Exception;
	public List<Ayat> getAyatList() throws Exception;
	public boolean deleteAyat(long id) throws Exception;
	public List<Ayat> getAyatListBySpecificSurah(long id) throws Exception;
	public List<Surah> getSurahList() throws Exception;
}
