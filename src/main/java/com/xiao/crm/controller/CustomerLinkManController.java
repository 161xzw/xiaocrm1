package com.xiao.crm.controller;

import com.xiao.crm.domain.CustomerLinkMan;
import com.xiao.crm.domain.Pages;
import com.xiao.crm.service.ICustomerLinkManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("crm/customerLinkMan")
public class CustomerLinkManController {

    @Autowired
    private ICustomerLinkManService customerLinkManService;

    @RequestMapping(value = "/findAll")
    public @ResponseBody
    Map<String,Object> findAllCustomerLinkMan(String body){
        //调用service的方法
        List<CustomerLinkMan> customerLinkMan =customerLinkManService.findAllCustomerLinkMan();
        int count = customerLinkMan.size();
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",customerLinkMan);
        System.out.println(map);
        return map;
    }

    /**
     * 查询客户相关联系人
     * @param request
     * @return
     */
    @RequestMapping(value = "/findA")
    public @ResponseBody
    Map<String,Object> findRelatedContacts(HttpServletRequest request, Pages pages){
        //从前台获取当前页数，每页总数量，和查询关键字
        int page = pages.getPage();
        int limit = pages.getLimit();
        String key = pages.getKey();
        List<CustomerLinkMan> customerLinkMan=null;
        //从前台获取当前页数，每页总数量，和查询关键字
        int cusId = Integer.parseInt(request.getParameter("cusId"));

        if (key != null){
            if (!key.equals("")){
                customerLinkMan=customerLinkManService.findOne("%"+key+"%");
            }
        }else{
            customerLinkMan=customerLinkManService.findA(cusId,(page - 1) * limit,limit);
            System.out.println("表现层：查询客户相关联系人...:"+customerLinkMan);
        }
        int count=customerLinkMan.size();
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",customerLinkMan);
        System.out.println(map);
        return map;
    }

    /**
     * 根据id删除联系人
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        int flag=customerLinkManService.deleteById(id);
        return "删除成功";
    }

    /**
     * 删除多个联系人
     * @param customerLinkMan
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String delete(@RequestBody List<CustomerLinkMan> customerLinkMan){
        //调用service的方法,删除客户
        int flag = customerLinkManService.deleteMany(customerLinkMan);
        return "删除成功";
    }

    /**
     * 新增客户
     * @param customerLinkMan
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String add(@RequestBody CustomerLinkMan customerLinkMan){
        //从前台获取json数据设置地址
//        customerLinkMan.setArea(customer.getProvince()+customer.getCity()+customer.getDistrict());
        //调用service的方法,获取客户集合
        int flag = customerLinkManService.save(customerLinkMan);
        return "添加成功";
    }

    /**
     * 修改客户
     * @param customerLinkMan
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody CustomerLinkMan customerLinkMan){
        //从前台获取json数据设置地址
//        customer.setArea(customer.getProvince()+customer.getCity()+customer.getDistrict());
        int flag = customerLinkManService.update(customerLinkMan);
        return "修改成功";
    }
}
