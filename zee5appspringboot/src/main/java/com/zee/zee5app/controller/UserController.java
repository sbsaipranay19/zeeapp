package com.zee.zee5app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.payload.request.LoginRequest;
import com.zee.zee5app.payload.request.SignupRequest;
import com.zee.zee5app.payload.response.JwtResponse;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.security.jwt.JwtUtils;
import com.zee.zee5app.security.services.UserDetailsImpl;
import com.zee.zee5app.service.UserService;

@CrossOrigin("*")
@RestController 
@EnableAutoConfiguration
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetailsImpl.getAuthorities().stream().map(i -> i.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetailsImpl.getId(), userDetailsImpl.getUsername(),
				userDetailsImpl.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {

		if (userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// user's account

		User user = new User(signupRequest.getUsername(), signupRequest.getEmail(),
				passwordEncoder.encode(signupRequest.getPassword()), signupRequest.getFirstName(),
				signupRequest.getLastName());
		// retrieving the roles details

		Set<String> strRoles = signupRequest.getRole();

		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error:role not found"));
			roles.add(userRole);
		}

		else {
			strRoles.forEach(e -> {
				switch (e) {
				case "admin":
					Role roleAdmin = roleRepository.findByRoleName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error:role not found"));
					roles.add(roleAdmin);
					break;

				case "mod":
					Role roleMod = roleRepository.findByRoleName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error:role not found"));
					roles.add(roleMod);
					break;

				default:
					Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error:role not found"));
					roles.add(userRole);
				}
			});

		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.status(201).body(new MessageResponse("user created successfully"));

	}

}
