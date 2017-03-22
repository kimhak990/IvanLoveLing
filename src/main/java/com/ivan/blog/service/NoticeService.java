package com.ivan.blog.service;

import com.ivan.blog.params.NoticePVO;

import java.util.List;
import java.util.Map;

/**
 * Created by kimha on 2017-03-06.
 */
public interface NoticeService {

    Map<String,String> addNotice(NoticePVO noticePVO);

    int selectNoticeCount(NoticePVO noticePVO);

    List<NoticePVO> selectNoticeList(NoticePVO noticePVO);

    NoticePVO selectNoticeInfo(NoticePVO noticePVO);

    Map<String,Object> deleteNotice(NoticePVO noticePVO);

    Map<String,Object> updateNotice(NoticePVO noticePVO);
}
