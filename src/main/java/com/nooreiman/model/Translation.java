package com.nooreiman.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "translation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Translation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "chapter")
	private long  chapter;

	@Column(name = "verse")
	private long verse;

	@Column(name = "translation")
	private String translation;

	

	public long getId() {
		return id;
	}
	@ManyToOne(cascade = CascadeType.ALL ,targetEntity= Surah.class)
	public long getChapter() {
		return chapter;
	}

	public void setChapter(long chapter) {
		this.chapter = chapter;
	}

	
	
	
	
	public long getVerse() {
		return verse;
	}

	public void setVerse(long verse) {
		this.verse = verse;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(long id) {
		this.id = id;
	}

}
