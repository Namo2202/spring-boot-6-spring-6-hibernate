package com.springboot.aopdemo.dao;

import com.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account("Leo Das", "Silver");
        Account temp2 = new Account("JD", "Platinum");

        myAccounts.add(temp1);
        myAccounts.add(temp2);

        return myAccounts;
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
