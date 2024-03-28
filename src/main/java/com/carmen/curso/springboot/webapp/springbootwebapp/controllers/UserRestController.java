package com.carmen.curso.springboot.webapp.springbootwebapp.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import com.carmen.curso.springboot.webapp.springbootwebapp.models.User;
import com.carmen.curso.springboot.webapp.springbootwebapp.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @GetMapping(path="/details")
    public UserDto details() {

        User user = new User("Carmen", "Salas");

        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");

        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user = new User("Carmen", "Salas");
        User user2 = new User("Aurora", "Ruiz");
        User user3 = new User("Maria", "Perez");

        List<User> users = Arrays.asList(user, user2, user3);
        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }

     @GetMapping(path = "/details-map")
      public Map<String, Object> detailsMap() {
            User user= new User("Carmen", "Cabrera");

            Map<String, Object> body = new HashMap<>();
            body.put("title", "Hola Mundo Spring Boot actualizado");
            body.put("User", user);
            return body;
      }

}