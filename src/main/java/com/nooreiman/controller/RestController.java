package com.nooreiman.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nooreiman.model.Ayat;
import com.nooreiman.model.Status;
import com.nooreiman.model.Surah;
import com.nooreiman.model.Translation;
import com.nooreiman.services.DataServices;

@Controller
@RequestMapping("/Quran")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	
	@RequestMapping(value = "surah/{id}/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Ayat> getAllAyatsFromSurah(@PathVariable("id") long id) {

		List<Ayat> ayatList = null;
		try {
			System.out.println("SURAH FOR WHICH ALL AYATS ARE BEING REQUESTED "+id);
			ayatList = dataServices.getAyatListBySpecificSurah(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ayatList;
	}

	
	@RequestMapping(value = "surah/{id}/list/translation", method = RequestMethod.GET)
	public @ResponseBody
	List<Translation> getAllTranslationsFromSurah(@PathVariable("id") long id) {

		List<Translation> translationList = null;
		try {
			System.out.println("SURAH FOR WHICH ALL AYATS ARE BEING REQUESTED "+id);
			translationList = dataServices.getTranslationListBySpecificSurah(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return translationList;
	}
	
	
	@RequestMapping(value = "/listofalltranslations", method = RequestMethod.GET)
	public @ResponseBody
	List<Translation> getAllTranslations() {
System.out.println("LIST OF ALL getAllTranslations");
		List<Translation> translationList = null;
		try {
			translationList= dataServices.getTranslationList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return translationList;
	}


	

	
	@RequestMapping(value = "/surah/{surahid}/ayat/{ayatid}/translation", method = RequestMethod.GET)
	public @ResponseBody
	Translation getSpecificTranslationfromSurah(@PathVariable("surahid") long surahid,@PathVariable("ayatid") long ayatid) {
		Translation translation = null;
		try {
			translation = dataServices.getSpecificTranslationfromSurah(surahid, ayatid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return translation ;
	}
	
	
	@RequestMapping(value = "/surah/{surahid}/ayat/{ayatid}", method = RequestMethod.GET)
	public @ResponseBody
	Ayat getSpecificAyatsfromSurah(@PathVariable("surahid") long surahid,@PathVariable("ayatid") long ayatid) {
		Ayat ayat = null;
		try {
			ayat = dataServices.getSpecificAyatsfromSurah(surahid, ayatid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ayat;
	}
	
	@RequestMapping(value = "/ayat/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Ayat getAyatByID(@PathVariable("id") long id) {
		Ayat ayat = null;
		try {
			ayat = dataServices.getAyatById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ayat;
	}

	
	@RequestMapping(value = "surah/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Surah getSurahByID(@PathVariable("id") long id) {
		Surah surah = null;
		try {
			surah = dataServices.getSurahById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return surah;
	}
	
	@RequestMapping(value = "/listofallsurahs", method = RequestMethod.GET)
	public @ResponseBody
	List<Surah> getallSurahs() {
System.out.println("LIST OF ALL SURAHS REQUESTED");
		List<Surah> surahList = null;
		try {
			surahList = dataServices.getSurahList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return surahList;
	}

	@RequestMapping(value = "/listofallayats", method = RequestMethod.GET)
	public @ResponseBody
	List<Ayat> getAyats() {
System.out.println("LIST OF ALL AYATS");
		List<Ayat> ayatList = null;
		try {
			ayatList = dataServices.getAllAyatList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ayatList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteAyat(@PathVariable("id") long id) {

		try {
			dataServices.deleteAyat(id);
			return new Status(1, "Ayat deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addAyat(@RequestBody Ayat ayat) {
		try {
			dataServices.addAyat(ayat);
			return new Status(1, "Ayat added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

}
