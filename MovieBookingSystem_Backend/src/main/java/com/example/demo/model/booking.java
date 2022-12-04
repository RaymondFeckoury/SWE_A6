package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name="bookings")
public class booking {
	@Id
	@GeneratedValue
	private int bid;
	private String title;
	private String email;
	private String date;
	private String time;
	private int screennumber;
	private int numberoftcikets;
	private int adultseats;
	private int childseats;
	private int seniorseats;
	private int cardnumber;
	private double totalamount;
	private String seatnumbers;	
	
	public booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public booking(int bid, String title, String email, String date, String time, int screennumber, int numberoftcikets,
			int adultseats, int childseats, int seniorseats, int cardnumber, double totalamount, String seatnumbers) {
		super();
		this.bid = bid;
		this.title = title;
		this.email = email;
		this.date = date;
		this.time = time;
		this.screennumber = screennumber;
		this.numberoftcikets = numberoftcikets;
		this.adultseats = adultseats;
		this.childseats = childseats;
		this.seniorseats = seniorseats;
		this.cardnumber = cardnumber;
		this.totalamount = totalamount;
		this.seatnumbers = seatnumbers;
	}

	@Override
	public String toString() {
		return "booking [bid=" + bid + ", title=" + title + ", email=" + email + ", date=" + date + ", time=" + time
				+ ", screennumber=" + screennumber + ", numberoftcikets=" + numberoftcikets + ", adultseats="
				+ adultseats + ", childseats=" + childseats + ", seniorseats=" + seniorseats + ", cardnumber="
				+ cardnumber + ", totalamount=" + totalamount + ", seatnumbers=" + seatnumbers + "]";
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int getScreennumber() {
		return screennumber;
	}


	public void setScreennumber(int screennumber) {
		this.screennumber = screennumber;
	}


	public int getNumberoftcikets() {
		return numberoftcikets;
	}


	public void setNumberoftcikets(int numberoftcikets) {
		this.numberoftcikets = numberoftcikets;
	}


	public int getAdultseats() {
		return adultseats;
	}


	public void setAdultseats(int adultseats) {
		this.adultseats = adultseats;
	}


	public int getChildseats() {
		return childseats;
	}


	public void setChildseats(int childseats) {
		this.childseats = childseats;
	}


	public int getSeniorseats() {
		return seniorseats;
	}


	public void setSeniorseats(int seniorseats) {
		this.seniorseats = seniorseats;
	}



	public int getCardnumber() {
		return cardnumber;
	}


	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}


	public double getTotalamount() {
		return totalamount;
	}


	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}


	public String getSeatnumbers() {
		return seatnumbers;
	}


	public void setSeatnumbers(String seatnumbers) {
		this.seatnumbers = seatnumbers;
	}
	
	
}
	
	