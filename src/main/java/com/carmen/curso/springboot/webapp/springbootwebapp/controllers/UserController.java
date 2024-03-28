package com.carmen.curso.springboot.webapp.springbootwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.carmen.curso.springboot.webapp.springbootwebapp.models.User;


@Controller
public class UserController {

      @GetMapping("/details")
      public String details(Model model) {

            User user = new User("Carmen", "Salas");
            model.addAttribute("title", "Hola Mundo Spring Boot");
            model.addAttribute("user", user);
            return "details";
      }
}

