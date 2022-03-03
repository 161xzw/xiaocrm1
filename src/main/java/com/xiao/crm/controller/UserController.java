package com.xiao.crm.controller;

import com.xiao.crm.domain.Pages;
import com.xiao.crm.domain.User;
import com.xiao.crm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Candy
 * @date: 2020/11/23 15:01
 * @description: 用户web层
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 查询用户
     * @param pages
     * @return
     */
    @RequestMapping("/findAll")
    private @ResponseBody
    Map<String,Object> findAllUser(Pages pages){
        //从前台获取当前页数，每页总数量，和查询关键字
        int page = pages.getPage();
        int limit = pages.getLimit();
        String key = pages.getKey();
        //调用业务层方法，获取用户集合
        List<User> users = null;
        int count = 0;

        if(key != null){
            if (!key.equals("")){
                //模糊查询
                users = userService.findOne("%" + key + "%");
                //获取指定用户总数量
                count = users.size();
            }
        }else {
            //查询全部用户
            users = userService.findAll((page - 1) * limit, limit);
            //获取用户总数量
            count = userService.findTotal();
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",users);
        return map;
    }

    /**
     * 验证登录
     * @param request
     * @return
     */
    @RequestMapping("/checkLogin")
    private @ResponseBody
    Map<String,Object> checkLogin(HttpServletRequest request){
        //登录名
        String login = request.getParameter("login");
        //密码
        String pwd = request.getParameter("pwd");
        //用户输入的验证码
        String code = request.getParameter("code");
        //随机生成的验证码
        String randomCode = request.getParameter("randomCode");
        String msg = "";
        int state = 0;
        if(!code.toUpperCase().equals(randomCode.toUpperCase())) {
            state = 1;
            msg = "验证码错误";
        } else if (userService.checkLogin(login,pwd) == null){
            state = 2;
            msg = "用户名或密码错误";
        } else {
            state = 200;
            //把当前用户放入session
            System.out.println(userService.checkLogin(login,pwd));
            request.getSession().setAttribute("user",userService.checkLogin(login,pwd));
            msg = "登录成功,正在进入系统，请稍后...";
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }

    /**
     * 获取用户信息及其权限
     * @param request
     * @return
     */
    @RequestMapping("/getUser")
    private @ResponseBody
    Map<String,Object> getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //拿到登陆的用户session
        User user = (User) request.getSession().getAttribute("user");

        //用户信息
        int id = user.getId();
        String userName = user.getUserName();
        String userPwd = user.getUserPwd();
        String trueName = user.getTrueName();
        String email = user.getEmail();
        String tel = user.getTel();
        int isValid = user.getIsValid();

        //创建权限id集合
        List<Integer> permissions = new ArrayList<>();
        //遍历角色
        for (int i = 0; i < user.getRoles().size(); i++) {
            //遍历权限
            for (int j = 0; j < user.getRoles().get(i).getPermissions().size(); j++) {
                //存入集合
                permissions.add(user.getRoles().get(i).getPermissions().get(j).getPermissionLevel());
            }
        }
        //存入返回前台数据的map集合
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("userName",userName);
        map.put("userPwd",userPwd);
        map.put("trueName",trueName);
        map.put("email",email);
        map.put("tel",tel);
        map.put("isValid",isValid);
        map.put("permissions",permissions);

        return map;
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("/quit")
    private @ResponseBody
    Map<String,Object> quit(HttpServletRequest request){
        //移除用户session
        request.getSession().removeAttribute("user");
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg","退出登录成功");
        return map;
    }

    /**
     * 根据id删除用户
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用service的方法,删除用户
        int flag = userService.deleteById(id);
        return "删除成功";
    }

    /**
     * 删除多个用户
     * @param users
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String deleteMany(@RequestBody List<User> users){
        //调用service的方法,删除一个或多个用户
        int flag = userService.deleteMany(users);
        return "删除成功";
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String save(@RequestBody User user) {
        //调用业务层方法，获取用户集合
        int flag = userService.save(user);
        return "添加成功";
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody User user){
        //调用业务层方法，修改用户
        int flag = userService.update(user);
        return "修改成功";
    }



}
