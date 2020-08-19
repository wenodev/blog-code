package com.weno.cookie;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CookieController {

    @GetMapping("/")
    public String checkCookie(@CookieValue(value = "username", defaultValue = "wenoBefore") String username){
        return "Hello! My name is : " + username;
    }

    @GetMapping("/set")
    public String setCookie(HttpServletResponse response){

        //create a cookie
        Cookie cookie = new Cookie("username", "wenoAfter");

        //set cookie expiration
        cookie.setMaxAge(10); // expires in 5 minute

        //set secure
        // cookie.setSecure(true); //https만 가능

        //set HttpOnly
        cookie.setHttpOnly(true); // prevent cross-site scripting (XSS) attacks and are not accessible via JavaScript


        //add cookie to response
        response.addCookie(cookie);

        return "Username is changed!";
    }

}
