package com.zee.zee5app.dto;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@EqualsAndHashCode
//@NoArgsConstructor
public class Register {
	public Register(String id, String firstName, String lastName, String email, String password) throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPassword(password);
		
	}

	@Setter(value = AccessLevel.NONE)
	private String id;
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	@Setter(value = AccessLevel.NONE)
	private String email;
	@Setter(value = AccessLevel.NONE)
	private String password;
	
	public Register() {
		System.out.println("hello ");
	}

	public void setId(String id) throws InvalidIdLengthException {
		
		if(id.length()<=6) {
			throw new InvalidIdLengthException("id length is lessthan or equal to 6");
		}
		this.id = id;
		
	}

	public void setFirstName(String firstName) throws InvalidNameException {
		
		if(firstName == null || firstName==" " || firstName.length()<2) {
			throw new InvalidNameException("Firstname is Not Valid");
		}
		this.firstName = firstName;
		
	}

	public void setLastName(String lastName) throws InvalidNameException {
		
		if(lastName == null || lastName==" " || lastName.length()<2) {
			throw new InvalidNameException("Firstname is Not Valid");
		}
		this.lastName = lastName;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}

	public void setEmail(String email) throws InvalidEmailException {
		
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		  Matcher matcher = pattern.matcher(email);
		  if(!matcher.matches()) {
			  throw new InvalidEmailException("Enter a Valid Email");
		  }
		this.email = email;
		
	}

	public void setPassword(String password) throws InvalidPasswordException {
		
		if(password == null || password==" " || password.length()<6) {
			throw new InvalidPasswordException("Passwrod is Not Valid");
		}
		
	}
	
}
