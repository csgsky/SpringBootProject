package com.shaogang.controller;

import com.shaogang.bean.User;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by allen on 17/11/28.
 */
@RestController
@RequestMapping("/users")  // 通过这里配置是下面的映射都在 /users 下面
public class UserController {
    // 创建线程安全的 map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        // 处理 /users/ 的 get 请求，来获取用户列表
        // 此处可以通过 @RequestParams 从页面中传递的参数来进行查询条件或者翻页的信息传递。
        List<User> r = new ArrayList<>(UserController.users.values());
        return r;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    // 处理 /users/ 的 post 请求，用来创建 User
    // 除了 @ModelAttribute 之外，也可以使用 @RequestParams 从页面传递参数
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        if (user != null) {
            System.out.println(user.toString());
            System.out.println("name ==> " + user.getName());
            System.out.println("age ===> " + user.getAge());
        } else {
            System.out.println(" 空 的 ");
        }

        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
