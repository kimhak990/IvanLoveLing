package com.ivan.blog.dao;

import com.ivan.blog.params.CategoryPVO;

import java.util.List;

/**
 * Created by kimha on 2017-02-28.
 */
public interface CategoryDao {

    List<CategoryPVO> selectCateList();
}
