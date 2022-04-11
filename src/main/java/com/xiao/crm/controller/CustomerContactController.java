package com.xiao.crm.controller;

import com.xiao.crm.domain.CustomerContact;
import com.xiao.crm.domain.Pages;
import com.xiao.crm.service.ICustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("crm/customerContact")
public class CustomerContactController {

    @Autowired
    private ICustomerContactService customerContactService;

    @RequestMapping(value = "/findAll")
    public @ResponseBody
    Map<String,Object> findAllCustomer(String body){
        //调用service的方法
        List<CustomerContact> customerContacts=customerContactService.findAllCustomerContact();
        int count = customerContacts.size();
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",customerContacts);
        System.out.println(map);
        return map;
    }

    /**
     * 根据客户联系人查询交往记录
     * @param request
     * @return
     */
    @RequestMapping(value = "/findA")
    public @ResponseBody
    Map<String,Object> findContactRecords(HttpServletRequest request, Pages pages){
        //从前台获取当前页数，每页总数量，和查询关键字
        int page = pages.getPage();
        int limit = pages.getLimit();
        String key = pages.getKey();
        List<CustomerContact> customerContacts=null;
        //从前台获取当前页数，每页总数量，和查询关键字
        int cusId = Integer.parseInt(request.getParameter("cusId"));
        int linkManId =Integer.parseInt(request.getParameter("linkManId"));
        if (key != null){
            if (!key.equals("")){
                customerContacts=customerContactService.findOne("%"+key+"%");
            }
        }else{
            customerContacts=customerContactService.findA(cusId,linkManId,(page - 1) * limit,limit);
            System.out.println("表现层：查询客户相关联系人...:"+customerContacts);
        }
        int count=customerContacts.size();
        Map<String,Object> map = new HashMap<>();
        map.put("msg",0);
        map.put("code",0);
        map.put("count",count);
        map.put("data",customerContacts);
        System.out.println(map);
        return map;
    }

    /**
     * 根据id删除交往记录
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    String delete(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        int flag=customerContactService.deleteById(id);
        return "删除成功";
    }

    /**
     * 删除多个交往记录
     * @param customerContacts
     * @return
     */
    @RequestMapping("/deleteMany")
    public @ResponseBody
    String delete(@RequestBody List<CustomerContact> customerContacts){
        //调用service的方法,删除客户
        int flag = customerContactService.deleteMany(customerContacts);
        return "删除成功";
    }

    /**
     * 新增交往记录
     * @param customerContact
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    String add(@RequestBody CustomerContact customerContact){
        //从前台获取json数据设置地址
//        customerLinkMan.setArea(customer.getProvince()+customer.getCity()+customer.getDistrict());
        //调用service的方法,获取客户集合
        int flag = customerContactService.save(customerContact);
        return "添加成功";
    }

    /**
     * 修改交往记录
     * @param customerContact
     * @return
     */
    @RequestMapping("/update")
    public @ResponseBody
    String update(@RequestBody CustomerContact customerContact){
        //从前台获取json数据设置地址
//        customer.setArea(customer.getProvince()+customer.getCity()+customer.getDistrict());
        int flag = customerContactService.update(customerContact);
        return "修改成功";
    }
}
