package com.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entities.Product;
import com.demo.service.ProductService;
import com.demo.util.Result;
import com.demo.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-22
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/getAll")
    public Result getAll(){
        return ResultGenerator.genSuccessResult(productService.list());
    }

    @RequestMapping("/getListByPage")
    public Result getListByPage(@RequestParam("page") int page){
        IPage<Product> productPage = productService.selectByPage(new Product(), page, 20);
        long total = productPage.getTotal();
        Map<String,Object> result=new HashMap<>();
        result.put("total",total);//数据总数
        result.put("nowPage",productPage.getCurrent());//当前页数
        result.put("productList",productPage.getRecords());//当前页数的数据
        result.put("totalPage",productPage.getPages());//一共多少页
//        System.out.println(page);
        return ResultGenerator.genSuccessResult(result);
    }

    @RequestMapping("/getListByPageAndWrapper")
    public Result getListByPageAndWrapper(@RequestParam("page") int page,@RequestParam("pageSize")int pageSize){
        IPage<Product> productPage = productService.selectByPageAndWrapper(new Product(),page,pageSize,new QueryWrapper<Product>().eq("is_new",1));
//        System.out.println(productPage.getRecords());
        return ResultGenerator.genSuccessResult(productPage.getRecords());
    }
    @RequestMapping("/getIndexList")
    public Result getIndexList(){
        //Map
        Map<String,Object> map=new HashMap<>();
        //new
        IPage<Product> newList=productService.page(new Page<Product>(1,5),new QueryWrapper<Product>().eq("is_new",1));
        //hot
        IPage<Product> hotList=productService.page(new Page<Product>(1,6),new QueryWrapper<Product>().eq("is_hot",1));
        //pick
        IPage<Product> pickList=productService.page(new Page<Product>(1,4),new QueryWrapper<Product>().eq("is_pick",1));
        //sexy
        IPage<Product> sexyList=productService.page(new Page<Product>(1,6),new QueryWrapper<Product>().eq("is_sexy",1));
        //couples
        IPage<Product> couplesList=productService.page(new Page<Product>(1,3),new QueryWrapper<Product>().eq("is_couples",1));
        //Guess you like
        IPage<Product> guessYouLikeList=productService.page(new Page<Product>(1,6),new QueryWrapper<Product>().eq("is_guess_you_like",1));
        map.put("newList",newList.getRecords());
        map.put("hotList",hotList.getRecords());
        map.put("pickList",pickList.getRecords());
        map.put("sexyList",sexyList.getRecords());
        map.put("couplesList",couplesList.getRecords());
        map.put("guessYouLikeList",guessYouLikeList.getRecords());
        return ResultGenerator.genSuccessResult(map);
    }

    @RequestMapping("insert")
    public String inset(HttpServletRequest request){
        String rootPath="http://192.168.31.211:8080/img/";
        List<Product> products=new ArrayList<>();
        for(int i=1;i<=6;i++){
            Product p=new Product();
            if(i<10) p.setImgPath(rootPath+"youlike"+i+".jpg");
            else  p.setImgPath(rootPath+"youlike"+i+".jpg");
            p.setPrice((""+new Random().nextInt(500)));
            p.setDetails("youlike商品"+(i)+"号");
            p.setEvaluateSum(new Random().nextInt(10000));
            p.setTurnover(new Random().nextInt(10000));
            p.setIsAdvertising(0);
            p.setIsCouples(0);
            p.setIsGuessYouLike(1);
            p.setIsHot(0);
            p.setIsNew(0);
            p.setIsPick(0);
            p.setIsSexy(0);
            products.add(p);
        }
        productService.saveBatch(products);

        return "成功";
    }

}
