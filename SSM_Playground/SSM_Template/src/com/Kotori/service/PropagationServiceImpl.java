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
public class PropagationServiceImpl implements PropagationService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private SubService subService;

    /***
     * testPropagation1加上@Transactional，默认是Propagation.REQUIRED
     * sub1()加@Transactional，默认是Propagation.REQUIRED
     * 不论异常发生在哪里都可以成功回滚
     * 单独调用sub1则会开启一个事务
     */
    @Override
    @Transactional
    public void testPropagation1() {
        this.accountMapper.updateAccount(1, 100L);
        int a=1/0;
        subService.sub1();
    }

    /***
     * testPropagation2加上@Transactional，默认是Propagation.REQUIRED
     * sub2()加 @Transactional(propagation = Propagation.SUPPORTS)
     * 不论异常发生在哪里都可以成功回滚
     * 单独调用sub2则以非事务运行
     */
    @Override
    @Transactional
    public void testPropagation2() {
        this.accountMapper.updateAccount(1, 100L);
        int a=1/0;
        subService.sub2();
    }

    /***
     * testPropagation3加上@Transactional，默认是Propagation.REQUIRED
     * sub3()加 @Transactional(propagation = Propagation.MANDATORY)
     * 不论异常发生在哪里都可以成功回滚
     * 如果没有事务就抛出异常
     */
    @Override
    @Transactional
    public void testPropagation3() {
        this.accountMapper.updateAccount(1, 100L);
        subService.sub3();
    }

    /***
     * testPropagation4加上@Transactional，默认是Propagation.REQUIRED
     * sub4()加 @Transactional(propagation = Propagation.REQUIRES_NEW)
     * 外层和内层事务互相独立
     * 异常发生在A处，则内部事务没有执行，外层事务回滚
     * 异常发生在B处，则内部事务和外层事务都回滚了
     * 异常发生在C处, 则内部事务成功，外部事务回滚
     */
    @Override
    @Transactional
    public void testPropagation4() {
        this.accountMapper.updateAccount(1, 100L);
        //int a=1/0; //A
        subService.sub4();
        int a=1/0; //C
    }

    /***
     * testPropagation5加上@Transactional，默认是Propagation.REQUIRED
     * sub5()加 @Transactional(propagation = Propagation.NOT_SUPPORTED)
     * 挂起外部事务后, sub5()将不会用事务执行
     * 异常发生在A处，则外层事务回滚，内部事务没有执行
     * 异常发生在B,C处，则内部事务成功，外层事务回滚
     */
    @Override
    @Transactional
    public void testPropagation5() {
        this.accountMapper.updateAccount(1, 100L);
        int a=1/0; //A
        subService.sub5();
        //int a=1/0; //C
    }

    /***
     * testPropagation6加上@Transactional，默认是Propagation.REQUIRED
     * sub6()加 @Transactional(propagation = Propagation.NEVER)
     * 异常发生在A处，则外层事务回滚，内部事务没有执行
     * 异常发生在B,C处，则内部事务抛出异常，因为它禁止了事务，外层事务回滚
     */
    @Override
    @Transactional
    public void testPropagation6() {
        this.accountMapper.updateAccount(1, 100L);
        //int a=1/0; //A
        subService.sub6();
        int a=1/0; //C
    }

    /***
     * testPropagation7加上@Transactional，默认是Propagation.REQUIRED
     * sub7()加 @Transactional(propagation = Propagation.NESTED)
     * 异常发生在A处，则内部事务没有执行，外层事务回滚
     * 异常发生在B,C处，则内部和外层事务都回滚
     *
     * 如何去掉testPropagation7的@Transactional，则sub7会自己创建事务
     * 因此在这种情况下，只有B处发生异常时，内部事务回滚，外部事务不回滚
     */
    @Override
    @Transactional
    public void testPropagation7() {
        this.accountMapper.updateAccount(1, 100L);
        //int a=1/0; //A
        subService.sub7();
        //int a=1/0; //C
    }

}
