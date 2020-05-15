package com.Kotori.service;

import com.Kotori.domain.Account;
import com.Kotori.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;

    public void insertAccount(Account account){
        this.accountMapper.insertAccount(account);
    }

    @Override
    public void transferAccount() {
        Account account1 = this.accountMapper.getAccountById(1);
        Account account2 = this.accountMapper.getAccountById(2);

        this.accountMapper.updateAccount(account1.getId(), 100L);
        this.accountMapper.updateAccount(account2.getId(), -100L);
        transferAccount2();
    }

    public void transferAccount2() {
        Account account3 = this.accountMapper.getAccountById(3);
        Account account4 = this.accountMapper.getAccountById(4);

        this.accountMapper.updateAccount(account3.getId(), 100L);
        this.accountMapper.updateAccount(account4.getId(), -100L);
        int a = 1/0;
    }
}
