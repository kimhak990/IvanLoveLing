package com.ivan.blog.dao;

import com.ivan.blog.params.FrontMenuPVO;

import java.util.List;

/**
 * Created by kimha on 2017-03-09.
 */
public interface FrontMenuDao {
    int selectFrontMenuCount(FrontMenuPVO frontMenuPVO);

    List<FrontMenuPVO> selectFrontMenuList(FrontMenuPVO frontMenuPVO);

    int addFrontMenu(FrontMenuPVO frontMenuPVO);

    int updateFrontMenu(FrontMenuDao frontMenuDao);

    int deleteFrontMenu(FrontMenuPVO frontMenuPVO);

    FrontMenuPVO selectFrontMenuInfo(String frontMenuDao) throws Exception;
}
