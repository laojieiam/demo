package com.demo.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entities.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-22
 */
public interface ProductDao extends BaseMapper<Product> {

    /**
     * 分页查询
     * @param page
     * @param product
     * @return
     */
    List<Product> selectByPage(Page page,Product product);

    /**
     * 分页查询2
     * @param page
     * @param product
     * @return
     */
    List<Product> selectByPageAndWrapper(Page page,Product product,Wrapper wrapper);

}
