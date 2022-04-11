package com.xiao.crm.controller;

import com.xiao.crm.domain.Pages;
import com.xiao.crm.domain.UserRole;
import com.xiao.crm.service.impl.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("crm/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleServiceImpl userRoleService;

    /**
     * 查询用户角色
     * @param pages
     * @return
     */
    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Pages pages, HttpServletRequest request){
        //从前台获取当前页数，每页总数量，和查询关键字
        int page = pages.getPage();
        int limit = pages.getLimit();
        String key = pages.getKey();
        int userId = Integer.parseInt(request.getParameter("userId"));
        //调用service的方法,获取客户集合
        List<UserRole> userRoles = null;
        int count = 0;
        if(key != null){
            if(!key.equals("")){
                //模糊查询
                userRoles = userRoleService.findOne(Integer.parseInt(key));
                //获取指定用户总数量
                count = userRoles.size();
            }
        } else {
            userRoles = userRoleService.findAll((page - 1) * limit,limit,userId);
            //获取客户总数量
            count = userRoleService.findTotal(userId);
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",userRoles);
        return map;
    }

    /**
     * 删除指定用户角色
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用service的方法,删除角色
        int flag = userRoleService.deleteById(id);
        return "删除成功";
    }

    /**
     * 新增用户角色
     * @param userRole
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String add(@RequestBody UserRole userRole){
        //调用service的方法,获取客户集合
        int flag = userRoleService.save(userRole);
        return "添加成功";
    }

    /**
     * 修改用户角色
     * @param userRole
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody UserRole userRole){
        int flag = userRoleService.update(userRole);
        return "修改成功";
    }

    /**
     * 删除多个用户角色
     * @param userRoles
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String delete(@RequestBody List<UserRole> userRoles){
        //调用service的方法,删除角色
        int flag = userRoleService.deleteMany(userRoles);
        return "删除成功";
    }
}
