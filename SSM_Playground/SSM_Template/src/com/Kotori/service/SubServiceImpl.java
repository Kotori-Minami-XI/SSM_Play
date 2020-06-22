package com.Kotori.service;

import com.Kotori.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/***
 * PROPAGATION_REQUIRED 支持当前事务，如果不存在 就新建一个(默认)
 * PROPAGATION_SUPPORTS 支持当前事务，如果不存在，就不使用事务
 * PROPAGATION_MANDATORY 支持当前事务，如果不存在，抛出异常（mandatory：强制的）
 * PROPAGATION_REQUIRES_NEW 如果有事务存在，挂起当前事务，创建一个新的事务
 * PROPAGATION_NOT_SUPPORTED 以非事务方式运行，如果有事务存在，挂起当前事务
 * PROPAGATION_NEVER 以非事务方式运行，如果有事务存在，抛出异常
 * PROPAGATION_NESTED 如果当前事务存在，则嵌套事务执行。如果上下文中存在事务，则嵌套事务执行，如果不存在事务，则新建事务
 */

@Service
public class SubServiceImpl implements SubService {
    @Autowired
    private AccountMapper accountMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public void sub1() {
        this.accountMapper.updateAccount(2, -100L);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void sub2() {
        this.accountMapper.updateAccount(2, -100L);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void sub3() {
        this.accountMapper.updateAccount(2, -100L);
        int a=1/0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sub4() {
        this.accountMapper.updateAccount(2, -100L);
        int a=1/0; //B
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void sub5() {
        this.accountMapper.updateAccount(2, -100L);
        //int a=1/0;//B
    }

    @Transactional(propagation = Propagation.NEVER)
    public void sub6() {
        this.accountMapper.updateAccount(2, -100L);
        //int a=1/0;//B
    }

    @Transactional(propagation = Propagation.NESTED)
    public void sub7() {
        this.accountMapper.updateAccount(2, -100L);
        int a=1/0;//B
    }
}
