package com.nooreiman.services;

import java.util.List;

import com.nooreiman.model.Ayat;

public interface DataServices {
	public boolean addEntity(Ayat Ayat) throws Exception;
	public Ayat getEntityById(long id) throws Exception;
	public List<Ayat> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
