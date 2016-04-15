package com.nooreiman.dao;

import java.util.List;

import com.nooreiman.model.Ayat;

public interface DataDao {

	public boolean addEntity(Ayat Ayat) throws Exception;
	public Ayat getEntityById(long id) throws Exception;
	public List<Ayat> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public List<Ayat> getEntityListBySpecificSurah(long id) throws Exception;
}
