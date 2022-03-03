package com.xiao.crm.controller;

import com.xiao.crm.domain.Pages;
import com.xiao.crm.domain.RolePermission;
import com.xiao.crm.service.impl.RolePermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Bei-Zhen
 * @date : 2020-12-06 2:39
 */
@RestController
@CrossOrigin
@RequestMapping("/rolePermission")
public class RolePermissionController {

    @Autowired
    private RolePermissionServiceImpl rolePermissionService;

    /**
     * 查询角色权限
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
        int roleId = Integer.parseInt(request.getParameter("roleId"));
        //调用service的方法,获取客户集合
        List<RolePermission> rolePermissions = null;
        int count = 0;
        if(key != null){
            if(!key.equals("")){
                //模糊查询
                rolePermissions = rolePermissionService.findOne(Integer.parseInt(key));
                //获取指定用户总数量
                count = rolePermissions.size();
            }
        } else {
            rolePermissions = rolePermissionService.findAll((page - 1) * limit,limit,roleId);
            //获取客户总数量
            count = rolePermissionService.findTotal(roleId);
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",rolePermissions);
        return map;
    }

    /**
     * 删除指定角色权限
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用service的方法,删除角色
        int flag = rolePermissionService.deleteById(id);
        return "删除成功";
    }

    /**
     * 新增角色权限
     * @param rolePermission
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String add(@RequestBody RolePermission rolePermission){
        //调用service的方法,获取客户集合
        int flag = rolePermissionService.save(rolePermission);
        return "添加成功";
    }

    /**
     * 修改角色权限
     * @param rolePermission
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody RolePermission rolePermission){
        int flag = rolePermissionService.update(rolePermission);
        return "修改成功";
    }

    /**
     * 删除多个角色权限
     * @param rolePermissions
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String delete(@RequestBody List<RolePermission> rolePermissions){
        //调用service的方法,删除角色
        int flag = rolePermissionService.deleteMany(rolePermissions);
        return "删除成功";
    }
}
