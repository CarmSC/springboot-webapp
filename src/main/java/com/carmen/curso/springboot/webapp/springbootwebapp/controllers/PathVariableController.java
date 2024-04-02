package com.carmen.curso.springboot.webapp.springbootwebapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carmen.curso.springboot.webapp.springbootwebapp.models.dto.ParamDto;
import com.carmen.curso.springboot.webapp.springbootwebapp.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    //@Value("${config.message}")
    // private String message;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @Value("${config.code}")
    private Integer code;
    
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        
        user.setName(user.getName().toUpperCase());
        //user.setLastname(user.getLastname().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message ) {

        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("code", code);
        json.put("listOfValues", listOfValues);
        return json;

    }
    
}
