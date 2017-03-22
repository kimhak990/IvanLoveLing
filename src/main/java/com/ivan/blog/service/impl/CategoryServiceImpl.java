package com.ivan.blog.service.impl;

import com.ivan.blog.dao.CategoryDao;
import com.ivan.blog.params.CategoryPVO;
import com.ivan.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kimha on 2017-02-28.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao cateDAO;

    @Override
    public List<CategoryPVO> selectCateList() {
        return cateDAO.selectCateList();
    }
}
