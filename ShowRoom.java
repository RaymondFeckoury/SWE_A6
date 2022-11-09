package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name="showroom")
public class ShowRoom {
	
	@Id
	private int id;
	private int numberofseats;
	
	
	
	public ShowRoom(int id, int numberofseats) {
		super();
		this.id = id;
		this.numberofseats = numberofseats;
	}

	public ShowRoom() {
		super();
	}
	
	@Override
	public String toString() {
		return "ShowRoom [id=" + id + ", numberOfSeats=" + numberofseats + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getNumberofseats() {
		return numberofseats;
	}

	public void setNumberofseats(int numberofseats) {
		this.numberofseats = numberofseats;
	}
	
	
}
