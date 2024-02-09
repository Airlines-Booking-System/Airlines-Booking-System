package com.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.LoginDetailsDTO;
import com.app.entities.UserDetails;
import com.app.services.LoginDtlsService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/login")
public class loginController {
    @Autowired 
    private LoginDtlsService service;

    @PostMapping("/")
    public String postMethodName(@RequestBody LoginDetailsDTO details,HttpSession session) {
        String route=service.getUser(details.getEmail(),details.getPassword());
        if (route != null) {
            session.setAttribute("name",details.getEmail() );
            session.setAttribute("pass", details.getPassword());
            return "redirect:" + route;
        } else {
            return "login";
        }
    }
    
}
