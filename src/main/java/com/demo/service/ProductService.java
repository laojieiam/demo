package com.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entities.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-22
 */
public interface ProductService extends IService<Product> {

    /**
     * 分页查询
     * @param product
     * @param page
     * @param pageSize
     * @return
     */
    IPage<Product> selectByPage(Product product,int page,int pageSize);

    /**
     * 分页查询2
     * @param page
     * @param product
     * @return
     */
    public IPage<Product> selectByPageAndWrapper(Product product, int page, int pageSize,Wrapper<Product> wrapper);
}
