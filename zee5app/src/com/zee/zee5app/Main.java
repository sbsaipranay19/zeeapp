package com.zee.zee5app;

import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.service.*;
import com.zee.zee5app.service.impl.SubscriptionServiceImpl;
import com.zee.zee5app.service.impl.*;
import com.zee.zee5app.dto.*;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;

public class Main {
	public static void main(String[] args) throws InvalidNameException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException {
		
		//Register
		
//		Register register = new Register();	
		Register register7 = new Register("sai0001","Sai","Pranay","sai123@gmail.com","sai123");
		System.out.println(register7);
//		register.setFirstName("Sai");
//		register.setLastName("pranay");
//		register.setEmail("sai@gmail.com");		
//		System.out.println(register);
		
		Login login = new Login();
		login.setUserName("sb19");
		login.setPassword("qwerty");	
		System.out.println(login);
		
		//Users
		
		UserService service = UserServiceImpl.getInstance();
		
		for(int i=1;i<=3;i++) {
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
		
		Optional<Register> register2 = service.getUserById("ab001");
		System.out.println(register2!=null);
		
		String register4 = service.deleteUserById("ab000002");
		System.out.println(register4);
		
		String register5 = service.updateUser("ab001","ab002");
		System.out.println(register5);
		
		for(Register register3 : service.getAllUsers()) {
			if(register3 !=null)
			System.out.println(register3);
		}
		
		//Subscriptions
		
		SubscriptionService subscripServ = SubscriptionServiceImpl.getInstance();
		
		for(int i=1;i<4;i++) {
			Subscription subs = new Subscription();
			subs.setId("sai00"+i);
			subs.setAutoRenewal(false);
			subs.setPaymentMode("Credit Card"+i);
			String result1  = subscripServ.addSubscription(subs);
			System.out.println(result1+" "+i);
		}
		
		Subscription subs = subscripServ.getSubscriptionById("sai001");
		System.out.println(subs!=null);
		
		String subs1 = subscripServ.deleteSubscription("sai002");
		System.out.println(subs1);
		
		String subs3 = subscripServ.updateSubscription("sai001","sai002");
		System.out.println(subs3);
		
		for(Subscription subs2 : subscripServ.getSubscription()) {
			if(subs2 !=null)
			System.out.println(subs2);
		}
		
		//Movies
		
		MovieService movieServ = MovieServiceImpl.getInstance();
		
		for(int i=1;i<4;i++) {
			Movie movie = new Movie();
			movie.setId("movie00"+i);
			movie.setMovieName("Movie"+i);
			String result1  = movieServ.addMovie(movie);
			System.out.println(result1+" "+i);
		}
		
		Movie movie = movieServ.getMovieById("movie001");
		System.out.println(movie!=null);
		
		String movie1 = movieServ.deleteMovie("movie002");
		System.out.println(movie1);
		
		String movie3 = movieServ.updateMovie("movie001","movie002");
		System.out.println(movie3);
		
		for(Movie movie2 : movieServ.getMovies()) {
			if(movie2 !=null)
			System.out.println(movie2);
		}
		
		//Series
		
		SeriesService seriesServ = SeriesServiceImpl.getInstance();
		
		for(int i=1;i<4;i++) {
			Series series = new Series();
			series.setId("series00"+i);
			series.setSeriesName("Series"+i);
			String result1  = seriesServ.addSeries(series);
			System.out.println(result1+" "+i);
		}
		
		Series series = seriesServ.getSeriesById("series001");
		System.out.println(series!=null);
		
		String series1 = seriesServ.deleteSeries("series002");
		System.out.println(series1);
		
		String series3 = seriesServ.updateSeries("series001","series002");
		System.out.println(series3);
		
		for(Series series2 : seriesServ.getSeries()) {
			if(series2 !=null)
			System.out.println(series2);
		}
		
	}
}
