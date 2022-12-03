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
	private int Bid;
	private int Mid;
	private int screennumber;
	private String TicketCategory;
	@Override
	public String toString() {
		return "booking [Bid=" + Bid + ", Mid=" + Mid + ", screennumber=" + screennumber + ", TicketCategory="
				+ TicketCategory + ", ticketcost=" + ticketcost + ", taxes=" + taxes + ", totalamount=" + totalamount
				+ ", numberoftcikets=" + numberoftcikets + ", seatnumbers=" + seatnumbers + ", pcode=" + pcode
				+ ", cardid=" + cardid + "]";
	}
	public booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public booking(int bid, int mid, int screennumber, String ticketCategory, double ticketcost, int cardnumber,
			double taxes, double totalamount, int numberoftcikets, int seatnumbers, String pcode, int cardid,
			String email, int userid, String title) {
		super();
		Bid = bid;
		Mid = mid;
		this.screennumber = screennumber;
		TicketCategory = ticketCategory;
		this.ticketcost = ticketcost;
		this.cardnumber = cardnumber;
		this.taxes = taxes;
		this.totalamount = totalamount;
		this.numberoftcikets = numberoftcikets;
		this.seatnumbers = seatnumbers;
		this.pcode = pcode;
		this.cardid = cardid;
		this.email = email;
		this.userid = userid;
		this.title = title;
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
	
	
	public int getBid() {
		return Bid;
	}
	public void setBid(int bid) {
		Bid = bid;
	}
	public int getMid() {
		return Mid;
	}
	public void setMid(int mid) {
		Mid = mid;
	}
	public int getScreennumber() {
		return screennumber;
	}
	public void setScreennumber(int screennumber) {
		this.screennumber = screennumber;
	}
	public String getTicketCategory() {
		return TicketCategory;
	}
	public void setTicketCategory(String ticketCategory) {
		TicketCategory = ticketCategory;
	}
	public double getTicketcost() {
		return ticketcost;
	}
	public void setTicketcost(double ticketcost) {
		this.ticketcost = ticketcost;
	}
	public double getTaxes() {
		return taxes;
	}
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public int getNumberoftcikets() {
		return numberoftcikets;
	}
	public void setNumberoftcikets(int numberoftcikets) {
		this.numberoftcikets = numberoftcikets;
	}
	public int getSeatnumbers() {
		return seatnumbers;
	}
	public void setSeatnumbers(int seatnumbers) {
		this.seatnumbers = seatnumbers;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	private double ticketcost;
	private int cardnumber;
	private double taxes;
	public int getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}
	private double totalamount;
	private int numberoftcikets;
	private int seatnumbers;
	private String pcode;
	private int cardid;
	private String email;
	private int userid;
	private String title;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
