package com.ivan.blog.service.impl;

import com.ivan.blog.dao.FrontMenuDao;
import com.ivan.blog.params.FrontMenuPVO;
import com.ivan.blog.service.FrontMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kimha on 2017-03-09.
 */
@Service
public class FrontMenuServiceImpl implements FrontMenuService {
    @Autowired
    private FrontMenuDao frontMenuDao;

    @Override
    public int selectFrontMenuCount(FrontMenuPVO frontMenuPVO) {
        return frontMenuDao.selectFrontMenuCount(frontMenuPVO);
    }

    @Override
    public List<FrontMenuPVO> selectFrontMenuList(FrontMenuPVO frontMenuPVO) {
        return frontMenuDao.selectFrontMenuList(frontMenuPVO);
    }

    @Override
    public Map<String, Object> addFrontMenu(FrontMenuPVO frontMenuPVO) {
        Map<String,Object> result = new HashMap<String, Object>();
        frontMenuPVO.setParent(0);
        int i = frontMenuDao.addFrontMenu(frontMenuPVO);
        System.out.println("system.... out .... println ... insert result i");
        result.put("code", i+"");
        return result;
    }

    @Override
    public Map<String, Object> updateFrontMenu(FrontMenuPVO frontMenuPVO) {
        Map<String,Object> result = new HashMap<String,Object>();

        int i = frontMenuDao.updateFrontMenu(frontMenuDao);
        result.put("code", i+"");
        return result;
    }

    @Override
    public Map<String, Object> deleteFrontMenu(FrontMenuPVO frontMenuPVO) {
        Map<String,Object> result = new HashMap<String,Object>();

        int i = frontMenuDao.deleteFrontMenu(frontMenuPVO);
        result.put("code", i+"");
        return result;
    }

    @Override
    public FrontMenuPVO selectFrontMenuInfo(FrontMenuPVO frontMenuPVO) throws Exception{
        System.out.println("frontMenuPVO . get FrontMenuId = " + frontMenuPVO.getFrontMenuId());
        String frontMenuId = frontMenuPVO.getFrontMenuId();
        return frontMenuDao.selectFrontMenuInfo(frontMenuId);
    }
}
