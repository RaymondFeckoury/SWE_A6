package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name = "showseats")
public class showseats {
	@Override
	public String toString() {
		return "showseats [id=" + id + ", seatnumber=" + seatnumber + ", screennumber="
				+ screennumber + "]";
	}
	public showseats() {
		super();
		// TODO Auto-generated constructor stub
	}
	public showseats(int id, int seatnumber, int screennumber,int seatoccupancy) {
		super();
		this.id = id;
		this.seatnumber = seatnumber;
		this.screennumber = screennumber;
		this.seatoccupancy=seatoccupancy;
	}
	@Id
	@GeneratedValue
	private int id;
	private int seatnumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}
	public int getScreennumber() {
		return screennumber;
	}
	public void setScreennumber(int screennumber) {
		this.screennumber = screennumber;
	}
	public int getSeatoccupancy() {
		return seatoccupancy;
	}
	public void setSeatoccupancy(int seatoccupancy) {
		this.seatoccupancy = seatoccupancy;
	}
	private int screennumber;
	@Column(columnDefinition = "integer default 0")
	private int seatoccupancy;

}
