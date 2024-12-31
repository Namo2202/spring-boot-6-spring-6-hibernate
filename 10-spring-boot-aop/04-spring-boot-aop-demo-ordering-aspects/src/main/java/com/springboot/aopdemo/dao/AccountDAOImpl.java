package com.springboot.aopdemo.dao;

import com.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass()+": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+": doWork()");
        return false;
    }
}
