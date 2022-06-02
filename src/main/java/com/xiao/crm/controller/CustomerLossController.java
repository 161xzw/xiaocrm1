package com.xiao.crm.controller;

import com.xiao.crm.domain.CustomerLoss;
import com.xiao.crm.domain.Pages;
import com.xiao.crm.service.ICustomerLossService;
import com.xiao.crm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("crm/customerLoss")
public class CustomerLossController {

    @Autowired
    private ICustomerLossService customerLossService;

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "/findAll")
    public @ResponseBody
    Map<String,Object> findAllCustomerLoss(Pages pages){
        //从前台获取当前页数，每页总数量，和查询关键字
        int page = pages.getPage();
        int limit = pages.getLimit();
        String key = pages.getKey();
        //调用service的方法,获取客户集合
        List<CustomerLoss> customerLosses = null;
        int count = 0;
        if(key != null){
            if(!key.equals("")){
                //模糊查询
                customerLosses = customerLossService.findOne("%" + key + "%");
                System.out.println("key::"+key);
                //获取指定客户总数量
                count = customerLosses.size();
            }
        } else {
            customerLosses = customerLossService.findAll((page - 1) * limit,limit);
            //获取客户总数量
            count = customerLossService.findTotal();
        }
        //放入map集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",customerLosses);
        return map;
    }

    /**
     * 删除流失客户
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        //从前台获取删除id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用service的方法,删除客户
        int flag = customerLossService.deleteById(id);
        System.out.println("删除的id："+id);
        return "删除成功";
    }

    /**
     * 新增流失客户
     * @param request
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String add(@RequestBody CustomerLoss customerLoss, HttpServletRequest request){
        //调用service的方法,获取客户集合
        if(customerLoss.getId()!=null){
            //从前台获取json数据设置地址

            int flag = customerLossService.update(customerLoss);
            return "修改成功";
        }
        int flag = customerLossService.save(customerLoss);
        System.out.println("-----"+customerLoss);
        //从前台获取删除id
        int cusId =customerLoss.getCusId();
        customerService.loss(cusId);
        System.out.println("删除客户表的id："+cusId);
        return "添加成功";
    }

    /**
     * 修改流失客户
     * @param customerLoss
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody CustomerLoss customerLoss){
        //从前台获取json数据设置地址
//        customer.setArea(customer.getProvince()+customer.getCity()+customer.getDistrict());
        int flag = customerLossService.update(customerLoss);
        return "修改成功";
    }

    /**
     * 删除多个流失客户
     * @param customerLosses
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String delete(@RequestBody List<CustomerLoss> customerLosses){
        //调用service的方法,删除客户
        int flag = customerLossService.deleteMany(customerLosses);
        return "删除成功";
    }
}
