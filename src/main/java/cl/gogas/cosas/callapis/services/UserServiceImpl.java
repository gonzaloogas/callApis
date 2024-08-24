package cl.gogas.cosas.callapis.services;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.gogas.cosas.callapis.domain.User;

@Service
public class UserServiceImpl implements UserService{

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
    
        logger.info("Inicia Busqueda Comentarios Con Exchange");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity <User> entity = new HttpEntity<User>(headers);



        ResponseEntity<List<User>> response = restTemplate.exchange(
				"https://jsonplaceholder.typicode.com/users", HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<User>>() {
				});

        logger.info("Response: {}", response.getBody());

		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);      
    }
    
}
