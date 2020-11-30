package com.anma.bh.sb.springtesting.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping({"/home", "/"})
    public String hetHomePage(HttpServletRequest request, Principal principal) {

        System.out.println("Context Path = " + request.getContextPath());
        System.out.println("Remote user = " + request.getRemoteUser());
        System.out.println("Servlet Path == " + request.getServletPath());
        System.out.println("Path info == " + request.getPathInfo());
        System.out.println("URI == " + request.getRequestURI());
        System.out.println("URL == " + request.getRequestURL());
        System.out.println("Session last access time == " + request.getSession());

        System.out.println("+++++++++ Headers:");
        Enumeration<String> headerStrings = request.getHeaderNames();

//        while (headerStrings.hasMoreElements()) {
//            System.out.println(headerStrings.nextElement() + " ::: " + request.getHeader(headerStrings.nextElement()));
//        }

        Enumeration<String> attrNames = request.getAttributeNames();

        System.out.println("++++++++ Attributes:");
        while (attrNames.hasMoreElements()) {
            System.out.println(attrNames.nextElement());
        }

        Map<String, String[]> paramsMap = request.getParameterMap();

        Enumeration<String> paramNames = request.getParameterNames();

        System.out.println("++++++++ Parameters:");

        while (paramNames.hasMoreElements()) {
            System.out.println(paramNames.nextElement());
        }
//        request.getParameterValues();

        System.out.println("+++++++++++++ Parameters Map :");
        paramsMap.entrySet().forEach(e -> System.out.println(e.getKey() + " ::: " + e.getValue()[0]));

        return "home";

    }
}
