package com.shaogang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by allen on 17/11/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info")
    public  Map<String, String> getInfo(@RequestParam String name){
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return map;
    }

    @RequestMapping("/getuser")
    public List<Map<String,String>> getList(){
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        for (int i = 0; i < 100; i++) {
            map = new HashMap<>();
            map.put("name", "allen - " + i);
            map.put("age", "1" + i);
            list.add(map);
        }
        return list;
    }

//    @RequestMapping("/getAnotherUser")
//    public ConfigBean getAnotherUser(){
//        ConfigBean configBean = new ConfigBean("小明明", "圣诞节快乐ll111");
//        return configBean;
//    }
}
