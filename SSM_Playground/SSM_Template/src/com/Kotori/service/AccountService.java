package com.Kotori.service;

import com.Kotori.domain.Account;

import java.io.FileNotFoundException;

public interface AccountService {
    public void insertAccount(Account account);

    void transferAccount1() throws FileNotFoundException;
    void transferAccount2() throws FileNotFoundException;
    void transferAccount3();
    void transferAccount4();
}
