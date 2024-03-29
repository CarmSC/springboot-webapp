package com.carmen.curso.springboot.webapp.springbootwebapp.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.carmen.curso.springboot.webapp.springbootwebapp.models.User;

@Controller
public class UserController {

      @GetMapping("/details")
      public String details(Model model) {

            User user = new User("Carmen", "Salas");
            user.setEmail("carmensalas@email.com");
            model.addAttribute("title", "Hola Mundo Spring Boot");
            model.addAttribute("user", user);
            return "details";
      }
      
      @GetMapping("/list")
      public String list(ModelMap model) {
            //List<User> users = new ArrayList<>();
            List<User> users = Arrays.asList(new User("Ana", "Gonzalez"),
                                             new User("Marta", "Morales", "Marta@email.com"),
                                             new User("Juan", "Roldan", "Juan@email.com"),
                                             new User("Maria", "Doe"));
  
            model.addAttribute("users", users);
            model.addAttribute("title", "Listado de usuarios!");
            return "list";
    }

}

