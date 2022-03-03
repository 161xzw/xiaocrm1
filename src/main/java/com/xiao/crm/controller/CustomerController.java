package com.xiao.crm.controller;

import com.xiao.crm.domain.*;
import com.xiao.crm.service.impl.CustomerLinkManServiceImpl;
import com.xiao.crm.service.impl.CustomerLossServiceImpl;
import com.xiao.crm.service.impl.CustomerOrderServiceImpl;
import com.xiao.crm.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户web层
 * @author : Bei-Zhen
 * @date : 2020-11-23 14:31
 */
@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerLinkManServiceImpl customerLinkManService;

    @Autowired
    private CustomerLossServiceImpl customerLossService;

    @Autowired
    private CustomerOrderServiceImpl customerOrderService;


    /**
     * 查询客户
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
        List<Customer> customers = null;
        int count = 0;
        if(key != null){
            if(!key.equals("")){
                //模糊查询
                customers = customerService.findOne("%" + key + "%");
                //获取指定客户总数量
                count = customers.size();
            }
        } else {
            customers = customerService.findAll((page - 1) * limit,limit);
            //获取客户总数量
            count = customerService.findTotal();
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",customers);
        return map;
    }

    /**
     * 删除指定客户
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用service的方法,删除客户
        int flag = customerService.deleteById(id);
        return "删除成功";
    }

    /**
     * 新增客户
     * @param customer
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String add(@RequestBody Customer customer){
        //从前台获取json数据设置地址
        customer.setArea(customer.getProvince()+customer.getCity()+customer.getDistrict());
        //调用service的方法,获取客户集合
        int flag = customerService.save(customer);
        return "添加成功";
    }

    /**
     * 修改客户
     * @param customer
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody Customer customer){
        //从前台获取json数据设置地址
        customer.setArea(customer.getProvince()+customer.getCity()+customer.getDistrict());
        int flag = customerService.update(customer);
        return "修改成功";
    }

    /**
     * 删除多个客户
     * @param customers
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String delete(@RequestBody List<Customer> customers){
        //调用service的方法,删除客户
        int flag = customerService.deleteMany(customers);
        return "删除成功";
    }

    /**
     * 流失客户
     * @param request
     * @return
     */
    @RequestMapping("/loss")
    public @ResponseBody
    String loss(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        int flag=customerService.loss(id);
        return "流失成功";
    }

    /**
     * 查询首页报表分析的数据
     * @param request
     * @return 报表数据map集合
     */
    @RequestMapping("/findTotal")
    public @ResponseBody
    Map<String,Integer> findTotal(HttpServletRequest request){
        //调用service的方法,拿到首页需要的所有数据
        //新增客户数
        int customerTotal = customerService.findSixTotal();
        //新增联系人数
        int linkManTotal = customerLinkManService.findSixTotal();
        //新增订单数
        int orderTotal = customerOrderService.findSixTotal();
        //流失客户数
        int customerLossTotal = customerLossService.findSixTotal();
        //1-6月新增客户数如下
        int one = customerService.findOneTotal();
        int two = customerService.findTwoTotal() - one;
        int three = customerService.findThreeTotal() - two - one;
        int four = customerService.findFourTotal() - three - two - one;
        int five = customerService.findFiveTotal() - four - three - two - one;
        int six = customerService.findSixTotal() - five - four - three - two - one;
        //放入map集合
        Map<String,Integer> map = new HashMap<>();
        map.put("customerTotal",customerTotal);
        map.put("linkManTotal",linkManTotal);
        map.put("orderTotal",orderTotal);
        map.put("customerLossTotal",customerLossTotal);
        map.put("one",one);
        map.put("two",two);
        map.put("three",three);
        map.put("four",four);
        map.put("five",five);
        map.put("six",six);
        return map;
    }
}
