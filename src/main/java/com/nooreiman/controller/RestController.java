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

	

	@RequestMapping(value = "/surah/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Ayat getSpecificAyatsfromSurah(@PathVariable("id") long id) {
		Ayat ayat = null;
		try {
			ayat = dataServices.getAyatById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ayat;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Ayat getAyat(@PathVariable("id") long id) {
		Ayat ayat = null;
		try {
			ayat = dataServices.getAyatById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ayat;
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

		List<Ayat> ayatList = null;
		try {
			ayatList = dataServices.getAyatList();

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
