package com.nooreiman.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name ="surahs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Surah {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	@Column(name = "surahnumber")
	private long surahnumber;
	@Column(name = "surahname")
	private String surahname;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSurahnumber() {
		return surahnumber;
	}
	public void setSurahnumber(long surahnumber) {
		this.surahnumber = surahnumber;
	}
	public String getSurahname() {
		return surahname;
	}
	public void setSurahname(String surahname) {
		this.surahname = surahname;
	}
	
	
	
	
	
}
