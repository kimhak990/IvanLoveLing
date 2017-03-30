package com.ivan.blog.util;

import com.ivan.blog.params.PageVO;

/**
 * Created by kimha on 2017-03-07.
 */
public class PageUtil {
    public  static String getPagingHtml(PageVO pageVO){
        String htmls = "<div class='row'>";
        htmls += "<div class='col-xs-6'>";
        htmls +=     "<div class='dataTables_info' id='example2_info'>Showing "+pageVO.getPageIndex()+" to "+pageVO.getPageDataIdx()+" of "+pageVO.getTotalCount()+" entries</div>";
        htmls += "</div>";
        htmls += "<div class='col-xs-6'>";
        htmls += "<div class='dataTables_paginate paging_bootstrap'>";
        htmls += "<ul class='pagination'>";

        if(pageVO.getPageNo() <= 1 ){
            htmls += "<li class='prev disabled'><a href='javascript:;'>← Previous</a></li>";
        }else{
            htmls += "<li class='prev' onclick='goPage("+pageVO.getPrevPageNo()+")'><a href='javascript:;'>← Previous</a></li>";
        }
        for(int i = pageVO.getStartPageNo(); i <= pageVO.getEndPageNo(); i++){
            if(i == pageVO.getPageNo()){
                htmls +="<li class='active'><a href='javascript:;'>"+i+"</a></li>";
            } else {
                htmls +="<li onclick='goPage("+i+")'><a href='javascript:;'>"+i+"</li>";
            }
        }

        if(pageVO.getPageNo() != pageVO.getEndPageNo()){
            htmls += "<li class='next' onclick='goPage("+pageVO.getNextPageNo()+")'><a href='javascript:;'>Next →</a></li>";
        }else{
            htmls += "<li class='next disabled' onclick='goPage("+pageVO.getNextPageNo()+")'><a href='javascript:;'>Next →</a></li>";
        }
        return htmls;
    }
}
