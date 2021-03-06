package com.zee.zee5app;

import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.service.*;
import com.zee.zee5app.service.impl.SubscriptionServiceImpl;
import com.zee.zee5app.service.impl.*;
import com.zee.zee5app.dto.*;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.MovieNotFoundException;

public class Main {
	public static void main(String[] args){
		
		//Register
		Register register7;
		try {
			register7 = new Register("ab000002","Sai","Pranay","sai123@gmail.com","sai123");
			System.out.println(register7);
		} catch (InvalidNameException | InvalidIdLengthException | InvalidEmailException
				| InvalidPasswordException e3) {
			e3.printStackTrace();
		}
		
		Login login = new Login();
		login.setUserName("sb19");
		login.setPassword("qwerty");	
		System.out.println(login);
		
		//Users
		
		UserService service = UserServiceImpl.getInstance();
		
		for(int i=1;i<=20;i++) {
			Register register2 = new Register();
			try {
				register2.setId("ab00000"+i);
				register2.setFirstName("abhi"+i);
				register2.setLastName("sai"+i);
				register2.setEmail("sai"+i+"@gmail.com");
				register2.setPassword("Sai000");
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidEmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result = service.addUser(register2);
			System.out.println(result+" "+i);
		}
		
		Optional<Register> register2;
		try {
			register2 = service.getUserById("ab000001");
			System.out.println(register2!=null);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		String register4;
		try {
			register4 = service.deleteUserById("ab000002");
			System.out.println(register4);
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		Optional<Register> register5;
		try {
			register5 = service.updateUser("ab000001","ab000002");
			System.out.println(register5);
		} catch (IdNotFoundException | InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		service.getAllUsers().forEach(e -> System.out.println(e));
		
		//Subscriptions
		
		SubscriptionService subscripServ = SubscriptionServiceImpl.getInstance();
		
		for(int i=1;i<4;i++) {
			try {
			Subscription subs = new Subscription();
			subs.setId("sai000"+i);
			subs.setAutoRenewal(false);
			subs.setPaymentMode("Credit Card"+i);
			String result1  = subscripServ.addSubscription(subs);
			System.out.println(result1+" "+i);
			}catch(InvalidIdLengthException e) {
				e.printStackTrace();
			}
			
		}
		
		Optional<Subscription> subs;
		try {
			subs = subscripServ.getSubscriptionById("sai0001");
			System.out.println(subs!=null);
			
			String subs1 = subscripServ.deleteSubscriptionById("sai0002");
			System.out.println(subs1);
			
			Optional<Subscription> subs3 = subscripServ.updateSubscription("sai0001","sai0002");
			System.out.println(subs3);
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		subscripServ.getAllSubscriptions().forEach(e -> System.out.println(e));	
		
		//Movies
		
		MovieService movieServ = MovieServiceImpl.getInstance();
		
		for(int i=1;i<4;i++) {
			try {
			Movie movie = new Movie();
			movie.setId("movie00"+i);
			movie.setMovieName("Movie"+i);
			String result1  = movieServ.addMovie(movie);
			System.out.println(result1+" "+i);
			}catch(InvalidIdLengthException e) {
				e.printStackTrace();
			}
		}
		
		Optional<Movie> movie;
		try {
			movie = movieServ.getMovieById("movie001");
			System.out.println(movie!=null);
			String movie1 = movieServ.deleteMovie("movie002");
			System.out.println(movie1);
			Optional<Movie> movie3 = movieServ.updateMovie("movie001","movie002");
			System.out.println(movie3);
			Optional<Movie> movie4 = movieServ.getMovie("Movie1");
			System.out.println(movie4);
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MovieNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		movieServ.getMovies().forEach(e -> System.out.println(e));
		
		//Series
		
		SeriesService seriesServ = SeriesServiceImpl.getInstance();
		
		for(int i=1;i<4;i++) {
			
			
			try {
				Series series = new Series();
				series.setId("series00"+i);
				series.setSeriesName("Series"+i);
				String result1  = seriesServ.addSeries(series);
				System.out.println(result1+" "+i);
			} catch (InvalidIdLengthException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		Optional<Series> series;
		try {
			series = seriesServ.getSeriesById("series001");
			System.out.println(series!=null);
			
			String series1 = seriesServ.deleteSeries("series002");
			System.out.println(series1);
			
			Optional<Series> series3 = seriesServ.updateSeries("series001","series002");
			System.out.println(series3);
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		for(Series series2 : seriesServ.getSeries()) {
			if(series2 !=null)
			System.out.println(series2);
		}
		
	}
}
