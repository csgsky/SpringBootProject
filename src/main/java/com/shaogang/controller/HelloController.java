package com.shaogang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allen on 17/12/3.
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host", "http://blog.didispace.com");
        return "thymeleafindex";
    }
}
