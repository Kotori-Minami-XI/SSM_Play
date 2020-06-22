package com.Kotori.web;

import com.Kotori.domain.Account;
import com.Kotori.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/insertAccount.action")
    public ModelAndView insertAccount(Account account) {
        accountService.insertAccount(account);

        ModelAndView model  =  new ModelAndView();
        model.setViewName("/index.jsp");
        return model;
    }

    @RequestMapping("/transferAccount1.action")
    public String transferAccount1() throws FileNotFoundException {
        accountService.transferAccount1();
        return "/index.jsp";
    }

    @RequestMapping("/transferAccount2.action")
    public String transferAccount2() throws FileNotFoundException {
        accountService.transferAccount2();
        return "/index.jsp";
    }

    @RequestMapping("/transferAccount3.action")
    public String transferAccount3() {
        accountService.transferAccount3();
        return "/index.jsp";
    }

    @RequestMapping("/transferAccount4.action")
    public String transferAccount4() {
        accountService.transferAccount4();
        return "/index.jsp";
    }

}
