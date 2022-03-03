package com.xiao.crm.controller;

import com.xiao.crm.domain.CustomerOrder;
import com.xiao.crm.domain.Pages;
import com.xiao.crm.service.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Candy
 * @date: 2020/12/4 17:06
 * @description:
 */
@RestController
@CrossOrigin
@RequestMapping("/customerOrder")
public class CustomerOrderController {

    @Autowired
    private ICustomerOrderService customerOrderService;
    /**
     * 新增订单
     * @param customerOrder
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String save(@RequestBody CustomerOrder customerOrder) {
        //调用业务层方法，获取用户集合
        int flag = customerOrderService.save(customerOrder);
        return "添加成功";
    }

    /**
     * 查询订单
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
        List<CustomerOrder> customerOrders = null;
        int count = 0;
        if(key != null){
            if(!key.equals("")){
                //模糊查询
                customerOrders = customerOrderService.findOne(Integer.parseInt(key));
                //获取指定客户总数量
                count = customerOrders.size();
            }
        } else {
            customerOrders = customerOrderService.findAll((page - 1) * limit,limit);
            //获取订单总数量
            count = customerOrderService.findSixTotal();
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",customerOrders);
        return map;
    }
}
