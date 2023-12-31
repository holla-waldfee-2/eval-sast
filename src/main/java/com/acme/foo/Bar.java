package com.acme.foo;

import java.io.IOException;
import java.net.HttpCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BarServlet", urlPatterns = "/barServlet")
public class Bar extends HttpServlet {
    
    public static final boolean T = true;

    public static final boolean F = false;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Cookie neg_custom_class = new Cookie("b-1", "b-1"); // Neg - It is not javax.servlet.http.Cookie
        //response.addCookie(c10);

        HttpCookie neg_http_cookie_class = new HttpCookie("b-2", "b-2"); // Neg - It is not javax.servlet.http.Cookie
        //response.addCookie(c11.get);



        javax.servlet.http.Cookie neg_fq_name_const_true = new javax.servlet.http.Cookie("b-3", "b-3"); // Neg - Bar.T is a constant with value true
        neg_fq_name_const_true.setSecure(Bar.T);
        response.addCookie(neg_fq_name_const_true);

        javax.servlet.http.Cookie pos_fq_name_const_false = new javax.servlet.http.Cookie("b-4", "b-4"); // Pos
        pos_fq_name_const_false.setSecure(Bar.F);
        response.addCookie(pos_fq_name_const_false);
    }

    public static class Cookie {
        public Cookie(String bla, String blu) {}
    }
}
