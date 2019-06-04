package com.consume;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.consume.domain.User;

@SpringBootApplication
public class RestConsumerApplication {

	 static final String URL_USERS = "http://localhost:9090/users/";
	public static void main(String[] args) {
		HttpHeaders headers = new HttpHeaders();
		// HttpEntity<User[]>: To get result as User[].
        HttpEntity<User> entity = new HttpEntity<User>(headers);
 
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Send request with GET method, and Headers.
        ResponseEntity<User[]> response = restTemplate.exchange(URL_USERS,HttpMethod.GET, entity, User[].class);
 
        HttpStatus statusCode = response.getStatusCode();
        System.err.println("Response Satus Code: " + statusCode);
 
        // Status Code: 200
        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            User[] list = response.getBody();
 
            if (list != null) {
                for (User user : list) {
                    System.err.println("User: " + user.getId() + " - " + user.getName());
                }
            }
        }
	
    }
 
}