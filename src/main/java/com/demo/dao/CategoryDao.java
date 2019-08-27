package com.demo.dao;

import com.demo.entities.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-23
 */
public interface CategoryDao extends BaseMapper<Category> {

    /**
     * 无限级分类
     * @param pid
     * @return
     */
    List<Category> findCategoriesByParentId(Long pid);

}
