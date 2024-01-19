package com.TodoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error/404")
    public String handleNotFound() {
        return "error-404";
    }

    @RequestMapping("/error/500")
    public String handleServerError() {
        return "error-500";
    }
}

