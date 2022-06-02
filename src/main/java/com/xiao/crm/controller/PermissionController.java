package com.xiao.crm.controller;

import com.xiao.crm.domain.Pages;
import com.xiao.crm.domain.Permission;
import com.xiao.crm.service.impl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("crm/permission")
public class PermissionController {

    @Autowired
    private PermissionServiceImpl permissionService;

    /**
     * 查询权限
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
        List<Permission> permissions = null;
        int count = 0;
        if(key != null){
            if(!key.equals("")){
                //模糊查询
                permissions = permissionService.findOne("%" + key + "%");
                //获取指定客户总数量
                count = permissions.size();
            }
        } else {
            permissions = permissionService.findAll((page - 1) * limit,limit);
            //获取客户总数量
            count = permissionService.findTotal();
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",permissions);
        return map;
    }

    /**
     * 删除指定权限
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用service的方法,删除权限
        int flag = permissionService.deleteById(id);
        return "删除成功";
    }

    /**
     * 新增权限
     * @param permission
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String add(@RequestBody Permission permission){
        //调用service的方法,获取客户集合
        if(permission.getId()!=null){
            //从前台获取json数据设置地址

            int flag = permissionService.update(permission);
            return "修改成功";
        }
        int flag = permissionService.save(permission);
        return "添加成功";
    }

    /**
     * 修改权限
     * @param permission
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody Permission permission){
        int flag = permissionService.update(permission);
        return "修改成功";
    }

    /**
     * 删除多个权限
     * @param permissions
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String delete(@RequestBody List<Permission> permissions){
        //调用service的方法,删除权限
        int flag = permissionService.deleteMany(permissions);
        return "删除成功";
    }
}
