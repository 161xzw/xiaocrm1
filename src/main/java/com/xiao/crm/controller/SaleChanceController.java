package com.xiao.crm.controller;

import com.xiao.crm.domain.Pages;
import com.xiao.crm.domain.SaleChance;
import com.xiao.crm.service.impl.SaleChanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("crm/saleChance")
public class SaleChanceController {

    @Autowired
    private SaleChanceServiceImpl saleChanceService;

    /**
     * 查询所有营销机会
     * @param pages
     * @return
     */
    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Pages pages){
        //从前台获取当前页数、每页总数量，和查询关键字
        int page = pages.getPage();
        int limit = pages.getLimit();
        String key = pages.getKey();
        //调用service的方法,获取营销机会集合
        List<SaleChance> saleChances = null;
        //营销机会数量
        int count = 0; //count = saleChanceService.findTotal();

        if(key != null){
            if (!key.equals("")){
                //模糊查询
                saleChances = saleChanceService.findOne("%" + key + "%");
                //获取指定营销机会总数量
                count = saleChances.size();
            }
        }else {
            //查询全部
            saleChances = saleChanceService.findAll((page - 1) * limit, limit);
            //获取总数量
            count = saleChanceService.findTotal();
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);

        map.put("count",count);
        map.put("data",saleChances);
        System.out.println(map);
        return map;
    }

    /**
     * 根据id删除指定营销机会
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用service的方法,删除营销机会
        int flag = saleChanceService.deleteById(id);
        return "删除成功";
    }

    /**
     * 删除多个营销机会
     * @param saleChances
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String deleteMany(@RequestBody List<SaleChance> saleChances){
        //调用service的方法,删除一个或多个营销机会
        int flag = saleChanceService.deleteMany(saleChances);
        return "删除成功";
    }
    /**
     * 新增营销机会
     * @param saleChance
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String save(@RequestBody SaleChance saleChance) {
        //调用业务层方法，获取用户集合
        int flag = saleChanceService.save(saleChance);
        return "添加成功";
    }

    /**
     * 修改营销机会
     * @param saleChance
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody SaleChance saleChance){
        //调用业务层方法，修改用户
        int flag = saleChanceService.update(saleChance);
        return "修改成功";
    }
}
