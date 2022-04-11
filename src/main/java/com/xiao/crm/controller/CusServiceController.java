package com.xiao.crm.controller;

import com.xiao.crm.domain.CusService;
import com.xiao.crm.domain.Pages;
import com.xiao.crm.service.impl.CusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("crm/cusService")
@CrossOrigin
public class CusServiceController {
    @Autowired
    private CusServiceImpl cusService;

    /**
     * 查询客户服务
     * @param pages
     * @return
     */
    @RequestMapping("/findAll")
    private @ResponseBody
    Map<String,Object> findAll(Pages pages){
        //从前台获取当前页数，每页总数量，和查询关键字
        int page = pages.getPage();
        int limit = pages.getLimit();
        String key = pages.getKey();
        //调用业务层方法，获取客户服务集合
        List<CusService> cusServices = null;
        int count = 0;

        if(key != null){
            if (!key.equals("")){
                //模糊查询
                cusServices = cusService.findOne("%" + key + "%");
                //获取指定客户服务总数量
                count = cusServices.size();
            }
        }else {
            //查询全部客户服务
            cusServices = cusService.findAll((page - 1) * limit, limit);
            //获取客户服务总数量
            count = cusService.findTotal();
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",cusServices);
        //System.out.println(map);
        return map;
    }

    /**
     * 根据id删除客户服务
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用service的方法,删除客户服务
        int flag = cusService.deleteById(id);
        return "删除成功";
    }

    /**
     * 删除多个客户服务
     * @param cusServices
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String deleteMany(@RequestBody List<CusService> cusServices){
        //调用service的方法,删除一个或多个客户服务
        int flag = cusService.deleteMany(cusServices);
        return "删除成功";
    }

    /**
     * 新增客户服务
     * @param cusServicee
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String save(@RequestBody CusService cusServicee) {
        //调用业务层方法，获取客户服务集合
        int flag = cusService.save(cusServicee);
        return "添加成功";
    }

    /**
     * 修改客户服务
     * @param cusServicee
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody CusService cusServicee){
        //调用业务层方法，修改客户服务
        int flag = cusService.update(cusServicee);
        return "修改成功";
    }
}
