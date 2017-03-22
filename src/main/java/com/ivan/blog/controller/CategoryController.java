package com.ivan.blog.controller;

import com.ivan.blog.params.CategoryPVO;
import com.ivan.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by kimha on 2017-02-28.
 */
@Controller
@RequestMapping(value="/cate")
public class CategoryController {
    @Autowired
    private CategoryService cateService;

    @RequestMapping("/cateList")
    public void selectCateList(){

        String testGit = "null";

        System.out.println("test MVC.... ing.");
        List<CategoryPVO> cateList= cateService.selectCateList();
        if(cateList == null){
            System.out.println("cateList is null... or DAO is not working");
        }else{
            for (CategoryPVO cate:cateList) {
                System.out.println("CateList ....ID = " + cate.getCateId());
                System.out.println("CateList ....ID = " + cate.getCateName());
            }
        }
    }
}
