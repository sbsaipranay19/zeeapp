package com.zee.zee5app;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		UserService service;
//		try {
//			service = UserServiceImpl.getInstance();
//			Optional<List<Register>>  optional = service.getAllUserDetails();
//			String result = service.deleteUserById("sai0002");
//			System.out.println(result);
//			
//			if(optional.isEmpty()) {
//				System.out.println("No Records Found");
//			}else {
//				optional.get().forEach(e -> System.out.println(e));;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			Register register = new Register("sai0006", "Sai Pranay", "SB", "sai369@gmail.com", "123456");
//			
//			register.setContactNumber(new BigDecimal("9876543210"));
//			
//			UserService service = UserServiceImpl.getInstance();
//			
//			String result = service.addUser(register);
//			System.out.println(result);
//			
//		} catch (InvalidIdLengthException | InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	

//		try {
//			LoginService service = LoginServiceImpl.getInstance();
//			service.changeRole("sai369@gmail.com", ROLE.ROLE_ADMIN);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			Optional<Register> register = service.getUserById("sai0001");
//			System.out.println(register.get());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			Subscription subscription = new Subscription("subs007", "2022-01-26", "2023-01-26", 1000,"Credit","active","annual","no", "sai0001");
//			SubscriptionService service = SubscriptionServiceImpl.getInstance();
//			Optional<Subscription> subscription = service.getSubscriptionById("sai0001");
//			System.out.println(subscription.get());		
//			String result = service.addSubscription(subscription);
//			System.out.println(result);
//			Optional<Subscription> result = service.updateSubscription("sai0001",subscription);
//			System.out.println(result.get());
//			SubscriptionService service = SubscriptionServiceImpl.getInstance();
//			String subscription = service.deleteSubscriptionById("sai0001");
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//			try {
//				SeriesService service = SeriesServiceImpl.getInstance();
//				(seriesId,seriesName,ageLimit,cast,genre,length,releaseDate,language,no_of_episodes)
//				Series series = new Series("series05","loser",18,"Priyadarshi","Sports",39.57,"https://www.youtube.com/watch?v=W_ZxZ0X8GDw","2022-01-27","telugu",6);
//				 service.addSeries(series);
//				 Series series1 = new Series("series06","loser",18,"Priyadarshi","Sports",39.57,"https://www.youtube.com/watch?v=W_ZxZ0X8GDw","2022-01-27","telugu",6);
//				 service.addSeries(series1);
//				 Series series2 = new Series("series01","loser",18,"Priyadarshi","Sports",39.57,"https://www.youtube.com/watch?v=W_ZxZ0X8GDw","2022-01-27","telugu",6);
//				 Optional<Series> result = service.updateSeries("series07",series2);
//				 Series series3 = new Series("series08","loser",18,"Priyadarshi","Sports",39.57,"https://www.youtube.com/watch?v=W_ZxZ0X8GDw","2022-01-27","telugu",6);
//				 service.deleteSeries("series04");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidIdLengthException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IdNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (LocationNotFOundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		try {
//			MovieService service = MovieServiceImpl.getInstance();
//			(seriesId,seriesName,ageLimit,cast,genre,length,releaseDate,language,no_of_episodes)
//			Movie movie = new Movie("movie01","loser",18,"Priyadarshi","Sports",39.57,"https://www.youtube.com/watch?v=W_ZxZ0X8GDw","2022-01-27","telugu");
//			 service.addMovie(movie);
//			 Movie movie1 = new Movie("movie06","loser",18,"Priyadarshi","Sports",39.57,"https://www.youtube.com/watch?v=W_ZxZ0X8GDw","2022-01-27","telugu");
//			 service.addMovie(movie1);
//			Movie movie2 = new Movie("movie01", "loser", 18, "Priyadarshi", "Sports", 39.57,
//					"https://www.youtube.com/watch?v=W_ZxZ0X8GDw", "2022-01-27", "telugu");
//			Optional<Movie> result = service.updateMovie("movie07", movie2);
//			Movie movie3 = new Movie("movie08", "loser", 18, "Priyadarshi", "Sports", 39.57,
//					"https://www.youtube.com/watch?v=W_ZxZ0X8GDw", "2022-01-27", "telugu");
//			service.deleteMovie("movie04");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			EpisodeService service = EpisodeServiceImpl.getInstance();
////			(episodeId,seriesId,episodeName,episodeLength,location,trailer)
//			Episodes episode = new Episodes("episode1","series01","episoden1",39.57,"find the location","https://www.youtube.com/watch?v=W_ZxZ0X8GDw");
//			 service.addEpisode(episode);
//			 Episodes episode1 = new Episodes("episode2","series01","episoden1",39.57,"find the location","https://www.youtube.com/watch?v=W_ZxZ0X8GDw");
//			 service.addEpisode(episode1);
//			Episodes episode2 = new Episodes("episode3","series01","episoden1",39.57,"find the location","https://www.youtube.com/watch?v=W_ZxZ0X8GDw");
//			service.addEpisode(episode2);
//			Episodes episode3 = new Episodes("episode4","series01","episoden1",39.57,"find the location","https://www.youtube.com/watch?v=W_ZxZ0X8GDw");
//			service.addEpisode(episode3);
//			service.deleteEpisodeById("episode4");

//			Optional<Episodes> episode6 = service.getEpisodeById("episode3");
//			System.out.println(episode6.get());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
//package com.zee.zee5app;
//
//import java.util.Optional;
//
//import javax.naming.InvalidNameException;
//
//import com.zee.zee5app.service.*;
//import com.zee.zee5app.service.impl.SubscriptionServiceImpl;
//import com.zee.zee5app.service.impl.*;
//import com.zee.zee5app.dto.*;
//import com.zee.zee5app.exception.IdNotFoundException;
//import com.zee.zee5app.exception.InvalidEmailException;
//import com.zee.zee5app.exception.InvalidIdLengthException;
//import com.zee.zee5app.exception.InvalidPasswordException;
//import com.zee.zee5app.exception.MovieNotFoundException;
//
//public class Main {
//	public static void main(String[] args){
//		
//		//Register
//		Register register7;
//		try {
//			register7 = new Register("ab000002","Sai","Pranay","sai123@gmail.com","sai123");
//			System.out.println(register7);
//		} catch (InvalidNameException | InvalidIdLengthException | InvalidEmailException
//				| InvalidPasswordException e3) {
//			e3.printStackTrace();
//		}
//		
//		Login login = new Login();
//		login.setUserName("sb19");
//		login.setPassword("qwerty");	
//		System.out.println(login);
//		
//		//Users
//		
//		UserService service = UserServiceImpl.getInstance();
//		
//		for(int i=1;i<=20;i++) {
//			Register register2 = new Register();
//			try {
//				register2.setId("ab00000"+i);
//				register2.setFirstName("abhi"+i);
//				register2.setLastName("sai"+i);
//				register2.setEmail("sai"+i+"@gmail.com");
//				register2.setPassword("Sai000");
//			} catch (InvalidIdLengthException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidNameException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidEmailException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidPasswordException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			String result = service.addUser(register2);
//			System.out.println(result+" "+i);
//		}
//		
//		Optional<Register> register2;
//		try {
//			register2 = service.getUserById("ab000001");
//			System.out.println(register2!=null);
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//		String register4;
//		try {
//			register4 = service.deleteUserById("ab000002");
//			System.out.println(register4);
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}	
//		
//		Optional<Register> register5;
//		try {
//			register5 = service.updateUser("ab000001","ab000002");
//			System.out.println(register5);
//		} catch (IdNotFoundException | InvalidIdLengthException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		service.getAllUsers().forEach(e -> System.out.println(e));
//		
//		//Subscriptions
//		
//		SubscriptionService subscripServ = SubscriptionServiceImpl.getInstance();
//		
//		for(int i=1;i<4;i++) {
//			try {
//			Subscription subs = new Subscription();
//			subs.setId("sai000"+i);
//			subs.setAutoRenewal(false);
//			subs.setPaymentMode("Credit Card"+i);
//			String result1  = subscripServ.addSubscription(subs);
//			System.out.println(result1+" "+i);
//			}catch(InvalidIdLengthException e) {
//				e.printStackTrace();
//			}
//			
//		}
//		
//		Optional<Subscription> subs;
//		try {
//			subs = subscripServ.getSubscriptionById("sai0001");
//			System.out.println(subs!=null);
//			
//			String subs1 = subscripServ.deleteSubscriptionById("sai0002");
//			System.out.println(subs1);
//			
//			Optional<Subscription> subs3 = subscripServ.updateSubscription("sai0001","sai0002");
//			System.out.println(subs3);
//		} catch (IdNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		} catch (InvalidIdLengthException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//				
//		subscripServ.getAllSubscriptions().forEach(e -> System.out.println(e));	
//		
//		//Movies
//		
//		MovieService movieServ = MovieServiceImpl.getInstance();
//		
//		for(int i=1;i<4;i++) {
//			try {
//			Movie movie = new Movie();
//			movie.setId("movie00"+i);
//			movie.setMovieName("Movie"+i);
//			String result1  = movieServ.addMovie(movie);
//			System.out.println(result1+" "+i);
//			}catch(InvalidIdLengthException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		Optional<Movie> movie;
//		try {
//			movie = movieServ.getMovieById("movie001");
//			System.out.println(movie!=null);
//			String movie1 = movieServ.deleteMovie("movie002");
//			System.out.println(movie1);
//			Optional<Movie> movie3 = movieServ.updateMovie("movie001","movie002");
//			System.out.println(movie3);
//			Optional<Movie> movie4 = movieServ.getMovie("Movie1");
//			System.out.println(movie4);
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (MovieNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (InvalidIdLengthException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//			
//		movieServ.getMovies().forEach(e -> System.out.println(e));
//		
//		//Series
//		
//		SeriesService seriesServ = SeriesServiceImpl.getInstance();
//		
//		for(int i=1;i<4;i++) {
//			
//			
//			try {
//				Series series = new Series();
//				series.setId("series00"+i);
//				series.setSeriesName("Series"+i);
//				String result1  = seriesServ.addSeries(series);
//				System.out.println(result1+" "+i);
//			} catch (InvalidIdLengthException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//		}
//		
//		Optional<Series> series;
//		try {
//			series = seriesServ.getSeriesById("series001");
//			System.out.println(series!=null);
//			
//			String series1 = seriesServ.deleteSeries("series002");
//			System.out.println(series1);
//			
//			Optional<Series> series3 = seriesServ.updateSeries("series001","series002");
//			System.out.println(series3);
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (InvalidIdLengthException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}	
//		
//		for(Series series2 : seriesServ.getSeries()) {
//			if(series2 !=null)
//			System.out.println(series2);
//		}
//		
//	}
//}
