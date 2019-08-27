package com.demo.controller;


import com.demo.service.BannerService;
import com.demo.util.Result;
import com.demo.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-22
 */
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * 获取所有的Banner（轮播图）
     * @return
     */
    @RequestMapping("/getAll")
    public Result getAll(){
        return ResultGenerator.genSuccessResult(bannerService.list());
    }

}
