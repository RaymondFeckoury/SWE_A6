package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.net.URL;
import java.io.File;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name="movies")
public class Movie {
	
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String cast;
	private String director;
	private String producer;
	private String synopsis;
	private URL trailer;
	private File thumbnail;
	private Date startdate;
	private Date enddate;
	private String category;
	private String rating;
	
	public Movie(int id, String title, String cast, String director, String producer, String synopsis, URL trailer,
			File thumbnail, Date startdate, Date enddate, String category, String rating) {
		super();
		this.id = id;
		this.title = title;
		this.cast = cast;
		this.director = director;
		this.producer = producer;
		this.synopsis = synopsis;
		this.trailer = trailer;
		this.thumbnail = thumbnail;
		this.startdate = startdate;
		this.enddate = enddate;
		this.category = category;
		this.rating = rating;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", cast=" + cast + ", director=" + director + ", producer="
				+ producer + ", synopsis=" + synopsis + ", trailer=" + trailer + ", thumbnail=" + thumbnail
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", category=" + category + ", rating=" + rating
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public URL getTrailer() {
		return trailer;
	}

	public void setTrailer(URL trailer) {
		this.trailer = trailer;
	}

	public File getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(File thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
}
