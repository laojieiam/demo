package com.demo.service;

import com.demo.entities.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-23
 */
public interface CategoryService extends IService<Category> {

    /**
     * 无限级分类
     * @param pid
     * @return
     */
    List<Category> findCategoriesByParentId(Long pid);

}
