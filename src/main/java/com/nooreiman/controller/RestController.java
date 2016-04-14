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
import com.nooreiman.services.DataServices;

@Controller
@RequestMapping("/ayats")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addAyat(@RequestBody Ayat ayat) {
		try {
			dataServices.addEntity(ayat);
			return new Status(1, "Ayat added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Ayat getAyat(@PathVariable("id") long id) {
		Ayat ayat = null;
		try {
			ayat = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ayat;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Ayat> getAyats() {

		List<Ayat> ayatList = null;
		try {
			ayatList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ayatList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteAyat(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Ayat deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
