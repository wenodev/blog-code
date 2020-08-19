package com.weno.cookie;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CookieController {

    @GetMapping("/hello")
    public String checkCookie(@CookieValue(value = "username", defaultValue = "BeforeCookie") String username){
        return "Hello! " + username;
    }

    @GetMapping("/setCookie")
    public String setCookie(HttpServletResponse response){

        //create a cookie
        Cookie cookie = new Cookie("username", "AfterCookie");

        //set cookie expiration
        cookie.setMaxAge(10); // expires in 10 seconds

        //set secure
//        cookie.setSecure(true); //https만 가능

        //set HttpOnly
        cookie.setHttpOnly(true); // prevent cross-site scripting (XSS) attacks and are not accessible via JavaScript

        //add cookie to response
        response.addCookie(cookie);

        return "Username is changed!";
    }

}


