package com.nooreiman.services;

import java.util.List;

import com.nooreiman.model.Ayat;
import com.nooreiman.model.Surah;
import com.nooreiman.model.Translation;

public interface DataServices {
	public boolean addAyat(Ayat ayat) throws Exception;
	public Ayat getAyatById(long ayatid) throws Exception;
	public List<Ayat> getAllAyatList() throws Exception;
	public List<Ayat> getAyatListBySpecificSurah(long surahid) throws Exception;
	public boolean deleteAyat(long id) throws Exception;
	
	
	
	public Surah getSurahById(long id) throws Exception;
	public List<Surah> getSurahList() throws Exception;
	public Ayat getSpecificAyatsfromSurah(long surahid,long ayatid ) throws Exception;
	public Translation getTranslationById(long id) throws Exception;
	public List<Translation> getTranslationList() throws Exception;
	public List<Translation> getTranslationListBySpecificSurah(long id) throws Exception;
	public Translation getSpecificTranslationfromSurah(long surahid,long ayatid ) throws Exception;
}
