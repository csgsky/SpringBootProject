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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by allen on 17/11/28.
 */
@RestController
@RequestMapping("/users")  // 通过这里配置是下面的映射都在 /users 下面
public class UserController {
    // 创建线程安全的 map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        // 处理 /users/ 的 get 请求，来获取用户列表
        // 此处可以通过 @RequestParams 从页面中传递的参数来进行查询条件或者翻页的信息传递。
        List<User> r = new ArrayList<>(UserController.users.values());
        return r;
    }

    // 处理 /users/ 的 post 请求，用来创建 User
    // 除了 @ModelAttribute 之外，也可以使用 @RequestParams 从页面传递参数
    @ApiOperation(value = "创建用户", notes = "根据 User 对象创建用户！")
    @ApiImplicitParam(name="user", value = "用户详细实体 user", required = true, dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据 url 的 id 更新用户的详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户实体详情", required = true, dataType = "User")
    })
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

    @ApiOperation(value = "查询用户", notes = "根据用户 id 获取单个用户的详细信息")
    @ApiImplicitParam(name = "id", value = "用户 id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value = "删除用户", notes = "根据用户的 id 删除用户实体")
    @ApiImplicitParam(name = "id", value = "用户 ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
