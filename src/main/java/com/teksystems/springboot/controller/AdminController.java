package com.teksystems.springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @RequestMapping(value = "/admin/admintest", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/admin");
        return response;
    }

}
