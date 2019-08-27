package com.demo.controller;


import com.demo.entities.Category;
import com.demo.service.CategoryService;
import com.demo.util.Result;
import com.demo.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-23
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/getAll")
    public Result getAll(){
        List<Category> list = categoryService.findCategoriesByParentId(0L);
//        System.out.println(list);
//        for (Category c:list) {
//            System.out.println(c);
//        }
        return ResultGenerator.genSuccessResult(list);
    }

}
