package com.xiao.crm.service;

import com.xiao.crm.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ICustomerService {

    /**
     * 查询所有客户
     * @return
     */
    List<Customer> findAll(int page, int limit);

    List<Customer> findAllqiye(int page, int limit);

    List<Customer> findAllgeren(int page, int limit);

    List<Customer> findAllVIP(int page, int limit);

    List<Customer> findAllVIPqiye(int page, int limit);

    List<Customer> findAllVIPgeren(int page, int limit);

    /**
     * 查询指定客户
     * @return
     */
    List<Customer> findOne(String name);

    List<Customer> findOneVip(String name);

    List<Customer> findOneqiye(String name);

    List<Customer> findOneVipqiye(String name);

    List<Customer> findOneVipgeren(String name);

    List<Customer> findOnegeren(String name);

    /**
     * 查询总客户数
     * @return
     */
    int findTotal();

    int findTotalVip();

    int findTotalqiye();

    int findTotalgeren();

    int findTotalVipgeren();

    int findTotalVipqiye();

    /**
     * 根据id删除客户
     * @return
     */
    int deleteById(int id);

    int updateVip();

    /**
     * 新增客户
     * @return
     */
    int save(Customer customer);

    /**
     * 修改客户
     * @return
     */
    int update(Customer customer);

    /**
     * 删除多个客户
     * @return
     */
    int deleteMany(List<Customer> customers);

    /**
     * 流失客户
     * @return
     */
    int loss(int id);

    /**
     * 查询一个月内总客户数
     *
     * @return
     */
    int findOneTotal();

    /**
     * 查询两个月内总客户数
     *
     * @return
     */
    int findTwoTotal();

    /**
     * 查询三个月内总客户数
     *
     * @return
     */
    int findThreeTotal();

    /**
     * 查询四个月内总客户数
     *
     * @return
     */
    int findFourTotal();

    /**
     * 查询五个月内总客户数
     *
     * @return
     */
    int findFiveTotal();

    /**
     * 查询六个月内总客户数
     *
     * @return
     */
    int findSixTotal();
}
