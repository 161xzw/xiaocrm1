package com.xiao.crm.controller;

import com.xiao.crm.domain.CusDevPlan;
import com.xiao.crm.domain.Pages;
import com.xiao.crm.service.impl.CusDevPlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Candy
 * @date: 2020/12/1 22:07
 * @description: 客户开发计划web层
 */
@RestController
@RequestMapping("/cusDevPlan")
@CrossOrigin
public class CusDevPlanController {

    @Autowired
    private CusDevPlanServiceImpl cusDevPlanService;

    /**
     * 查询客户开发计划
     * @param pages
     * @return
     */
    @RequestMapping("/findAll")
    private @ResponseBody
    Map<String,Object> findAllCusDevPlan(Pages pages){
        System.out.println("表现层：查询所有客户开发计划");
        //从前台获取当前页数，每页总数量，和查询关键字
        int page = pages.getPage();
        int limit = pages.getLimit();
        String key = pages.getKey();
        //调用业务层方法，获取客户开发计划集合
        List<CusDevPlan> cusDevPlans = null;
        int count = 0;

        if(key != null){
            if (!key.equals("")){
                //模糊查询
                cusDevPlans = cusDevPlanService.findOne("%" + key + "%");
                //获取指定客户开发计划总数量
                count = cusDevPlans.size();
            }
        }else {
            //查询全部客户开发计划
            cusDevPlans = cusDevPlanService.findAll((page - 1) * limit, limit);
            //获取客户开发计划总数量
            count = cusDevPlanService.findTotal();
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",cusDevPlans);
        System.out.println(map);
        return map;
    }

    /**
     * 根据id删除客户开发计划
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        //System.out.println("id--" + id);
        //调用service的方法,删除客户开发计划
        int flag = cusDevPlanService.deleteById(id);
        return "删除成功";
    }

    /**
     * 删除多个客户开发计划
     * @param cusDevPlans
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String deleteMany(@RequestBody List<CusDevPlan> cusDevPlans){
        //调用service的方法,删除一个或多个客户开发计划
        int flag = cusDevPlanService.deleteMany(cusDevPlans);
        return "删除成功";
    }

    /**
     * 新增客户开发计划
     * @param cusDevPlan
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String save(@RequestBody CusDevPlan cusDevPlan) {
        System.out.println(cusDevPlan);
        //调用业务层方法，获取客户开发计划集合
        int flag = cusDevPlanService.save(cusDevPlan);
        return "添加成功";
    }

    /**
     * 修改客户开发计划
     * @param cusDevPlan
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody CusDevPlan cusDevPlan){
        //调用业务层方法，修改客户开发计划
        int flag = cusDevPlanService.update(cusDevPlan);
        return "修改成功";
    }

}
