package com.springboot.aopdemo.dao;

import com.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{
    @Override
    public void addAccount(Account theAccount) {
        System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
