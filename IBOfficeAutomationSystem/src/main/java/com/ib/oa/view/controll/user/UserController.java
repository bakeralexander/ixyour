package com.ib.oa.view.controll.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        ModelAndView mv=new ModelAndView("/main/login");
        return mv;
    }
}
