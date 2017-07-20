package com.qa.cdstore.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CD {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String artist;
	private String genre;

	public CD() {

	}

	public CD(String title, String artist, String genre) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String genre) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String published) {
		this.genre = genre;
	}

}
