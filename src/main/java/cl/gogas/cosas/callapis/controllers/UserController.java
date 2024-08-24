package cl.gogas.cosas.callapis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.gogas.cosas.callapis.domain.User;
import cl.gogas.cosas.callapis.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
  public ResponseEntity<List<User>> getAllUsers() {
    ResponseEntity<List<User>> response = userService.getAllUsers();
	return response;      
    }
    
}

