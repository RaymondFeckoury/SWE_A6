package com.example.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MovieEntity;
import com.example.demo.model.booking;
import com.example.demo.model.showseats;
import com.example.demo.model.showtimes;
import com.example.demo.model.userRegistration;
import com.example.demo.repo.Movierepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.repo.bookingrepo;
import com.example.demo.repo.showseatsrepo;
import com.example.service.imple.Emailsenderservice;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/homepage")
public class Homepage {
	@Autowired
	Movierepo movierepo;
	@Autowired
	showseatsrepo seatsrepo;
	@Autowired
	UserRepo urepo;
	@Autowired
	bookingrepo brepo;
	 @Autowired
	  Emailsenderservice emailsenderservice;
	@GetMapping(path = "/currentlyrunning") 
	public List<List<String>> getCurrentlyRunning() {
		List<String> titles = new ArrayList<>();
		List<String> ratings = new ArrayList<>();
		List<String> trailers = new ArrayList<>();
		ResultSet resultSet = null;
	 	try {
	 		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinemabooking", "root", "");
	 		java.sql.Statement stmt = conn.createStatement();
	 		stmt = conn.createStatement();
	 		resultSet = stmt.executeQuery("SELECT title,rating,trailer FROM movies WHERE currentrunning = 1");
	 		while(resultSet.next()) {
	 			titles.add(resultSet.getString("title"));
	 			titles.add(resultSet.getString("rating"));
	 			titles.add(resultSet.getString("trailer"));
	 		}
	 		List<List<String>> allData = new ArrayList<>();
	 		allData.add(titles);
	 		allData.add(ratings);
	 		allData.add(trailers);
	 		return allData;
	 	} catch (SQLException e1) {
	 		e1.printStackTrace();
	 	}
	 	return  null;
	}
	
	// Returns the title, rating, and trailer of each upcoming movie
	@GetMapping(path = "/upcomingmovies") 
	public List<List<String>> getUpcomingMovies() {
		List<String> titles = new ArrayList<>();
		List<String> ratings = new ArrayList<>();
		List<String> trailers = new ArrayList<>();
		ResultSet resultSet = null;
		try {
		 	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinemabooking", "root", "");
		 	java.sql.Statement stmt = conn.createStatement();
		 	stmt = conn.createStatement();
		 	resultSet = stmt.executeQuery("SELECT title,rating,trailer FROM movies WHERE currentrunning = 0");
		 	while(resultSet.next()) {
		 		titles.add(resultSet.getString("title"));
		 		titles.add(resultSet.getString("rating"));
		 		titles.add(resultSet.getString("trailer"));
		 	}
		 	List<List<String>> allData = new ArrayList<>();
		 	allData.add(titles);
		 	allData.add(ratings);
		 	allData.add(trailers);
		 	return allData;
		 } catch (SQLException e1) {
		 	e1.printStackTrace();
		 }
		 return  null;
	}
	@PostMapping("/getscheduleinfo")
	  public List<List<String>> getinfo(@RequestBody showtimes showtime)throws SQLException {
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cinemabooking", "root", "");
		 java.sql.Statement stmt = conn.createStatement();
		 String moviename=showtime.getMoviename();
		 System.out.println(showtime.getDate());
		 ResultSet resultSet = stmt.executeQuery("SELECT showroomid,time FROM showtimes WHERE date = "+ "'" + showtime.getDate() + "'"+"AND moviename = "+"'"+showtime.getMoviename()+"'");
		 List<String> data = new ArrayList<>();
		 List<String> data1 = new ArrayList<>();
		 String title="";
		 while(resultSet.next()) {
     	  data.add(resultSet.getString("time"));
     	  data1.add(resultSet.getString("showroomid"));
     	  
}
		 List<List<String>> allData = new ArrayList<>();
		 allData.add(data);
		 allData.add(data1);
		 return allData;
	  }
	@GetMapping("/getallmovie")
	public List<MovieEntity> getallmovie(){
		return movierepo.findAll();
	}
	@PostMapping("/selectseats")
	public List<showseats> seatselect(@RequestBody showseats seats) {
		System.out.println("Screennumber : "+seats.getScreennumber());
		return seatsrepo.findByscreennumber(seats.getScreennumber());
	}
	@PostMapping("/updateseat")
	public boolean updateseat(@RequestBody showseats seats)throws SQLException {
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cinemabooking", "root", "");
		PreparedStatement ps=conn.prepareStatement("UPDATE showseats SET seatoccupancy = ? WHERE screennumber=?");
		ps.setInt(1,seats.getSeatoccupancy());
		ps.setInt(2, seats.getScreennumber());
		ps.executeUpdate();
		ps.close();
		return true;
	}
	@PostMapping("/confirmbooking")
	public boolean bookingseats(@RequestBody booking booking)throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinemabooking", "root", "");
		java.sql.Statement stmt = conn.createStatement();
		int userid=0;
		ResultSet resultSet = stmt.executeQuery("SELECT id FROM users WHERE email = "+ "'" + booking.getEmail() + "'");
		while(resultSet.next()) {
		        	  userid = resultSet.getInt("id");
		}
		booking.setUserid(userid);
		int movieid=0;
		ResultSet resultSet2 = stmt.executeQuery("SELECT id FROM movies WHERE title = "+ "'" + booking.getTitle() + "'");
		while(resultSet2.next()) {
		        	  movieid = resultSet2.getInt("id");
		}
		//System.out.println(urepo.findidByemail(booking.getEmail()));
		booking.setMid(movieid);
		int cardid=0;
		ResultSet resultSet3 = stmt.executeQuery("SELECT cardid FROM paymentcard WHERE cardnumber = "+ "'" + booking.getCardnumber() + "'");
		while(resultSet3.next()) {
		        	  cardid = resultSet3.getInt("cardid");
		}
		booking.setCardid(cardid);
		brepo.save(booking);
		return true;
	}
	
	
@PostMapping("/emailtester")
public boolean sendmail(@RequestBody userRegistration user)throws MessagingException {
	try {
	emailsenderservice.sendemailwithattachment(user.getEmail(),"mail","Promotion Expired");
	}catch(AddressException ex) {
		return false;
	}
	return true;
}
	
}
