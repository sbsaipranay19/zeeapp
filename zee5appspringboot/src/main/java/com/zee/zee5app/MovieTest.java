//package com.zee.zee5app;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import com.zee.zee5app.dto.Movie;
//import com.zee.zee5app.service.MovieService;
//
//public class MovieTest {
//	public static void main(String[] args) {
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
//				args);
//		MovieService service =applicationContext.getBean(MovieService.class);
////		FileOutputStream  fileOutputStream=null;
////		try {
////			Optional<Movie> movie = service.getMovieById("movie00");
////			if(movie.isEmpty()) {
////				System.out.println("Movie not Found");
////			}else {
////				Movie movie2 = movie.get();
////				fileOutputStream =new FileOutputStream("C:\\Users\\somavarapu.pranay\\Videos\\read\\sample.mp4");
////				fileOutputStream.write(movie2.getTrailer());
////				
////			}
////		} catch (IdNotFoundException | InvalidIdLengthException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (FileNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}finally {
////			try {
////				fileOutputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
//		
////		for (int i = 0; i < 2; i++) {
////			System.out.println("Adding Movie" + i);
////			Movie movie = new Movie("movie0"+i, "loser"+i, 18, "Priyadarshi", "Sports", 39.57,
////					null, "2022-01-27", "telugu");
////			FileInputStream fileInputStream=null;
////			try {
////				fileInputStream = new FileInputStream("C:\\Users\\somavarapu.pranay\\Videos\\sample.mp4");
////				long fileSize = new File("C:\\Users\\somavarapu.pranay\\Videos\\sample.mp4").length();
////				byte[] allBytes = new byte[(int)fileSize];
////				fileInputStream.read(allBytes);
////				movie.setTrailer(allBytes);
////				
////				
////			} catch (FileNotFoundException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}finally {
////				try {
//////					fileInputStream.close();
////				} catch (IOException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////			}
////			System.out.println(service.addMovie(movie));
////			System.out.println("Added Movie: " + movie.getId());
////		}
////
////		try {
////			System.out.println("MovieId: movie01 " + service.getMovieById("movie00").isPresent());
////			System.out.println("Delete Movie: movie01 " + service.deleteMovie("movie01"));
//////			System.out.println("All Movie Details: \n" + service.getMovies());
////		} catch (IdNotFoundException | InvalidIdLengthException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//		for (int i = 0; i < 2; i++) {
//			System.out.println("Adding Movie" + i);
//			Movie movie = new Movie("movie0"+i, "loser"+i, 18, "Priyadarshi", "Sports", 39.57,
//					"location", "2022-01-27", "telugu");
//			System.out.println(service.addMovie(movie));
//			System.out.println("Added Movie: " + movie.getId());
//		}
//		applicationContext.close();
//		
//		
//	
//		
//
//	}
//}
//
////package com.zee.zee5app;
////
////import java.io.File;
////import java.io.FileInputStream;
////import java.io.FileNotFoundException;
////import java.io.FileOutputStream;
////import java.io.IOException;
////import java.math.BigDecimal;
////import java.util.HashSet;
////import java.util.Optional;
////import java.util.Set;
////
////import javax.naming.NameNotFoundException;
////
////import org.springframework.boot.SpringApplication;
////import org.springframework.boot.autoconfigure.SpringBootApplication;
////import org.springframework.context.ConfigurableApplicationContext;
////
////import com.zee.zee5app.dto.EROLE;
////import com.zee.zee5app.dto.Movie;
////import com.zee.zee5app.dto.Register;
////import com.zee.zee5app.dto.Role;
////import com.zee.zee5app.exception.AlreadyExistsException;
////import com.zee.zee5app.exception.IdNotFoundException;
////import com.zee.zee5app.exception.InvalidIdLengthException;
////import com.zee.zee5app.repository.RoleRepository;
////import com.zee.zee5app.repository.UserRepository;
////import com.zee.zee5app.service.MovieService;
////import com.zee.zee5app.service.RoleService;
////import com.zee.zee5app.service.UserService;
////@SpringBootApplication
////public class Main2 {
////
////	public static void main(String[] args) throws AlreadyExistsException {
////		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
////				args);
////		
////		MovieService movieService = applicationContext.getBean(MovieService.class);
////		
////		Movie movie = new Movie();
////		movie.setId("mov001");
////		
////		movie.setAgeLimit("18");
////		movie.setCast("Allu Arjun");
////		movie.setLanguage("hindi");
////		movie.setLength(250);
////		movie.setMoviename("pushpa");
////		movie.setGenre("abc");
////		FileInputStream fileInputStream = null;
////		FileOutputStream fileOutputStream = null;
////		try {
////		 fileInputStream = new FileInputStream("C:\\movies\\pushpa.mp4");
////		 File file = new File("C:\\movies\\pushpa.mp4");
////		 long fileSize= file.length();
////         byte[] allBytes = new byte[(int) fileSize];
////         
////         fileInputStream.read(allBytes);
////         
////         movie.setTrailer("C:\\movies\\movieStore\\"+file.getName());
////         
////         movie.setReleaseDate("2022-12-15");
////       String result =  movieService.addMovie(movie);
////       
////       if(result.equals("record added in movie")) {
////    	   
////    	   fileOutputStream = new FileOutputStream("C:\\movies\\movieStore\\"+file.getName());
////    	   
////    	   byte[] data = new byte[(int) file.length()];
////    	   
////    	   fileInputStream.read(data);
////    	   fileOutputStream.write(data);
////    	   
////       }
////         
////         
////		} catch (FileNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		finally {
////			try {
////				fileInputStream.close();
////				fileOutputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
//////		FileOutputStream fileOutputStream =null;
//////		
//////		
//////		try {
//////			Optional<Movie> optional = movieService.getMovieById("mov001");
//////			if(optional.isEmpty()) {
//////				System.out.println("record not found");
//////			}
//////			else {
//////				// we should print the info and copy the file to movies folder with name pushpa2.
//////				
//////				Movie movie = optional.get();
//////				
//////				 fileOutputStream = new FileOutputStream("c:\\movies\\read\\pushpa2.mp4");
//////				fileOutputStream.write(movie.getTrailer());
//////				
//////				
//////			}
//////		} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e) {
//////			// TODO Auto-generated catch block
//////			e.printStackTrace();
//////		} catch (FileNotFoundException e) {
//////			// TODO Auto-generated catch block
//////			e.printStackTrace();
//////		} catch (IOException e) {
//////			// TODO Auto-generated catch block
//////			e.printStackTrace();
//////		}finally {
//////			try {
//////				fileOutputStream.close();
//////			} catch (IOException e) {
//////				// TODO Auto-generated catch block
//////				e.printStackTrace();
//////			}
//////		}
//////		
//////		
//////		Movie movie = new Movie();
//////		movie.setId("mov001");
////		
//////		movie.setAgeLimit("18");
//////		movie.setCast("Allu Arjun");
//////		movie.setLanguage("hindi");
//////		movie.setLength(250);
//////		movie.setMoviename("pushpa");
//////		movie.setGenre("abc");
//////		FileInputStream fileInputStream = null;
//////		try {
//////		 fileInputStream = new FileInputStream("C:\\movies\\pushpa.mp4");
//////		 long fileSize = new File("C:\\movies\\pushpa.mp4").length();
//////         byte[] allBytes = new byte[(int) fileSize];
//////         
//////         fileInputStream.read(allBytes);
//////         
//////         movie.setTrailer(allBytes);
//////         
//////         movie.setReleaseDate("2022-12-15");
//////         movieService.addMovie(movie);
//////         
//////         
//////		} catch (FileNotFoundException e) {
//////			// TODO Auto-generated catch block
//////			e.printStackTrace();
//////		} catch (IOException e) {
//////			// TODO Auto-generated catch block
//////			e.printStackTrace();
//////		}
//////		finally {
//////			try {
//////				fileInputStream.close();
//////			} catch (IOException e) {
//////				// TODO Auto-generated catch block
//////				e.printStackTrace();
//////			}
//////		}
//////		
//////		movie.setTrailer(null);
//////		Role role = new Role();
//////		role.setRoleName(EROLE.ROLE_ADMIN);
//////		
//////		Role role2 = new Role();
//////		role2.setRoleName(EROLE.ROLE_USER); 
//////		
//////		RoleService roleService = applicationContext.getBean(RoleService.class);
//////		RoleRepository roleRepository  = applicationContext.getBean(RoleRepository.class);
//////		
//////		System.out.println(roleService.addRole(role));
//////		System.out.println(roleService.addRole(role2));
////		
//////		UserService service = applicationContext.getBean(UserService.class);
//////		Register register;
//////		register = new Register("ab000125", "riya", "sharma", "abhi7@gmail.com", "Ji2ed3443", null, null);
//////		register.setContactnumber(new BigDecimal("9813973123"));
//////		Set<Role> roles = new HashSet<>();
//////		roles.add(roleRepository.findById(1).get());
//////		roles.add(roleRepository.findById(4).get());
//////		register.setRoles(roles);
//////		System.out.println(service.addUser(register));	
////		
////		
////		applicationContext.close();
////	}
////}
//
