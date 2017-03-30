package com.ivan.blog.controller;

import com.ivan.blog.util.PageUtil;
import com.ivan.blog.params.NoticePVO;
import com.ivan.blog.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by kimha on 2017-03-03.
 */
@Controller
@RequestMapping(value="/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
                                                        /** 어드민 Controller */
                                                /**                 분리                   */

    /**
     *  Admin - 공지사항 리스트
     * Created by kimhak on 2017-03-03.
     */@RequestMapping(value="/noticeList")
    public String noticeList(@ModelAttribute("noticePVO") NoticePVO noticePVO, Model model){
        String count = String.valueOf(noticeService.selectNoticeCount(noticePVO));
        noticePVO.setTotalCount(Integer.parseInt(count));

        model.addAttribute("list",noticeService.selectNoticeList(noticePVO));
        model.addAttribute("pagingHtml", PageUtil.getPagingHtml(noticePVO));
        return "/admin/notice/noticeList";
    }

    /**
     *  Admin - 공지사항 추가페이지 이동
     * Created by kimhak on 2017-03-03.
     */
    @RequestMapping(value = "/addNoticePage")
    public String addNoticePage(Model model){

        return "/admin/notice/addNotice";
    }

    /**
     *  Admin - 공지사항 추가
     * Created by kimhak on 2017-03-03.
     */
    @RequestMapping(value="/addNotice")
    @ResponseBody
    public Map<String, String> addNotice(@ModelAttribute NoticePVO noticePVO) throws Exception
    {
        return noticeService.addNotice(noticePVO);
    }

    /**
     *  Admin - 공지사항 수정
     * Created by kimhak on 2017-03-03.
     */
    @RequestMapping(value="updateNotice")
    @ResponseBody
    public Map<String,Object> updateNotice(@ModelAttribute("noticePVO") NoticePVO noticePVO) throws Exception{
            return noticeService.updateNotice(noticePVO);
    }

    /**
     *  Admin - 공지사항 상세
     * Created by kimhak on 2017-03-08.
     */
    @RequestMapping(value="/noticeInfo")
    public String noticeInfo(@ModelAttribute NoticePVO noticePVO, Model model) throws Exception
    {
        model.addAttribute("noticeInfo",noticeService.selectNoticeInfo(noticePVO));
        return "/admin/notice/updateNotice";
    }

    /**
     * Admin - 공지사항 삭제
     * Created by kimhak on 2017-03-09.
     */
    @RequestMapping(value = "/deleteNotice")
    @ResponseBody
    public Map<String,Object> deleteNotice(@ModelAttribute NoticePVO noticePVO){

        return noticeService.deleteNotice(noticePVO);
    }
}
