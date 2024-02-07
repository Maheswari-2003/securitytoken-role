package com.example.Inherit.PersonAddress.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Provide your own error handling logic or return a specific error view
        return "error";
    }


    public String getErrorPath() {
        return "/error";
    }
}
