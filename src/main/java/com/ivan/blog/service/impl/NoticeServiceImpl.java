package com.ivan.blog.service.impl;

import com.ivan.blog.dao.NoticeDao;
import com.ivan.blog.params.NoticePVO;
import com.ivan.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kimha on 2017-03-06.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    /**
     * 공지사항 등록
     * @param noticePVO
     * @return Map
     */
    @Override
    public Map<String, String> addNotice(NoticePVO noticePVO) {
        Map<String,String> result = new HashMap<String, String>();

        int i = noticeDao.addNotice(noticePVO);
        System.out.println("system.... out .... println ... insert result i");
        result.put("code", i+"");
        return result;
    }

    /**
     * 공지사항 카운팅
     * @return
     */
    @Override
    public int selectNoticeCount(NoticePVO noticePVO) {
        return noticeDao.selectNoticeCount(noticePVO);
    }

    /**
     * 공지사항 리스트
     * @return
     */
    @Override
    public List<NoticePVO> selectNoticeList(NoticePVO noticePVO) {
        return noticeDao.selectNoticeList(noticePVO);
    }

    /**
     * 공지사항 상세정보
     * @param noticePVO
     * @return
     */
    @Override
    public NoticePVO selectNoticeInfo(NoticePVO noticePVO) {
        return noticeDao.selectNoticeInfo(noticePVO);
    }

    /**
     * 공지사항 삭제
     * @param noticePVO
     * @return
     */
    @Override
    public Map<String, Object> deleteNotice(NoticePVO noticePVO) {
        Map<String,Object> result = new HashMap<String, Object>();
        noticePVO.setUseYn("N");
        int i = noticeDao.deleteNotice(noticePVO);
        System.out.println("system.... out .... println ... update delete result i");
        result.put("code", i+"");
        return result;
    }

    @Override
    public Map<String, Object> updateNotice(NoticePVO noticePVO) {
        Map<String,Object> result = new HashMap<String, Object>();
        int i = noticeDao.updateNotice(noticePVO);
        System.out.println("system.... out .... println ... update delete result i");
        result.put("code", i+"");
        return result;
    }
}
