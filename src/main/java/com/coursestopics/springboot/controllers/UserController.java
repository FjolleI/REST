package com.coursestopics.springboot.controllers;

import com.coursestopics.springboot.model.AuthenticationRequest;
import com.coursestopics.springboot.model.AuthenticationResponse;
import com.coursestopics.springboot.model.User;
import com.coursestopics.springboot.repository.UserRepository;
import com.coursestopics.springboot.service.UserService;
import com.coursestopics.springboot.util.JwtUtil;
import com.coursestopics.springboot.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtTokenUtil;

    public UserController(AuthenticationManager authenticationManager, UserService userService,
                          JwtUtil jwtTokenUtil){
        this.authenticationManager=authenticationManager;
        this.userService = userService;
        this.jwtTokenUtil=jwtTokenUtil;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<Response> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();

        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Bad Credentials!");
        }
        final UserDetails userDetails = userService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        Response response = Response.builder().success(true).message("Login Successfully!").data(new AuthenticationResponse(jwt)).code(200).build();
        return ResponseEntity.ok(response);

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)

    public ResponseEntity<Response> createUser(@RequestBody User user) throws Exception {
        User userCreated = userService.create(user);
        try {
            Response response = Response.builder()
                    .success(true)
                    .code(200)
                    .message("User has been created successfully!")
                    .data(userCreated)
                    .build();
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            throw new Exception("Failed to create user!");
        }

    }
}

