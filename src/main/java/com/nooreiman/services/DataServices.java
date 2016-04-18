package com.nooreiman.services;

import java.util.List;

import com.nooreiman.model.Ayat;
import com.nooreiman.model.Surah;

public interface DataServices {
	public boolean addAyat(Ayat ayat) throws Exception;
	public Ayat getAyatById(long ayatid) throws Exception;
	public List<Ayat> getAllAyatList() throws Exception;
	public List<Ayat> getAyatListBySpecificSurah(long surahid) throws Exception;
	public boolean deleteAyat(long id) throws Exception;
	public List<Surah> getSurahList() throws Exception;
	public Ayat getSpecificAyatsfromSurah(long surahid,long ayatid ) throws Exception;
	
}
