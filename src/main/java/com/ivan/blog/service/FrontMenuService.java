package com.ivan.blog.service;

import com.ivan.blog.params.FrontMenuPVO;

import java.util.List;
import java.util.Map;

/**
 * Created by kimha on 2017-03-09.
 */
public interface FrontMenuService {
    int selectFrontMenuCount(FrontMenuPVO frontMenuPVO);

    List<FrontMenuPVO> selectFrontMenuList(FrontMenuPVO frontMenuPVO);

    Map<String,Object> addFrontMenu(FrontMenuPVO frontMenuPVO);

    Map<String,Object> updateFrontMenu(FrontMenuPVO frontMenuPVO);

    Map<String,Object> deleteFrontMenu(FrontMenuPVO frontMenuPVO);

    FrontMenuPVO selectFrontMenuInfo(FrontMenuPVO frontMenuPVO) throws Exception;
}
