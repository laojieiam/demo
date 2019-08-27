package com.demo.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-22
 */
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片路径
     */
    private String imgPath;

    /**
     * 商品价格
     */
    private String price;

    /**
     * 商品介绍
     */
    private String details;

    /**
     * 是否是热门,0不是，1是
     */
    private Integer isHot;

    /**
     * 是否是新品,0不是，1是
     */
    private Integer isNew;

    /**
     * 推荐商品,0 1
     */
    private Integer isPick;

    /**
     * 性感风情,0 1
     */
    private Integer isSexy;

    /**
     * 情侣装,0 1
     */
    private Integer isCouples;

    /**
     * 猜你喜欢,0 1
     */
    private Integer isGuessYouLike;

    /**
     * 是否是广告,0 1
     */
    private Integer isAdvertising;

    /**
     * 评价人数
     */
    private Integer evaluateSum;

    /**
     * 成交量
     */
    private Integer turnover;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }
    public Integer getIsPick() {
        return isPick;
    }

    public void setIsPick(Integer isPick) {
        this.isPick = isPick;
    }
    public Integer getIsSexy() {
        return isSexy;
    }

    public void setIsSexy(Integer isSexy) {
        this.isSexy = isSexy;
    }
    public Integer getIsCouples() {
        return isCouples;
    }

    public void setIsCouples(Integer isCouples) {
        this.isCouples = isCouples;
    }
    public Integer getIsGuessYouLike() {
        return isGuessYouLike;
    }

    public void setIsGuessYouLike(Integer isGuessYouLike) {
        this.isGuessYouLike = isGuessYouLike;
    }
    public Integer getIsAdvertising() {
        return isAdvertising;
    }

    public void setIsAdvertising(Integer isAdvertising) {
        this.isAdvertising = isAdvertising;
    }
    public Integer getEvaluateSum() {
        return evaluateSum;
    }

    public void setEvaluateSum(Integer evaluateSum) {
        this.evaluateSum = evaluateSum;
    }
    public Integer getTurnover() {
        return turnover;
    }

    public void setTurnover(Integer turnover) {
        this.turnover = turnover;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", imgPath=" + imgPath +
            ", price=" + price +
            ", details=" + details +
            ", isHot=" + isHot +
            ", isNew=" + isNew +
            ", isPick=" + isPick +
            ", isSexy=" + isSexy +
            ", isCouples=" + isCouples +
            ", isGuessYouLike=" + isGuessYouLike +
            ", isAdvertising=" + isAdvertising +
            ", evaluateSum=" + evaluateSum +
            ", turnover=" + turnover +
        "}";
    }
}
