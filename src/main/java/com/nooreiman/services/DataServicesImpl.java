package com.nooreiman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nooreiman.dao.DataDao;
import com.nooreiman.model.Ayat;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(Ayat Ayat) throws Exception {
		return dataDao.addEntity(Ayat);
	}

	@Override
	public Ayat getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Ayat> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
