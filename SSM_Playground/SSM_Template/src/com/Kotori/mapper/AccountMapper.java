package com.Kotori.mapper;

import com.Kotori.domain.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    void insertAccount(Account account);

    Account getAccountById(Integer a);

    void updateAccount(@Param("id") Integer id, @Param("change") Long change);
}
