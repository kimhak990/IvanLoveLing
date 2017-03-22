package com.ivan.blog.dao;

import com.ivan.blog.params.NoticePVO;

import java.util.List;

/**
 * Created by kimha on 2017-03-06.
 */
public interface NoticeDao {

    int addNotice(NoticePVO noticePVO);

    List<NoticePVO> selectNoticeList(NoticePVO noticePVO);

    int selectNoticeCount(NoticePVO noticePVO);

    NoticePVO selectNoticeInfo(NoticePVO noticePVO);

    int deleteNotice(NoticePVO noticePVO);

    int updateNotice(NoticePVO noticePVO);
}
