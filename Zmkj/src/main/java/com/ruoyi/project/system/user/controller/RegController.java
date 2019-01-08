package com.ruoyi.project.system.user.controller;

import com.ruoyi.framework.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: ct
 * @Date: 2019/1/7 13:35
 * @Description:
 */
@Controller
@RequestMapping("/reg")
public class RegController extends BaseController {


    @GetMapping(value = "/toReg")
    public String reg()
    {
        return "reg";
    }
    
    @GetMapping(value = "/toLogin")
    public String toLogin()
    {
        return "login";
    }
}
