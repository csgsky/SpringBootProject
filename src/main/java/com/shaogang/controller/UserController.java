package com.shaogang.controller;

import com.shaogang.bean.ConfigBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by allen on 17/11/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getuser")
    public ConfigBean hexo(){
        ConfigBean configBean = new ConfigBean("小明", "新年快乐");
        return configBean;
    }

    @RequestMapping("/getAnotherUser")
    public ConfigBean getAnotherUser(){
        ConfigBean configBean = new ConfigBean("小明明", "圣诞节快乐ll111");
        return configBean;
    }
}
