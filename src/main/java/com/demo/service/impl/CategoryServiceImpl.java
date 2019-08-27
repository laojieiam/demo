package com.demo.service.impl;

import com.demo.entities.Category;
import com.demo.dao.CategoryDao;
import com.demo.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-23
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<Category> findCategoriesByParentId(Long pid) {
        return categoryDao.findCategoriesByParentId(pid);
    }
}
