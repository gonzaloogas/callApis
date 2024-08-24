package cl.gogas.cosas.callapis.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.gogas.cosas.callapis.domain.User;

@Service
public interface UserService {

    public ResponseEntity<List<User>> getAllUsers();
    
}
