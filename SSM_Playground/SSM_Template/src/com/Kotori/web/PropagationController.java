package com.Kotori.web;

import com.Kotori.service.PropagationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropagationController {
    @Autowired
    private PropagationService propagationService;

    @RequestMapping("/testPropagation1.action")
    public String testPropagation1() {
        propagationService.testPropagation1();
        return "/index.jsp";
    }

    @RequestMapping("/testPropagation2.action")
    public String testPropagation2() {
        propagationService.testPropagation2();
        return "/index.jsp";
    }

    @RequestMapping("/testPropagation3.action")
    public String testPropagation3() {
        propagationService.testPropagation3();
        return "/index.jsp";
    }

    @RequestMapping("/testPropagation4.action")
    public String testPropagation4() {
        propagationService.testPropagation4();
        return "/index.jsp";
    }

    @RequestMapping("/testPropagation5.action")
    public String testPropagation5() {
        propagationService.testPropagation5();
        return "/index.jsp";
    }

    @RequestMapping("/testPropagation6.action")
    public String testPropagation6() {
        propagationService.testPropagation6();
        return "/index.jsp";
    }

    @RequestMapping("/testPropagation7.action")
    public String testPropagation7() {
        propagationService.testPropagation7();
        return "/index.jsp";
    }
}
