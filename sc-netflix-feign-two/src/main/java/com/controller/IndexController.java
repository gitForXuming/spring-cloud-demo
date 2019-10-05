package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2018/4/25.
 * Title IndeController
 * Package  com.controller
 * Description
 *
 * @Version V1.0
 */
@Controller
public class IndexController extends BaseController{
    @RequestMapping( value= "/index")
    public String indx(Model model){
        model.addAttribute("contextPath",getContextPath());
        return "login";
    }
}
