package com.carmen.curso.springboot.webapp.springbootwebapp.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
            model.addAttribute("title", "Listado de usuarios!");
            return "list";
    }

    @ModelAttribute("users")
    public List<User> userModel() {
      return Arrays.asList(new User("Ana", "Gonzalez"),
                                       new User("Marta", "Morales", "Marta@email.com"),
                                       new User("Juan", "Roldan", "Juan@email.com"),
                                       new User("Maria", "Doe"));

}

}

