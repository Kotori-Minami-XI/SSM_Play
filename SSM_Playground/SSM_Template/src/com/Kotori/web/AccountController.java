package com.Kotori.web;

import com.Kotori.domain.Account;
import com.Kotori.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/transferAccount.action")
    public String transferAccount() {
        accountService.transferAccount();
        return "/index.jsp";
    }

}
