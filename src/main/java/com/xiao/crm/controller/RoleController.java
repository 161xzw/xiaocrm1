package com.xiao.crm.controller;

import com.xiao.crm.domain.Pages;
import com.xiao.crm.domain.Role;
import com.xiao.crm.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色web层
 * @author : Bei-Zhen
 * @date : 2020-12-01 20:07
 */
@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    /**
     * 查询角色
     * @param pages
     * @return
     */
    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Pages pages){
        //从前台获取当前页数，每页总数量，和查询关键字
        int page = pages.getPage();
        int limit = pages.getLimit();
        String key = pages.getKey();
        //调用service的方法,获取客户集合
        List<Role> roles = null;
        int count = 0;
        if(key != null){
            if(!key.equals("")){
                //模糊查询
                roles = roleService.findOne("%" + key + "%");
                //获取指定用户总数量
                count = roles.size();
            }
        } else {
            roles = roleService.findAll((page - 1) * limit,limit);
            //获取客户总数量
            count = roleService.findTotal();
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",roles);
        return map;
    }

    /**
     * 删除指定角色
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用service的方法,删除角色
        int flag = roleService.deleteById(id);
        return "删除成功";
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String add(@RequestBody Role role){
        //调用service的方法,获取客户集合
        int flag = roleService.save(role);
        return "添加成功";
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody Role role){
        int flag = roleService.update(role);
        return "修改成功";
    }

    /**
     * 删除多个角色
     * @param roles
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String delete(@RequestBody List<Role> roles){
        //调用service的方法,删除角色
        int flag = roleService.deleteMany(roles);
        return "删除成功";
    }
}
