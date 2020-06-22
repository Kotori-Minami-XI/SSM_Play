package com.Kotori.service;

import com.Kotori.domain.Account;
import com.Kotori.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.*;



@Service
//@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
//@Transactional(rollbackFor = Exception.class)
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;

    public void insertAccount(Account account){
        this.accountMapper.insertAccount(account);
    }

    /***
     * transferAccount1
     * 加上@Transactional，没有成功回滚，原因是事务默认支持RuntimeException级别的异常回滚
     * 加上@Transactional(rollbackFor = { Exception.class }),让事务支持Exception级别的异常回滚，成功回滚
     * 注意一定要抛出异常，不要用try catch捕获
     */
    @Override
    public void transferAccount1() throws FileNotFoundException {
        this.accountMapper.updateAccount(1, 100L);
        InputStream in = new FileInputStream("C://1.txt");
        this.accountMapper.updateAccount(2, -100L);
    }

    /***
     * transferAccount2
     * 使用try catch捕获捕获异常，加上@Transactional，没有成功回滚
     * 需要设置手动回滚TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
     */
    @Override
    public void transferAccount2() {
        try {
            this.accountMapper.updateAccount(1, 100L);
            InputStream in = new FileInputStream("C://1.txt");
            this.accountMapper.updateAccount(2, -100L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @Override
    public void transferAccount3() {

    }

    @Override
    public void transferAccount4() {
    }

}
