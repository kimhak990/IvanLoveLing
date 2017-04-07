package com.ivan.blog.controller;

import com.ivan.blog.common.PageUtil;
import com.ivan.blog.params.FrontMenuPVO;
import com.ivan.blog.service.FrontMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by kimha on 2017-03-09.
 */
@Controller
@RequestMapping("/frontMenu")
public class FrontMenuController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private  FrontMenuService frontMenuService;

    @RequestMapping("/frontMenuList")
    public String frontMenuList(@ModelAttribute("frontMenuPVO") FrontMenuPVO frontMenuPVO, Model model){
        frontMenuPVO.setTotalCount(frontMenuService.selectFrontMenuCount(frontMenuPVO));

        model.addAttribute("list",frontMenuService.selectFrontMenuList(frontMenuPVO));
        model.addAttribute("pageHtml", PageUtil.getPagingHtml(frontMenuPVO));

        return "/admin/frontmenu/frontMenuList";
    }

    @RequestMapping("/addFrontMenuPage")
    public String addFrontMenuPage(){

        return "/admin/frontmenu/addFrontMenu";
    }

    @RequestMapping("/addFrontMenu")
    @ResponseBody
    public Map<String,Object> addFrontMenu(@ModelAttribute FrontMenuPVO frontMenuPVO){
        return frontMenuService.addFrontMenu(frontMenuPVO);
    }

    @RequestMapping(value = "/frontMenuInfo")
    public String updateFrontMenuPage(@ModelAttribute FrontMenuPVO frontMenuPVO, Model model) throws Exception{

        logger.debug("front Menu Id = " + frontMenuPVO.getFrontMenuId());
        model.addAttribute("frontMenuInfo",frontMenuService.selectFrontMenuInfo(frontMenuPVO));
        return "/admin/frontmenu/updateFrontMenu";
    }

    @RequestMapping(value = "updateFrontMenu")
    @ResponseBody
    public Map<String,Object> updateFrontMenu(@ModelAttribute("frontMenuPVO") FrontMenuPVO frontMenuPVO){
        logger.debug("check FrontMenuPvo value " , frontMenuPVO.getFrontMenuName());
        logger.debug("check FrontMenuPvo value " , frontMenuPVO.getFrontMenuId());
        logger.debug("check FrontMenuPvo value " , frontMenuPVO.getParent());
        logger.debug("check FrontMenuPvo value " , frontMenuPVO.getDepth());
        logger.debug("check FrontMenuPvo value " , frontMenuPVO.getUseYn());
        return frontMenuService.updateFrontMenu(frontMenuPVO);
    }

    @RequestMapping(value = "deleteFrontMenu")
    @ResponseBody
    public Map<String, Object> deleteFrontMenu(@ModelAttribute FrontMenuPVO frontMenuPVO){
        return frontMenuService.deleteFrontMenu(frontMenuPVO);
    }

}
