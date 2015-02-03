package com.medinsky.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Aleksandr on 28.01.2015.
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {

    @RequestMapping(method = RequestMethod.GET)
    public String show(){
        return "index";
    }
}
