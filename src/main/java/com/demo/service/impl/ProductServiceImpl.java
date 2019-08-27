package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entities.Product;
import com.demo.dao.ProductDao;
import com.demo.service.ProductService;
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
 * @since 2019-08-22
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public IPage<Product> selectByPage(Product product, int page, int pageSize) {
       try {
           Page<Product> p=new Page<>(page,pageSize);
           p.setRecords(productDao.selectByPage(p,product));
           return p;
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
    }

    @Override
    public IPage<Product> selectByPageAndWrapper(Product product, int page, int pageSize, Wrapper<Product> wrapper) {
        try {
            Page<Product> p=new Page<>(page,pageSize);
            p.setRecords(productDao.selectByPageAndWrapper(p,product,wrapper));
            return p;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
