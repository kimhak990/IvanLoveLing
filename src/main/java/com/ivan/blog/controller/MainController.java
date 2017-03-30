package com.ivan.blog.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ivan.blog.params.CategoryPVO;
import com.ivan.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by kimha on 2017-03-02.
 */
@Controller
@RequestMapping(value="/")
public class MainController {

    @Autowired
    private CategoryService cateService;

    @RequestMapping(value="home")
    public String mainPage(Model model){
        model.addAttribute("cateList",cateService.selectCateList());
        return "/admin/index";
    }
}
