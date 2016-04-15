package com.nooreiman.services;

import java.util.List;

import com.nooreiman.model.Ayat;
import com.nooreiman.model.Surah;

public interface DataServices {
	public boolean addAyat(Ayat Ayat) throws Exception;
	public Ayat getAyatById(long id) throws Exception;
	public List<Ayat> getAyatList() throws Exception;
	public List<Ayat> getAyatListBySpecificSurah(long id) throws Exception;
	public boolean deleteAyat(long id) throws Exception;
	public List<Surah> getSurahList() throws Exception;
	
	
}
