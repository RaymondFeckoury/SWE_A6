package com.example.demo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.example.demo.model.Movie;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name="upcomingshows")
public class UpcomingShow {
	
	@Id
	@GeneratedValue
	private int id;
	
	// Foreign keys, both one to one
	private int roomid;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
	private Movie movie;
	
	private int numseatsavailable;
	private Date dateandtime;
	
	
	
	public UpcomingShow(int id, int roomid, Movie movie, int numseatsavailable, Date dateandtime) {
		super();
		this.id = id;
		this.roomid = roomid;
		this.movie = movie;
		this.numseatsavailable = numseatsavailable;
		this.dateandtime = dateandtime;
	}

	public UpcomingShow() {
		super();
	}
	
	@Override
	public String toString() {
		return "UpcomingShow [id=" + id + ", roomid=" + roomid + ", movie=" + movie + ", numseatsavailable="
				+ numseatsavailable + ", dateandtime=" + dateandtime + "]";
	}
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	
	public int getNumseatsavailable() {
		return numseatsavailable;
	}
	public void setNumseatsavailable(int numseatsavailable) {
		this.numseatsavailable = numseatsavailable;
	}
	public Date getDateandtime() {
		return dateandtime;
	}
	public void setDateandtime(Date dateandtime) {
		this.dateandtime = dateandtime;
	}
	
}
