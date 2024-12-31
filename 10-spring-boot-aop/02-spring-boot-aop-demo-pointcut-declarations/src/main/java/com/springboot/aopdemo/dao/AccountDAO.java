package com.springboot.aopdemo.dao;

import com.springboot.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);
    boolean doWork();
}
