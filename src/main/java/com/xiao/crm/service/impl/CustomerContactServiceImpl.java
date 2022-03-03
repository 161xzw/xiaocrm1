package com.xiao.crm.service.impl;

import com.xiao.crm.dao.ICustomerContactDao;
import com.xiao.crm.domain.CustomerContact;
import com.xiao.crm.service.ICustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("customerContactService")
public class CustomerContactServiceImpl implements ICustomerContactService {

    @Autowired
    public ICustomerContactDao customerContactDao;

    public List<CustomerContact> findAllCustomerContact() {
        System.out.println("查询所有交往记录：");
        return customerContactDao.findAll();
    }

    @Override
    public List<CustomerContact> findA(int cusId, int linkManId, int page, int limit) {
        return customerContactDao.findA(cusId,linkManId,page,limit);
    }

    @Override
    public int deleteById(int id) {
        return customerContactDao.deleteById(id);
    }

    @Override
    public int deleteMany(List<CustomerContact> customerContacts) {
        return customerContactDao.deleteMany(customerContacts);
    }

    @Override
    public List<CustomerContact> findOne(String outline) {
        return customerContactDao.findOne(outline);
    }

    @Override
    public int findTotal() {
        return customerContactDao.findTotal();
    }

    @Override
    public int save(CustomerContact customerContact) {
        customerContact.setIsValid(1);
        //设置创建时间
        customerContact.setCreateDate(new Date());
        return customerContactDao.save(customerContact);
    }

    @Override
    public int update(CustomerContact customerContact) {
        //设置修改时间
        customerContact.setUpdateDate(new Date());
        return customerContactDao.update(customerContact);
    }
}
